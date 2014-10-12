// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.CliOptions;
import com.digitalgeyser.jigger.CliParser;
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
    opts.setCommand("init", cmd);
    Assert.assertEquals(cmd, opts.command());
  }

  @Test
  public void cliParser() throws ParseException {
    ICliCommand cmd = CommandRegistry.instance().command("init");
    CliOptions opts = CliParser.parse(TestUtility.printer(),
                                      new String[] { "init", "a", "b", "c"});
    Assert.assertSame(cmd, opts.command());
    Assert.assertEquals(3, opts.commandArgCount());
    Assert.assertEquals("c", opts.commandArgs()[2]);
  }

  @Test
  public void verifyCommandExistence() {
    String[] cmds = new String[] { "init", "add" };

    for ( String cmd: cmds ) {
      Assert.assertNotNull(cmd + " exists", CommandRegistry.instance().command(cmd));
    }
  }
}
