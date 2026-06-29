from abc import ABC, abstractmethod

class PlayableContent(ABC):

    def __init__(self, title, duration_minutes):
        self._title = title
        self._duration_minutes = duration_minutes

    def get_title(self):
        return self._title

    def get_duration_minutes(self):
        return self._duration_minutes

    @abstractmethod
    def play(self):
        pass

    @abstractmethod
    def get_content_type(self):
        pass