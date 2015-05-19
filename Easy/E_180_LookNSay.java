package dailyprogrammerreddit;

import java.util.Scanner;

public class E_180_LookNSay {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        int[] digits;
        for (int i = 0; i < 15; i++) {
            digits = Digits(text);
            Sort(digits);
            text = "";
            int actual = digits[0];
            int count = 0;
            for (int j = 0; j < digits.length; j++) {
                if (actual != digits[j]) {
                    text += "" + count + actual;
                    count = 1;
                    actual = digits[j];
                } else {
                    count++;
                }
            }
            text += "" + count + actual;
            System.out.println(text);
        }
    }

    public static int[] Digits(String number) {
        int[] digs = new int[number.length()];
        for (int i = 0; i < digs.length; i++) {
            digs[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        return digs;
    }

    public static void Sort(int[] in) {
        int max = Integer.MAX_VALUE;
        int pos = -1;
        int pom1, pom2 = 0;
        for (int j = 0; j < in.length; j++) {
            for (int i = pom2; i < in.length; i++) {
                if (in[i] < max) {
                    max = in[i];
                    pos = i;
                }
            }

            pom1 = in[pom2];
            in[pom2] = max;
            in[pos] = pom1;
            pom2++;
            max = Integer.MAX_VALUE;
        }
    }
}
