import java.io.*;
import java.util.*;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        char[] arr = s.toCharArray();
        int idx = arr.length - 1;

        arr[idx]++;
        while (idx >= 0 && idx < arr.length) {
            if (arr[idx] >= 'a' + num) {
                idx--;
                if (idx > 0) arr[idx]++;
            } else if ((idx > 0 && arr[idx] == arr[idx - 1]) ||
                    (idx > 1 && arr[idx] == arr[idx - 2])) {
                arr[idx]++;
            } else {
                idx++;
                arr[idx] = 'a';
            }
        }
    }
}