import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<int[]> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            String[] token = line.trim().split("\\s+");
            list.add(new int[]{Integer.parseInt(token[0]), Integer.parseInt(token[1])});
        }

        list.sort((x, y) -> {
            if (x[0] == y[0]) return Integer.compare(y[1], x[1]);
            return Integer.compare(y[0], x[0]);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int[] tmp = list.get(i);
            sb.append(tmp[0]).append(" ").append(tmp[1]);

            if (i != 9) sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
