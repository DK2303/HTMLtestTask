package com.task1;

import java.util.Scanner;

public class ReverceString {
	    public static void main(String[] args) {
	        String str = "Saket Saurav";
	        char chars[] = str.toCharArray();  // converted to character array and printed in reverse order
	        for(int i= chars.length-1; i>=0; i--) {
	            System.out.print(chars[i]);
	            
	           }
	        int x, y;
            System.out.println("\nEnter x and y");
            Scanner in = new Scanner(System.in);
        
            x = in.nextInt();
            y = in.nextInt();
        
            System.out.println("Before Swapping\nx = "+x+"\ny = "+y);
        
            x = x + y;
            y = x - y;
            x = x - y;
        
            System.out.println("After Swapping without third variable\nx = "+x+"\ny = "+y);
       
	    }
	}

