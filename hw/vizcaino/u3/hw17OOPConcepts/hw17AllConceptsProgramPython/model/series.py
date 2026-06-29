from model.playable_content import PlayableContent

class Series(PlayableContent):

    def __init__(self, title, duration_minutes):
        super().__init__(title, duration_minutes)
        self._episodes = []

    def add_episode(self, episode):
        self._episodes.append(episode)

    def get_episodes(self):
        return self._episodes

    def play(self):
        print(f"Playing series: {self.get_title()}")

    def get_content_type(self):
        return "Series"