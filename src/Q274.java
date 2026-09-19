import java.util.*;

public class Q274 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);

        int tarIdx = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curDiff = Math.abs(x - a[i]);
            if (curDiff < diff) {
                diff = curDiff;
                tarIdx = i;
            }
        }

        int l = tarIdx - 1, r = tarIdx + 1;
        int nowLorR = 0;
        List<Integer> list = new ArrayList<>();
        list.add(a[tarIdx]);
        k--;
        while (k != 0) {
            if (nowLorR == 0) {
                if (l < 0) {
                    nowLorR = (nowLorR + 1) % 2;
                    continue;
                }
                list.addFirst(a[l]);
                l--;
                k--;
            } else if (nowLorR == 1) {
                if (r > n - 1) {
                    nowLorR = (nowLorR + 1) % 2;
                    continue;
                }
                list.add(a[r]);
                r++;
                k--;
            }

            nowLorR = (nowLorR + 1) % 2;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i : list) sj.add(i + "");
        System.out.println(sj.toString());
    }
}
