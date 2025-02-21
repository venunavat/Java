package com.vn.utils;

public class ReverseString {

	public static void main(String[] args) {
		
		String orig = "satyam";
		String reversed = new ReverseString().RevStr(orig);
        System.out.println(""+reversed);
	}
	
	public String RevStr (String str) {
		
		if(str == null || str.length() <=1) 
			return str;
		
		return RevStr(str.substring(1)) + str.charAt(0);
		
	}

}
