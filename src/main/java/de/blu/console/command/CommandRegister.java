package de.blu.console.command;

import de.blu.console.command.data.Command;
import de.blu.console.command.data.CommandExecutor;
import lombok.Getter;
import org.reflections.Reflections;

public final class CommandRegister {

  @Getter private ConsoleCommandHandler consoleCommandHandler;

  public CommandRegister(ConsoleCommandHandler consoleCommandHandler) {
    this.consoleCommandHandler = consoleCommandHandler;
  }

  public void registerRecursive(String packageName) {
    Reflections reflections = new Reflections(packageName);
    for (Class<?> commandClass : reflections.getTypesAnnotatedWith(Command.class)) {
      if (commandClass.getSuperclass() != CommandExecutor.class) {
        continue;
      }

      try {
        CommandExecutor commandExecutor = (CommandExecutor) commandClass.newInstance();

        Command command = commandClass.getAnnotation(Command.class);
        String name = command.name();
        String[] aliases = command.aliases();

        this.getConsoleCommandHandler().registerCommand(name, aliases, commandExecutor);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
