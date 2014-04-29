from threading import Thread
import urllib2

def fetch_and_find(url, token):
    stream = urllib2.urlopen(url)
    lines = filter(lambda x: x.count(token), stream.readlines())
    return [line.strip() for line in lines]

def basic_mapreduce(urls, token):
    return reduce(lambda x, y: x + y,
                  map(lambda x: fetch_and_find(x, token), urls))

class ThreadWithReturnValue(Thread):
    def __init__(self, target, args):
        Thread.__init__(self)
        self._target = target
        self._args = args

    def run(self):
        self._return_value = self._target(*self._args)

def multithreaded_mapreduce(urls, token):
    threads = [ThreadWithReturnValue(fetch_and_find, (url, token))
               for url in urls]
    [t.start() for t in threads]
    [t.join() for t in threads]
    return reduce(lambda x, y: x + y, [t._return_value for t in threads])

def main():
    urls_to_find = [
        'http://www.apple.com',
        'http://www.macworld.com',
        'http://www.apple.com/ipod/',
        'http://www.apple.com/support/',
        'http://arstechnica.com/apple/'
    ]

    output = multithreaded_mapreduce(urls_to_find, "iPod")

    for line in output:
        print line
    print len(output)

if __name__ == "__main__":
    main()
