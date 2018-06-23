package com.inventory.stocks;

public class StockBean {
	int id;
	String name;
	double cost;
	public StockBean() {}
	
	public StockBean(int id, String name, double cost) {
		this.id=id;
		this.name = name;
		this.cost = cost;
	}
	public StockBean(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
