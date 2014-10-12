// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.JigConfig;
import com.digitalgeyser.jigger.db.JigDbException;

/**
 * Init command.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class Init implements ICliCommand {

  @Override
  public void execute(final JigConfig jd, final String[] args) {
    try {
      jd.init();
    } catch (JigDbException e) {
      jd.reportError(e);
    }
  }

}
