# Mini Hospital Emergency Management System

## Project Description
This project is a Java console-based hospital emergency management system designed for CIT300 – Data Structures and Algorithms. It demonstrates the use of four core data structures:

- Binary Search Tree (BST) for patient records
- Queue for emergency patient management
- Stack for treatment history
- Singly Linked List for patient visit history

The system simulates a realistic hospital workflow where patients are registered, queued for emergency treatment, treated, and their visit history is tracked.

## Objectives
- Implement a custom BST without using Java's built-in TreeSet or TreeMap
- Use a custom queue for FIFO emergency scheduling
- Use a custom stack for LIFO treatment history
- Store each patient's previous visits in a singly linked list
- Build a beginner-friendly, console-based hospital management system
- Demonstrate correct behavior with validation and sample data

## Technologies Used
- Java
- VS Code
- Command Line / Terminal
- Standard Java Scanner for input

## Data Structures Used
### 1. Binary Search Tree (BST)
Used to store patients by unique Patient ID. The BST allows:
- insertion
- searching
- deletion
- in-order traversal in ascending Patient ID order

### 2. Queue
Used to manage emergency patients in first-in, first-out order. Patients are added to the queue when they arrive and removed when the doctor calls the next patient.

### 3. Stack
Used to store treatment records in last-in, first-out order. The most recent completed treatment is displayed first and can be popped.

### 4. Singly Linked List
Used to manage each patient's visit history. Each patient has an independent linked list with visits such as date, doctor name, diagnosis, and treatment.

## System Features
- Register new patients
- Search patient by ID
- Delete patient from BST
- Display all patients in ascending ID order
- Add patients to emergency queue
- View the queue in FIFO order
- Dequeue the next patient for treatment
- Complete treatment and push record to stack
- Display treatment history
- Add patient visits
- Remove a patient visit
- Search patient visit
- Display all visits for a patient
- Input validation for invalid menu entries and malformed data

## Class Structure
```text
src/
├── Main.java
├── Patient.java
├── PatientNode.java
├── PatientBST.java
├── QueueNode.java
├── EmergencyQueue.java
├── TreatmentRecord.java
├── StackNode.java
├── TreatmentStack.java
├── Visit.java
├── VisitNode.java
├── VisitHistory.java
└── out/   (compiled Java classes)
```

## How Each Data Structure Works in This Project
### BST Implementation
- Each patient has a unique ID.
- The root node stores the first patient.
- Smaller IDs go to the left subtree.
- Larger IDs go to the right subtree.
- In-order traversal prints patients in ascending ID order.

### Queue Implementation
- Patients are stored in nodes.
- `front` points to the first patient in line.
- `rear` points to the last patient in the queue.
- New patients are added at the rear.
- Existing patients are removed from the front.

### Stack Implementation
- New treatment records are added to the top.
- The most recent record is popped first.
- This follows LIFO behavior.

### Singly Linked List Implementation
- Each visit is stored in a node.
- Each node points to the next visit.
- The head node marks the beginning of the visit history.
- Visits can be inserted, searched, and removed in sequence.

## How to Compile and Run
Open a terminal in the project folder and run:

```bash
javac -d out src/*.java
java -cp out Main
```

If you are using PowerShell on Windows:

```powershell
javac -d out src/*.java
java -cp out Main
```

## Sample Operations
### Example patient registration
- Register patient ID 101
- Register patient ID 105
- Add both patients to emergency queue
- Dequeue first patient for treatment
- Complete treatment and push to treatment stack
- Add a visit for that patient in the visit history list

### Example BST demonstration
- Insert patients with IDs 101, 105, 102, 110, 108
- Display all patients
- Search for ID 105
- Search for non-existing ID 999
- Delete patient ID 102
- Display remaining patients in ascending order

### Example queue demonstration
- Enqueue patients in order
- Demonstrate FIFO behavior using display and dequeue
- Try dequeue on an empty queue

### Example stack demonstration
- Push multiple treatment records
- View treatment history
- Pop the newest record
- Try pop on an empty stack

### Example linked list demonstration
- Add multiple visits for a patient
- Search a visit ID
- Remove one visit
- Display the updated history

## Testing
The program includes sample data at startup to show real workflow execution.

Testing scenarios covered:
- BST insertion of 5 patients
- Search for existing and missing patient IDs
- Delete a patient
- Display all patients in ascending order
- Emergency queue FIFO order
- Empty queue handling
- Treatment stack LIFO order
- Empty stack handling
- Visit list adding, searching, and removing
- Input validation for invalid age and invalid choices

## Author
Student Name: [Your Name]
Course: CIT300 – Data Structures and Algorithms
Assignment: Mini Hospital Emergency Management System

## Suggested GitHub Commit Sequence
The project is structured so you can commit incrementally without fake history.

1. Initial project structure
2. Added Patient class
3. Implemented Patient BST insertion
4. Added BST search and traversal
5. Added BST deletion
6. Implemented emergency queue
7. Implemented treatment stack
8. Implemented patient visit linked list
9. Added input validation
10. Added testing
11. Updated README

## Demonstration Video Summary
This system simulates a mini hospital emergency workflow: patients are registered in a BST by ID, emergency patients are queued in FIFO order, doctors call the next patient, treatment records are pushed onto a stack, and every patient keeps a linked-list-based visit history. The project is easy to explain because each data structure has a clear purpose and its behavior is visible in the console output.
