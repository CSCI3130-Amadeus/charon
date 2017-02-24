package org.amadeus.charon.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestExample extends TestCase {
  
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public TestExample( String testName )
  {
      super( testName );
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
      return new TestSuite( TestExample.class );
  }

  public void testApp()
  {
    UserManager instance = UserManager.getInstance();
    assertNotNull(instance);
  }
}
