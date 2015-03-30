// Copyright 2014 Platycore

package com.digitalgeyser.jigger.exec;

import java.lang.ProcessBuilder.Redirect;

import com.digitalgeyser.jigger.JigException;

/**
 * Class used to
 *
 * Created on Mar 30, 2015
 * @author Timotej
 */
public class Executor {

  private final ProcessBuilder pb;

  public Executor(final String... commandLine) {
    pb = new ProcessBuilder(commandLine);
    pb.redirectOutput(Redirect.INHERIT);
    pb.redirectInput(Redirect.INHERIT);
    pb.redirectError(Redirect.INHERIT);
  }

  public String commandLine() {
    StringBuilder sb = new StringBuilder();
    String sep = "";
    for ( String s: pb.command() ) {
      sb.append(sep).append(s);
      sep = " ";
    }
    return sb.toString();
  }

  public int run() throws JigException {
    try {
      Process p = pb.start();
      return  p.waitFor();
    } catch (Exception e) {
      throw new JigException(e);
    }

  }
}
