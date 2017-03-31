package com.lizhengxian.creativeproblem;

import java.util.Arrays;
class Item<Key>{
	 Key key;
	 int keyIndex;
	 Item(){}
	 Item(Key key,int keyIndex){
		 this.key = key;
		 this.keyIndex = keyIndex;
	 }
}
public class ForceStability<Key extends Comparable<Key>> {
     Item<Key>[] item ;
     int[] a;
     public ForceStability(){}
     public ForceStability(Key[] key){
    	// item = new Item[key.length];
    	 int index = 0;
    	 for(int i =0;i<key.length;i++){
    		 item[i] = new Item(key[i],index++);
    	 }
     }
     public void forcestability(Integer[] key){
    	 //item = new Item[key.length];
    	  Arrays.sort(item);
     }
     
}
