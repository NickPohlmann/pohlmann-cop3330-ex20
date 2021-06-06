/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String orderAmountString = myApp.readInput("What is the order amount? ");
        String state = myApp.readInput("What is the state? ");
        String county = myApp.getCounty(state);
        float orderAmount = myApp.convertToFloat(orderAmountString);
        float tax = myApp.calculateTax(state, county, orderAmount);
        float total = myApp.calcTotal(orderAmount, tax);
        float roundedTax = myApp.roundNum(tax);
        float roundedTotal = myApp.roundNum(total);
        String outputString = myApp.generateOutputString(roundedTotal, roundedTax, state);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private float roundNum(float num) {
        float roundedNum = (float) ((Math.floor(num * 100)) / 100);
        return roundedNum;
    }

    private String generateOutputString(float total, float tax, String state) {
        if (state.equalsIgnoreCase("Wisconsin") || state.equalsIgnoreCase("Illinois")) {
            return String.format("The tax is $%.2f.\nThe total is $%.2f.", tax, total);
        } else {
            return String.format("The total is $%.2f.", total);
        }
    }

    private float calcTotal(float orderAmount, float tax) {
        float total = orderAmount + tax;
        return total;
    }

    private float calculateTax(String state, String county, float orderAmount) {
        if(state.equalsIgnoreCase("Wisconsin")) {
            if(county.equalsIgnoreCase("Eau Claire")){
                float tax = (float) (orderAmount * .055);
                return tax;
            } else if (county.equalsIgnoreCase("Dane")) {
                float tax = (float) (orderAmount * .054);
                return tax;
            } else {
                float tax = (float) (orderAmount * .05);
                return tax;
            }
        } else if (state.equalsIgnoreCase("Illinois")) {
            float tax = (float) (orderAmount * .08);
            return tax;
        } else {
            float tax = orderAmount;
            return tax;
        }
    }

    private float convertToFloat(String orderAmountString) {
        float orderAmount = Float.parseFloat(orderAmountString);
        return orderAmount;
    }

    private String getCounty(String state) {

        if(state.equalsIgnoreCase("Wisconsin")) {
            System.out.print("What county do you live in? ");
            String county = in.nextLine();
            return county;
        }
        String county = "none";
        return county;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }
}