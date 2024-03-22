import java.util.*;
import java.util.Arrays;
public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String g="fine am i hi";
		String[] s=g.split(" ");
		String[]a=new String[s.length];
		for(int i=s.length-1,j=0;i>=0;i--,j++) {	
				a[j]=s[i];
				System.out.print(a[j]+" ");
		}
		
		
	}

}
