// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db.fs;

import java.io.File;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;

/**
 * Implementation of the IJigDatabase that saves and reads it's content from the
 * .jig directory at the root of the project.
 * 
 * Created on Oct 12, 2014
 * 
 * @author Timotej
 */
public class DotJigDatabase implements IJigDatabase {
  private static final String DIR = ".jig";

  private File dotJig;

  @Override
  public void createNew(final File projectRoot) throws JigDbException {
    File d = new File(projectRoot, DIR);
    if (d.exists()) {
      throw new JigDbException(DIR + " already exists.");
    }
    d.mkdirs();
    if (d.exists() && d.isDirectory()) {
      dotJig = d;
    } else {
      throw new JigDbException("Could not create " + DIR + " directory.");
    }
  }

  @Override
  public void read(final File projectRoot) throws JigDbException {
    File d = new File(projectRoot, DIR);
    if (d.exists() && d.isDirectory()) {
      dotJig = d;
    } else {
      throw new JigDbException(DIR
          + " is missing. You need to run 'init' first.");
    }
  }

}
