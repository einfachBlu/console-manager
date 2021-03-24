# General
With this Library you can append the logger and command system to your console application to create microservices faster.

# Repository
### Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

# Dependency
### Gradle

```gradle
dependencies {
    compileOnly 'com.github.einfachBlu:console-manager:master-SNAPSHOT'
}
```

# Usage
### Initialize
```java
ConsoleReader consoleReader = new ConsoleReader(System.in, System.out);
consoleReader.setExpandEvents(false);
consoleReader.setPrompt("> ");

File logsDirectory = new File("/var/logs/myservice/");
Logger logger = new ConsoleAndFileLogger(consoleReader);
logger.init(logsDirectory);

// Initialize ConsoleInputReader
ConsoleCommandHandler consoleCommandHandler = new ConsoleCommandHandler(consoleReader, logger);
consoleCommandHandler.init();
```

### Register Command
```java
consoleCommandHandler.registerCommand("help", new String[] {"?"},
      new CommandExecutor() {
        @Override
        public void execute(String label, String[] args) {
          System.out.println("Command executed!");
        }
      });
```

### Read lines from console input
```java
System.out.println("Enter your age:");
String age = consoleCommandHandler.readLine();
System.out.println("You wrote " + age + "!");
```
