import java.util.*;

public class Q25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] words = sc.nextLine().split(" ");

        int[] people = new int[words.length];
        char[] flag = new char[words.length];

        int i = 0;
        for (String word : words) {
            String[] ok = word.split("/");
            people[i] = Integer.parseInt(ok[0]);
            char f = ok[1].charAt(0);
            if (f != 'Y' && f != 'N') {
                System.out.println("ERROR");
                return;
            }
            flag[i] = f;
            i++;
        }

        List<Integer>[] list = new ArrayList[2];
        list[0] = new ArrayList<>();
        list[1] = new ArrayList<>();

        int curClass = 0;
        for (int j = 0; j < people.length; j++) {
            if (j == 0 && flag[j] == 'Y') {
                System.out.println("ERROR");
                return;
            }

            if (flag[j] == 'N') {
                curClass = (curClass + 1) % 2;
            }
            list[curClass].add(people[j]);
        }
        Collections.sort(list[0]);
        Collections.sort(list[1]);

        if (!list[0].isEmpty() && !list[1].isEmpty()
                && list[0].get(0) > list[1].get(0)) {
            List<Integer> tmp = list[0];
            list[0] = list[1];
            list[1] = tmp;
        }

        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < list[j].size(); k++) {
                System.out.print(list[j].get(k));
                if (k != list[j].size() - 1)
                    System.out.print(" ");
            }
            if(j!=list[j].size()-1) {
                System.out.print("\n");
                System.out.println("");
            }
        }
    }
}