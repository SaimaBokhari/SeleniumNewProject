package tests.day02;

import org.junit.*;

public class Day02_JUnitAnnotations {
    /*

    So far we used main method, we no longer need to use it to create test cases when we have JUnit
    We will learn JUnit annotations
       *  @Test: is used to create test cases
           NOTE: All @Test methods must be void
       *  @Before: runs before each @Test class. This is used to run repeated pre-conditions.
                   For example: setup, create driver, maximise window
       *  @After: runs after each @Test class. This is used to run repeated after conditions.
                   For example: driver.quit(), report generation

       *  @BeforeClass: This runs before each class ONLY ONCE.. can be used for pre-condition.
                        This method must be static.
       *  @AfterClass: This runs AFTER each class ONLY ONCE
                         This method must be static.

       *  @Ignore: is used to skip/ ignore a test case


     */

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class runs before the entire class.");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class runs after the entire class.");
    }

    @Before
    public void setUp(){
        System.out.println("Before Method runs before each @Test annotation");
    }

    @After
    public void tearDown(){
        System.out.println("After Method runs after each @Test annotation");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }


    @Test@Ignore
    public void test3(){
        System.out.println("Test 3");
    }

    @Test
    public void test4(){
        System.out.println("Test 4");
    }

    @Test
    public void test5(){
        System.out.println("Test 5");
    }


}
