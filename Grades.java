import java.util.*;
import java.util.Arrays;
public class Grades {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("No.of Subjects :");
		int no_sub=sc.nextInt();
		int []arr=new int[no_sub];
		System.out.print("Enter the marks :");
		for(int i=0;i<no_sub;i++) {
			arr[i]=sc.nextInt();	
		}
		int Total_marks=0;
		for(int i=0;i<no_sub;i++) {
			Total_marks=Total_marks+arr[i];
		}
		System.out.println("Total marks: "+Total_marks);
		double avg=Total_marks/no_sub;
		System.out.println("Average: "+avg);
		if(avg>89) {
			System.out.println("The Student Grade is \"A\"");
		}
		else if(avg>79 && avg<90) {
			System.out.println("The Student Grade is \"B\"");
		}
		else if(avg>69 && avg<80) {
			System.out.println("The Student Grade is \"C\"");
		}
		else if(avg>59 && avg<70) {
			System.out.println("The Student Grade is \"D\"");
		}
		else if(avg>49 && avg<60) {
			System.out.println("The Student Grade is \"E\"");
		}
		else {
			System.out.println("The Student Grade is \"F\"");
		}
	}

}
