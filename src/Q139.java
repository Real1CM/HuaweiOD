import java.awt.desktop.PreferencesEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q139 {
    static String[] str = {" ", ",.", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        StringBuilder sb = new StringBuilder();
        boolean isEngMod = false;

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (tmp == '#') {
                isEngMod = !isEngMod;
                continue;
            }

            if (tmp == '/') continue;

            if (!isEngMod) {
                sb.append(getNum(tmp));
            } else {
                if (tmp >= '0' && tmp <= '9') {
                    int time = 0;
                    while (i<s.length()&&s.charAt(i)==tmp){
                        time++;
                        i++;
                    }
                    i--;

                    sb.append(getAlphabet(tmp, time));
                }
            }
        }

        System.out.println(sb);
    }

    private static String getNum(char num) {
        return num + "";
    }

    private static String getAlphabet(char numc, int time) {
        int num = numc - '0';
        int idx = (time - 1) % str[num].length();
        return str[num].charAt(idx) + "";
    }
}
