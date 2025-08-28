# BankAccount – JUnit Testing Project

[![Java](https://img.shields.io/badge/Java-11-blue.svg)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![JUnit](https://img.shields.io/badge/JUnit-5-green.svg)](https://junit.org/junit5/)

A simple **Java project** that demonstrates **unit testing with JUnit 5**.  
The project models a **basic Bank Account** with common operations such as **deposit, withdraw, and transfer**.  
Comprehensive **JUnit tests** are written to validate both **positive** and **negative scenarios**, ensuring correct and reliable behavior.  

---

## Features

* `BankAccount` class with:

  * `deposit(double amount)` – adds money to the account.
  * `withdraw(double amount)` – withdraws money, prevents overdraft.
  * `transfer(BankAccount toAccount, double amount)` – transfers funds between accounts.
* Input validation (e.g., prevents negative amounts, null accounts, or overdrafts).
* Fully tested with **JUnit 5**.

---

## Project Structure

```
BankAccount-JUnit-Testing/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── BankAccount.java
│   │
│   └── test/
│       └── java/
│           └── BankAccountTest.java
│
└── README.md
```

---

## Sample Test Cases

* **Valid deposit & withdraw**
* **Deposit negative amount → exception**
* **Withdraw more than balance → exception**
* **Successful transfer between accounts**
* **Transfer with insufficient funds**
* **Transfer to null account → exception**

---

## How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/DyoNheL/BankAccount-JUnit-Testing.git
   ```

2. Open the project in your preferred IDE (**IntelliJ IDEA, Eclipse, or VS Code with Java extensions**).

3. Run the tests:

   * **Option 1 (IDE):**
     Open `BankAccountTest.java` in your IDE, **right-click on the file (or inside the class)** → choose **Run 'BankAccountTest'** (or **Run JUnit Test** in IntelliJ / Eclipse).
   * **Option 2 (Maven CLI):**
     Run:

     ```bash
     mvn test
     ```

---

## Example Test Output (JUnit 5)

* **If running via IDE (IntelliJ / Eclipse):**
  You will see green check marks ✅ indicating that all tests passed.

  Example (IntelliJ / Eclipse):

  ```
  Test Results
  ✔ testInitialBalance()
  ✔ testDeposit()
  ✔ testDepositNegativeAmount()
  ✔ testWithdraw()
  ✔ testWithdrawInsufficientFunds()
  ✔ testWithdrawNegativeAmount()
  ✔ testTransferSuccess()
  ✔ testTransferInsufficientFunds()
  ✔ testTransferToNullAccount()
  ```

* **If running via Maven CLI (`mvn test`):**

  ```
  [INFO] Running BankAccountTest
  [INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
  [INFO] BUILD SUCCESS
  ```

---

## Learning Highlights

* Writing **clean Java classes** with business logic.
* Using **JUnit 5** for unit testing.
* Handling **positive and negative test cases**.
* Applying **test-driven development (TDD) concepts** in a simple project.

---
