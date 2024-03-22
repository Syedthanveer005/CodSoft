import java.util.*;
public class Find_Celcius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        int startFahrenheit =sc.nextInt(); // Start Fahrenheit value
        int endFahrenheit = sc.nextInt(); // End Fahrenheit value
        int stepSize = sc.nextInt(); // Step Size
        System.out.println("Fahrenheit\tCelsius");
        System.out.println("----------      --------");
        for (int fahrenheit = startFahrenheit; fahrenheit <= endFahrenheit; fahrenheit += stepSize) {
            int celsius = (fahrenheit - 32) * 5 / 9; // Conversion formula
            System.out.printf("%d\t\t%d\n", fahrenheit, celsius);
        }

	}

}
