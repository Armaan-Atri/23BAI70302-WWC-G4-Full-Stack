public class Main
{   int balance;
    String name;
    Main(int balance,String name){
        this.balance = balance;
        this.name = name;
        System.out.println("New User Created:" + this.name +" "+ this.balance);
        
    }
    
    void deposit(int amount){
        balance += amount;
        System.out.println("Amount deposited : " + balance);
    }
    void withdraw(int amount){
        if (amount > balance){
            System.out.println("Error amount exceeds the balance");
        } else {
            balance -= amount;
            System.out.println("Amount deducted: " + amount);
            System.out.println("Current Balance is " + balance);
        }
    }
	public static void main(String[] args) {
	    Main Armaan = new Main(5000,"Armaan");
	    Armaan.withdraw(1000);
	    Armaan.deposit(1);
	    Armaan.withdraw(5000);


      return 0;
	
		
		
	}
}
