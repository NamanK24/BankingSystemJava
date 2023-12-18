import java.util.Scanner;
class Bank
{
    private static int AccNo_gen=202300;
    private int AccNo;
    private String name,gender;
    private double amount;
    void openAccount(String name,String gender, double amount)
    {
        this.name=name;
        this.gender=gender;
        this.amount=amount;
        this.AccNo=Bank.AccNo_gen;
        Bank.AccNo_gen++;
    }
    void displayUser()
    {
        System.out.println("Account Number:"+AccNo+"\tName:"+name+"\tGender:"+gender+"\tBalance:"+amount+"\n-----------------------");
    }
    int get_AccNo()
    {
        return (this.AccNo);
    }
    double get_balance(){
        return (this.amount);
    }
    void update_balance(double money)
    {
        this.amount=money;
        System.out.println("transaction Successful!!\n-----------------------");
    }
}
public class BankingSystem {

    static int searchUserAccount(Bank ulist[], int count, int AccNo) {
        for (int i = 0; i < count; i++) {
            if (ulist[i].get_AccNo() == AccNo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ch, count = 0;
        Scanner in = new Scanner(System.in);
        Bank ulist[] = new Bank[100];
        int index;

        do {
            System.out.println("Welcome to the Bank!!");
            System.out.println("1.Open Bank Account" +
                    "\n2.Check Balance" +
                    "\n3.Withdraw Amount" +
                    "\n4.Deposit Amount\n0.Exit\n");
            ch = in.nextInt();

            switch (ch) {
                case 1: //open bank acc with 3000 min balance;
                    String t = in.nextLine();
                    System.out.println("Enter name:");
                    String n = in.nextLine();
                    System.out.println("Enter gender:");
                    String g = in.nextLine();
                    System.out.println("Deposit minimum amount of 3000: ");
                    int a = in.nextInt();
                    if(a >= 3000) {
                        ulist[count] = new Bank();
                        ulist[count].openAccount(n, g, a);
                        ulist[count].displayUser();
                        count++;
                        break;
                    } else {
                        System.out.println("Amount is less than minimum required!!\n-------------------");
                        break;
                    }

                case 2: // checking balance of user;
                    System.out.println("Enter Account Number: ");
                    int an = in.nextInt();
                    index = searchUserAccount(ulist,count,an);
                    if (index == -1) {
                        System.out.println("Account not registered!\n-------------------------------");
                    } else {
                        ulist[index].displayUser();
                    }
                    break;

                case 3: //withdraw amount;
                    System.out.println("Enter the account number: ");
                    an = in.nextInt();
                    index = searchUserAccount(ulist, count, an);
                    if (index == -1) {
                        System.out.println("Account not registered!\n-------------------------------");
                    } else {
                        ulist[index].displayUser();
                        System.out.println("Enter the amount to withdraw: ");
                        int amount = in.nextInt();
                        double difference = ulist[index].get_balance() - amount;
                        if (difference >= 2000) {
                            double money = ulist[index].get_balance() - amount;
                            ulist[index].update_balance(money);
                            break;
                        } else {
                            System.out.println("Transaction Failed!!\n--------------------------");
                        }
                    }
                    break;

                case 4://deposit amount;
                    System.out.println("Enter the account number: ");
                    an = in.nextInt();
                    index = searchUserAccount(ulist, count, an);
                    if (index == -1) {
                        System.out.println("Account not registered!\n-------------------------------");
                    } else {
                        ulist[index].displayUser();
                        System.out.println("Enter the amount you want to deposit");
                        int amount = in.nextInt();
                        if (amount <= 0) {
                            System.out.println("Invalid Amount\n---------------------------");
                        } else{
                            double new_balance = amount + ulist[index].get_balance();
                            ulist[index].update_balance(new_balance);
                            System.out.println(amount + " deposited successfully\n----------------------------");
                            ulist[index].displayUser();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Data available "+count);
                    for(int i=0;i<count;i++) {
                        ulist[i].displayUser();
                    }
                    break;

                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;

            }
        }while (ch!=0);
    }
}


