package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public static boolean isAnagram(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        int[] letterCount = new int[26];
        for (int i = 0; i < s.length(); i++){
            letterCount[s.charAt(i)-'a']++;
            letterCount[t.charAt(i)-'a']--;
        }
        for (int i : letterCount ){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
