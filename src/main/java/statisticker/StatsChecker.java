/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker;

import java.util.Collections;
import java.util.List;

/**
 * @author RUK3KOR
 *
 */
public class StatsChecker {

  /**
   * @param maxThreshold
   * @param alerters
   *    
   */
  float maxThreshold;
  IAlerter[] alerters;
  float maxNumber;
  
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
   * @param numberList
   */
  public void checkAndAlert(List<Float> numberList) {
    // Getting the Max number
    maxNumber = Collections.max(numberList);
    if(maxNumber > this.maxThreshold)
    {
      // Alert 
      for(int j = 0; j < this.alerters.length; j++)
      {
        this.alerters[j].alert();
      }
    }
   
/*
    //Not used code, different logic
    for(int i=0;i<numberList.size() ;i++)
    {
      if(numberList.get(i) > this.maxThreshold )
      {
        for(int j = 0; j < this.alerters.length; j++)
        {
          this.alerters[j].alert();
        }
      }
    }
*/
 }
}
