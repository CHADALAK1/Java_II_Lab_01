/**
 * Created by CHADALAK1 on 8/25/15.
 */

import java.util.*;

public class Account
{
    private int id;
    private double balance;
    private double annualinterestRate;
    private Date dateCreated = new Date();
    private Calendar cali = Calendar.getInstance();

    public Account(int ID, float Balance, int year, int month, int day)
    {
        id = ID;
        balance = Balance;
        annualinterestRate = 0.045;
        cali.set(year,month,day);
        long milli = cali.getTimeInMillis();
        dateCreated.setTime(milli);
    }

    public int getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public double getAnnualinterestRate()
    {
        return annualinterestRate;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void withdrawlAccount(double Amount)
    {
        if(Amount > 0.f && Amount <= balance)
        {
            System.out.println("Current Balance: $" + balance);
            balance -= Amount;
            System.out.println("Withdrawled $" + Amount);
            System.out.println("New Balance: $" + balance);
        }
        else
        {
            System.out.println("Insufficient Funds");
        }
    }

    public void depositAccount(double Amount)
    {
        if(Amount > 0.f)
        {
            System.out.println("Current Balance: $" + balance);
            balance += Amount;
            System.out.println("Deposited $" + Amount);
            System.out.println("New Balance: $" + balance);
        }
        else
        {
            System.out.println("Invalid Amount to Deposit");
        }
    }
}
