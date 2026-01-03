import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetFlaw = Integer.parseInt(sc.nextLine());
        String string = sc.nextLine();

        String vowels = "aeiouAEIOU";
        List<Integer> exsitVowels = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char tmp = string.charAt(i);
            if (vowels.indexOf(tmp) != -1) {
                exsitVowels.add(i);
            }
        }

        int left = 0;
        int maxlen = 0;
        for (int right = 0; right < exsitVowels.size(); right++) {
            int flaw = (exsitVowels.get(right) - exsitVowels.get(left) + 1) - (right - left + 1);

            while(left < right && flaw >targetFlaw) {
                left++;
                flaw =  (exsitVowels.get(right) - exsitVowels.get(left) + 1) - (right - left + 1);
            }

            if(flaw == targetFlaw) {
                int len = exsitVowels.get(right) - exsitVowels.get(left) + 1;
                maxlen = Math.max(maxlen, len);
            }
        }

        System.out.println(maxlen);
        sc.close();
    }
}
