class Battery:

    def __init__(self, capacity):
        self._capacity = capacity

    @property
    def capacity(self):
        return self._capacity