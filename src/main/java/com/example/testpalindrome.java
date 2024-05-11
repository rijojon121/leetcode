package com.example;

import java.util.Scanner;

public class testpalindrome {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A string: ");
        String str =  sc.next();

        String org_String = str;

        String rev = "";
        int len = str.length();

        for(int i=len-1;i>=0;i--){
            rev = rev +str.charAt(i);
        }
        if(org_String.equals(rev)){
            System.out.println("This is a palindrome String");
        } else {
            System.out.println("This is not a Palindrome String");
        }
    }
}
