// Copyright 2014 Platycore

package com.digitalgeyser.jigger.impl;

import java.util.ArrayList;
import java.util.List;

import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.JigException;
import com.digitalgeyser.jigger.file.JigFile;
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

  private RelativeFile f;

  public UncategorizedFileSource(final JigFile f) {
    this.f = new RelativeFile(f);
  }

  @Override
  public IReadable readable() {
    return f;
  }

  @Override
  public String name() {
    return f.name();
  }

  @Override
  public List<String> marshall(final JigContext context) {
    List<String> l = new ArrayList<String>();
    l.add(f.toLine(context));
    return l;
  }

  @Override
  public void unmarshall(final JigContext context, final List<String> list)
      throws JigException {
    f = new RelativeFile();
    f.fromLine(context, list.get(0));
  }
}
