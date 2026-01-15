import java.util.*;

public class Q27 {
    private static final Set<Integer> NARCISSISTIC_NUMS = new HashSet<>(Arrays.asList(153, 370, 371, 407));

    private static int totalSolution = 0;
    private static int firstCut = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line = sc.nextLine();

        solve(line, 0, 0);

        if(totalSolution == 0) {
            System.out.println(0);
        } else if(totalSolution == 1) {
            System.out.println(firstCut);
        } else {
            System.out.println(-1);
        }
    }

    private static void solve(String line, int first, int curCut) {
        if (first == line.length()) {
            totalSolution++;
            firstCut = curCut;
            return;
        }

        int curSum = 0;
        for (int i = 0; i < line.length(); i++) {
            curSum += line.charAt(i);
            if(curSum > 407) {
                break;
            }

            if(NARCISSISTIC_NUMS.contains(curSum)) {
                solve(line, i + 1, curCut + 1);

                if(totalSolution > 1) return;
            }
        }
    }
}
