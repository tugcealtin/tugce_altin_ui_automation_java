# Insider UI Test Automation (Java + Selenium)

This project contains UI automation tests for the **Insider Careers** flows using  
**Java, Selenium WebDriver, TestNG and Maven**.  
The tests are implemented with a **Page Object Model (POM)** structure and cover
the requirements shared in the task description.

---

## Tech Stack

- **Language:** Java 17
- **Build Tool:** Maven
- **Test Framework:** TestNG
- **UI Automation:** Selenium WebDriver
- **Driver Management:** WebDriverManager

---

## Project Structure

```text
src
└── test
    └── java
        └── com.tugcealtin.ui
            ├── base
            │   ├── BasePage.java     // Common WebDriver & helpers (click, type, wait, scroll, hover)
            │   └── BaseTest.java     // WebDriver setup & teardown
            ├── pages
            │   ├── CareerPage.java     // Insider careerpage actions & verifications
            │   ├── HomePage.java     // Insider homepage actions & verifications
            │   └── LeverApplicationPage.java  // Lever Application page blocks & URL verification
            │   └── QAJobsPage.java  // QA Jobs page actions & verifications & URL verification
            └── tests
                └── CareersPageTest.java // Test class for the first scenario
                └── QAJobsPageTest.java // Test class for the second scenario

```
---

## Implemented Test Scenarios

### 1. CareersPageTest.verifyCareersPageBlocks

 **1–2** steps in case :

1. Open `https://useinsider.com/` and verify that the **Insider home page** is opened  
   - Checks that:
     - Insider logo is visible  
     - Header menu section is visible  

2. Open **Company → Careers** from the navigation bar and verify **main blocks** on Careers page:  
   - Waits until `/careers` URL is fully loaded  
   - Checks presence of:
     - `Locations` block (if available)
     - `Teams` block (if available)
     - `Life at Insider` block (if available)

### 2. QAJobsPageTest.verifyQAJobsInIstanbul

**3–5** steps in case :

3. Open `https://useinsider.com/careers/quality-assurance/`
    - Click **“See all QA jobs”**
    - Scroll to the filters area
    - Wait until **Department** is automatically set to `Quality Assurance`
    - Filter jobs by:
        - **Location:** `Istanbul, Turkiye`
        - **Department:** (already `Quality Assurance`)

4. Verify jobs list and job details:
    - Check that **jobs list is present** after filters
    - For **each job card**:
        - Position text contains `"Quality Assurance"`
        - Department text contains `"Quality Assurance"`
        - Location text contains `"Istanbul, Turkiye"`

5. Click the **“View Role”** button:
    - Switch to the newly opened **Lever Application** tab
    - Verify that Lever page is opened successfully.
   - Checks that:
     - Lever logo is visible
     - Application For button is visible
---

## How to Run the Tests
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-repo/tugce_altin_ui_automation_java.git
   cd tugce_altin_ui_automation_java
   ```
2. **Install dependicies:**
   ```bash
   mvn clean install
   ```
3. **Run the tests:**
    ```bash
    mvn clean test   
    ```
   **Run a Specific Test Class**

    ```bash
    mvn -Dtest=CareersPageTest test  
    ```
4. **View Test Reports:**
   - After execution, check the target/surefire-reports directory for detailed test results. (You can open index.html in a browser for a user-friendly report.)