import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }

        String content = sb.toString();
        int cnt = 0;

        boolean inString = false;
        char quoteChar = 0;
        boolean inEscape = false;
        boolean inComment = false;
        boolean hasContent = false;

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);

            if (inComment) {
                if (c == '\n' || c == '\r') {
                    inComment = false;
                }
                continue;
            }

            if (inString) {
                if (inEscape) inEscape = false;
                else if (c == '\\') inEscape = true;
                else if (c == quoteChar) inString = false;
                hasContent = true;
                continue;
            }

            if (c == '-' && i + 1 < content.length() && content.charAt(i + 1) == '-') {
                inComment = true;
                i++;
                continue;
            }

            if (c == '\'' || c == '"') {
                inString = true;
                quoteChar = c;
                hasContent = true;
                continue;
            }

            if (c == ';') {
                if (hasContent) {
                    cnt++;
                    hasContent = false;
                }
                continue;
            }

            if (!Character.isWhitespace(c)) {
                hasContent = true;
            }
        }

        if (hasContent) cnt++;
        System.out.println(cnt);
    }
}
