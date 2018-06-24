package com.inventory.stocks;

import java.util.*;

class Items {
	String name;
	Double price;

	public Items(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

}

class Processor {
	private final Object lock = new Object();
	private final int LIMIT = 30;
	private final int BOTTOM = 0;
	Random rand = new Random();
	StockDao sd = StockDao.getInstance();

	public void producer() throws InterruptedException {
		List<Items> items = new ArrayList<Items>();
		items.add(new Items("PEN", 20d));
		items.add(new Items("MARKER", 10d));
		items.add(new Items("NOTEPAD", 30d));
		items.add(new Items("DUSTER", 15d));
		synchronized (lock) {

			while (true) {

				if (StockDao.stock.size() == LIMIT) {
					System.out.println("Waiting for removing items from the list...");
					lock.wait();
				} else {
					System.out.println("Adding...");
					Items i = items.get(rand.nextInt(items.size()));
					System.out.println(sd.updateStock(i.getName(), i.getPrice()));
					System.out.println("******************");
					StockDao.generateInventoryReport();
					lock.notify();
				}

				Thread.sleep(500);
			}
		}
	}

	public void consumer() throws InterruptedException {
		List<Items> items = new ArrayList<Items>();
		items.add(new Items("PEN", 20d));
		items.add(new Items("MARKER", 10d));
		items.add(new Items("NOTEPAD", 30d));
		items.add(new Items("DUSTER", 15d));
		synchronized (lock) {
			while (true) {

				if (StockDao.stock.size() == BOTTOM) {
					System.out.println("Waiting for adding items to the list...");
					lock.wait();
				} else {
					System.out.println("Removing...");
					Items i = items.get(rand.nextInt(items.size()));
					int qty = rand.nextInt(3);
					System.out.println(sd.checkOutItem(i.getName(), qty));
					System.out.println("******************");
					StockDao.generateInventoryReport();
				}
				Thread.sleep(500);
			}

		}

	}

}

public class Driver {
	static Processor processor = new Processor();
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.producer();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consumer();
					StockDao.generateInventoryReport();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

}
