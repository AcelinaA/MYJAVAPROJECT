# Employee Information System Part 2
This program is Part 2 of the my Simple Employee Information System written in Java.

## Description
This enhanced version of the Employee Information System builds on Lab Activity 1. 

**It collects employee data from the user and performs multiple salary-related computations from the user**
- Daily Salary
- Retirement Age
- Weekly Salary
- Monthly Salary
- Gross Yearly Salary
- Net Yearly Salary

## Objectives
- Reinforce the use of Java's `Scanner` class for input handling
- Apply mathematical operations for salary and financial computations
- Use `Math.abs()` to calculate retirement age difference

## How It Works

1. **It ask for the following information first** 
   - First and last name
   - Age
   - Hours worked
   - Hourly wage

2. **Calculate the following**
   - `dailySalary = hoursWorked * hourlyWage`
   - `retirementAge = Math.abs(65 - age)`
   - `weeklySalary = dailySalary * 5`
   - `monthlySalary = weeklySalary * 4`
   - `grossYearlyWage = monthlySalary * 12`
   - `netYearlyWage = grossYearlyWage - (grossYearlyWage * 0.32) - 1500`

3. **Output:**
   - Displays full name, age, years to retirement, and all salary breakdowns

---

## Sample Output

---

```
Enter your first name: Ahron James
Enter your last name: Balmoria
Enter your age: 30
Enter hours worked: 8
Enter hourly wage: 120

            Employee Information
--------------------------------------------
Full Name             : Ahron James Balmoria
Age                   : 30 years old
Years to Retirement   : 35 years old
Daily Salary          : PHP 960.00
Weekly Salary         : PHP 4800.00
Monthly Salary        : PHP 19200.00
Gross Yearly Wage     : PHP 230400.00
Net Yearly Wage       : PHP 154672.00
```

## Author
*Ahron James Balmoria*  
*DCIT 23 - Computer Programming 2*
