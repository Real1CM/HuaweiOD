import java.util.*;

public class Q29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(sc.nextLine());

        int left = 0;
        int curSum = 0;
        int maxIndex = -1;
        for (int right = 0; right < arr.length; right++) {
            curSum += arr[right];

            while (curSum > target && left <= right) curSum -= arr[left++];


            if (curSum == target) {
                maxIndex = Math.max(maxIndex, right - left + 1);
            }
        }
        System.out.println(maxIndex);
    }
}