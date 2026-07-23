class Team:

    def __init__(self, name):
        self.name = name
        self.members = []

    def add_member(self, character):
        self.members.append(character)

    def show_team(self):
        print("Team:", self.name)
        for m in self.members:
            m.display_info()