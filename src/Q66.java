import java.util.Scanner;
import java.util.Stack;

public class Q66 {
    static class Fraction {
        long num;
        long den;

        public Fraction(long num, long den) {
            if (den == 0) {
                throw new ArithmeticException("ERROR");
            }
            this.num = num;
            this.den = den;
        }

        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(a, b % a);
        }

        private void shrink() {
            if (den < 0) {
                num = -num;
                den = -den;
            }
            long g = gcd(Math.abs(num), den);
            num /= g;
            den /= g;
        }

        public Fraction add(Fraction o) {
            return new Fraction(this.num * o.den + this.den * o.num, this.den * o.den);
        }

        public Fraction sub(Fraction o) {
            return new Fraction(this.num * o.den - this.den * o.num, this.den * o.den);
        }

        public Fraction mul(Fraction o) {
            return new Fraction(this.num * o.num, this.den * o.den);
        }

        public Fraction div(Fraction o) {
            if (o.num == 0) {
                throw new ArithmeticException("ERROR");
            }
            return new Fraction(this.num * o.den, this.den * o.num);
        }

        @Override
        public String toString() {
            if (den == 1) return String.valueOf(num);
            else return num + "/" + den;
        }
    }

    private static int priority(char op) {
        if (op == '*' || op == '/') return 1;
        if (op == '+' || op == '-') return 2;
        return 0;
    }

    private static void eval(Stack<Fraction> numStack, Stack<Character> opStack) {
        if (numStack.size() < 2 || opStack.isEmpty()) return;
        Fraction b = numStack.pop();
        Fraction a = numStack.pop();
        char op = opStack.pop();

        Fraction res;
        switch (op) {
            case '+':
                res = a.add(b);
                break;
            case '-':
                res = a.sub(b);
                break;
            case '*':
                res = a.mul(b);
                break;
            case '/':
                res = a.div(b);
                break;
            default:
                return;
        }
        numStack.push(res);
    }

    public static String calculate(String s) {
        Stack<Fraction> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                long val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numStack.push(new Fraction(val, 1));
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    eval(numStack, opStack);
                }
                opStack.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!opStack.isEmpty() && priority(opStack.peek()) >= priority(c)) {
                    eval(numStack, opStack);
                }
                opStack.push(c);
            }
        }

        while (!opStack.isEmpty()) {
            eval(numStack, opStack);
        }

        return numStack.peek().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();

        expr = expr.replaceAll("\\s+", "");

        try {
            String res = calculate(expr);
            System.out.println(res);
        } catch (ArithmeticException e) {
            System.out.println("ERROR");
        }
    }
}