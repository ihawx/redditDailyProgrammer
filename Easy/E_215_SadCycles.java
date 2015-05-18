package dailyprogrammerreddit;

import java.util.ArrayList;
import java.util.Scanner;

public class E_215_SadCycles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the power");
        int power = Integer.parseInt(in.nextLine());
        System.out.println("Enter the number");
        int num = Integer.parseInt(in.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("----------------");
        while (!list.contains(num)) {
            list.add(num);
            num = ArrayPower(StringToInt("" + num), power);
        }
        for (int i = list.indexOf(num); i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i) + "\n");
            }
        }
    }

    public static int[] StringToInt(String text) {
        int[] out = new int[text.length()];
        for (int i = 0; i < out.length; i++) {
            out[i] = Integer.parseInt(text.substring(i, i + 1));
        }
        return out;
    }

    public static int ArrayPower(int[] in, int power) {
        int out = 0;
        for (int i = 0; i < in.length; i++) {
            out += Math.pow(in[i], power);
        }
        return out;
    }
}
