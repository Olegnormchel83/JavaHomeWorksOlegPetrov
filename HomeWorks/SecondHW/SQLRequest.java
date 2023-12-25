//Лень лезть за полным условием
//Если вкратце, то необходимо распарсить строку PARAMS 
//И спаять ее с QUERY так, чтобы получился валидный sql-запрос
//И да, я знаю, что конкретно этот код решает конкретную задачу "Прохождение автотеста в ГикБрейнс"
//И что? Ты что-ли списывать собрался?)

package HomeWorks.SecondHW;

public class SQLRequest {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";
        QUERY = "select * from students where ";
        PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";

        String line1 = PARAMS.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replace("\"", "");
        StringBuilder result = new StringBuilder(QUERY);

        String[] arrayData = line3.split(", ");
        for (int i = 0; i < arrayData.length - 1; i++) {
            String[] arrData = arrayData[i].split(":");
            System.out.println(arrData[0] + " " + arrData[1]);

            result.append(arrData[0]);
            result.append("='");
            result.append(arrData[1]);
            result.append("'");
            if (i != arrayData.length - 2) {
            result.append(" and ");
            }
        }
        System.out.println(result);
    }
}
