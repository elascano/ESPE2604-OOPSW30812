from abc import ABC, abstractmethod

class Button(ABC):

    def __init__(self):
        self.caption = ""

    def set_caption(self, caption):
        self.caption = caption

    @abstractmethod
    def paint(self):
        pass