package lab4;

import java.util.Random;

public class BinaryOperation {
    static final int UPPER = 100;
    static final int LOWER = 0;

    private static final Random RANDOM = new Random();

    private int leftOperand = 0;
    private int rightOperand = 0;
    private char operator = '+';
    private int value = 0;

    private void construct(int left, int right, char op) {
        leftOperand = left;
        rightOperand = right;
        operator = op;
        if (op == '+') {
            value = left + right;
        } else {
            value = left - right;
        }
    }

    public BinaryOperation generateAdditionOperation() {
        int left = RANDOM.nextInt(UPPER - LOWER + 1) + LOWER;
        int right = RANDOM.nextInt(UPPER - left + 1);
        BinaryOperation operation = new BinaryOperation();
        operation.construct(left, right, '+');
        return operation;
    }

    public BinaryOperation generateSubstractOperation() {
        int left = RANDOM.nextInt(UPPER - LOWER + 1) + LOWER;
        int right = RANDOM.nextInt(left - LOWER + 1) + LOWER;
        BinaryOperation operation = new BinaryOperation();
        operation.construct(left, right, '-');
        return operation;
    }

    public BinaryOperation generateBinaryOperation() {
        if (RANDOM.nextBoolean()) {
            return generateAdditionOperation();
        }
        return generateSubstractOperation();
    }

    public int getLeftOperand() {
        return leftOperand;
    }

    public int getRightOperand() {
        return rightOperand;
    }

    public char getOperator() {
        return operator;
    }

    public int getResult() {
        return value;
    }

    public boolean equals(BinaryOperation anOperation) {
        return leftOperand == anOperation.getLeftOperand()
                && rightOperand == anOperation.getRightOperand()
                && operator == anOperation.getOperator();
    }

    @Override
    public String toString() {
        return leftOperand + String.valueOf(operator) + rightOperand;
    }

    public String asString() {
        return toString() + "=";
    }

    public String fullString() {
        return asString() + value;
    }
}
