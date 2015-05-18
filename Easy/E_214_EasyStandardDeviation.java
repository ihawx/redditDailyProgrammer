package dailyprogrammerreddit;

import java.util.Scanner;

public class E_214_EasyStandardDeviation {

    public static void main(String[] args) {
        String text = " ";
        while (text.length() > 0) {
            Scanner input = new Scanner(System.in);
            double average = 0, variance = 0;
            System.out.println("Enter numbers or press ENTER to end the program");
            text = input.nextLine();
            if (text.length() > 0) {
                String[] nums = text.split(" ");
                for (String num : nums) {
                    average += Double.parseDouble(num)/nums.length;
                }
                for (String num : nums) {
                    variance += Math.pow(Double.parseDouble(num) - average, 2)/nums.length;
                }
                System.out.print("Standard deviation: ");
                System.out.printf("%.4f\n\n", Math.sqrt(variance));              
            }
        }
    }

}
