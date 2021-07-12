package com.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task1 {

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
		System.out.println(append(givenString, "6", "<img id=\"appendSample2\" />"));

		System.out.println("\nOutput for prepend:");
		System.out.println(prepend(givenString, "10", "<br id=\"prependSample2\" />"));

		System.out.println("\nOutput for after:");
		System.out.println(after(givenString, "7", "<div id=\"afterSample2\"></div>"));

		System.out.println("\nOutput for before:");
		System.out.println(before(givenString, "5", "<span id=\"beforeSample2\"></span>"));


	}

	private static String appendCheck(int no,String stringtoAdd) {
		String outPutString="";
		if(tag==0) { 
			String s1=subString2.substring(0, no);
			String s2=subString2.substring(no, subString2.length());
			outPutString=subString1+s1+stringtoAdd+s2;
			flag = true;

		}
		/*if(tag==1) { 
			String s1=subString2.substring(0, no);
			String s2=subString2.substring(no, subString2.length());
			outPutString=subString1+s1+stringtoAdd+s2;
			flag = true;

		}*/
		else {
			outPutString=subString1+stringtoAdd+subString2;
		}
		return outPutString;

	}

	public static String append(String givenString, String id, String stringToAdd) {

		String outputString = ""; 
		int i=0;
		int indexValue=givenString.indexOf(id);

		for(int j=indexValue;j<=givenString.length();j--) {
			if(id=="7" || id=="8" || id=="9") {
				System.out.println("this ID's are not applicable for append");
				break;
			}
			else if(givenString.charAt(j)=='<') {
				subString2=givenString.substring(j,givenString.length());
				subString1=givenString.substring(0,j);
				break;
			}
		}


		while(i<=subString2.length()-1) {

			if( subString2.charAt(i)=='<' && subString2.charAt(i+1)>='a' && subString2.charAt(i+1)<='z') {
				tag++;
				outputString=appendCheck(i,stringToAdd);
				if(flag==true) {
					break;
				}

			} 

			else if(subString2.charAt(i)=='<' && subString2.charAt(i+1)=='/'){
				tag--; 
				outputString=appendCheck(i,stringToAdd);
				if(flag==true) {
					break;
				}
			} 
			else if(subString2.charAt(i)=='/' && subString2.charAt(i+1)=='>'){
				tag--; 
				outputString=appendCheck(i,stringToAdd);
				if(flag==true) {
					break;
				}
			} 
			i++;
		}		
		return outputString;

	}

	public static String prepend(String givenString, String id, String stringToAdd) {

		String outputString = "";
		int indexValue=givenString.indexOf(id);
		
		for(int j=indexValue;j<=givenString.length();j++) {
			if(id=="7" || id=="8" || id=="9") {
				System.out.println("this ID's are not applicable for Prepend");
				break;
			}
			else if(givenString.charAt(j)=='>') {
				subString2=givenString.substring(j+1,givenString.length());
				subString1=givenString.substring(0,j+1);
				tag=1;
				outputString=appendCheck(j,stringToAdd);
				if(flag==true) {
					tag=0;
					break;
				}
			}
		}
		
		
		return outputString;
	}

	public static String after(String givenString, String id, String stringToAdd) {

		String outputString = "";
		int i=0;
		int indexValue=givenString.indexOf(id);

		for(int j=indexValue;j<=givenString.length();j--) {
			if(givenString.charAt(j)=='<') {
				subString2=givenString.substring(j,givenString.length());
				subString1=givenString.substring(0,j);
				break;
			}
		}


		while(i<=subString2.length()-1) {

			if( subString2.charAt(i)=='<' && subString2.charAt(i+1)>='a' && subString2.charAt(i+1)<='z') {
				tag++;
			} 

			else if(subString2.charAt(i)>='a' && subString2.charAt(i)<='z' && subString2.charAt(i+1)=='>' ){
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

public static String before(String givenString, String id, String stringToAdd) {

		String outputString = "";
		
		int i=0;
		int indexValue=givenString.indexOf(id);

		for(int j=indexValue;j<=givenString.length();j--) {
			if(givenString.charAt(j)=='<') {
				subString2=givenString.substring(j,givenString.length());
				subString1=givenString.substring(0,j);
				tag=1;
				outputString=appendCheck(i,stringToAdd);
				if(flag==true) {
					break;
				}
			}
		}		
		return outputString;
	}
}
