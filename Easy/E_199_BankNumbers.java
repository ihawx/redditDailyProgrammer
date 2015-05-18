package dailyprogrammerreddit;

import java.util.Scanner;

public class E_199_BankNumbers {

    public static void main(String[] args) {
        String[][] nums = new String[3][10];
        nums[0] = new String[]{" _ ", "   ", " _ ", " _ ", "   ", " _ ", " _ ", " _ ", " _ ", " _ "};
        nums[1] = new String[]{"| |", "  |", " _|", " _|", "|_|", "|_ ", "|_ ", "  |", "|_|", "|_|"};
        nums[2] = new String[]{"|_|", "  |", "|_ ", " _|", "  |", " _|", "|_|", "  |", "|_|", " _|"};
        Scanner in = new Scanner(System.in);
        String toConvert = in.nextLine();
        String out="";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < toConvert.length(); j++) {
                out+=nums[i][Integer.parseInt(toConvert.substring(j, j + 1))];                
            }
            out+="\n";
        }
        System.out.println(out);
    }
}
