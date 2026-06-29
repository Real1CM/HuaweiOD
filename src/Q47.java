import java.util.*;

public class Q47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        /*
        //StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < arr.length - n + 1; i++) {
            int curMin = arr[i];
            for (int j = i; j < i + n; j++) {
                curMin = Math.min(curMin, arr[j]);

            }
            //sb.append(curMin).append(i != arr.length - n ? "," : "");
            sj.add(String.valueOf(curMin));
        }

        //System.out.println(sb.toString());
        System.out.println(sj);
        */

        StringJoiner sj = new StringJoiner(",");
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - n + 1) dq.pollFirst();

            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) dq.pollLast();

            dq.addLast(i);

            if (i >= n - 1) sj.add(String.valueOf(arr[dq.peekFirst()]));
        }

        System.out.println(sj);
    }
}