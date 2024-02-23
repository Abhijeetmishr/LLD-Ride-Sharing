package com.example.demo;

import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.services.GreetingService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
