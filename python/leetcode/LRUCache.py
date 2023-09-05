class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = dict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        value = self.cache[key]
        self.cache.pop(key)
        self.cache[key] = value
        return value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache.pop(key)
            self.cache[key] = value
        else:
            if len(self.cache) >= self.cap:
                self.cache.pop(next(iter(self.cache)))
            self.cache[key] = value
