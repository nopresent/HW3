package lab.onpresent;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Circle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        double radius = 3.33;
        // Кол-во попыток
        int i = 3;

        System.out.println("1. Написати клас Circle (коло) і метод, який буде повертати його площа.");
        while (i >= 0) {

            System.out.println("Введіть радіус кола у см.:");
            String inputRadius = in.next();

            try {
                double inputRadiusD = Double.valueOf(inputRadius);

                if (inputRadiusD <= 0) {
                    System.out.println("Радіус кола може бути тільки більше 0.");
                } else {
                    radius = inputRadiusD;
                    break;
                }

            } catch (NumberFormatException n) {
                System.out.println("Це не число!");
            }

            --i;

            if (i <= 0) {
                System.out.println("Я втомився, нехай це буде: " + radius + " см.");
                break;
            }
        }

        System.out.println("Якщо радіус дорівнює " + radius + " см., площа кола дорівнює " +
                Circle.square(radius) + " квадратних сантиметрів");
        System.out.println(stringDelimiter);


    }

    // Разделитель вопросов
    public static String stringDelimiter = "---------";

    // Площадь круга
    public static double square(double radius) {
        DecimalFormat df = new DecimalFormat(".####");
        String answer = df.format(Math.PI * Math.pow(radius, 2));
        return Double.valueOf(answer.replace(",", "."));
    }

}
