from abc import ABC, abstractmethod
from typing import List, Optional
from models.entities.character import Character

class CharacterRepository(ABC):
    @abstractmethod
    def save(self, character: Character):
        pass

    @abstractmethod
    def find_by_id(self, char_id: str) -> Optional[Character]:
        pass

    @abstractmethod
    def find_all(self) -> List[Character]:
        pass

    @abstractmethod
    def delete(self, char_id: str):
        pass
