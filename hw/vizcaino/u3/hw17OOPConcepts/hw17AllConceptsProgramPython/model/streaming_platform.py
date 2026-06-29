class StreamingPlatform:

    def __init__(self, name):
        self._name = name

    def play_content(self, user, content):
        print(f"{user.get_name()} is using {self._name} ({user.get_subscription().get_plan_name()} plan)")
        content.play()