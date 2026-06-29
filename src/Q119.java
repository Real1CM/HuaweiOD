import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q119 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");

        for (int i = 0; i < str.length; i++) {
            char[] arr = str[i].toCharArray();

            int l = 0, r = arr.length - 1;
            while (l < r) {
                if (arr[l] == '.' || arr[l] == '?') l++;
                else if (arr[r] == '.' || arr[r] == '?') r--;
                else {
                    char tmp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = tmp;
                    l++;
                    r--;
                }
            }

            System.out.print(new String(arr));
            System.out.print(i != str.length - 1 ? " " : "");
        }
    }
}
