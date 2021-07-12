package com.task1;

public class PrintHexogan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="abcd";
		int n=6;
		int startPos=2;
		StringBuilder sb=new StringBuilder(s);
		
		
		 for (int i=1;i<=s.length()-1;i++){
	           if(i%2 ==0){
	               System.out.print(s.charAt(n-s.length()-1));
	           }
	               else
	                   System.out.print("--");
	           }
	        System.out.println();
	        
	        for(int j=s.length()-2;j>=0;j--){
	        	if(j%2 !=0){
	            System.out.print("--");
	            }
	            else{
	            System.out.print(s.charAt(j));
	            }
	        
	        }
	        System.out.println();
	        
	        for (int k=1;k<=s.length();k++){
	            
	            if(k==2){
	            System.out.print(s.charAt(s.length()-1));
	            }
	                             
	            else if(k==1){
	            System.out.print("");
	            }
	            else if(k==4) {
	            	System.out.print("*");
	            }
	        	else
	                System.out.print("--");
	        }
	        
	        System.out.println();     
	        
	        for (int i=1;i<=s.length()-1;i++){
		           if(i%2 ==0){
		               System.out.print("*");
		           }
		               else
		                   System.out.print("--");
		           }

	}
	

}
