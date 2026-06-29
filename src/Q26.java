import java.util.*;

public class Q26 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int i = 0;
        try{
            while (i < str.length()) {
                if (str.charAt(i) == '(') {
                    stack.push(str.substring(i + 1, i + 4));
                    i += 4;
                } else if (str.charAt(i) == ')') {
                    String op = stack.pop();
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(cal(op, a, b));
                    i++;
                } else if (str.charAt(i) == ' ') {
                    i++;
                } else {
                    int start = i;
                    if (str.charAt(i) == '-') i++;
                    while (i < str.length() && Character.isDigit(str.charAt(i))) i++;

                    int num = Integer.parseInt(str.substring(start, i));
                    numStack.push(num);
                }
            }

            System.out.println(numStack.pop());
        } catch(Exception e){
            System.out.println("error");
        }
    }

    private static int cal(String op, int a, int b) {
        return switch (op) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> {
                if (b == 0) throw new ArithmeticException("error");
                yield a / b;
            }
            default -> throw new ArithmeticException("error");
        };
    }*/

    //解法二
    private static int index = 0;
    private static String[] tokens;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();

        line = line.replace("(", "( ").replace(")", " )");
        tokens = line.trim().split("\\s+");

        try {
            int res = parse();
            System.out.println(res);
        } catch (ArithmeticException e) {
            System.out.println("error");
        }
    }

    private static int parse() {
        String token = tokens[index++];
        if (token.equals("(")) {
            String op = tokens[index++];

            int val1 = parse();
            int val2 = parse();

            index++;

            return calculate(op, val1, val2);
        } else {
            return Integer.parseInt(token);
        }
    }

    private static int calculate(String op, int a,int b) {
        switch (op) {
            case "add": return a + b;
            case "sub": return a - b;
            case "mul": return a * b;
            case "div":
                if(b == 0) throw new ArithmeticException("error");
                return Math.floorDiv(a, b);
            default: return 0;
        }
    }
}
