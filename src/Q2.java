import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",", 2);

        String prefix = words.length > 0 ? words[0] : "";
        String suffix = words.length > 1 ? words[1] : "";

        if(prefix.isEmpty() && suffix.isEmpty()) {
            System.out.println("/");
        } else if (prefix.isEmpty() && !suffix.isEmpty()) {
            if(suffix.startsWith("/")) {
                System.out.println(suffix);
            } else {
                System.out.println("/" + suffix);
            }
        } else if (!prefix.isEmpty() && suffix.isEmpty()) {
            if(prefix.startsWith("/")) {
                System.out.println(prefix);
            } else {
                System.out.println("/" + prefix);
            }
        } else {
            if(suffix.startsWith("/") && prefix.startsWith("/")) {
                System.out.println(prefix + suffix);
            } else if (!suffix.startsWith("/") && prefix.startsWith("/")) {
                System.out.println(prefix + "/" + suffix);
            } else if (suffix.startsWith("/") && !prefix.startsWith("/")) {
                System.out.println("/" + prefix  + suffix);
            } else if (!suffix.startsWith("/") && !prefix.startsWith("/")) {
                System.out.println("/" + prefix + "/"+ suffix);
            }
        }
    }
}
