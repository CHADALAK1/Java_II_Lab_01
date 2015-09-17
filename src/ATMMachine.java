/**
 * Created by CHADALAK1 on 8/25/15.
 */

import java.util.Scanner;

public class ATMMachine
{
    /* Make 10 accounts in the ATM Machine System Memory */
    private Account account1 = new Account(0000,100,1999,10,25);
    private Account account2 = new Account(1111,100,2005,1,10);
    private Account account3 = new Account(2222,100,2009,10,28);
    private Account account4 = new Account(3333,100,1982,11,30);
    private Account account5 = new Account(4444,100,2010,6,29);
    private Account account6 = new Account(5555,100,2013,4,1);
    private Account account7 = new Account(6666,100,2000,2,18);
    private Account account8 = new Account(7777,100,1990,12,12);
    private Account account9 = new Account(8888,100,1988,7,7);
    private Account account10 = new Account(9999,100,1995,9,9);

    /* Store accounts in an array */
    public Account[] accArray = {account1,account2,account3,
            account4,account5,account6,account7,account8,
            account9,account10};

    //Checks to see if the account was found on User input
    private boolean bFoundAccount = false;

    //Sets the slot of the array for which account was found
    private int currAccount = 0;

    /*Starts up program and calls
    accountInput function to get an array slot number depending
    on the account ID
     */
    public void bootATM()
    {
        int currAccount = accountInput();
        if(currAccount >=0)
        {
            menuInterface();
        }
    }

    /*Checks to see which account number exists. uses recursion to redo search if failed*/
    public void getAccount(int ID)
    {
        for(int i = 0; i <10; i++)
        {
            if(accArray[i].getId() == ID)
            {
                bFoundAccount = true;
                currAccount = i;
            }
        }
        if(bFoundAccount)
        {
            System.out.println("Account " + accArray[currAccount].getId() + " Opened");
        }
        else
        {
            System.out.println("Incorrect Account Number");
            accountInput();
        }
    }

    /* Retrieves Account number and returns the Array slot of the account retrieved*/
    public int accountInput()
    {
        while(!bFoundAccount)
        {
            System.out.println("Welcome To Slenderman ATM");
            System.out.println("Please Enter your FOUR digit Account Number");
            Scanner keyboard = new Scanner(System.in);
            int AccountListener = keyboard.nextInt();
            getAccount(AccountListener);
        }
        return currAccount;
    }

    /*Does the ATM interface of Withdrawl, Deposit, or exit*/
    public void menuInterface()
    {
        System.out.println("Current Balance: $" + accArray[currAccount].getBalance());
        System.out.println("Date Created " + accArray[currAccount].getDateCreated().toString());
        System.out.println("Annual Interest Rate: " + accArray[currAccount].getAnnualinterestRate() * 100 + "%");
        System.out.println("What would you like to do?");
        System.out.println("Press 1 to withdrawl, Press 2 to Deposit, Press 3 to exit");
        Scanner keyboard = new Scanner(System.in);
        int decision = keyboard.nextInt();
        if(decision == 1)
        {
            System.out.println("How Much would you like to Withdraw?");
            Scanner keyboard1 = new Scanner(System.in);
            double Amount = keyboard1.nextDouble();
            if(Amount <= accArray[currAccount].getBalance() && accArray[currAccount].getBalance() > 0.f)
            {
                accArray[currAccount].withdrawlAccount(Amount);
            }
            else
            {
                System.out.println("Insufficient Funds");
                menuInterface();
            }

        }
        if(decision == 2)
        {
            System.out.println("How Much would you like to Deposit?");
            Scanner keyboard2 = new Scanner(System.in);
            double Amount = keyboard2.nextDouble();
            if(Amount > 0)
            {
                accArray[currAccount].depositAccount(Amount);
            }
            else
            {
                System.out.println("Incorrect Amount");
                menuInterface();
            }
        }
        if(decision == 3)
        {
            System.out.println("Goodbye!");
            System.out.println("");
            bFoundAccount = false;
            currAccount = 0;
            bootATM();
        }
        else
        {
            System.out.println("Incorrect Key");
            menuInterface();
        }
    }
}