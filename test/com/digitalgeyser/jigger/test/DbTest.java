// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.CliParser;
import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.file.JigDir;

/**
 * Tests for basic DB operations
 *
 * Created on Oct 12, 2014
 *
 * @author Timotej
 */
public class DbTest {

  private static JigDir testDir() {
    return new JigDir(".testJigDir");
  }

  private static void clean() throws IOException {
    if (testDir().exists())
      testDir().rmdir();
    testDir().mkdir();
  }

  private static void run(final String... args)
      throws ParseException, IOException, JigDbException {
    JigContext jc = new JigContext(TestUtility.printer(),
                                   testDir(),
                                   CliParser.parse(TestUtility.printer(), args));
    jc.execute();
  }

  @Test
  public void testSimpleDbCreation() throws Exception {

    clean();
    run("init");

    try {
      clean();
      run("add");
      Assert.fail("add shouldn't succeed");
    } catch (JigDbException e) {
      // That's what should happen, since .jig doesn't exist.
    }

    clean();
    run("init");
    run("add", "x.java");
    clean();
  }

}
