package com.me;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
    public static double evaluate(String polynomial, double x) {
        double result = 0.0;
        
        // Split polynomial into individual terms
        String[] terms = polynomial.split("\\s*\\+\\s*");
        
        // Loop through each term
        for (String term : terms) {
            double coefficient = 0.0;
            int exponent = 0;
            
            // Use regex to extract coefficient and exponent
            Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d*)?x(?:\\^(\\d+))?");
            Matcher matcher = pattern.matcher(term);
            
            if (matcher.find()) {
                String coeffStr = matcher.group(1);
                String expStr = matcher.group(2);
                
                if (coeffStr != null && !coeffStr.isEmpty())
                    coefficient = Double.parseDouble(coeffStr);
                else
                    coefficient = 1.0; // If coefficient is not specified, assume it's 1
                
                if (expStr != null && !expStr.isEmpty())
                    exponent = Integer.parseInt(expStr);
            }
            
            // Evaluate the term and add it to the result
            result += coefficient * Math.pow(x, exponent);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the polynomial: ");
        String polynomial = scanner.nextLine();
        
        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();
        
        double result = evaluate(polynomial, x);
        System.out.println("Result for x = " + x + " is: " + result);
        
        scanner.close();
    }
}
