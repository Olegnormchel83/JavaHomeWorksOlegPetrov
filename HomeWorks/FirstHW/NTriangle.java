// Вычислить n-ое треугольного число(сумма чисел от 1 до n).

// Внутри класса Answer напишите метод countNTriangle, 
// который принимает число n и возвращает его n-ое треугольное число.
// Если число n < 1 (ненатуральное) метод должен вернуть -1.

package HomeWorks.FirstHW;

public class NTriangle {
    public static void main(String[] args) {
        System.out.println(CountNTriangle(5));
    }

    public static int CountNTriangle(int n) {
        int res = 0;
        if (n < 1) {
            return -1;
        }
        else {
            while (n != 0) {
                res += n;
                n--;
            }
        }
        return res;
    }
}
