package tests;

public class Day14_WebDriverException {
    // 1. When you quit and still call the driver
    // 2.Happens when chrome driver and web browser don't have the same versions

    // SOLUTION: Keep drivers up to date that is compatible with the browser version

    /*   INTERVIEW QUESTIONS ABOUT WAITS
1. Tell me 5 exception that you get/What type of exceptions do you get in selenium?

Null pointer, no such element, time out, slate element reference, web driver

2. What is your solution?
Read the error message and learn what is the error and where it is.
In general, error happens because of the timing issue, wrong locator, or iframe/windows/alerts
Each error has specific solutions but in general, I debug my code, and do some research then execute the code one more time after the fix.
(debug means inspect my code closely, check where failure happened, by reading the failure message on the console,
change code if necessary, run the test again)

3. What type of waits do you use?
I use implicit or explicit wait

4. Which wait do you prefer?
Explicit wait works better in some cases. When I use explicit wait, and still see timeout exception, then then there can be other issues such as incorrect locators.

5. Why do you prefer that wait?
I already have implicit wait in my Driver class, but I prefer explicit wait when I need to use an expected condition such as element is not visible.
How do you resolve synchronization issue?
I use implicit or explicit wait. In my driver class, I already have implicit wait, that handles most of the wait issues,
but when it is not enough than I use explicit wait.


     */


}
