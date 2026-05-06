package lab4;

import java.util.Scanner;

public class project006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exercise3_1 exercise = new Exercise3_1();

        show();
        System.out.print("请选择 1-加法 2-减法 3-混合: ");
        int choice = scanner.nextInt();

        exercise.generateExerciseByChoice(choice);
        exercise.formateAndDisplay();

        scanner.close();
    }

    public static void show() {
        System.out.println("\n========== 实验四：面向对象算术习题集 ==========");
        System.out.println("  1. 加法运算");
        System.out.println("  2. 减法运算");
        System.out.println("  3. 混合运算");
        System.out.println("  说明：默认生成50道100以内不重复题目");
        System.out.println("==============================================\n");
    }
}
