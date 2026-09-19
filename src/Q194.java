import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Q194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tar = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        while (st.hasMoreTokens()) {
            String tag = st.nextToken();

            String first = st.nextToken();
            String second = st.nextToken();
            int len = Integer.parseInt(second + first, 16);

            if (tar.equals(tag)) {
                StringJoiner sj = new StringJoiner(" ");
                while (len-- > 0) {
                    sj.add(st.nextToken());
                }
                System.out.println(sj);
                return;
            } else {
                while (len-- > 0) {
                    st.nextToken();
                }
            }
        }
    }
}
