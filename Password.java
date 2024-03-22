import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password:");
        String s = sc.nextLine();
        checkPassword(s);
    }

    public static void checkPassword(String password) {
        char[] ch = password.toCharArray();
        int cap = 0;
        int sm = 0;
        int n = 0;
        int spl = 0;
        int si = ch.length;
        
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) {
                cap++;
            } else if (Character.isLowerCase(ch[i])) {
                sm++;
            } else if (Character.isDigit(ch[i])) {
                n++;
            } else {
                spl++;
            }
        }

        if (si < 8) {
            System.out.println("Password is too short");
        } if (cap < 1) {
            System.out.println("One Capital letter is needed");
        }if (sm < 1) {
            System.out.println("One Small letter is needed");
        }if (n < 1) {
            System.out.println("One Number is needed");
        }if (spl < 1) {
            System.out.println("One Special Character is needed");
        } else {
            System.out.println("Password Generated Successfully");
            return; 
        }
        main(null);
    }
}
