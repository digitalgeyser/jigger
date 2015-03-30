// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.JigException;
import com.digitalgeyser.jigger.exec.Executor;

/**
 * Run command executes a target or an external program.
 *
 * Created on Mar 30, 2015
 * @author Timotej
 */
public class Run implements ICliCommand {

  @Override
  public void execute(final JigContext jc) throws JigException {
    Executor ex = new Executor(jc.cliOptions().commandArgs());
    if ( jc.isVerbose() ) {
      jc.printer().println("Executing command: '" + ex.commandLine() + "'");
    }
    int exitCode = ex.run();
    if ( exitCode != 0 ) {
      jc.printer().printlnErr("Process returned error code: " + exitCode);
    }
  }

}
