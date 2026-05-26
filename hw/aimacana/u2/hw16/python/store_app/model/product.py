import sys
from pathlib import Path

# Add python directory to path so taxes_lib can be found
python_dir = str(Path(__file__).resolve().parents[3])
if python_dir not in sys.path:
    sys.path.append(python_dir)

from taxes_lib.tax import Tax

class Product:
    def __init__(self, id: int, description: str, price: float, pvp: float = None):
        self.id = id
        self.description = description
        self.price = price
        if pvp is None:
            # Replicating the constructor: pvp = Tax.computeTotal(price, 15F);
            self.pvp = Tax.compute_total(price, 15.0)
        else:
            self.pvp = pvp

    def __str__(self) -> str:
        return f"Product\n{{id={self.id}, description='{self.description}', price={self.price}, pvp={self.pvp}}}"
