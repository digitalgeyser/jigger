// Copyright 2014 Platycore

package com.digitalgeyser.jigger.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.digitalgeyser.jigger.JigException;
import com.digitalgeyser.jigger.model.IReadable;
import com.digitalgeyser.jigger.model.ISource;
import com.digitalgeyser.jigger.model.RelativeFile;

/**
 * This source is a simple file that we don't known anything particular about.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class UncategorizedFileSource implements ISource {

  private final RelativeFile f;

  public UncategorizedFileSource(final File f) {
    this.f = new RelativeFile(f);
  }

  @Override
  public IReadable readable() {
    return f;
  }

  @Override
  public List<String> marshall() {
    List<String> l = new ArrayList<String>();
    l.add(f.file().getAbsolutePath());
    return l;
  }

  @Override
  public void unmarshall(final List<String> list) throws JigException {
    // TODO: Add unmarshalling
  }
}
