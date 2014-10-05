// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.Print;

/**
 * Registry of all available commands.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class CommandRegistry {

  private final Map<String, ICliCommand> commandMap
    = new LinkedHashMap<String, ICliCommand>();

  // Singleton
  private CommandRegistry() {
    URL props = getClass().getClassLoader()
                          .getResource("com/digitalgeyser/jigger/command/command.properties");
    if ( props == null )
      throw new IllegalStateException("Can't locate command.properties");

    Properties p = new Properties();
    InputStream is = null;
    try {
      is = props.openStream();
      p.load(is);
    } catch (IOException ioe) {
      throw new IllegalStateException("Can't read command.properties", ioe);
    } finally {
      try { is.close(); } catch (Exception e) {}
    }

    for ( Object k: p.keySet() ) {
      if ( !(k instanceof String) ) continue;
      String key = (String)k;
      String value = p.getProperty(key);

      if ( key.startsWith("cmd.") ) {
        String cmdName = key.substring(4);
        String className = "com.digitalgeyser.jigger.command." + value;
        try {
          Class<?> clazz = getClass().getClassLoader().loadClass(className);
          Object x = clazz.newInstance();
          if ( x instanceof ICliCommand ) {
            commandMap.put(cmdName, (ICliCommand)x);
          }
        } catch ( Exception e) {
          throw new IllegalStateException("Can't create class " + className, e);
        }
      }
    }
  }

  private static class LazyHolder {
    private static final CommandRegistry instance = new CommandRegistry();
  }

  /**
   * Returns the single instance of this class.
   *
   *
   * @param
   * @returns CommandRegistry
   */
  public static CommandRegistry instance() {
    return LazyHolder.instance;
  }

  /**
   * Returns all available commands.
   *
   *
   * @param
   * @returns String[]
   */
  public String[] commands() {
    return commandMap.keySet().toArray(new String[0]);
  }

  /**
   * Returns a given command implementation, or null if not present.
   *
   *
   * @param
   * @returns ICliCommand
   */
  public ICliCommand command(final String commandName) {
    return commandMap.get(commandName);
  }

  /**
   * Prints out help for all the commands.
   *
   *
   * @param
   * @returns void
   */
  public void printHelp() {
    Print.out().println("Valid commands:");
    for ( String cmd: commands() ) {
      Print.out().println("  " + cmd);
    }
  }
}
