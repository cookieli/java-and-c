package com.lizhengxian.graph;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwocolor = true;
    public TwoColor(){}
    public TwoColor(graph G){
    	marked = new boolean[G.V()];
    	color  = new boolean[G.V()];
    	for(int i = 0 ; i < G.V() ; i++){
    		
    	}
    }
    private void dfs(graph G,int v){
    	marked[v] = true ;
    	for(int w:G.adj(v)){
    		if(!marked[w]) {
    			color[w] = !color[v];
    			dfs(G,w);
    	}
    		else if(color[w] ==color[v]) isTwocolor = false;
    	}
    }
    public boolean isTwoColor(){
    	return this.isTwocolor;
    }
}
