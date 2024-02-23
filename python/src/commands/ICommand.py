from abc import ABC, abstractmethod
from typing import List


class ICommand(ABC):
    @abstractmethod
    def invoke(self, tokens: List[str]) -> None:
        pass