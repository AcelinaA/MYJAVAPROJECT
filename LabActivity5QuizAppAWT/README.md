# Quiz Application (Java AWT)
This program is a Quiz App with GUI using AWT written in Java.
## Description
This project is a simple **Quiz Application** built using **Java AWT (Abstract Window Toolkit)**. It features multiple-choice questions with radio buttons, error handling, and score tracking, all within a basic GUI layout. The quiz consists of three questions and gives the user a score summary upon completion.

## Objectives
- Apply Java AWT components to create an interactive GUI application
- Use `CheckboxGroup` for radio button-style multiple-choice answers
- Implement event-driven programming using `ActionListener`
- Manage quiz flow, answer validation, and scoring

## How It Works

1. **Questions and Options:**
   - 3 multiple-choice questions are defined with 4 options each
   - Correct answers are stored using index references

2. **User Interface:**
   - Uses `Label`, `CheckboxGroup`, `Checkbox`, and `Button`
   - Layouts: `BorderLayout`, `GridLayout` for clean positioning
   - "Next" button loads the next question

3. **Functionality:**
   - Only one answer can be selected per question
   - Displays error if no option is selected
   - Calculates score and displays result at the end
   - All checkboxes are disabled after completion

## Sample Flow

```
Question: What does CPU stand for?
[A] Central Processing Unit
[B] Computer Personal Unit
[C] Central Print Unit
[D] Control Processing Unit

[User selects an answer and clicks "Next"]

...

After 3 questions:
"Quiz Completed! Your Score: 2 out of 3 correct!"
```

## Author
*Ahron James Balmoria*  
*DCIT 23 - Computer Programming 2*
