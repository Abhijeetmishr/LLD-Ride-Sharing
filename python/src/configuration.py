# https://refactoring.guru/design-patterns/singleton/python/example#example-0
from src.commands import CommandKeyword, CommandRegistry, CreateGreetingCommand, GetGreetingCommand, ListGreetingCommand
from src.repositories import GreetingRepository
from src.services import GreetingService


class SingletonMeta(type):
    """
    The Singleton class can be implemented in different ways in Python. Some
    possible methods include: base class, decorator, metaclass. We will use the
    metaclass because it is best suited for this purpose.
    """

    _instances = {}

    def __call__(cls, *args, **kwargs):
        """
        Possible changes to the value of the `__init__` argument do not affect
        the returned instance.
        """
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]

class Configuration(metaclass=SingletonMeta):

    # Initialize repositories
    _greetingRepository = GreetingRepository()
    
    # Initialize services
    _greetingService = GreetingService(_greetingRepository)

    # Initialize commands
    _createGreetingCommand = CreateGreetingCommand(_greetingService)
    _listGreetingCommand = ListGreetingCommand(_greetingService)
    _getGreetingCommand = GetGreetingCommand(_greetingService)

    _commandRegistry = CommandRegistry()

    # Register commands 
    def _registerCommands(self) -> None:
        self._commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.value,self._createGreetingCommand)
        self._commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.value,self._getGreetingCommand)
        self._commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.value,self._listGreetingCommand)
            
    def getCommandRegistry(self) -> CommandRegistry:
        self._registerCommands()
        return self._commandRegistry