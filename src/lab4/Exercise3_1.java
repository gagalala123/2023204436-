package lab4;

public class Exercise3_1 {
    private static final short OPERATION_NUMBER = 50;
    private static final short COLUMN_NUMBER = 5;

    private final BinaryOperation[] operationList = new BinaryOperation[OPERATION_NUMBER];

    public void generateBinaryExercise() {
        BinaryOperation anOperation;
        BinaryOperation opCreator = new BinaryOperation();
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateBinaryOperation();
            while (contains(anOperation, i - 1)) {
                anOperation = opCreator.generateBinaryOperation();
            }
            operationList[i] = anOperation;
        }
    }

    public void generateAdditionExercise() {
        BinaryOperation anOperation;
        BinaryOperation opCreator = new BinaryOperation();
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateAdditionOperation();
            while (contains(anOperation, i - 1)) {
                anOperation = opCreator.generateAdditionOperation();
            }
            operationList[i] = anOperation;
        }
    }

    public void generateSubstractExercise() {
        BinaryOperation anOperation;
        BinaryOperation opCreator = new BinaryOperation();
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateSubstractOperation();
            while (contains(anOperation, i - 1)) {
                anOperation = opCreator.generateSubstractOperation();
            }
            operationList[i] = anOperation;
        }
    }

    public void generateExerciseByChoice(int choice) {
        if (choice == 1) {
            generateAdditionExercise();
        } else if (choice == 2) {
            generateSubstractExercise();
        } else {
            generateBinaryExercise();
        }
    }

    private boolean contains(BinaryOperation anOperation, int length) {
        boolean found = false;
        for (int i = 0; i <= length; i++) {
            if (anOperation.equals(operationList[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    void formateAndDisplay() {
        System.out.println("========== 50道100以内加减法练习题 ==========");
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            System.out.printf("%-18s", (i + 1) + ". " + operationList[i].asString());
            if ((i + 1) % COLUMN_NUMBER == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("========== 参考答案 ==========");
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            System.out.printf("%-18s", (i + 1) + ". " + operationList[i].fullString());
            if ((i + 1) % COLUMN_NUMBER == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Exercise3_1 exercise = new Exercise3_1();
        exercise.generateBinaryExercise();
        exercise.formateAndDisplay();
    }
}
