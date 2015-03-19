// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.JigException;
import com.digitalgeyser.jigger.file.JigFile;

/**
 * Method that drives the adding of resources.
 *
 * Created on Oct 6, 2014
 *
 * @author Timotej
 */
public class Add implements ICliCommand {

  @Override
  public void execute(final JigContext ctx) throws JigException {
    String[] args = ctx.cliOptions().commandArgs();
    for (String a : args) {
      JigFile f = new JigFile(a);
      ctx.db().addSource(f);
    }
  }
}
