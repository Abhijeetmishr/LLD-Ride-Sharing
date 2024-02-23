from typing import List
from src.commands import ICommand
from src.services import GreetingService


class CreateGreetingCommand(ICommand):
    def __init__(self, greetingService: GreetingService) -> None:
        self._greetingService = greetingService

    def invoke(self, tokens: List[str]) -> None:
        message = tokens[1]
        g = self._greetingService.create(message)
        print(g)