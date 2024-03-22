
public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="radar";
		String s2="";
		char[] c1=s1.toCharArray();
		for(int i=s1.length()-1;i>=0;i--) {
			s2=s2+c1[i];
		}
		if(s1.equals(s2)) {
			System.out.println("palindrome");
		}
		else {
			System.out.println("not palindrome");
		}

	}

}
