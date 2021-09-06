package ex20;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 justin gesek
 */
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

//Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
//For Eau Claire county residents, add an additional 0.005 tax.
//For Dunn county residents, add an additional 0.004 tax.
//Illinois residents must be charged 8% sales tax with no additional county-level charge.
//All other states are not charged tax.
//The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.
//
//Example Output
//What is the order amount? 10
//What state do you live in? Wisconsin
//What county do you live in? Dane
//The tax is $0.50.
//The total is $10.50.
public class ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        double amount = scanner.nextDouble();
        System.out.print("What is the state? ");
        String state = scanner.nextLine();
        while(state.equals(""))
        {
            state = scanner.nextLine();
        }
        System.out.println("The state is '"+state + "'");
        state = state.toUpperCase(Locale.ROOT).trim().substring(0,2);
        System.out.println("The state is '"+state + "'");
        if(state.equals("WI"))
        {
            System.out.print("What is the county? ");
            String county = scanner.nextLine();
            county = county.toUpperCase(Locale.ROOT).trim();
            double tax = 0.05;
            if(county.equals("EAU CLAIRE"))
            {
                tax += 0.005;
            }
            else if(county.equals("DUNN"))
            {
                tax += 0.004;

            }
            tax *= amount;
            System.out.printf("The tax is $%.2f.\n", tax);
            amount += tax;
        }
        else if (state.equals("IL"))
        {
            double tax = amount * 0.08;
            System.out.printf("The tax is $%.2f.\n", tax);
            amount += tax;
        }
        System.out.printf("The total is $%.2f.\n", amount);
    }
}
