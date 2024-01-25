import java.util.Scanner;
import java.util.Random;
public class Number_Guess {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	Random random=new Random();
	
	int start=1;
	int end=100;
	int random_num=random.nextInt(end-start+1)+start;
	System.out.println(random_num);
	guess(random_num,start,end);
	}
	public static void guess(int ran_num,int start,int end) {
		int no_attempts=0;
		boolean guess_num=false;
		for(int i=0;i<4;i++) {
			no_attempts++;
			if(no_attempts>3) {
				System.out.println("YOu failed to Guess the Correct Number");
				System.out.println("1.Try Again");
				System.out.println("2.Exit");
				int option=sc.nextInt();
				switch(option) {
				case 1:{
					guess(ran_num,start,end);
					break;
				}
				case 2:{
					System.out.println("Thank You! Come and Play Again");
					break;
				}
					
				}
				break;
			}
			System.out.print("Enter the number: ");
			int num=sc.nextInt();
			if(num<start || num>end) {
				System.out.println("Please enter the valid number within the range");
			}
			if(num>ran_num) {
				System.out.println("Too High! Try Again ");
			}
			else if(num<ran_num) {
				System.out.println("Too Low! Try Again");
			}
			else {
				guess_num=true;
				System.out.println("Congratulations! YOu guessed the Correct Number");
				switch(no_attempts){
					case 1:{
						System.out.println("You  Scored 100 points");
						break;
					}
					case 2:{
						System.out.println("You Scored 60 points");
						break;
					}
					case 3:{
						System.out.println("You Scored 30 points");
						break;
					}
						
				}
				break;
				
			}
			
		}
	}

}
