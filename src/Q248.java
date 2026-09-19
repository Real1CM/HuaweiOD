import java.util.Arrays;
import java.util.Scanner;

public class Q248 {
    static int[][] cards = new int[5][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) cards[i] = convert(sc.nextLine());

        Arrays.sort(cards, (x, y) -> x[0] - y[0]);

        int res = 0;
        if (is1()) res = 1;
        else if (is2()) res = 2;
        else if (is3()) res = 3;
        else if (is4()) res = 4;
        else if (is5()) res = 5;
        else if (is6()) res = 6;
        System.out.println(res);
    }

    private static int[] convert(String line) {
        String[] parts = line.trim().split("\\s+");

        int rank;
        if ("A".equals(parts[0])) rank = 1;
        else if ("J".equals(parts[0])) rank = 11;
        else if ("Q".equals(parts[0])) rank = 12;
        else if ("K".equals(parts[0])) rank = 13;
        else rank = Integer.parseInt(parts[0]);

        int suit = 0;
        if ("H".equals(parts[1])) suit = 1;
        else if ("S".equals(parts[1])) suit = 2;
        else if ("C".equals(parts[1])) suit = 3;
        else if ("D".equals(parts[1])) suit = 4;

        return new int[]{rank, suit};
    }

    private static boolean is1() {
        int suit = cards[0][1];
        for (int i = 1; i < 5; i++) {
            if (suit != cards[i][1]) return false;
        }
        if (!is5()) return false;
        return true;
    }

    private static boolean is2() {
        for (int i = 0; i < 2; i++) {
            int cur = cards[i][0];
            int num = 0;

            for (int j = i + 1; j < 5; j++) {
                if (cur != cards[j][0]) break;
                num++;
            }

            if (num == 4) return true;
        }
        return false;
    }

    private static boolean is3() {
        if (cards[0][0] == cards[1][0] && cards[0][0] == cards[2][0] && cards[3][0] == cards[4][0]) return true;
        if (cards[4][0] == cards[3][0] && cards[4][0] == cards[2][0] && cards[1][0] == cards[2][0]) return true;
        return false;
    }

    private static boolean is4() {
        int cur = cards[0][1];
        int num = 1;

        for (int j = 1; j < 5; j++) {
            if (cur != cards[j][1]) break;
            num++;
        }

        if (num == 5) return true;
        return false;
    }

    private static boolean is5() {
        int rank = cards[0][0] + 1;
        for (int i = 1; i < 5; i++) {
            if (rank != cards[i][0]) return false;
            rank++;
        }
        return true;
    }

    private static boolean is6() {
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            int cur = cards[i][0];
            boolean has3 = true;
            for (int j = i + 1; j <= i + 2; j++) {
                if (cur != cards[j][0]) {
                    has3 = false;
                    break;
                }
            }
            if (has3) {
                idx = i;
                break;
            }
        }

        if (idx == 0 && cards[3][0] != cards[4][0]) return true;
        else if (idx == 1) return true;
        else if (idx == 2 && cards[0][0] != cards[1][0]) return true;
        return false;
    }
}
