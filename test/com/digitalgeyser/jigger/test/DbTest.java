// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.CliParser;
import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.model.AbsoluteFile;

/**
 * Tests for basic DB operations
 *
 * Created on Oct 12, 2014
 * 
 * @author Timotej
 */
public class DbTest {

  private static AbsoluteFile testDir() {
    return new AbsoluteFile(".testJigDir");
  }

  private static JigContext createTestContext(final boolean delete,
                                              final String... args)
      throws ParseException, IOException {
    if (delete) {
      if (testDir().exists())
        testDir().deleteDirectory();
      testDir().mkdirs();
    }
    return new JigContext(TestUtility.printer(), testDir(),
        CliParser.parse(TestUtility.printer(), args));
  }

  @Test
  public void testSimpleDbCreation() throws Exception {

    JigContext c = createTestContext(true, "init");
    c.execute();

    try {
      c = createTestContext(true, "add");
      c.execute();
      Assert.fail("add shouldn't succeed");
    } catch (JigDbException e) {
      // That's what should happen, since .jig doesn't exist.
    }
  }

}
