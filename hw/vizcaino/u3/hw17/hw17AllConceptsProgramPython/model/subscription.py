class Subscription:

    def __init__(self, plan_name):
        self._plan_name = plan_name

    def get_plan_name(self):
        return self._plan_name