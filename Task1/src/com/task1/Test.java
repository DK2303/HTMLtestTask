package com.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
	static int tag = 0;
	static String subString1="";
	static String subString2="";
	static boolean flag= false;

	public static void main(String[] args) throws IOException {

		String givenString = new String(
				Files.readAllBytes(Paths.get("C:\\Users\\Dinesh.A\\workspace\\Task1\\Txt file\\htmlFile.txt")));
		givenString = givenString.replaceAll("\\t", "");
		givenString = givenString.replaceAll("\\r", "");
		givenString = givenString.replaceAll("\\n", "");

		System.out.println("Given String:");
		System.out.println(givenString);

		System.out.println("\nOutput for append:");
		System.out.println(after(givenString, "15", "<img id=\"appendSample2\" />"));
		System.out.println(tag);
		 
	}
	
	private static String appendCheck(int no,String stringtoAdd) {
		String outPutString="";
		if(tag==0) { 
			String s1=subString2.substring(0, no);
			String s2=subString2.substring(no, subString2.length());
			outPutString=subString1+s1+stringtoAdd+s2;
			flag = true;
			
		}
		return outPutString;
	
	}

	public static String after(String givenString, String id, String stringToAdd) {

		String outputString = ""; 
		int i=0;
		int indexValue=givenString.indexOf(id);
	
			for(int j=indexValue;j<=givenString.length();j--) {
				/*if(id=="7" || id=="8" || id=="9") {
					System.out.println("this ID's are not applicable for append");
					break;
				}*/
				if(givenString.charAt(j)=='<') {
					subString2=givenString.substring(j,givenString.length());
					subString1=givenString.substring(0,j);
					break;
				}
			}
			
				
			while(i<=subString2.length()-1) {
				
			if( subString2.charAt(i)=='<' && subString2.charAt(i+1)>='a' && subString2.charAt(i+1)<='z') {
				tag++;
				/*outputString=appendCheck(i,stringToAdd);
				if(flag==true) {
					break;
				}*/
				
			} 
			
			else if(subString2.charAt(i)>='a' && subString2.charAt(i)<='z' && subString2.charAt(i+1)=='>'){
				tag--; 
				outputString=appendCheck(i+2,stringToAdd);
				if(flag==true) {
					break;
				}
			} 
			else if(subString2.charAt(i)=='/' && subString2.charAt(i+1)=='>'){
				tag--; 
				outputString=appendCheck(i+2,stringToAdd);
				if(flag==true) {
					break;
				}
			} 
			i++;
			}

		return outputString;

	}
}
