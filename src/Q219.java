import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (!Character.isLetter(c)) {
                if (c == '-') {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    i++;

                    char cur = s.charAt(i);
                    if (Character.isLetter(cur)) continue;

                    while (Character.isDigit(cur)) {
                        sb.append(cur);
                        i++;
                        cur = s.charAt(i);
                    }
                    i--;
                    list.add(Integer.parseInt(sb.toString()));
                } else if (Character.isDigit(c)) {
                    list.add(c - '0');
                }
            }

            i++;
        }

        int res = 0;
        for (int n : list) res += n;
        System.out.println(res);
    }
}
