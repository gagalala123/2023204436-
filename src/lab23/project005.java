

import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class project005 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ��ʾ�˵�
        show();
        
        System.out.print("��ѡ�� 1-�ӷ� 2-���� 3-���: ");
        int choice = scanner.nextInt();
        
        System.out.print("��������Ŀ����: ");
        int count = scanner.nextInt();
        
        System.out.print("������������ȡֵ��Χ: ");
        int maxValue = scanner.nextInt();
        
        // ����Լ����������
        Constraint constraint = new Constraint(maxValue);
        
        // ��������
        generateExerciseSet(choice, count, constraint);
        
        scanner.close();
    }
    
    // ģ��1 ˵��
    public static void show() {
        System.out.println("\n========== ����ϰ�⼯����ϵͳ ==========");
        System.out.println("  1. �ӷ�����");
        System.out.println("  2. ��������");
        System.out.println("  3. �������");
        System.out.println("========================================\n");
    }
    
    // �㷨��ϰ��ķ���
    // ȥ���ظ���ʽ������HashSet���ݽṹ
    public static String[][] generateQuestions(int choice, int count, Constraint constraint) {
        Random random = new Random();
        HashSet<String> questionSet = new HashSet<>();  // ����ȥ��
        String[] questions = new String[count];
        int[] answers = new int[count];
        
        int generated = 0;        // �ѳɹ����ɵ���Ŀ���������ظ��ģ�
        int maxAttempts = count * 10;  // ����Դ�������ֹ����ѭ����
        int attempts = 0;         // ��ǰ�Ѿ������˶��ٴ�
        
        // �������ͳ��
        int additionCount = 0;
        int subtractionCount = 0;
        
        System.out.println("\n�������ɲ��ظ�����Ŀ...");
        System.out.println(constraint.getDescription());
        
        while (generated < count && attempts < maxAttempts) {
            String question;
            int answer;
            
            if (choice == 1) {
                // ȫ�ӷ�
                int first = constraint.getRandomFirstForAddition(random);
                int second = constraint.getRandomSecondForAddition(random, first);
                question = String.format("%3d + %3d", first, second);
                answer = first + second;
            } else if (choice == 2) {
                // ȫ����
                int first = constraint.getRandomFirstForSubtraction(random);
                int second = constraint.getRandomSecondForSubtraction(random, first);
                question = String.format("%3d -%3d", first, second);
                answer = first - second;
            } else {
                // �������
                boolean isAddition = random.nextBoolean();
                if (isAddition) {
                    int first = constraint.getRandomFirstForAddition(random);
                    int second = constraint.getRandomSecondForAddition(random, first);
                    question = String.format("%3d +%3d", first, second);
                    answer = first + second;
                } else {
                    int first = constraint.getRandomFirstForSubtraction(random);
                    int second = constraint.getRandomSecondForSubtraction(random, first);
                    question = String.format("%3d -%3d", first, second);
                    answer = first - second;
                }
            }
            
            // ����Ƿ��ظ�
            if (!questionSet.contains(question)) {
                questionSet.add(question);
                questions[generated] = question;
                answers[generated] = answer;
                
                // ͳ�ƻ����������ͷֲ�
                if (choice == 3) {
                    if (question.contains("+")) {
                        additionCount++;
                    } else {
                        subtractionCount++;
                    }
                }
                
                generated++;
            }
            attempts++;
        }
        
        // ������ɽ����Ϣ
        if (generated < count) {
            System.out.println("���棺ֻ������ " + generated + " �����ظ�����Ŀ��");
            System.out.println(constraint.getWarning());
        } else {
            System.out.println("�ɹ����� " + count + " �����ظ�����Ŀ��");
            if (choice == 3) {
                System.out.println("���ͷֲ����ӷ� " + additionCount + " �������� " + subtractionCount + " ��");
            }
        }
        System.out.println("���Դ�����" + attempts + " ��");
        
        String[][] result = new String[2][count];
        result[0] = questions;
        for (int i = 0; i < count; i++) {
            result[1][i] = String.valueOf(answers[i]);
        }
        return result;
    }
    
    // ģ��3 ��ӡ��ϰ
    public static void printExercise(String[] questions, int count) {
        System.out.println("\n========== ��ϰ�� ==========\n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%2d.  %s = ______\n", i + 1, questions[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
    
    // ģ��4 ��ӡ��
    public static void printAnswers(String[] questions, String[] answers, int count) {
        System.out.println("\n========== �ο��� ==========\n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%2d.  %s = %3s\n", i + 1, questions[i], answers[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
    
    // �ܿ�
    public static void generateExerciseSet(int choice, int count, Constraint constraint) {
        String[][] result = generateQuestions(choice, count, constraint);
        String[] questions = result[0];
        String[] answers = result[1];
        
        printExercise(questions, count);
        printAnswers(questions, answers, count);
        
        System.out.println("\n========== ������ϣ� ==========");
    }
}

		//��װԼ��������
class Constraint {
    private int maxValue;           // ���ֵ��Χ
    private String description;     // ��Χ����
    private int maxPossibleQuestions; // ��������Ŀ��
    
    public Constraint(int maxValue) {
        this.maxValue = maxValue;
        this.description = generateDescription(maxValue);
        this.maxPossibleQuestions = calculateMaxQuestions(maxValue);
    }
    
    /**
     * ���ɷ�Χ����
     */
    private String generateDescription(int maxValue) {
        if (maxValue <= 10) {
            return "��ֵ��Χ��0 - " + maxValue + "��10���ڣ�";
        } else if (maxValue <= 20) {
            return "��ֵ��Χ��0 - " + maxValue + "��20���ڣ�";
        } else if (maxValue <= 50) {
            return "��ֵ��Χ��0 - " + maxValue + "��50���ڣ�";
        } else if (maxValue <= 100) {
            return "��ֵ��Χ��0 - " + maxValue + "��100���ڣ�";
        } else if (maxValue <= 200) {
            return "��ֵ��Χ��0 - " + maxValue + "��200���ڣ�";
        } else {
            return "��ֵ��Χ��0 - " + maxValue;
        }
    }
    
    /**
     * ���������ܵĲ��ظ���Ŀ����
     * �ӷ������ + ���������
     */
    private int calculateMaxQuestions(int maxValue) {
        // �ӷ��������(maxValue+1)*(maxValue+2)/2
        int additionCount = (maxValue + 1) * (maxValue + 2) / 2;
        // �����������(maxValue+1)*(maxValue+2)/2
        int subtractionCount = (maxValue + 1) * (maxValue + 2) / 2;
        return additionCount + subtractionCount;
    }
    
    /**
     * ��ȡ�ӷ���ʽ�ĵ�һ��������������
     */
    public int getRandomFirstForAddition(Random random) {
        return random.nextInt(maxValue + 1);
    }
    
    /**
     * ��ȡ�ӷ���ʽ�ĵڶ�������������
     * Լ����first + second <= maxValue
     */
    public int getRandomSecondForAddition(Random random, int first) {
        return random.nextInt(maxValue + 1 - first);
    }
    
    /**
     * ��ȡ������ʽ�ĵ�һ��������������
     */
    public int getRandomFirstForSubtraction(Random random) {
        return random.nextInt(maxValue + 1);
    }
    
    /**
     * ��ȡ������ʽ�ĵڶ�������������
     * Լ����second <= first
     */
    public int getRandomSecondForSubtraction(Random random, int first) {
        return random.nextInt(first + 1);
    }
    
    /**
     * ��֤�ӷ���ʽ�Ƿ�����Լ��
     */
    public boolean isValidAddition(int first, int second) {
        return first + second <= maxValue;
    }
    
    /**
     * ��֤������ʽ�Ƿ�����Լ��
     */
    public boolean isValidSubtraction(int first, int second) {
        return first >= second && first <= maxValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getMaxPossibleQuestions() {
        return maxPossibleQuestions;
    }
    
    public String getWarning() {
        if (maxPossibleQuestions < 100) {
            return "��ʾ����Χ " + maxValue + " �����ֻ������ " + maxPossibleQuestions + " �����ظ���Ŀ";
        }
        return "��ʾ����Χ " + maxValue + " ����������Լ " + maxPossibleQuestions + " �����ظ���Ŀ";
    }
    
    /**
     * ��֤�������Ŀ�����Ƿ����
     */
    public boolean isCountValid(int count) {
        return count <= maxPossibleQuestions;
    }
    
    /**
     * �����µķ�Χ��������չ��
     */
    public void setMaxValue(int newMaxValue) {
        this.maxValue = newMaxValue;
        this.description = generateDescription(newMaxValue);
        this.maxPossibleQuestions = calculateMaxQuestions(newMaxValue);
    }
}