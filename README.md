# Fencing Weapon Inspection System

## Description
This project is a Java application using the Facade Design Pattern.

The system checks three types of fencing weapons: Foil, Epee, and Sabre. It checks weapon safety and electrical circuits before competitions.

## Main Classes
- WeaponRegistry - registers weapons.
- SafetyInspector - checks weapon safety.
- ElectricalInspector - checks the electrical circuit.
- ApprovalService - approves or rejects weapons.
- InspectionArchive - saves inspection history.
- InspectionRecord - stores inspection results.
- FencingInspectionFacade - manages all subsystems.

## Facade Pattern
The Main class communicates with the Facade instead of calling each subsystem separately.

Example:

`facade.inspectWeapon("F001");`

The Facade coordinates the inspection process and saves the result.

## Testing
I used JUnit 5 to test the application.

The project includes 8 tests covering weapon approval, rejection, error handling, inspection history, and rejection reasons.

## How to Run
1. Open the project in IntelliJ IDEA.
2. Run Main.java.
3. Run FencingInspectionFacadeTest.java to execute the tests.

## Conclusion
This assignment helped me understand how the Facade Pattern simplifies interactions between multiple classes and makes Java code easier to maintain.
