class SlaughterHouse:

    def __init__(self, name):
        self.name = name
        self.cuts = []

    def add_cut(self, cut):
        self.cuts.append(cut)