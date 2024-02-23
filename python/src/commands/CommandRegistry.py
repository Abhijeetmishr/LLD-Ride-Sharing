from typing import List
from src.commands.ICommand import ICommand


class CommandRegistry:
    _commands = {}

    def registerCommand(self, commandKeyword: str, command: ICommand) -> None:
        self._commands[commandKeyword] = command

    def unRegisterCommand(self, commandKeyword: str) -> None:
        self._commands.pop(commandKeyword)

    def _get(self, commandName: str) -> ICommand:
        return self._commands.get(commandName)

    def _parse(self, input: str) -> List[str]:
        return input.strip().split(" ")

    def invokeCommand(self, input: str) -> None:
        tokens = self._parse(input)
        command = self._get(tokens[0])
        if command is None:
            raise Exception("INVALID COMMAND 🛑")
        command.invoke(tokens)