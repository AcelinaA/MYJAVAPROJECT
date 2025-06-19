import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LabCalcFinalProject extends JFrame implements ActionListener {

    // Display components
    private JTextField display;
    private JLabel expressionDisplay;

    // Calculator state variables
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean startNewNumber = true;
    private boolean justCalculated = false; // Track if we just performed a calculation

    // History system
    private List<String> history = new ArrayList<>();

    // Pink color scheme
    private final Color LIGHT_PINK = new Color(255, 182, 193);
    private final Color MEDIUM_PINK = new Color(255, 105, 180);
    private final Color DARK_PINK = new Color(219, 112, 147);

    // Constructor
    public LabCalcFinalProject() {
        setupWindow();
        createComponents();
    }

    // Setup main window
    private void setupWindow() {
        setTitle("Ahron's Pink Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(LIGHT_PINK);
    }

    // Create all GUI components
    private void createComponents() {
        // Main layout
        setLayout(new BorderLayout());

        // Create display
        createDisplay();

        // Create buttons
        createButtons();
    }

    // Create the display area
    private void createDisplay() {
        // Create a panel to hold both displays
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(Color.WHITE);
        displayPanel.setBorder(BorderFactory.createLineBorder(MEDIUM_PINK, 2));

        // Expression display (shows ongoing calculation)
        expressionDisplay = new JLabel(" ");
        expressionDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
        expressionDisplay.setHorizontalAlignment(JLabel.RIGHT);
        expressionDisplay.setPreferredSize(new Dimension(300, 25));
        expressionDisplay.setForeground(Color.GRAY);
        expressionDisplay.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));

        // Main display
        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(300, 50));
        display.setBackground(Color.WHITE);
        display.setForeground(DARK_PINK);
        display.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

        displayPanel.add(expressionDisplay, BorderLayout.NORTH);
        displayPanel.add(display, BorderLayout.CENTER);

        add(displayPanel, BorderLayout.NORTH);
    }

    // Create button panel
    private void createButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBackground(LIGHT_PINK);

        // Button text array (added History button)
        String[] buttonText = {
                "History", "C", "⌫", "√",
                "7", "8", "9", "÷",
                "4", "5", "6", "×",
                "1", "2", "3", "-",
                "±", "0", ".", "+",
                "x²", "%", "", "="
        };

        // Create and add buttons
        for (String text : buttonText) {
            if (text.equals("")) {
                // Empty space
                JPanel emptyPanel = new JPanel();
                emptyPanel.setBackground(LIGHT_PINK);
                buttonPanel.add(emptyPanel);
            } else {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.BOLD, 16));
                button.addActionListener(this);

                // Pink styling for buttons
                if (text.matches("[0-9]")) {
                    // Number buttons - lightest pink
                    button.setBackground(Color.WHITE);
                    button.setForeground(DARK_PINK);
                } else if (text.equals("History")) {
                    // History button - special color
                    button.setBackground(DARK_PINK);
                    button.setForeground(Color.WHITE);
                } else {
                    // Operator buttons - medium pink
                    button.setBackground(MEDIUM_PINK);
                    button.setForeground(Color.WHITE);
                }

                button.setBorder(BorderFactory.createRaisedBevelBorder());
                buttonPanel.add(button);
            }
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle different button types
        if (isNumber(command)) {
            handleNumber(command);
        } else if (isOperator(command)) {
            handleOperator(command);
        } else if (command.equals("=")) {
            calculateResult();
        } else if (command.equals("C")) {
            clearAll();
        } else if (command.equals("⌫")) {
            backspace();
        } else if (command.equals(".")) {
            addDecimal();
        } else if (command.equals("±")) {
            changeSign();
        } else if (command.equals("√")) {
            calculateSquareRoot();
        } else if (command.equals("x²")) {
            calculateSquare();
        } else if (command.equals("%")) {
            handlePercent();
        } else if (command.equals("History")) {
            showHistory();
        }
    }

    // Check if button is a number
    private boolean isNumber(String text) {
        return text.matches("[0-9]");
    }

    // Check if button is an operator
    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("-") || text.equals("×") ||
                text.equals("÷");
    }

    // Handle number input
    private void handleNumber(String number) {
        if (startNewNumber || justCalculated) {
            currentInput = number;
            startNewNumber = false;
            justCalculated = false;
        } else {
            currentInput += number;
        }
        display.setText(currentInput);
    }

    // Handle operator input
    private void handleOperator(String op) {
        if (!currentInput.isEmpty()) {
            // If we have a pending operation, calculate it first
            if (!operator.isEmpty() && !startNewNumber) {
                calculateResult();
                // After calculation, currentInput contains the result
                // and we're ready for the next operation
            }

            // Set up for the next operation
            firstNumber = Double.parseDouble(currentInput);
            operator = op;
            startNewNumber = true;
            justCalculated = false;

            // Update expression display
            updateExpressionDisplay();
        } else if (justCalculated && !operator.isEmpty()) {
            // Allow changing operator after just calculating
            operator = op;
            updateExpressionDisplay();
        }
    }

    // Handle percent button - NEW METHOD
    private void handlePercent() {
        if (!currentInput.isEmpty()) {
            try {
                double currentNumber = Double.parseDouble(currentInput);

                if (!operator.isEmpty() && !startNewNumber) {
                    // We have a pending operation (like 100 × 50%)
                    // Convert the current number to a percentage and calculate immediately
                    double percentValue = currentNumber / 100.0;
                    double result = performCalculation(firstNumber, percentValue, operator);

                    // Add calculation to history
                    String calculation = formatResult(firstNumber) + " " + operator + " " +
                            formatResult(currentNumber) + "% = " + formatResult(result);
                    history.add(calculation);

                    display.setText(formatResult(result));
                    currentInput = formatResult(result);
                    operator = "";
                    startNewNumber = true;
                    justCalculated = true;
                    expressionDisplay.setText(" ");
                } else {
                    // No pending operation, just convert current number to percentage
                    double result = currentNumber / 100.0;

                    // Add to history
                    String calculation = formatResult(currentNumber) + "% = " + formatResult(result);
                    history.add(calculation);

                    display.setText(formatResult(result));
                    currentInput = formatResult(result);
                    startNewNumber = true;
                    justCalculated = true;
                    expressionDisplay.setText(" ");
                }
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
    }

    // Calculate and display result
    private void calculateResult() {
        if (!operator.isEmpty() && !currentInput.isEmpty() && !startNewNumber) {
            try {
                double secondNumber = Double.parseDouble(currentInput);
                double result = performCalculation(firstNumber, secondNumber, operator);

                // Add calculation to history
                String calculation = formatResult(firstNumber) + " " + operator + " " +
                        formatResult(secondNumber) + " = " + formatResult(result);
                history.add(calculation);

                display.setText(formatResult(result));
                currentInput = formatResult(result);
                operator = "";
                startNewNumber = true;
                justCalculated = true;
                expressionDisplay.setText(" ");

            } catch (Exception ex) {
                display.setText("Error");
                clearAll();
            }
        }
    }

    // Perform the actual calculation
    private double performCalculation(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "×":
                return num1 * num2;
            case "÷":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                return 0;
        }
    }

    // Format result for display
    private String formatResult(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.format("%.10g", result); // Better formatting for decimals
        }
    }

    // Clear all inputs
    private void clearAll() {
        currentInput = "";
        operator = "";
        firstNumber = 0;
        startNewNumber = true;
        justCalculated = false;
        display.setText("0");
        expressionDisplay.setText(" ");
    }

    // Delete last digit
    private void backspace() {
        if (!currentInput.isEmpty() && !startNewNumber) {
            if (currentInput.length() == 1) {
                currentInput = "";
                display.setText("0");
                startNewNumber = true;
            } else {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                display.setText(currentInput);
            }
        }
    }

    // Add decimal point
    private void addDecimal() {
        if (startNewNumber || justCalculated) {
            currentInput = "0.";
            startNewNumber = false;
            justCalculated = false;
        } else if (!currentInput.contains(".")) {
            currentInput += ".";
        }
        display.setText(currentInput);
    }

    // Change sign of current number
    private void changeSign() {
        if (!currentInput.isEmpty() && !currentInput.equals("0")) {
            if (currentInput.startsWith("-")) {
                currentInput = currentInput.substring(1);
            } else {
                currentInput = "-" + currentInput;
            }
            display.setText(currentInput);
        }
    }

    // Calculate square root
    private void calculateSquareRoot() {
        if (!currentInput.isEmpty()) {
            try {
                double number = Double.parseDouble(currentInput);
                if (number < 0) {
                    display.setText("Error");
                    return;
                }
                double result = Math.sqrt(number);

                // Add to history
                String calculation = "√" + formatResult(number) + " = " + formatResult(result);
                history.add(calculation);

                display.setText(formatResult(result));
                currentInput = formatResult(result);
                startNewNumber = true;
                justCalculated = true;
                expressionDisplay.setText(" ");
                expressionDisplay.setText(" ");
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
    }

    // Calculate square
    private void calculateSquare() {
        if (!currentInput.isEmpty()) {
            try {
                double number = Double.parseDouble(currentInput);
                double result = number * number;

                // Add to history
                String calculation = formatResult(number) + "² = " + formatResult(result);
                history.add(calculation);

                display.setText(formatResult(result));
                currentInput = formatResult(result);
                startNewNumber = true;
                justCalculated = true;
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
    }

    // Show calculation history
    private void showHistory() {
        if (history.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No calculations yet!",
                    "History", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder historyText = new StringBuilder("Recent Calculations:\n\n");

        // Show last 10 calculations
        int start = Math.max(0, history.size() - 10);
        for (int i = start; i < history.size(); i++) {
            historyText.append((i + 1) + ". " + history.get(i) + "\n");
        }

        if (history.size() > 10) {
            historyText.append("\n... and " + (history.size() - 10) + " more calculations");
        }

        // Create a scrollable dialog for long history
        JTextArea textArea = new JTextArea(historyText.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane,
                "Calculation History", JOptionPane.INFORMATION_MESSAGE);
    }

    // Update the expression display to show current calculation
    private void updateExpressionDisplay() {
        if (!operator.isEmpty()) {
            String expression = formatResult(firstNumber) + " " + operator;
            expressionDisplay.setText(expression);
        } else {
            expressionDisplay.setText(" ");
        }
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LabCalcFinalProject().setVisible(true);
            }
        });
    }
}
