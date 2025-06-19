# IT Ticket System 
This program is IT Ticket System written in Java.

## Description
This program is a **console-based IT Ticket System** that allows users to manage up to 5 tickets. It simulates a basic support ticket workflow, including adding issues, updating statuses, displaying all tickets, and generating a summary report.

## Objectives
- Practice object-oriented programming using Java (`class`, `object`, `constructor`)
- Implement a simple array-based data storage
- Use `Scanner` for input handling
- Apply `switch-case` statements and control flow for menu-driven applications
- Perform validations on input and object status

## How It Works

### Ticket Class
- Contains:
  - `description`
  - `urgency` (Low, Medium, High)
  - `status` (Default: "Pending")

### Menu Options
1. **Add Ticket**
   - Creates a new ticket (up to 5 max)
2. **Update Ticket Status**
   - Allows changing status from:
     - `Pending` → `In Progress` or `Resolved`
     - `In Progress` → `Resolved`
   - Cannot update if already `Resolved`
3. **Show All Tickets**
   - Displays ticket list with urgency and status
4. **Generate Report**
   - Shows total, pending/in-progress, and resolved ticket counts
5. **Exit**
   - Ends the program

## ✅ Sample Interaction

```
--- IT Ticket System ---
1. Add Ticket
2. Update Ticket Status
3. Show All Tickets
4. Generate Report
5. Exit
Enter your choice: 1

Enter issue description: Cannot connect to WiFi
Enter urgency level (Low / Medium / High): High
Ticket successfully added!
```

Or when generating report:

```
--- Ticket Report ---
Total Tickets: 2
Pending/In Progress Tickets: 1
Resolved Tickets: 1
```

## Author
*Ahron James Balmoria*  
*DCIT 23 - Computer Programming 2*
