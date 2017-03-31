package com.lizhengxian.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
     private ST<String ,Integer> st;
     private String[] keys;
     private graph G;
     public SymbolGraph(String stream, String sp){
    	 In in = new In(stream);
    	 while(in.hasNextLine()){
    		 String[] a = in.readLine().split(sp);
    		 for(int i = 0 ;i <a.length;i++){
    			 st.put(a[i], i);
    		 }
    	 }
    	 keys = new String[st.size()];
    	 for(String name:st.keys()){
    		 keys[st.get(name)] = name;
    	 }
    	G = new graph(keys.length);
    	 in = new In(stream);
    	 while(in.hasNextLine()){
    		 String[] a = in.readLine().split(sp);
    		 int v = st.get(a[0]);
    		 for(int i = 0 ; i <keys.length ; i++){
    			 G.addEdge(v, st.get(a[i]));
    		 }
    	 }
     }
     public boolean contains(String s){return st.contains(s);}
     public int index(String s)       {return st.get(s);}
     public String name(int v)        { return keys[v];}
     public static  void main(String[] args){
    	 SymbolGraph f = new SymbolGraph("routes.txt"," ");
     }
}
