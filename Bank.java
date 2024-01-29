import java.util.Scanner;

public class Bank {

    public static void main(String[] args) throws Exception {
        BankAccount bankAccount = new BankAccount(12345678, "SYED THANVEER S", 908765432, 1322, 100000);

        System.out.println("\t\t\tWelcome to SST Bank");
        System.out.println("1.Atm Card\n2.Cardless Transactions");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                bankAccount.atmCard();
                break;
            case 2:
                bankAccount.cardLess();
                break;
        }
    }
}

class BankAccount {
    private long accNo;
    private String name;
    private long mobNo;
    private int atmPin;
    private double accBal;

    public BankAccount(long accNo, String name, long mobNo, int atmPin, double accBal) {
        this.accNo = accNo;
        this.name = name;
        this.mobNo = mobNo;
        this.atmPin = atmPin;
        this.accBal = accBal;
    }

    public void atmCard() throws Exception {
        Scanner sc = new Scanner(System.in);
        int noOfAttempts = 0;

        for (int i = 0; i < 3; i++) {
            noOfAttempts++;
            System.out.println("\n\t\t\tEnter the PIN Number");
            int pin = sc.nextInt();

            if (pin == atmPin) {
                performTransaction();
                break;
            } else {
                if (noOfAttempts > 2) {
                    System.out.println("\t\t\tYour Card has been Blocked");
                    System.out.println("\t\t\tThank You! Visit Again");
                    break;
                }
                System.out.println("\t\t\tYour PIN Number is Incorrect");
            }
        }
    }

    public void cardLess() throws Exception {
        Scanner sc = new Scanner(System.in);
        int attemp=0;
        for(int i=0;i<5;i++) {
        	attemp++;

        	System.out.println("Enter the Account Number");
            long acNo = sc.nextLong();
            if (acNo == accNo) {
                System.out.println("\n" + name + "\t\t\t" + accNo);
                System.out.println("\n1.Deposit\n2.Withdrawl");
                int choice = sc.nextInt();
                if (choice == 1) {
                    ATM.deposit(accBal);
                } else if (choice == 2) {
                    ATM.withdrawal(accBal);
                }
                break;
            }
        	else if(acNo != accNo){
        		if(attemp==3){
            		System.out.println("Your Transaction Has been Timed Out");
            		System.out.println("Thank You! Visit Again");
            		break;
            	}
        		else {
        			System.out.println("Enter the Valid Account Number");
        		}
        	}
        	
        }
    }

    private void performTransaction() throws Exception {
        System.out.println("\n\n1.Deposit\n2.Withdrawl\n3.CheckBalance");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                ATM.deposit(accBal);
                break;
            case 2:
                ATM.withdrawal(accBal);
                break;
            case 3:
                ATM.checkBalance(accBal);
                break;
        }
    }
}

class ATM {
    static Scanner sc = new Scanner(System.in);

    public static void deposit(double amount) throws Exception {
        System.out.println("\t\t\tEnter the Amount");
        double value = sc.nextDouble();
        if (value <= 30000) {
            amount += value;
            performTransaction(amount);
        } else {
            System.out.println("Transaction amount is too High");
            System.out.println("Enter the amount within the limit:30000");
            deposit(amount);
        }
    }

    public static void withdrawal(double amount) throws Exception {
        System.out.println("\t\t\tEnter the Amount");
        double value = sc.nextDouble();
        if (value <= amount && value <= 10000) {
            amount -= value;
            performTransaction(amount);
        } else if (value > amount) {
            System.out.println("\t\t\tInsufficient Balance");
            withdrawal(amount);
        } else {
            System.out.println("Enter the Amount within the Limit:10000");
            withdrawal(amount);
        }
    }

    public static void checkBalance(double amount) {
        System.out.println("\t\t\tYour Accounts available Balance is:" + amount);
        System.out.println("\t\t\tThank You! Visit Again");
    }

    private static void performTransaction(double amount) throws Exception {
        System.out.print("\t\t\tTransaction Processing");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.print(".");
        }
        System.out.println("\n\n\t\t\tTransaction completed Successfully");
        System.out.println("\n\t\t\tYour Account Balance is:" + amount);
        System.out.println("\t\t\tThank You! Visit Again");
    }
}
