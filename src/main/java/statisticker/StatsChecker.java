/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker;


/**
 * @author RUK3KOR
 *
 */
public class StatsChecker {

  /**
   * @param maxThreshold
   * @param alerters
   * 
   * 
   * 
   * 
   */
  float maxThreshold;
  IAlerter[] alerters;
  
  public StatsChecker(float maxThreshold, IAlerter[] alerters) {
 this.maxThreshold=maxThreshold;
  this.alerters=alerters;
  }

  /**
   * @param args
   */
  
  
  public static void main(String[] args) {
 

  }

  /**
   * @param numbers
   */
  public void checkAndAlert(Float[] numbers) {
    
    for(int i=0;i<numbers.length ;i++)
    {
      //for those number>
      if(this.maxThreshold > numbers[i])
      {
        for(int j = 0; j < this.alerters.length; j++)
        {
          this.alerters[j].alert();
        }
      }
  
    }
  }

}
