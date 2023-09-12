package com.blacol.util;

public class NumberUtil {
    private static double sum;
    public static double last(){
        return sum;
    }
    public static double add(double ...doubles){
        sum = 0;
        for (double number : doubles) {
            sum+=number;
        }
        return sum;
    }
    public static double subtract(double ...numbers){
        sum=numbers[0];
        for (int i=1;i<numbers.length;i++){
            sum-=numbers[i];
        }
        return sum;
    }
    public static double multiply(double ...numbers){
        sum=1;
        for (double number:numbers){
            sum*=number;
        }
        return sum;
    }
    public static double divide(double ...numbers){
        sum=numbers[0];
        for (int i=1;i<numbers.length;i++){
            if (numbers[i]!=0){
                sum/=numbers[i];
            }else{
                System.out.println("除数不能为0");
                return 0d;
            }
        }
        return sum;
    }
}
