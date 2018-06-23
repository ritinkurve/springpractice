package com.inventory.stocks;

public class App {

	public static void main(String[] args) {
		StockDao sd=StockDao.getInstance();
		sd.updateStock("PEN",20.2);
		sd.updateStock("PEN",20.2);
		sd.updateStock("PEN", 20.2);
		sd.updateStock("Notepad", 30.2);
		sd.updateStock("Notepad", 30.2);
		sd.updateStock("Marker", 30.2);
		sd.updateStock("Marker", 15);
		sd.updateStock("PEN", 20.2);
		sd.generateInventoryReport();
		System.out.println("After Checkout");
		System.out.println(sd.checkOutItem("PEN", 2));
		sd.generateInventoryReport();
		System.out.println(sd.updateStock("PEN", 20.2));
		sd.generateInventoryReport();
		System.out.println(sd.checkOutItem("PEN", 5));

	}

}
