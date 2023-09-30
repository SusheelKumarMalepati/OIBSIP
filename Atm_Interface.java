import java.util.*;
public class Atm_Interface{
	public static void main(String args[]){
		details d=new details();
		Scanner sc=new Scanner(System.in);
		int c;
		do{
			System.out.println("enter 1 for login 2 for register 0 for exit");
			c=Integer.parseInt(sc.nextLine());
			switch(c){
				case 1:
					d.log();
					break;
				case 2:
					d.reg();
					break;
				case 0:
					System.out.println("exitted successfully");
					break;
			}
		}while(c!=0);
	}
}
//registering user
class details{
	String name;
	int uid;
	int upin;
	int n;
	int p;
	public void reg(){
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your name");
	name=sc.nextLine();
	System.out.println("enter user id");
	uid=Integer.parseInt(sc.nextLine());
	System.out.println("enter pin");
	upin=Integer.parseInt(sc.nextLine());
	}
	public void log(){
		accdetails ac=new accdetails();
		Scanner sc=new Scanner(System.in);	
		System.out.println("enter user id");
		n=Integer.parseInt(sc.nextLine());
		System.out.println("enter pin");
		p=Integer.parseInt(sc.nextLine());
		if(n==uid&&p==upin){
			int c;
			System.out.println("login successful as "+name);
			do{
				System.out.println("enter 1 for deposit\nenter 2 for withdraw\nenter 3 for transfer\nenter 4 for transaction history\nenter 5 for balance\nenter 0 for logout");
				c=Integer.parseInt(sc.nextLine());
				switch(c){
					case 1:
						ac.deposit();
						break;
					case 2:
						ac.withdraw();
						break;
					case 3:
						ac.transfer();
						break;
					case 4:
						ac.transaction_history();
						break;
					case 5:
						ac.Balance();
						break;
					case 0:
						System.out.println("logged out successfully");
						break;
				}
			}while(c!=0);
						
		}
		else{
			System.out.println("username or password incorrect");
		}
	}
}
class accdetails{
	Scanner sc=new Scanner(System.in);
	int balence=0;
	String transaction_hist="";
	public void deposit(){
		System.out.println("enter amount to be deposited");
		int dep;
		dep=Integer.parseInt(sc.nextLine());
		balence+=dep;
		System.out.println(dep+" deposited successfully");
		transaction_hist+=dep+"deposited successfully\n";
	}
	public void withdraw(){
		System.out.println("enter amount to be withdrawed");
		int wit;
		wit=Integer.parseInt(sc.nextLine());
		if(balence>wit){
			balence-=wit;
			System.out.println(wit+" withdrawed successfully");
			transaction_hist+=wit+" withdrawed successfully\n";
		}
		else{
			System.out.println("Insufficientbalance");
		}
	}
	public void transfer(){
		System.out.println("enter recepient name :");
		String rn;
		rn=sc.nextLine();
		System.out.println("enter amount to transfer");
		int ta;
		ta=Integer.parseInt(sc.nextLine());
		if(balence>ta){
			balence-=ta;
			System.out.println(ta+" transfered successfully to "+rn);
			transaction_hist+=ta+" transfered to "+rn+"\n";
		}
		else{
			System.out.println("Insufficientbalance");
		}
	}
	public void Balance(){
		System.out.println(balence);
	}
	public void transaction_history(){
		System.out.println(transaction_hist);
	}
}
