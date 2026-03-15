import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q360 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int i = 0;
        while (st.hasMoreTokens()) {
            sum += st.nextToken().length();
            i++;
        }

        double avg = (double)sum/i;
        System.out.printf("%.2f%n", avg);
    }
}
