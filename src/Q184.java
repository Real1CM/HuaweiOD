import java.util.Scanner;
import java.util.StringJoiner;

public class Q184 {
    static String pswd = "******";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().replaceAll("__", "_").trim().split("_");

        StringJoiner sj = new StringJoiner("_");
        int i = 0;
        int mark = 0;
        while (i < str.length) {
            if ("password".equals(str[i])) {
                sj.add(str[i]);

                i++;
                if(str[i].charAt(0)=='"') mark++;
                while (mark!=0){
                    if(str[i].charAt(str[i].length()-1)=='"') {
                        mark--;
                        break;
                    }
                    i++;
                }

                sj.add(pswd);
            } else {
                sj.add(str[i]);
            }

            i++;
        }

        System.out.println(sj.toString());
    }
}
