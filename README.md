### Veeva

---

### Project Description

This project features a Selenium automation script developed in Java to validate the job search functionality on the Veeva Careers page.

* The script simulates a user journey through the site: navigating from the homepage to the Careers section, opening the job search tool, and applying filters for region and work type.
* It automates essential actions like selecting “United States,” enabling the “Remote” checkbox, and entering the keyword “Associate Quality Engineer.”
* The **Locators** class has been introduced to centralize element identification, improving maintainability and reducing redundancy. This class contains well-structured XPath for key elements.
* The `Thread.sleep` method is used solely for visual validation purposes.

At the end of the test, the script performs multiple assertion checks to confirm that the filtered results display the correct job criteria: `"Associate Quality Engineer"`, `"Remote"`, and `"United States"`.

---

### Technologies & Tools Used

* **Programming Language:** Java
* **Testing Framework:** Selenium WebDriver
* **IDE:** IntelliJ IDEA
* **Locator Strategy:** XPath, ID
* **Screen Capture Tool:** Snipping Tool (used for visual test validation)
* **Operating System:** Windows 10
