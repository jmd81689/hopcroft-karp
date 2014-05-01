package com.hc;

public class Edge<T> {

	private T a;
	private T b;
	
	public Edge(){
		
	}
	
	public Edge(T a, T b){
		this.a = a;
		this.b = b;
	}
	
	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	public boolean isIncident(T v) 
	{
		return (v == a || v == b);
	}

	public T getAdj(T v) 
	{
		if(v == a)
			return b;
		return a;
	}
	public String toString(){
		return a.toString() + " --> " + b.toString();
	}
}
