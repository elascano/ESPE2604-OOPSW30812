"""
@author Cristian Palomo, Error 404, @ESPE
"""
from abc import ABC, abstractmethod
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from ec_edu_espe.observer.model.stock import Stock


class Investor(ABC):

    @abstractmethod
    def update(self, stock: "Stock", args: object) -> None:
        ...
