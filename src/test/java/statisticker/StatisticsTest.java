package statisticker;

import static org.junit.Assert.*;
import org.junit.Assert;
import jdk.nashorn.internal.AssertsEnabled;
import java.lang.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMaxx()
    {
        Float[] numbers = {1.2f, 7.7f, 5.2f, 6.5f};
        List<Float> numberList = Arrays.asList(numbers);
        Statistics.Stats s = Statistics.getStatistics(numberList);
        float epsilon = 0.001f;
        assertEquals(s.average, 5.15f, epsilon);
        assertEquals(s.min, 1.2f, epsilon);
        assertEquals(s.max, 7.7f, epsilon);
    }
    @Test
    public void reportsNaNForEmptyInput()
    {
        List<Float> emptyList = new ArrayList<>();
        Statistics.Stats s = Statistics.getStatistics(emptyList);
        //All fields of computedStats (average, max, min) must be
        //Float.NaN (not-a-number), as described in
        //https://www.geeksforgeeks.org/nan-not-number-java/
        //Design the asserts here and implement accordingly.
        Assert.assertTrue(s.average.isNaN());
        Assert.assertTrue(s.min.isNaN());
        Assert.assertTrue(s.max.isNaN());
        assertEquals(s.average, Float.NaN, 0.0);
        assertEquals(s.min, Float.NaN, 0.0);
        assertEquals(s.max, Float.NaN, 0.0);
        
    }

    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
        EmailAlert emailAlerter = new EmailAlert();
        LEDAlert ledAlerter = new LEDAlert();
        IAlerter alerters[] = {emailAlerter, ledAlerter};
        float maxThreshold = 10.2f;
        StatsChecker checker = new StatsChecker(maxThreshold, alerters);
        
        Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
        List<Float> numberList = Arrays.asList(numbers);
        checker.checkAndAlert(numberList);
        
        assertTrue(emailAlerter.emailSent);
        assertTrue(ledAlerter.ledGlows);
    }
   
    
}
