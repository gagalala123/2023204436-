

import java.util.Random;
import java.util.Scanner;

public class project002 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ��ʾ�˵�
        show();
        System.out.print("��ѡ�� 1-�ӷ� 2-����: ");
        int choice = scanner.nextInt();
        System.out.print("��������Ŀ����: ");
        int count = scanner.nextInt();
        
        // ��������
        generateExerciseSet(choice, count);
        
        scanner.close();
    }
    
    	//ģ��1 ˵��
    public static void show() {
        System.out.println("\n========== ����ϰ�⼯����ϵͳ ==========");
        System.out.println("  1. �ӷ�����");
        System.out.println("  2. ��������");
        System.out.println("======================================\n");
    }
    
    	//ģ��2 ������ʽ
    public static String[][] generateQuestions(int choice, int count) {
        Random random = new Random();
        String[] questions = new String[count];
        int[] answers = new int[count];
        
        for (int i = 0; i < count; i++) {
            if (choice == 1) {//��
                int first = random.nextInt(101);
                int second = random.nextInt(101 - first);
                questions[i] = String.format("%3d +%3d", first, second);
                answers[i] = first + second;
            } else {//��
                int first = random.nextInt(101);
                int second = random.nextInt(first + 1);
                questions[i] = String.format("%3d -%3d", first, second);
                answers[i] = first - second;
            }
        }
        
        String[][] result = new String[2][count];
        result[0] = questions;
        for (int i = 0; i < count; i++) {
            result[1][i] = String.valueOf(answers[i]);
        }
        return result;
    }
    
    		//ģ��3 ��ӡ��ϰ
    public static void printExercise(String[] questions, int count) {
        System.out.println("\n========== ��ϰ�� ==========\n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%2d.  %s = ______\n", i + 1, questions[i]);
        }
    }
    
    		//ģ��4��ӡ��
    public static void printAnswers(String[] questions, String[] answers, int count) {
        System.out.println("\n========== �ο��� ==========\n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%2d.  %s = %3s\n", i + 1, questions[i], answers[i]);
        }
    }
    
    		//�ܿ�
    public static void generateExerciseSet(int choice, int count) {
        // ģ��2��������ʽ
        String[][] result = generateQuestions(choice, count);
        String[] questions = result[0];
        String[] answers = result[1];
        
        // ģ��3����ӡ��ϰ��
        printExercise(questions, count);
        
        // ģ��4����ӡ��
        printAnswers(questions, answers, count);
        
        System.out.println("\n========== ������ϣ� ==========");
    }
}