// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db;

import java.io.File;

import com.digitalgeyser.jigger.model.ISource;
import com.digitalgeyser.jigger.model.ITarget;

/**
 * Interface that represents the "database" for a configuration.
 * 
 * A typical database is a content of the .jig/ directory. But there may be
 * other implementations in the future.
 * 
 * Created on Oct 12, 2014
 * 
 * @author Timotej
 */
public interface IJigDatabase {

  /**
   * This method is used to initialize the database if database doesn't exist
   * yet.
   * 
   * If it exists, it throws an exception.
   * 
   * 
   * @param
   * @returns void
   */
  public void createNew(File projectRoot) throws JigDbException;

  /**
   * This method is used to read existing database.
   * 
   * 
   * @param
   * @returns void
   */
  public void read(File projectRoot) throws JigDbException;

  /**
   * THis method adds a source to the database.
   * 
   * 
   * @param
   * @returns void
   */
  public ISource addSource(File source) throws JigDbException;

  /**
   * THis method adds a target to the database.
   * 
   * 
   * @param
   * @returns ITarget
   */
  public ITarget addTarget(File destination) throws JigDbException;
}
