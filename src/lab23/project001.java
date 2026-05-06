
import java.util.Random;

public class project001 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] ans = new int[50];
        String[] questions = new String[50];
        // ����50����Ŀ�������
        for(int i = 0; i < 50; i++) {
            boolean isAddition = random.nextBoolean();
            int first = random.nextInt(101);
            int second;
            
            if(isAddition) {
                second = random.nextInt(101 - first);
                ans[i] = first + second;
                questions[i] = String.format("%2d + %2d", first, second);
            } else {
                second = random.nextInt(first + 1);
                ans[i] = first - second;
                questions[i] = String.format("%2d - %2d", first, second);
            }
        }
        
        System.out.println("========== 50��100���ڼӼ�����ϰ�� ==========\n");
        for(int i = 0; i < 50; i++) {
            System.out.printf("%2d.  %s = ______\n", i + 1, questions[i]);

        }
        
        System.out.println("\n========== �ο��� ==========\n");
        for(int i = 0; i < 50; i++) {
        	System.out.printf("No.%2d  Ans: %3d\n", i + 1, ans[i]);
        }
    }
}