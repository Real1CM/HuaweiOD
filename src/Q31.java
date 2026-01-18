import java.lang.reflect.Array;
import java.util.*;

public class Q31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.replaceAll("[^a-zA-Z]", " ").split("\\s+");
        String target = sc.nextLine();

        /*List<String> list = new ArrayList<String>();
        for (String word : words) {
            if (word.startsWith(target)) {
                list.add(word);
            }
        }

        if(list.isEmpty()){
            System.out.println(target);
            return;
        }

        list.sort(String::compareTo);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i != list.size()-1) System.out.print(" ");
        }*/

        //解法二
        TreeSet<String> set = new TreeSet<>();

        for (String word : words) {
            if (!word.isEmpty() && word.startsWith(target)) {
                set.add(word);
            }
        }

        if (set.isEmpty()) {
            System.out.println(target);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String word : set) {
                sb.append(word).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}