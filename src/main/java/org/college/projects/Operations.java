package org.college.projects;

public class Operations {
    public static Double addition(Double number1, Double number2){
        return number1 + number2;
    }
    public static double subtraction(Double number1, Double number2) {
        return number1 - number2;
    }
    public static double division(Double number1, Double number2){
        Double result = 0.0;
        try {
            result = number1 / number2;
        }
        catch (Exception exception){
        }
        return result;
    }
    public static Double modulus(Double number1, Double number2){
        Double result = 0.0;
        try {
            result = number1 % number2;
        }
        catch (Exception exception){
        }
        return result;
    }
    public static double multiplication(Double number1, Double number2){
        return number1 * number2;
    }
    public static Double power(Double number, Double power) {
        Double result = 0.0;
            result = Math.pow(number, power);
        return result;
    }
    public static int factorial(int number){
        if(number == 0.0)
            return 1;
        return number * factorial(number - 1);
    }
}
