from dataclasses import dataclass


@dataclass
class Supplier:
    ruc: str
    company_name: str
    address: str
    phone: str
    email: str

    def __post_init__(self):
        if not self.phone.isdigit() or len(self.phone) != 10:
            raise ValueError("The phone number must be exactly 10 digits.")

    def to_dict(self) -> dict:
        return {
            "ruc": self.ruc,
            "companyName": self.company_name,
            "address": self.address,
            "phone": self.phone,
            "email": self.email,
        }
