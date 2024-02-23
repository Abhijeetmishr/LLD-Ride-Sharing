from typing import List
from src.commands import ICommand
from src.services import GreetingService


class ListGreetingCommand(ICommand):
    def __init__(self, greetingService: GreetingService) -> None:
        self._greetingService = greetingService

    def invoke(self, tokens: List[str]) -> None:
        gList = self._greetingService.getAllGreetings()
        print(gList)