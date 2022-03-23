package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.xml.namespace.QName;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

class Accounting {
    abstract class Account{
        String name;
        int number;
        int balance;
        Date startDate;

        public static double calculateInterest(int amount, int  years, double roi){
            double si = amount * years * roi;
            return si;
        }

        public Account(String name, int number, int balance, Date startDate) {
            this.name = name;
            this.number = number;
            this.balance = balance;
            this.startDate = startDate;
        }
    }

    class CurrentAccount extends Account{
        int amount;
        Date endDate;
        final static double ROI = 0.05;
        public CurrentAccount(String name, int accountNumber, int amount, Date startDate, Date endDate){
            super(name, accountNumber, amount, startDate);
            this.endDate = endDate;
        }
//        public double calculateInterest(int amount, int years, double roi){
//            return super.calculateInterest(amount, years, roi);
//        }
    }

    class SavingsAccount extends Account{
        int amount;
        Date endDate;
        final static double ROI = 0.12;
        public SavingsAccount(String name, int accountNumber, int amount, Date startDate, Date endDate){
            super(name, accountNumber, amount,startDate);

            this.endDate = endDate;
        }

        /*public double calculateInterest(int amount, int years, double roi){
            return super.calculateInterest(amount, years, roi);
        }*/
    }



}
class print{
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if(a == 1){
            String name = sc.next();
            int accountNumber = sc.nextInt();
            int amount = sc.nextInt();
            String sDate=sc.next();
            Date startDate= new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            String  eDate = sc.next();
            Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);
            Accounting.SavingsAccount savingsAccount = new Accounting(). new SavingsAccount(name, accountNumber, amount, startDate, endDate);
            LocalDate sDates = convertToLocalDateTimeViaInstant(startDate);
            LocalDate eDates = convertToLocalDateTimeViaInstant(endDate);
            Period period = Period.between(sDates, eDates);
            int years = period.getYears();
            System.out.println(savingsAccount.calculateInterest(amount, years, 0.05));
        }



    }
    public static LocalDate convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
