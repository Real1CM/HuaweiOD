import java.util.Arrays;
import java.util.Scanner;

public class Q132 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = sc.nextInt();
        int tar = sc.nextInt();

        Arrays.sort(arr);

        int cnt = 0;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            if (arr[r] >= tar) {
                cnt++;
                r--;
            } else if (l < r && arr[l] + arr[r] >= tar) {
                cnt++;
                l++;
                r--;
            } else l++;
        }

        System.out.println(cnt);
    }
}