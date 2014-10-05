// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.CliOptions;
import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.command.CommandRegistry;

/**
 * Unit test for command line options.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class CliTest {

  @Test
  public void commandRegistry() {
    String[] keys = CommandRegistry.instance().commands();
    Assert.assertTrue(keys.length > 0);
  }

  @Test
  public void cliOptions() {
    CliOptions opts = new CliOptions();
    ICliCommand cmd = CommandRegistry.instance().command("init");
    opts.setCommand(cmd);
    Assert.assertEquals(cmd, opts.command());
  }
}
