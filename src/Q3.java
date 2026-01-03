import java.util.Scanner;

public class Q3 {
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < num; i++){
            if(num%i != 0) continue;

            boolean flag = true;

            for(int j = i; j < num; j++){
                if(arr[j] != arr[j - i]) {
                    break;
                     flag = false;
                }
            }

            if(flag) {
                for(int k = 0; k < i; k++){
                    System.out.print(arr[k]);
                }
                break;
            }

        }

        sc.close();
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] lps = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && nums[j] != nums[i]) {
                j = lps[j - 1];
            }

            if(nums[j] == nums[i]){
                j++;
            }

            lps[i] = j;
        }

        int min = n - lps[n - 1];

        for(int i = 0; i < min; i++){
            System.out.print(nums[i]);
            if(i < n - 1) System.out.print(" ");
        }
    }
}
