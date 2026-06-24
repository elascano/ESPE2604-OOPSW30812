import json
import os

class PhoneController:

    FILE_PATH = "data/phones.json"

    def save_phone(self, phone):

        data = []

        if os.path.exists(self.FILE_PATH):
            try:
                with open(self.FILE_PATH, "r") as file:
                    data = json.load(file)
            except:
                data = []

        data.append(phone.to_dict())

        with open(self.FILE_PATH, "w") as file:
            json.dump(data, file, indent=4)

        print("Phone saved successfully!")

    def show_saved_phones(self):

        if not os.path.exists(self.FILE_PATH):
            print("No phones registered.")
            return

        with open(self.FILE_PATH, "r") as file:
            phones = json.load(file)

        print("\nREGISTERED PHONES")

        for phone in phones:
            print(phone)