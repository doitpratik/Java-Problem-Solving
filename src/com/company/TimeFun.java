package com.company;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TimeFun {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);
        System.out.println("Today date: "+date);
        System.out.println("Yesterday date: "+yesterday);
        System.out.println("Tomorrow date: "+tomorrow);

        LocalDate d1 = LocalDate.parse("2020-05-06", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse("2020-05-30", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate d3 = LocalDate.parse("2021-03-24", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d4 = LocalDate.parse("2020-01-23", DateTimeFormatter.ISO_LOCAL_DATE);

        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        Period period = Period.between(d3, d4);

        long diffDays = diff.toDays();
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        System.out.println("Diffrence between dates is : "+diffDays + "days");
        System.out.println("Diffrence is : "+years+" year, "+months+" months, "+days+" days");
    }
}
