// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db.fs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.impl.SourceUtilities;
import com.digitalgeyser.jigger.model.ISource;
import com.digitalgeyser.jigger.model.ITarget;

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
  private File sourceDir;
  private File destinationDir;

  private void initializeDirectories(final File d) {
    this.dotJig = d;
    this.sourceDir = new File(d, "source");
    this.destinationDir = new File(d, "destination");
  }

  @Override
  public void createNew(final File projectRoot) throws JigDbException {
    File d = new File(projectRoot, DIR);
    if (d.exists()) {
      throw new JigDbException(DIR + " already exists.");
    }
    d.mkdirs();
    if (d.exists() && d.isDirectory()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException("Could not create " + DIR + " directory.");
    }
  }

  @Override
  public void read(final File projectRoot) throws JigDbException {
    File d = new File(projectRoot, DIR);
    if (d.exists() && d.isDirectory()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException(DIR
          + " is missing. You need to run 'init' first.");
    }
  }

  @Override
  public ISource addSource(final File source) throws JigDbException {
    try {
      if (!sourceDir.exists())
        FileUtils.forceMkdir(sourceDir);
      ISource s = SourceUtilities.createSource(source);
      // TODO: Add physical saving
      return s;
    } catch (IOException ioe) {
      throw new JigDbException(ioe);
    }
  }

  @Override
  public ITarget addTarget(final File destination) throws JigDbException {
    return null;
  }
}
