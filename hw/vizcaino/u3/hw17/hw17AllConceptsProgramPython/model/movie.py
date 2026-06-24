from model.playable_content import PlayableContent

class Movie(PlayableContent):

    def play(self):
        print(f"Playing movie: {self.get_title()}")

    def get_content_type(self):
        return "Movie"