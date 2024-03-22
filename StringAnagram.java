import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Java";
		String s2="Vaja";
		String a1= s1.toLowerCase();
		String a2=s2.toLowerCase();
		if(a1.length()==a2.length()) {
			char[] c1= a1.toCharArray();
			char[] c2= a2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			boolean result=Arrays.equals(c1,c2);
			if(result) {
				System.out.println("Anagram");
			}
			else
				System.out.println("not anagram");
		}
		else 
			System.out.println("not anagram");
		
				
	}

}
