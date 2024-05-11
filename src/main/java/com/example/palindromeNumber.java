package com.example;

import java.util.Scanner;

public class palindromeNumber {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Rational number: ");
        int num = sc.nextInt();

        int org_num = num;
        int rev=0;

        while(num>0){
            rev= rev*10 + num%10;
            num = num/10;
        }
        System.out.println("Reverse of the given number is : "+ rev);

        if(org_num==rev){
            System.out.println("This is a palindrome number  : " + rev);
        } else{
            System.out.println("This is not a palindrome number  : " + rev);

        }
        

    }
}
