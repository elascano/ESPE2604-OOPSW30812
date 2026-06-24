class SIMCard:

    def __init__(self, operator):
        self._operator = operator

    @property
    def operator(self):
        return self._operator