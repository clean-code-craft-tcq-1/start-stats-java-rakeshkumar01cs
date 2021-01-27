/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker;


/**
 * @author RUK3KOR
 *
 */
public class EmailAlert implements IAlerter {

  /** 
   * {@inheritDoc}
   * 
   * 
   */
  boolean emailSent=false;
  
  @Override
  public void alert() {
    System.out.println("hey i am email, sending maillll");
    emailSent=true;
  }
  
  
}
