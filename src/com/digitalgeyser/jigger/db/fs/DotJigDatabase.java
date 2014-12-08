// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db.fs;

import java.io.IOException;
import java.util.Map;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.file.JigDir;
import com.digitalgeyser.jigger.file.JigFile;
import com.digitalgeyser.jigger.impl.SourceUtilities;
import com.digitalgeyser.jigger.impl.YamlUtilities;
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
  private static final String PROPS = "prefs.yaml";

  private JigDir dotJig;
  private JigDir sourceDir;
  private JigDir targetDir;
  private Map<String, Object> preferences = null;

  private void initializeDirectories(final JigDir d) {
    this.dotJig = d;
    this.sourceDir = d.subdir("source");
    this.targetDir = d.subdir("target");
  }

  @Override
  public void createNew(final JigDir projectRoot)
      throws JigDbException {
    JigDir d = new JigDir(projectRoot, DIR);
    if (d.exists()) {
      throw new JigDbException(DIR + " already exists.");
    }
    d.mkdir();
    if (d.exists()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException("Could not create " + DIR + " directory.");
    }
  }

  @Override
  public void read(final JigDir projectRoot) throws JigDbException {
    JigDir d = projectRoot.subdir(DIR);
    if (d.exists()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException(DIR
          + " is missing. You need to run 'init' first.");
    }
  }

  @Override
  public ISource addSource(final JigFile source) throws JigDbException {
    if (!sourceDir.exists())
      sourceDir.mkdir();
    ISource s = SourceUtilities.createSource(source);
    try {
      sourceDir.touch(s.name());
      return s;
    } catch (IOException ioe) {
      throw new JigDbException(ioe);
    }
  }

  @Override
  public ITarget addTarget(final JigFile destination)
      throws JigDbException {
    return null;
  }

  private void readPreferences() throws IOException {
    JigFile f = dotJig.file(PROPS);
    Object x = YamlUtilities.readYamlFile(f.file());
    if ( x instanceof Map ) {
      this.preferences = (Map<String, Object>)x;
    }
  }

  @Override
  public String[] preferenceKeys() {
    if ( preferences == null ) {
      try {
        readPreferences();
      } catch (Exception e) {
        return new String[0];
      }
    }
    return preferences.keySet().toArray(new String[0]);
  }

  @Override
  public Object preferenceValue(final String key) {
    if ( preferences == null ) {
      try {
        readPreferences();
      } catch (Exception e) {
        return new String[0];
      }
    }
    return preferences.get(key);
  }
}
