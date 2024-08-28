import java.util.Scanner;

public class Calculator {
    private double result = 0;             // Stores the current result of calculations
    private String operator;               // Stores the current operator (+, -, *, /)
    private boolean isFirstInput = true;   // Flag to check if it's the first input

    // Main method for running the calculator
    public void calculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Read and trim the input from the user
            String input = scanner.nextLine().trim();

            // Check if the input is a number
            if (isNumber(input)) {
                handleNumberInput(Double.parseDouble(input));
            }
            // Check if the input is a valid operator and it's not the first input
            else if (isOperator(input) && !isFirstInput) {
                handleOperatorInput(input);
            }
            // Check if the input is '=' to end the calculation
            else if (input.equals("=")) {
                break;
            }
            // Handle invalid inputs
            else {
                if (isFirstInput) {
                    System.out.println("Invalid input. Please enter a number.");
                } else {
                    System.out.println("Invalid input. Please enter a number or a valid operator (+, -, *, /, =).");
                }
            }
        }

        // Output the final result, formatted as int or double
        if (result % 1 == 0) {
            System.out.println("Result: " + (int) result);
        } else {
            System.out.println("Result: " + result);
        }
    }

    // Checks if the input is a number
    private static boolean isNumber(String input) {
        try {
            Double.parseDouble(input); // Try to parse the input as a double
            return true;
        } catch (NumberFormatException e) {
            return false; // Return false if parsing fails
        }
    }

    // Checks if the input is an operator
    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    // Handles the input of a number
    private void handleNumberInput(double number) {
        if (isFirstInput) {
            // If it's the first input, set result to the number
            result = number;
            isFirstInput = false;
        } else if (operator != null) {
            // If an operator is set, perform the operation
            result = performOperation(result, number, operator);
            operator = null; // Reset the operator after use
        } else {
            System.out.println("Error: Operator is missing.");
        }
    }

    // Handles the input of an operator
    private void handleOperatorInput(String operator) {
        this.operator = operator; // Set the current operator
    }

    // Performs the addition operation
    private double sum(double a, double b) {
        return a + b;
    }

    // Performs the subtraction operation
    private double subtract(double a, double b) {
        return a - b;
    }

    // Performs the multiplication operation
    private double multiply(double a, double b) {
        return a * b;
    }

    // Performs the division operation
    private double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return a; // Return the previous result if division by zero occurs
        }
        return a / b;
    }

    // Performs operations based on the given operator
    private double performOperation(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> sum(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> {
                System.out.println("Error: Unknown operator");
                yield a; // Return the previous result if the operator is unknown
            }
        };
    }

    // Main function to start the calculator application
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculator(); // Run the calculator
    }
}