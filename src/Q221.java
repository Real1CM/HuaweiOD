import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        int[] sa = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            sa[tmp - 'A'] = i;
        }

        String sub = br.readLine().trim();
        int res = 0;
        int curIdx = sa[sub.charAt(0) - 'A'];
        for (int i = 1; i < sub.length(); i++) {
            int tmpIdx = sa[sub.charAt(i) - 'A'];
            res += Math.abs(tmpIdx - curIdx);
            curIdx = tmpIdx;
        }
        System.out.println(res);
    }
}
