import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
 *           "Multistate Sales Tax Calculator" output
 * What is the order amount? 10
 * What state do you live in? Wisconsin
 * What county do you live in? Dane
 * The tax is $0.50.
 * The total is $10.50.
 */
public class App
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();
        double taxRate = 0;

        System.out.print("What is the order amount? ");
        double order = in.nextDouble();
        System.out.print("What state do you live in? ");
        String state = in.next();
        state = state.toLowerCase();

        if(state.equals("wisconsin"))
        {
            taxRate += 0.05;
            System.out.print("What county do you live in? ");
            String county = in.next();
            county = county.toLowerCase();
            if(county.equals("eau claire"))
                taxRate += 0.005;
            else if(county.equals("dunn"))
                taxRate += 0.004;
        }
        if(state.equals("illinois"))
            taxRate += 0.08;

        double tax = myApp.calculateTax(order, taxRate);

        String result = String.format("The total is $%.2f.\n", order + tax);

        if(taxRate != 0)
            result = String.format("The tax is $%.2f.\nThe total is $%.2f.\n", tax, order + tax);

        System.out.print(result);
    }

    private double calculateTax(double subtotal, double taxRate)
    {
        double result = taxRate * subtotal;
        double temp = result;

        temp *= 100;

        if(temp%1 > 0.00000000000001)//checks for fractions of a cent, 0.00000000000001 is present even when perfectly divided
        {
            result -= (temp%1)/100;
            result += 0.01;
        }

        return result;
    }
}