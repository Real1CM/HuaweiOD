import java.util.*;

public class Q34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (val % 2 == 0) evens.add(val);
            else odds.add(val);
        }

        int count = 0;
        int[] match = new int[evens.size()];
        Arrays.fill(match, 0);

        for (int odd : odds) {
            boolean[] used = new boolean[evens.size()];
            if (canFind(odd, evens, used, match)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean canFind(int odd, List<Integer> evens, boolean[] used, int[] match) {
        for (int i = 0; i < evens.size(); i++) {

            if (isPrime(odd + evens.get(i)) && !used[i]) {
                used[i] = true;

                if (match[i] == 0 || canFind(match[i], evens, used, match)) {
                    match[i] = odd;
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * 1 <= n / 2; i++) {    //只要判断到根号n
            if (n % i == 0) return false;
        }
        return true;
    }
}
