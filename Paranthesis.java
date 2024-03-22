import java.util.Scanner;

public class Paranthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		int count=0;
		for(char c:s1.toCharArray()) {
			if(c=='(') {
				count++;
			}
			if(c==')') {
				count--;
			}
		}
		System.out.println(count);
	}

}
