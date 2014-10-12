// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.db.JigDbManager;

/**
 * Tests for basic DB operations
 *
 * Created on Oct 12, 2014
 * @author Timotej
 */
public class DbTest {

  private File testDir() {
    return new File(".testJigDir");
  }

  @Test
  public void testDbCreate() throws IOException, JigDbException {
    File d = testDir();
    if ( d.exists() ) {
      FileUtils.deleteDirectory(d);
    }

    d.mkdirs();

    IJigDatabase db = JigDbManager.instance().getDefault();

    try {
      db.read(d);
      Assert.fail("Reading empty directory should fail.");
    } catch (JigDbException ex) {
      // Ok, this is what's supposed to happen
    }

    db.createNew(d);

  }

}
