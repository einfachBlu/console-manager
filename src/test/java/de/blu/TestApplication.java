package de.blu;

import de.blu.console.command.ConsoleCommandHandler;
import de.blu.console.command.data.CommandExecutor;
import de.blu.console.logging.ConsoleAndFileLogger;
import de.blu.console.logging.Logger;
import jline.console.ConsoleReader;

import java.io.File;
import java.io.IOException;

public final class TestApplication {
  public static void main(String[] args) {
    new TestApplication();
  }

  public TestApplication() {
    // Init Logging
    try {
      ConsoleReader consoleReader = new ConsoleReader(System.in, System.out);
      consoleReader.setExpandEvents(false);
      consoleReader.setPrompt("> ");

      File logsDirectory = new File("C:\\Users\\Blu\\Desktop\\temp\\logs");
      Logger logger = new ConsoleAndFileLogger(consoleReader);
      logger.init(logsDirectory);

      // Initialize ConsoleInputReader
      ConsoleCommandHandler consoleCommandHandler =
              new ConsoleCommandHandler(consoleReader, logger);
      consoleCommandHandler.init();

      System.out.println("&eHello &6World");
      System.out.println("Hello &aa&bb&cc&dd&ee&ff&00&11&22&33&44&55&66&77&88&rTest");
      System.out.println("Hello &aWorld&r 3");

      consoleCommandHandler.registerCommand(
              "help",
              new String[] {"?"},
              new CommandExecutor() {

                @Override
                public void execute(String label, String[] args) {
                  System.out.println("Help Command executed!");

                  System.out.println("Enter your age:");
                  String age = consoleCommandHandler.readLine();
                  System.out.println("You wrote " + age + "!");
                  System.out.println("Can you type it again?");
                  age = consoleCommandHandler.readLine();
                  System.out.println("Amazing! last input was: " + age);
                }
              });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
