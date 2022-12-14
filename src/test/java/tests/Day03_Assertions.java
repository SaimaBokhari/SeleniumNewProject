package tests;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day03_Assertions {
    @Test
    public void assertions(){
        /*
        What is assertion in testing?
        Assertion is done to check if expected result is equal to actual result.
         - expected = actual -> PASS
         - expected != actual -> FAIL
        ---------------------------
        assertEquals("expected","actual");  IF EQUALS --> PASS
        assertTrue(if value is true); --> PASS
        assertTrue(if value is false); --> FAIL
        assertFalse(if value is false); --> PASS
        assertFalse(if value is true); --> FAIL
        ---------------------------

         */
        // Assert.assertEquals(); OR

        assertEquals(5,5); // PASS
        // assertEquals("Values didn't match.",3,5); // FAIL
        assertEquals("Java","Java"); // PASS
       // assertEquals("Java","java");
        assertEquals("java".contains("j"), true); // PASS
//      ------------------------
        assertTrue(true);
      //  assertTrue(false);
        assertTrue("java".contains("j")); // PASS

        int a =3;
        int b =5;
        //assertTrue(a==b);
//      ------------------------
        assertFalse("Java".contains("j")); // PASS
        assertFalse( a==b); // PASS
        assertFalse(a>b);  // PASS
//      ------------------------
        String name = "John";
        assertTrue(name.contains("J")); // PASS
        assertFalse(name.contains("A")); // PASS

        // These are examples of HARD ASSERTION ... Test execution stops if the test fails at any step
        // Soft assertion is in TestNG

        /*
        Verification is like IF-else statement

        even if this if-statement fails, the test execution will continue.
         */

        if("Java".contains("j")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        if(name.contains("X")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed!");
        }
       /*
       Interview question:
                 What's the difference between assertion and verification?
                 "Assertion stops the execution in case of failure, whereas verification continues even
                 if it fails at any point."
                 e.g JUnit assertions are hard assertions. If-Statement (or while loops) are verifications.
                     TestNG has soft assertions.(will learn later)

        */




    }

}
