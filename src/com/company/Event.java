package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

class Event{
    String name;
    String detail, type, ownerName;
    Double costPerDay;
    Event(Double costPerDay){
        this.costPerDay = costPerDay;
    }
}
class Exhibition extends Event{
    Integer noOfStall;
    final double interest = 0.05;
    Exhibition(Double costPerDay){
        super(costPerDay);

    }
    public double calculateGST(int days){
        return costPerDay*days*interest;
    }
}
class StageEvent extends Event{
    Integer noOfSeats;
    final double interest = 0.15;
    StageEvent(Double costPerDay){
        super(costPerDay);

    }
    public double calculateGST(int days){
        return costPerDay*days*interest;
    }
}
class MainSolve{
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        String name = sc.next();
        //System.out.println(name);
        String deatil = sc.next();
        //System.out.println(deatil);
        String stype = sc.next();
        //System.out.println(stype);
        String ownerName = sc.next();
        //System.out.println(ownerName);
        String costPerDay = sc.nextLine();
        Integer noOfSeats = sc.nextInt();
        String sDate=sc.next();
        Date startDate= new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        String  eDate = sc.next();
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);

        LocalDate sDates = convertToLocalDateTimeViaInstant(startDate);
        LocalDate eDates = convertToLocalDateTimeViaInstant(endDate);
        Period period = Period.between(sDates, eDates);
        int days = period.getDays();
        double xyz = Double.parseDouble(costPerDay);
        int type1 = Integer.parseInt(type);
        if(type1 == 1){

            Exhibition exh = new Exhibition(xyz);
            System.out.println(exh.calculateGST(days));
        }else{
            StageEvent stg = new StageEvent(xyz);
            System.out.println(stg.calculateGST(days));
        }

    }
    public static LocalDate convertToLocalDateTimeViaInstant(Date dateToConvert){
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}