# Complete Employee Information System with Conditional Statements
This program is a continuation of the Emplyoo Information System with the addition of Conditional Statements written in Java.

## Description
This version introduces **conditional statements** to validate user inputs and simulate basic HR logic. It restricts access based on age, validates working hours, and calculates salary details depending on job roles and income thresholds.


## Objectives
- Implement `if-else` statements for input validation and control flow
- Use `switch` statements for job role selection
- Reinforce salary calculations with conditional logic
- Handle special cases such as minors, seniors, and invalid input


## How It Works

1. **Check if the user Input Validation:**
   - Blocks users under 18 and those aged 65 or above
   - Ensures working hours are between 1 and 24
   - Validates role selection using a switch expression

2. **Role Identification:**
   - Role codes:
     - 1 = Manager
     - 2 = Supervisor
     - 3 = Staff
     - 4 = Intern

3. **Salary Computation:**
   - `dailySalary = hoursWorked * hourlyWage`
   - `weeklySalary = dailySalary * 5`
   - `monthlySalary = weeklySalary * 4`
   - `grossYearlyWage = monthlySalary * 12`
   - If `grossYearlyWage > 250000`, apply 32% tax + PHP 1500 benefits
   - Otherwise, subtract PHP 1500 only

## Sample Output

```
Enter your first name: Ahron James
Enter your last name: Balmoria
Enter your age: 28
Enter hours worked: 8
Enter hourly wage: 150
Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): 2

            Employee Information
--------------------------------------------
Full Name             : Ahron James Balmoria
Age                   : 28 years old
Position              : Supervisor
Years to Retirement   : 37 years old
Daily Salary          : PHP 1200.00
Weekly Salary         : PHP 6000.00
Monthly Salary        : PHP 24000.00
Gross Yearly Wage     : PHP 288000.00
Net Yearly Wage       : PHP 193140.00
```

## Author
*Ahron James Balmoria*  
*DCIT 23 - Computer Programming 2*
