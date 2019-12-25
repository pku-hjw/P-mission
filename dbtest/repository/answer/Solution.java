import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i <len ; i++) {
            nums[i]=input.nextInt();
        }
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                times++;
            } else {
                times--;
                if (times == 0) {
                    result = nums[++i];
                    times++;
                }
            }
        }
        System.out.println(result);
    }
}