import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");

        int[] arr = new int[str.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            arr[i] = num;
            if (num == 1) list.add(i);
        }

        int maxDistance = 0;
        for (int i = 1; i < list.size(); i++) {
            int curDistance = (list.get(i) - list.get(i - 1)) / 2;
            maxDistance = Math.max(maxDistance, curDistance);
        }

        if (arr[0] == 0) maxDistance = Math.max(maxDistance, list.get(0));

        if (arr[arr.length - 1] == 0) maxDistance = Math.max(maxDistance, list.get(list.size() - 1));

        System.out.println(maxDistance);
    }
}
