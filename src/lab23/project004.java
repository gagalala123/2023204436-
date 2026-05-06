

import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class project004 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        show();
        System.out.print("��ѡ�� 1-�ӷ� 2-���� 3-���: ");
        int choice = scanner.nextInt();
        System.out.print("��������Ŀ����: ");
        int count = scanner.nextInt();
        
        generateExerciseSet(choice, count);
        
        scanner.close();
    }
    
    // ģ��1 ˵��
    public static void show() {
        System.out.println("\n========== ����ϰ�⼯����ϵͳ ==========");
        System.out.println("  1. �ӷ�����");
        System.out.println("  2. ��������");
        System.out.println("  3. �������");
        System.out.println("======================================\n");
    }
    
    // ģ��2 ������ʽ
	// �㷨��ϰ��ķ���
	// ȥ���ظ���ʽ ���õ�HashSet���ݽṹ
    public static String[][] generateQuestions(int choice, int count) {
        Random random = new Random();
        HashSet<String> questionSet = new HashSet<>();  // ����ȥ��
        String[] questions = new String[count];
        int[] answers = new int[count];
        
        System.out.println("\n�������ɲ��ظ�����Ŀ...");
        
        for (int i = 0; i < count; i++) {
            String question;
            int answer;
            
            // ѭ��ֱ�����ɲ��ظ�����ʽ
            do {
                if (choice == 1) {  // ȫ�ӷ�
                    int first = random.nextInt(101);
                    int second = random.nextInt(101 - first);
                    question = String.format("%3d +%3d", first, second);
                    answer = first + second;
                } else if (choice == 2) {  // ȫ����
                    int first = random.nextInt(101);
                    int second = random.nextInt(first + 1);
                    question = String.format("%3d -%3d", first, second);
                    answer = first - second;
                } else {  // �������
                    boolean isAddition = random.nextBoolean();
                    if (isAddition) {
                        int first = random.nextInt(101);
                        int second = random.nextInt(101 - first);
                        question = String.format("%3d +%3d", first, second);
                        answer = first + second;
                    } else {
                        int first = random.nextInt(101);
                        int second = random.nextInt(first + 1);
                        question = String.format("%3d -%3d", first, second);
                        answer = first - second;
                    }
                }
            } while (questionSet.contains(question));
            
            questionSet.add(question);
            questions[i] = question;
            answers[i] = answer;
        }
        
        System.out.println("�ɹ����� " + count + " �����ظ�����Ŀ��");
        
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
    
    // �ܿ�
    public static void generateExerciseSet(int choice, int count) {
        String[][] result = generateQuestions(choice, count);
        String[] questions = result[0];
        String[] answers = result[1];
        
        printExercise(questions, count);
        printAnswers(questions, answers, count);
        
        System.out.println("\n========== ������ϣ� ==========");
    }
}