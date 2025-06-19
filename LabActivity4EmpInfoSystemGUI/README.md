# Employee Information System (GUI using AWT)
This program is a Employee Information System with GUI using AWT written in Java.

## Description
This activity introduces a **Graphical User Interface (GUI)** version of the Employee Information System using **Java AWT (Abstract Window Toolkit)**. It replaces the previous console-based input/output with text fields, labels, a submit button, and a display area. The program performs basic employee salary calculations and validations in a more user-friendly environment.

## Objectives
- Implement Java GUI using AWT components (`Frame`, `Panel`, `Label`, `TextField`, `Button`, `TextArea`)
- Apply layout managers (`BorderLayout`, `GridLayout`)
- Handle GUI events using `ActionListener` and `WindowAdapter`
- Perform input validation with user-friendly error feedback

## How It Works

1. **Inputs Collected via GUI:**
   - First Name
   - Last Name
   - Age
   - Hours Worked
   - Hourly Rate

2. **Validation Checks:**
   - All fields must be filled
   - Age must be a valid whole number
   - Hours Worked and Hourly Rate must be valid numeric values (can include decimals)

3. **Calculations:**
   - `dailySalary = hoursWorked * hourlyRate`

4. **Output:**
   - Full Name
   - Age
   - Daily Salary (formatted to two decimal places)

5. **Features:**
   - Error messages are shown in the output area if inputs are invalid
   - Window closes gracefully on user request

## Sample Output (in the TextArea)

```
Full Name: Ahron James Balmoria
Age: 26 years old
Daily Salary: PHP 1040.00
```

Or in case of invalid input:

```
Error: Hourly worked and hourly rate must be valid numbers.
```

## Author
*Ahron James Balmoria*  
*DCIT 23 - Computer Programming 2*
