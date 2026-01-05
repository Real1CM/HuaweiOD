import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetFlaw = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        String vowels = "aeiouAEIOU";
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(vowels.indexOf(str.charAt(i)) != -1) {
                indexes.add(i);
            }
        }

        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < indexes.size(); right++) {
            int curFlaw = (indexes.get(right) - indexes.get(left)) +(right -left);

            while (curFlaw > targetFlaw && right > left) {
                left++;
                curFlaw = (indexes.get(right) - indexes.get(left)) +(right -left);
            }

            if(targetFlaw == curFlaw) {
                int curLen = indexes.get(right) - indexes.get(left);
                maxLen = Math.max(maxLen, curLen);
            }
        }
    }
}