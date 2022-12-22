package tests;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Day09_Cookies extends TestBase {
    /*
    - It's a small piece of data stored in the browser temporarily.
    - generated by the browser
    - it's not a big deal like iframes.
    - it's used to track our behaviour on the internet/habits/experience, get information about your interest

    What is a cookie?
    - The temporary data that is created by the browser.
    - cookies are stored in our computers as we visit the websites.

    We can automate handling cookies. Through selenium, we can
    - find the cookies
    - add new cookies
    - delete cookies

    - To summarise
    Cookies are temporary data/files that is generated by the browsers.
    It's a way for a website to remember you, your preferences, and your habits online.

     */


    @Test
    public void cookieTest() throws InterruptedException {

//        -Go to amazon  and automate the tasks:
           driver.get("https://www.amazon.com");

//        1. Find the total number of cookies
           Set<Cookie> allCookies =  driver.manage().getCookies();
           int numOfCookies = allCookies.size();
           System.out.println("numOfCookies = " + numOfCookies);  // 8

        System.out.println("----------------------");
//        2. Print all the cookies
           for (Cookie eachCookie : allCookies){
               System.out.println("Cookie==> " + eachCookie);
               System.out.println("Cookie Value==> " + eachCookie.getValue());
               System.out.println("Cookie Name==> " + eachCookie.getName());
               System.out.println("Cookie Domain==> " + eachCookie.getDomain());
           }

        System.out.println("----------------------");
//        3. Get the cookies by their name
               System.out.println("Cookie named : " + driver.manage().getCookieNamed("skin")); // getting the entire cookie mentioned in the method

        System.out.println("----------------------");
//        4. Add new cookie
               Cookie cookie = new Cookie("my-fav-cookie","choc-chip");
               driver.manage().addCookie(cookie);

               Thread.sleep(2000);

               // to see whether mine is added or not
               Set<Cookie> newCookies =  driver.manage().getCookies();
               System.out.println("New number Of Cookies ==> " + newCookies.size());

        System.out.println("----------------------");

//        5. Delete cookie by name
               driver.manage().deleteCookieNamed("session-token");
               int lastNumberOfCookie = driver.manage().getCookies().size();
               System.out.println("lastNumberOfCookie = " + lastNumberOfCookie);

        System.out.println("----------------------");

//        6. Delete all the cookies
               driver.manage().deleteAllCookies();
               int finalNumOfCookies = driver.manage().getCookies().size();
               System.out.println("finalNumOfCookies = " + finalNumOfCookies);

    }

}
/*
        Given
                Go to "https://www.amazon.com"
        When
                Find the total number of cookies
        And
                Print all the cookies
        And
                Get the cookies by their name
        And
                Add new cookie
        And
                Delete cookie by name
        And
                Delete all the cookies
        */
