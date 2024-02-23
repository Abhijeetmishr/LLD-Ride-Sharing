from sys import argv
import traceback
from typing import List
from src.configuration import Configuration


def main():
    if len(argv) != 2:
        raise Exception("File path not entered")
    run(argv)

def run(commandLineArgs : List[str]) -> None:

    conf = Configuration()

    commandRegistry = conf.getCommandRegistry()

    inputFile = commandLineArgs[1].split("=")[1]
    try:
        f = open(inputFile, 'r')
        while True:
            line = f.readline()
            if not line:
                break
            commandRegistry.invokeCommand(line)
       
    except Exception as e:
        print(e.__class__, '-', e)
        traceback.print_exc()
      
if __name__ == "__main__":
    main()