import java.io.*;
import java.util.*;

public class Q58 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String nums = null;
        String[] str = new String[m];
        for (int i = 0; i < m; i++) {
            str[i] = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < n; j++)
                sb.append(str[i].charAt(j) - str[i].charAt(j - 1)).append(j != n - 1 ? " " : "");

            if (i == 0) nums = sb.toString();
            else if (i == 1) {
                if (sb.toString().equals(nums)) continue;
                else {
                    i++;
                    StringBuilder sb1 = new StringBuilder();
                    for (int j = 1; j < n; j++)
                        sb1.append(str[i].charAt(j) - str[i].charAt(j - 1)).append(j != n - 1 ? " " : "");

                    if (sb1.toString().equals(nums)) {
                        System.out.println(str[1]);
                        return;
                    } else {
                        System.out.println(str[0]);
                        return;
                    }
                }
            } else {
                if(!sb.toString().equals(nums)) {
                    System.out.println(str[i]);
                    return;
                }
            }
        }

        System.out.println("null");
        return;
    }
}