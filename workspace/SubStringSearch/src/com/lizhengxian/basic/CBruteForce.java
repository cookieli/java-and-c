package com.lizhengxian.basic;

public class CBruteForce {
      public static int search(char[] pat,char[] txt){
    	  int  M = pat.length;
    	  int  N = txt.length;
    	  for(int i = 0 ; i < N - M ;i++){
    		  int j ;
    		  for(j = 0 ; j < M ; j++)
    			  if(txt[i+j] != pat[j]) break;
    		      if(j== M)          return i ;
    	  }
    	  return N;
      }
      public static void main(String[] args){
    	  String Stxt = "AABRAACADABRAACAADABRA";
    	  String Spat = "AACAA";
    	  char[] txt = new char[Stxt.length()];
    	  char[] pat = new char[Spat.length()];
    	  for(int i =0 ; i < txt.length ; i++)
    		  txt[i] = Stxt.charAt(i);
    	  for(int i =0 ; i < pat.length ; i++)
    		  pat[i] = Spat.charAt(i);
    	  System.out.println(search(pat,txt));
      }
}
