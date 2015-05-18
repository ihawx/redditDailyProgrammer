package dailyprogrammerreddit;

import java.util.Scanner;

public class E_212_Rovarspraket {

    public static void main(String[] args) {
        char[] cons = {'q', 'w', 'r', 't', 'z', 'p', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'R', 'T', 'Z', 'P', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'X', 'C', 'V', 'B', 'N', 'M'};
        System.out.println("Enter sentence for coding");
        Scanner vstup = new Scanner(System.in);
        String text = vstup.nextLine();
        for (int i = 0; i < text.length(); i++) {
            if (contains(cons,text.charAt(i))) {
                text=text.substring(0, i+1)+"o"+text.substring(i, i+1).toLowerCase()+text.substring(i+1);                
                i+=2;
            }
        }
        System.out.println("Coded text: "+text);
        for (int i = 0; i < text.length(); i++) {
            if (contains(cons,text.charAt(i))) {
                text=text.substring(0, i+1)+text.substring(i+3);
            }
        }
        System.out.println("Decoded text: "+text);
    }

    public static boolean contains(char[] input, char cont) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == cont) {
                return true;
            }
        }
        return false;
    }
}
