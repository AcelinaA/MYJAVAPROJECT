# Ahron's Pink Calculator
A stylish, fully functional **Java Swing-based calculator** with custom pink themes and added features like square root, exponent, percentage, and history tracking.

## Features

### Core Operations
- Basic arithmetic: `+`, `-`, `×`, `÷`
- Advanced math: 
  - Square (`x²`)
  - Square root (`√`)
  - Percentage (`%`)
  - Sign toggle (`±`)
- Decimal support and backspace (`⌫`)
- Clear all (`C`)

### History System
- Stores the last **10 recent calculations**
- View via the **“History”** button
- Auto-scrollable dialog with formatting

### UI Design
- Three-tone **pink color scheme**:
  - `Light Pink`, `Medium Pink`, `Dark Pink`
- Rounded, color-coded buttons
- Stylized input and expression displays

## Built With
- Java Swing (`javax.swing`)
- AWT Layouts & Events
- `ArrayList<String>` for storing history

## Sample Output

![Calculator UI Preview](#) *(Add screenshot if publishing on GitHub)*

### Example History Dialog:
```
Recent Calculations:

1. 100 × 5% = 5
2. 25² = 625
3. √81 = 9
...
```

## How It Works

### Input Handling
- Displays current expression (`expressionDisplay`) and current number (`display`)
- `startNewNumber` and `justCalculated` control state transitions between inputs

### Logic Breakdown
- **`handleOperator()`**: Sets operator and first number
- **`calculateResult()`**: Finalizes and stores result in history
- **`handlePercent()`**: Smart percentage handling based on context
- **`backspace()`, `changeSign()`, `clearAll()`**: Manage input editing
- **`updateExpressionDisplay()`**: Shows current math flow

## Author
*Ahron James Balmoria* 
DCIT 23 – Computer Programming 2
