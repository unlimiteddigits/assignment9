package jUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BloodPressureTest.class, BmiTesting.class, CholesterolTest.class })
public class RunAllTests {

}
