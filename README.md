# Fencing Weapon Inspection System

## 1. Project Description

This project is a Java application developed for Assignment 4 of the Software Design Patterns course.

The main purpose of the project is to demonstrate the **Facade Design Pattern** using a fencing weapon inspection system.

Before a fencing competition, weapons must be checked to make sure they are safe and working correctly.

The system supports three types of fencing weapons:

- **Foil** — Rapier
- **Epee** — Épée
- **Sabre** — Sabre

The application checks weapon safety and electrical circuits. Based on these checks, each weapon receives one of two results: **APPROVED** or **REJECTED**.

The system also saves inspection history and explains why a weapon failed an inspection.

## 2. Design Pattern — Facade

The main design pattern used in this project is **Facade**.

The Facade Pattern provides a simple interface for working with multiple subsystem classes.

Without Facade, the Main class would need to communicate with every subsystem separately.

In my project, the `FencingInspectionFacade` class manages the inspection process.

For example, the client only needs to call:

`facade.inspectWeapon("F001");`

This single method performs several operations:

1. Finds the weapon in the registry.
2. Checks weapon safety.
3. Checks the electrical circuit.
4. Determines whether the weapon is approved.
5. Creates an inspection record.
6. Saves the result in the inspection archive.

This makes the Main class simpler and reduces its dependencies on subsystem classes.

## 3. Project Structure

The project contains the following classes.

### Main Classes

- **Main.java** — The entry point of the application.
- **Weapon.java** — Stores weapon information and condition.
- **WeaponType.java** — Defines the three weapon types: FOIL, EPEE, and SABRE.
- **InspectionRecord.java** — Stores the details and result of an inspection.

### Subsystem Classes

**WeaponRegistry.java**

Registers weapons and searches for them using serial numbers. It also prevents duplicate registration.

**SafetyInspector.java**

Checks whether the blade is intact and the guard is securely attached.

**ElectricalInspector.java**

Checks whether the weapon's electrical circuit is working.

**ApprovalService.java**

Receives the inspection results and makes the final approval decision. Both safety and electrical checks must pass.

**InspectionArchive.java**

Stores inspection records and allows the application to retrieve inspection history and the latest result.

### Facade Class

**FencingInspectionFacade.java**

Connects all five subsystems and coordinates their operations. The client does not need to manage these subsystems directly.

## 4. How the System Works

First, the application creates three weapons with different conditions.

| Weapon | Serial Number | Condition | Expected Result |
|---|---|---|---|
| Foil | F001 | All checks passed | APPROVED |
| Epee | E001 | Electrical problem | REJECTED |
| Sabre | S001 | Guard problem | REJECTED |

After registration, the Facade starts the inspection process.

Example console output:

```text
Weapon registered: F001
Weapon registered: E001
Weapon registered: S001

Weapon Inspection

Electrical circuit is working!
F001 APPROVED
Result saved: F001

Electrical circuit is not working!
E001 REJECTED
Result saved: E001

Guard is not secure!
Electrical circuit is working!
S001 REJECTED
Result saved: S001
```

The application can also show why a weapon was rejected.

```text
Inspection Reasons

Foil: All checks passed
Epee: Electrical check failed
Sabre: Safety check failed
```

## 5. Clean Code Principles

I tried to follow Clean Code principles while developing the application.

**1. Meaningful Names**

Classes and methods have clear names, such as `SafetyInspector`, `registerWeapon()`, and `inspectWeapon()`.

**2. Single Responsibility Principle**

Each subsystem has one main responsibility. For example, `ElectricalInspector` checks the electrical circuit, while `InspectionArchive` manages inspection history.

**3. Encapsulation**

The `Weapon` and `InspectionRecord` classes use private fields and public getter methods to provide access to their data.

**4. Simple and Focused Methods**

Methods perform specific tasks. The Facade coordinates the operations instead of repeating the inspection logic inside one large method.

**5. Proper Error Handling**

The application uses exceptions to handle invalid operations, such as searching for an unknown weapon or registering the same weapon twice.

## 6. Unit Testing

I used **JUnit 5** to test the application.

The project includes eight automated tests:

1. `shouldApproveSafeFoil()` — Checks approval of a working foil.
2. `shouldRejectBrokenEpee()` — Checks rejection of an epee with an electrical problem.
3. `shouldRejectUnsafeSabre()` — Checks rejection of a sabre with an unsafe guard.
4. `shouldSaveRepeatedInspections()` — Checks that repeated inspections are saved.
5. `shouldRejectUnknownWeapon()` — Checks error handling for unknown weapons.
6. `shouldRejectDuplicateRegistration()` — Checks duplicate weapon registration.
7. `shouldExplainRejectionReason()` — Checks the reason for rejection.
8. `shouldReportBothFailedChecks()` — Checks a weapon with both safety and electrical problems.

All eight tests passed during development.

The tests help verify that the Facade and subsystems work correctly.

## 7. How to Run the Project

The application was developed using Java and IntelliJ IDEA.

**Requirements:**

- Java JDK 17 or newer
- IntelliJ IDEA
- JUnit 5 for running the tests

**Steps:**

1. Clone or download the GitHub repository.
2. Open the project in IntelliJ IDEA.
3. Select the installed Java JDK.
4. Open `Main.java`.
5. Run the `main()` method to see the inspection results.

To run automated tests, make sure JUnit 5 is configured, then open `FencingInspectionFacadeTest.java` and run the test class.

## 8. Limitations

This project is a simplified simulation of weapon inspection.

Weapon conditions are provided as input values instead of being measured using real inspection equipment.

Inspection history is stored in memory, so it is reset when the application restarts.

## 9. Conclusion

In this assignment, I implemented the Facade Design Pattern using a fencing weapon inspection system.

The Facade simplifies communication between the Main class and multiple subsystems. It also helps organize the code by keeping different responsibilities in separate classes.

Through this project, I learned how to implement the Facade Pattern, handle errors, and write unit tests in Java.
