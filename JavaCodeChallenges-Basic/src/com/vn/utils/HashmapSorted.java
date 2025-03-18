package com.vn.utils;

import java.util.HashMap;
import java.util.TreeMap;

public class HashmapSorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(0, "def");
		hm.put(3, "ghi");
		System.out.println(hm);
        hm.put(1, "abc");
        hm.put(2, "def");
        hm.put(22, "def");
        System.out.println(hm);
        System.out.println(hm);
        System.out.println(hm);
        System.out.println(hm);
        System.out.println(hm);
        TreeMap<Integer,String> sortedMapp = new TreeMap<>(hm);
        System.out.println("sortedMapp:"+sortedMapp);
        
	}

}
