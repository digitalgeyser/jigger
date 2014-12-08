// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db;

import com.digitalgeyser.jigger.file.JigDir;
import com.digitalgeyser.jigger.file.JigFile;
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
  public void createNew(JigDir projectRoot) throws JigDbException;

  /**
   * This method is used to read existing database.
   *
   *
   * @param
   * @returns void
   */
  public void read(JigDir projectRoot) throws JigDbException;

  /**
   * THis method adds a source to the database.
   *
   *
   * @param
   * @returns void
   */
  public ISource addSource(JigFile source) throws JigDbException;

  /**
   * THis method adds a target to the database.
   *
   *
   * @param
   * @returns ITarget
   */
  public ITarget addTarget(JigFile destination) throws JigDbException;

  /**
   * General purpose key/value pair properties that are carried along with the database.
   *
   * @returns Properties
   */
  public String[] preferenceKeys();

  /**
   * Returns the value of the preference under a given key.
   *
   *
   * @param key
   * @returns Object
   */
  public Object preferenceValue(String key);
}
