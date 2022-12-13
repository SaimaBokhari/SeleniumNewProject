package tests.day03;

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
        assertEquals("expected","actual");
        assertTrue(if value is true); --> PASS
        assertTrue(if value is false); --> FAIL
        assertFalse(if value is false); --> PASS
        assertFalse(if value is true); --> FAIL
        ---------------------------

         */
        assertEquals(5,5); // PASS
        assertEquals("Java","Java"); // PASS
       // assertEquals("Java","java");
        assertEquals("java".contains("j"), true); // PASS
//      ------------------------
        assertTrue("java".contains("j")); // PASS
//      ------------------------
        assertFalse("Java".contains("j")); // PASS
//      ------------------------

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
       /*
       Interview question:
                 What's the difference between assertion and verification?
                 "Assertion stops if assertion fails, whereas verification continues even
                 if it fails at any point."
                 e.g JUnit assertions are hard assertions. If Statement (or while loops) are verifications
                     TestNG has soft assertions.(will learn later)

        */




    }

}
