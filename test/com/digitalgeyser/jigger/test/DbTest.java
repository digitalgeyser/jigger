// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.CliParser;
import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.db.JigDbException;

/**
 * Tests for basic DB operations
 *
 * Created on Oct 12, 2014
 * @author Timotej
 */
public class DbTest {

  private static File testDir() {
    return new File(".testJigDir");
  }

  private static JigContext createTestContext(final boolean delete,
                                              final String ... args) throws IOException {
    if ( delete ) {
      if ( testDir().exists() )
        FileUtils.deleteDirectory(testDir());
      testDir().mkdirs();
    }
    return new JigContext(testDir(), CliParser.parse(args));
  }

  @Test
  public void testSimpleDbCreation() throws IOException, JigDbException {

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
