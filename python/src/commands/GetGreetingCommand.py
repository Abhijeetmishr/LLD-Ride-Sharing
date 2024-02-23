from typing import List
from src.commands import ICommand
from src.services import GreetingService


class GetGreetingCommand(ICommand):
    def __init__(self, greetingService: GreetingService) -> None:
        self._greetingService = greetingService

    def invoke(self, tokens: List[str]) -> None:
        id = int(tokens[1])
        try:
            g = self._greetingService.getGreeting(id)
            print(g)
        except Exception as e:
            print(e)