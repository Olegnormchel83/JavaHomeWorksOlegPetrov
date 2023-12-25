package HomeWorks.SecondHW;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        // int[] arr = new int[] { 9, 4, 8, 3, 1 };
        int[] arr = new int[] { 9, 3, 4, 8, 2, 5, 7, 1, 6, 10 };
        //int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSortAlgorithm(arr);
    }

    public static void bubbleSortAlgorithm(int[] mas) throws IOException {
        PrintWriter writer = new PrintWriter("log.txt");
        writer.write("");
        writer.close();
        int temp = 0;
        FileWriter fileWriter;
        fileWriter = new FileWriter("log.txt", true);
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < mas.length - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    temp = mas[j + 1];
                    mas[j + 1] = mas[j];
                    mas[j] = temp;
                    isSorted = false;
                }
            }
            fileWriter.write(LocalDate.now().toString() + " ");
                int nowMinute = LocalTime.now().getMinute();
                if (nowMinute >= 0 && nowMinute < 10) {
                    fileWriter.write(LocalTime.now().getHour() + ":" + "0" + nowMinute + " ");
                } else {
                    fileWriter.write(LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + " ");
                }
                fileWriter.write(Arrays.toString(mas) + "\n");
        }
        fileWriter.close();
    }
}
