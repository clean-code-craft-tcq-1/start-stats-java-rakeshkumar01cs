/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker;


/**
 * @author RUK3KOR
 *
 */
public class LEDAlert implements IAlerter {

  /** 
   * {@inheritDoc}
   */
  boolean ledGlows=false;
  @Override
  public void alert() {
    // TODO Auto-generated method stub
    System.out.println("red green yellow glowiiiiiiiing");
  ledGlows=true;
  }

}
