package com.lizhengxian.riseproblem;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

public class DoubleEndedPriorityQueue<Key extends Comparable<Key>> {
	 private MaxPQ<Element> max;
	 private MinPQ<Element> min;
	 
	 public DoubleEndedPriorityQueue(){
		 max = new MaxPQ<Element>();
		 min = new MinPQ<Element>();
	 }
	 public void insert(Key item){
		 Element thisElement = new Element(item);
		 Element thatElement = new Element(item);
		 thisElement.element = thatElement;
		 thatElement.element = thisElement;
		 max.insert(thisElement);
		 min.insert(thatElement);
	 }
	
     private class Element implements Comparable<Element>
    {
    	 Key item;
    	 Element element;
    	 private Element(){}
    	 private Element(Key item){
    		 this(item,null);
    	 }
    	 private Element(Key item,Element element){
    		 this.item = item;
    		 this.element = element;
    	 }
		@Override
		public int compareTo(Element e) {
			// TODO Auto-generated method stub
			return this.item.compareTo(e.item);
		}
     }
     
}
