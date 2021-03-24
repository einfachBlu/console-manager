package de.blu.console.command.data;

public abstract class CommandExecutor {

  /**
   * This Method will be called when the Command will be executed
   *
   * @param label the label which was used for the Command
   * @param args the arguments from the command line
   */
  public abstract void execute(String label, String[] args);
}
