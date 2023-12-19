package HomeWorks.FirstHW;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(Calc('+', 3, 7));
    }

    public static int Calc(char op, int a, int b) {
        int res = 0;

        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            default:
                System.err.println("Invalid command.");
                break;
        }
        return res;
    }
}
