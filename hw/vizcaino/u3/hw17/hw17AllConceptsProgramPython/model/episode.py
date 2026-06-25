from model.playable_content import PlayableContent

class Episode(PlayableContent):

    def __init__(self, title, duration_minutes, episode_number):
        super().__init__(title, duration_minutes)
        self._episode_number = episode_number

    def get_episode_number(self):
        return self._episode_number

    def play(self):
        print(f"Playing episode {self._episode_number}: {self.get_title()}")

    def get_content_type(self):
        return "Episode"