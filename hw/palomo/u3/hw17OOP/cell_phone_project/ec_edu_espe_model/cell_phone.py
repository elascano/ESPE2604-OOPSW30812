from ec_edu_espe_model.device import Device

class CellPhone(Device):

    def __init__(self, brand, model, imei,
                 battery, screen, sim_card):

        super().__init__(brand, model)

        self._imei = imei

        # Composition
        self._battery = battery

        # Association
        self._screen = screen

        # Aggregation
        self._sim_card = sim_card

    def turn_on(self):
        print("Phone ON")

    def turn_off(self):
        print("Phone OFF")

    def make_call(self, number):
        print(f"Calling {number}")

    def to_dict(self):

        return {
            "brand": self.brand,
            "model": self.model,
            "imei": self._imei,
            "battery": self._battery.capacity,
            "screen": self._screen.size,
            "operator": self._sim_card.operator
        }

    def show_info(self):

        print("\nPHONE INFORMATION")
        print(f"Brand: {self.brand}")
        print(f"Model: {self.model}")
        print(f"IMEI: {self._imei}")
        print(f"Battery: {self._battery.capacity} mAh")
        print(f"Screen: {self._screen.size}\"")
        print(f"Operator: {self._sim_card.operator}")