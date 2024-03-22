import java.util.*;
public class NearestValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			System.out.println(getNearestMulitple(n));
		}
	}
	public static int getNearestMulitple(int n) {
		// Write your code here.
		int remainder = n % 10;
        int nearestMultipleOfTen = n - remainder;

        if (remainder > 5) {
            nearestMultipleOfTen += 10;
        }

        return nearestMultipleOfTen;
	}

}
