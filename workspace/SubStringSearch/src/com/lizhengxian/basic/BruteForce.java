package com.lizhengxian.basic;

public class BruteForce {
     public static int search(String pat, String txt){
    	 int M = pat.length();
    	 int N = txt.length();
    	 for(int i = 0 ; i< N-M ; i++){
    		 int  j;
    		 for( j = 0 ; j < M ;j++)
    			if(txt.charAt(i + j)!=pat.charAt(j)) break;
    		 if(j == M) return i;
     }
    	 return N ;
   }
     public static int Esearch(String pat,String txt){
    	 int i, M = pat.length();
    	 int j,N = txt.length();
    	 for( i = 0 , j = 0 ; i < N&& j < M ;i++){
    		 if(txt.charAt(i) == pat.charAt(j)) j++;
    		 else                             {i-=j;}
    	 }
    	 if(j == M)  return i - M;
    	 else        return N;
     }
     public static void main(String[]args){
    	 String pat = "AACAA";
    	 String txt = "AABRAACADABRAACAADABRA";
    	 System.out.println("txet:   "+txt);
    	 int offset = search(pat,txt);
    	 System.out.print("pattern:");
    	 for(int i = 0 ; i < offset ; i++){
    		 System.out.print(" ");
    	 }
    	 System.out.println(pat);
     }
}
