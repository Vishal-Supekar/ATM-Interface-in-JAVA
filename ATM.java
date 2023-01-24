import java.io.Console;
import java.util.*;
class bankaccount{
    static String user="";
    static char pass[];
    static  void register(){
        Scanner sc=new Scanner(System.in);  
        Console console = System.console(); 
        System.out.println("---------------------");
        System.out.print("Enter your name : ");
        ATM.name=sc.nextLine();
        System.out.print("Enter username : ");
        user=sc.nextLine();
        System.out.print("Enter password : ");
         pass=console.readPassword();
        ATM.accnumber=sc.nextLine();
        System.out.println();
        System.out.println("REGISTRATION SUCCESSFULLY DONE!");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid Value! Please! Enter again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,char pass[]){}
    static void displayacc(){
        System.out.println();
        System.out.println("My Account Details ");
        System.out.println();
        System.out.println("Name : " + ATM.name);
        System.out.println("Username : " + user);
        System.out.print("Password : ");
        for(int i=0;i<pass.length;i++)
         {
             System.out.print(pass[i]);
         }
         System.out.println();
         System.out.println("Balance is : "+ ATM.balance +" Rs ");
         System.out.println();
         ATM.prompt();
    }
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println();
        System.out.print("Enter amount to withdraw : ");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw Successful");
            System.out.println();
            System.out.println("Amount Rs "+wcash+"/-withdraw successfully");
            System.out.println();
            System.out.println("Remaining Balance is "+ ATM.balance +" Rs");
            System.out.println("---------------------");
        }
        else{
            System.out.println("Insufficient balance to withdraw the cash");
            System.out.println("---------------------");
        }
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println();
        System.out.print("Enter amount to deposit : ");
        int dcash=sc.nextInt();
        int nb=dcash+ATM.balance;
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        System.out.println();
        ATM.history.add("Deposited Successful");
        System.out.println("Amount Rs."+dcash+"/- deposited successfully!");
        System.out.println();
        System.out.println("New Balance is "+ nb +" Rs");
        System.out.println("---------------------");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the username of the receiving body: ");
        String s=sc.nextLine();
        System.out.println();
        System.out.print("Enter the account number of the receiving body: ");
        int num=sc.nextInt();
        System.out.println();
        System.out.print("Enter the amount to be transferred in Rs : ");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("Transferred Successful");
            System.out.println();
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
        }
        else{
            System.out.println("Insufficient balance to transfer the cash");
            System.out.println("---------------------");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println();
        System.out.print("The available balance in the bank account is in Rs : ");
        ATM.showbalance();
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
        System.out.println("---------------------");
        System.out.println();
            System.out.println("Transactions History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                System.out.print(i+1 +". ");
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                
               System.out.println();
            }
            }
            else {
                System.out.println("Your account is Empty!!! No Transactions History Found");
            }
            ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------");
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("---------------------");
        System.out.println("Select an Option :");
        System.out.println("1. To Register");
        System.out.println("2. To Exit");
        System.out.print("Enter Your choice : ");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("Invalid Value!!! Select a value only from the given options :");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println(" HELLO "+ATM.name+"! WELCOME TO ATM SYSTEM!");
        System.out.println("-----------------------------------------");
        System.out.println("Select an Option : ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transaction History");
        System.out.println("4. Transfer");
        System.out.println("5. Check balance");
        System.out.println("6. My Account Details");
        System.out.println("7. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.deposit();
            case 2:
                transaction.withdraw();
            case 3:
                his.transactionhistory();
            case 4:
                transaction.transfer();
            case 5:
                check.checkbalance();
            case 6:
               bankaccount.displayacc();
            case 7:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}