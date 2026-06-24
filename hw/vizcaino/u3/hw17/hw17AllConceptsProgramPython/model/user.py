from model.subscription import Subscription

class User:

    def __init__(self, name, plan):
        self._name = name
        self._subscription = Subscription(plan)

    def get_name(self):
        return self._name

    def get_subscription(self):
        return self._subscription

    def to_dict(self):
        return {
            "name": self._name,
            "plan": self._subscription.get_plan_name()
        }