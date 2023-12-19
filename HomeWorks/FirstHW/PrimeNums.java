package HomeWorks.FirstHW;

public class PrimeNums {
    public static void main(String[] args) {
        PrintPrimeNums();
    }

    public static void PrintPrimeNums() {
        int number = 1000;
        System.out.println(2);

        for (int i = 3; i < number; i += 2) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
        
    }

    public static boolean isPrime(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
}
