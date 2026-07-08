class Door:

    def __init__(self, is_exterior=False):
        self._is_open = False
        self._is_exterior = is_exterior

    def open(self):
        self._is_open = True

    def close(self):
        self._is_open = False

    def is_open(self):
        return self._is_open

    def is_exterior(self):
        return self._is_exterior

    def set_exterior(self, exterior):
        self._is_exterior = exterior