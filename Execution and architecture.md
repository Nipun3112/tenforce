1. How to run the test ?
   
Tests can be executed directly from eclipse:

- For this, Driver setup must be there
- WE can run the Tenforce.java class as a standard Java application from run menu available in eclipse header and even can  be run by right clicking at active java file > Run As Java Application
- Also it can be run from the command line using maven 
- Also Selenium dependencies should be configured to the project via pom.xml 
- Running the script will launch Chrome, perform the navigation, and print validation results in the console.

2. Framework choice justification:

- I chose Selenium WebDriver because it is the industry standard for browser automation and UI testing. 
It supports multiple browsers, integrates well with test frameworks like TestNG and allows handling dynamic elements with explicit waits and JavaScript execution.
 
- As tenforce tasks include navigation Tenforce’s career page and validating text, Selenium provides flexibility and reliability.
 
- And If this is part of a large suite, I would go with Selenium with TestNG for structured test cases, reporting, and parallel execution.

3. Architecture explanation:

The architecture follows a modular test automation design which includes multiple layers:
Test Layer: “Tenforce.java” script contains the test flow - opening the site, navigating to menus & validating content.

Driver/Utility Layer: WebDriver, WebDriverWait, Actions, and JavaScriptExecutor handle browser interactions and synchronization.

Validation Layer: Assertions or checks confirm expected outcomes like presence of “Feel free to send your CV to job” and we can assert multiple text available on the web page.
