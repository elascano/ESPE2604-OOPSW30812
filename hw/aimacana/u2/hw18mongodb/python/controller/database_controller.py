from abc import ABC, abstractmethod
from typing import List, Generic, TypeVar

T = TypeVar('T')

class IDatabaseController(ABC, Generic[T]):
    @abstractmethod
    def create(self, entity: T) -> None:
        pass

    @abstractmethod
    def read_all(self) -> List[T]:
        pass

    @abstractmethod
    def read_by_id(self, id_field: str, id_value: str) -> T:
        pass

    @abstractmethod
    def update(self, id_field: str, id_value: str, field_name: str, new_value: any) -> None:
        pass

    @abstractmethod
    def delete(self, id_field: str, id_value: str) -> None:
        pass

    @abstractmethod
    def clean_collection(self) -> None:
        pass
