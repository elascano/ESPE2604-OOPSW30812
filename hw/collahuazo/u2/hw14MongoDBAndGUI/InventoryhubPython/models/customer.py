from dataclasses import dataclass


@dataclass
class Customer:
    ruc: int
    name: str
    address: str
    gmail_customer: str

    def to_dict(self) -> dict:
        return {
            "ruc": self.ruc,
            "name": self.name,
            "address": self.address,
            "gmailCustomer": self.gmail_customer,
        }
