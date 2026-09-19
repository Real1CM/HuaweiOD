import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q272 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String a = sc.nextLine();
        if (!sc.hasNextLine()) return;
        String b = sc.nextLine();

        int aLen = a.length();
        int bLen = b.length();

        List<Integer>[] aIdx = new List[26];
        for (int i = 0; i < 26; i++) aIdx[i] = new ArrayList<>();

        for (int i = 0; i < aLen; i++) {
            char c = a.charAt(i);
            aIdx[c - 'a'].add(i);
        }

        int cnt = 0;
        while (true) {

            int lastListIdx = -1;
            boolean isMatched = true;
            boolean allDone = false;
            for (int i = 0; i < bLen; i++) {
                int curBCharIdx = b.charAt(i) - 'a';

                if (aIdx[curBCharIdx].isEmpty()) {
                    if (i == 0) allDone = true;
                    isMatched = false;
                    break;
                }

                int curListIdx = aIdx[curBCharIdx].getFirst();
                if (curListIdx <= lastListIdx) {
                    isMatched = false;
                    break;
                }

                lastListIdx = curListIdx;
                aIdx[curBCharIdx].removeFirst();
            }

            if (allDone) break;

            if (isMatched) cnt++;
        }

        System.out.println(cnt);
    }
}