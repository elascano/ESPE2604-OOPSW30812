from abc import ABC, abstractmethod
from typing import List, TypeVar, Generic

T = TypeVar('T')

class IManageable(ABC, Generic[T]):
    @abstractmethod
    def add(self, element: T) -> None:
        pass
    
    @abstractmethod
    def remove(self, id: str) -> None:
        pass
    
    @abstractmethod
    def find(self, id: str) -> T:
        pass
    
    @abstractmethod
    def find_all(self) -> List[T]:
        pass
    
    @abstractmethod
    def update(self, element: T) -> None:
        pass