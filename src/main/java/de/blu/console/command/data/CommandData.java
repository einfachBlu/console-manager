package de.blu.console.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class CommandData {
  private String name;
  private String[] aliases;
  private CommandExecutor commandExecutor;
}
