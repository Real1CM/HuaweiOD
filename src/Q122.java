import java.util.Arrays;
import java.util.Scanner;

public class Q122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().trim().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);

        int l = 0, r = arr.length - 1;
        long maxS = 0;
        while (l < r) {
            long curS = (long) Math.min(arr[l], arr[r]) * (r - l);

            maxS = Math.max(curS,maxS);

            if(arr[l]>arr[r]) r--;
            else l++;
        }

        System.out.print(maxS);
    }
}
