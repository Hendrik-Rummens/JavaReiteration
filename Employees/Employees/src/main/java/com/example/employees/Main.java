package com.example.employees;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone1, Fred, 1/1/1900, Programmer, {locpd=2001,yoe=11,iq=141}
                Flinstone2, Fred, 1/1/1900, Programmer, {locpd=2002,yoe=12,iq=142}
                Flinstone3, Fred, 1/1/1900, Programmer, {locpd=2003,yoe=13,iq=143}
                Flinstone4, Fred, 1/1/1900, Programmer, {locpd=2004,yoe=14,iq=144}

                Rubble, Barney, 2/2/1905, Manager {orgSize=200,dr=1}
                Rubble, Barney1, 2/2/1905, Manager {orgSize=201,dr=2}
                Rubble, Barney2, 2/2/1905, Manager {orgSize=202,dr=3}
                Rubble, Barney3, 2/2/1905, Manager {orgSize=203,dr=4}
                Rubble, Barney4, 2/2/1905, Manager {orgSize=204,dr=5}

                Flinstone, Wilma, 3/3/1910, Analyst {projectCount=1}
                Flinstone, Wilma1, 3/3/1910, Analyst {projectCount=2}
                Flinstone, Wilma2, 3/3/1910, Analyst {projectCount=3}
                Flinstone, Wilma3, 3/3/1910, Analyst {projectCount=4}
                Flinstone, Wilma4, 3/3/1910, Analyst {projectCount=5}

                Rubble, Betty, 4/4/1915, CEO {avgStockPrice=300}
                """;

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}), \\s*(?<role>\\w+)\\n";
        Pattern pat = Pattern.compile(peopleRegex);
        Matcher peopleMat = pat.matcher(peopleText);

        String programmerRegex = "\\w+=(?<locpd>\\w),\\w+=(?<yoe>\\w),\\w+=(?<iq>\\w),";
        Pattern coderPat = Pattern.compile(programmerRegex);

        int totalSalarie = 0;
        while (peopleMat.find()) {
            totalSalarie += switch (peopleMat.group("role")){
                case "Programmer" -> {
                    Matcher coderMat = coderPat.matcher(peopleMat.group("details"));
                    yield 3000;
                }
                case "Manager" -> {
                    yield 3500;
                }
                case "Analyst" -> {
                    yield 2500;
                }
                case "CEO" -> {
                    yield 5000;
                }
                default -> 0;
            };
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s", currencyInstance.format(totalSalarie));

    }
}
