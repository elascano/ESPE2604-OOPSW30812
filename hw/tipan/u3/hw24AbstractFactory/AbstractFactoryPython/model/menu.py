from abc import ABC, abstractmethod

class Menu(ABC):
    def __init__(self):
        self.caption = ""

    def set_caption(self, caption):
        self.caption = caption

    @abstractmethod
    def paint(self):
        pass