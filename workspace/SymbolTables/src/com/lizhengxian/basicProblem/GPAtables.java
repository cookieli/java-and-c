package com.lizhengxian.basicProblem;

public class GPAtables {
	  private Node first;
      private class Node{
    	  String rank;
    	  Double score;
    	  Node next;
    	  public Node(){}
    	  public Node(String rank,Double score,Node next){
    		  this.rank = rank;
    		  this.score = score;
    		  this.next = next;
    	  }
      }
      public Double get(String rank){
    	  for(Node x =first;x!=null;x = x.next){
    		  if(rank.equals(x.rank)){
    			  return x.score;//ÃüÖÐ
    		  }
    	  }
    	  return null;//Î´ÃüÖÐ
      }
      public void put(String rank){
    	  for(Node x = first;x!=null;x =x.next){
    		  if(x.equals(rank)){ return;}
    	  }
    	  if(rank.equals("A+")){
    		 first = new Node("A+",4.33,first); 
    	  }
    	  else if(rank.equals("A")){
     		 first = new Node("A",4.00,first); 
     	  }
    	  else if(rank.equals("A-")){
      		 first = new Node("A-",3.67,first); 
      	  }
    	  else if(rank.equals("B+")){
       		 first = new Node("B+",3.33,first); 
       	  }
    	  
      }
      public static void main(String[] args){
    	  
      }
      
}
