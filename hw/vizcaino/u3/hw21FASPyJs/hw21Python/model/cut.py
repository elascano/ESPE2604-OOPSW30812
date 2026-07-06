from dataclasses import dataclass


@dataclass
class Cut:
    id: int
    description: str
    procedure: str
    weight: float