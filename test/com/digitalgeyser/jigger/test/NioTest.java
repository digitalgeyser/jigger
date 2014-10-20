// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for many NIO things.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class NioTest {

  public void filesystem() {
    FileSystem fs = FileSystems.getDefault();
    for (Path p : fs.getRootDirectories()) {
      System.err.println("ROOT: " + p.toString());
    }
    for (FileStore p : fs.getFileStores()) {
      System.err.println("FS: " + p.toString());
    }
  }

  @Test
  public void paths() {
    Path p = FileSystems.getDefault().getPath("/some/file.txt");
    Assert.assertEquals("file.txt", p.getFileName().toString());
  }
}
