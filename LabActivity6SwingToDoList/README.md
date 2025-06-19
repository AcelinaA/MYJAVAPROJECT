# Lab Activity 6 - To-Do List Application (Java Swing)
This program is a Employee Information System with GUI using SWING written in Java.

## 📄 Description
This Java Swing application implements a **To-Do List Manager** with a clean graphical interface. It allows users to view a table of tasks and add new tasks using a secondary form window. The program uses `JFrame`, `JTable`, and other Swing components to create a professional, responsive GUI with modern features.

## Objectives
- Practice using Java Swing to build a multi-window GUI application
- Handle user inputs and events with interactive components
- Organize task data using `JTable` and `DefaultTableModel`
- Use modular design through multiple class structures (main + form window)

## How It Works

### Main Window (`LabActivity6SwingToDoList`)
- Displays a table showing all tasks
- Contains a **"Add Task"** button that opens a form window
- Uses `DefaultTableModel` to manage task entries

### Form Window (`ToDoListForm`)
- Accepts user input for:
  - Task Name
  - Task Description
  - Task Status (`Not Started`, `Ongoing`, `Completed`)
- Validates required fields before saving
- Adds task to the main window's table on submission

## Sample Workflow

1. User opens the app and clicks **"Add Task"**.
2. A new window appears where the user fills in:
   - Task Name: `Submit project`
   - Task Description: `Finalize and upload the group project`
   - Status: `Ongoing`
3. After clicking **"Save Task"**, the form closes and the task appears in the table.

## Features
- Multi-window functionality (main + form)
- Input validation with error messages
- User-friendly design with pink color theme and scrollable task list
- Centered windows for better UX

## Author
*Ahron James Balmoria*  
*DCIT 23 - Computer Programming 2*
