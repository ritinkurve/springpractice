package com.inventory.stocks;

import java.util.*;

public class StockDao {
	public static List<StockBean> stock;
	private static StockDao stockDao = new StockDao();
	static {
		stock = new ArrayList<StockBean>();
	}

	private StockDao() {
	}

	public static StockDao getInstance() {
		if (stockDao == null)
			return new StockDao();
		return stockDao;
	}

	private final Object lock = new Object();

	public static List<StockBean> getStockBean() {
		return stock;
	}

	public static void setStockBean(List<StockBean> stock) {
		StockDao.stock = stock;
	}

	public String updateStock(String name, double cost) {
		synchronized (lock) {
			int id = getLastId() + 1;
			StockBean bean = new StockBean(id, name, cost);
			stock.add(bean);
		}
		return "Stock Updated !";
	}

	public static int getLastId() {
		if(stock.size()>=1) {
			StockBean bean=stock.get(stock.size()-1);
			return bean.getId();
		}else {
			return 0;
		}
	}

	public String checkOutItem(String name, int qty) {
		if (qty > countQty(name)) {
			return "Not enough inventory !";
		} else {
			synchronized (lock) {
				int count=0;
				for (Iterator<StockBean> iter = stock.listIterator(); iter.hasNext();) {
					StockBean sb = iter.next();
					if (sb.getName().equals(name)) {
						iter.remove();
						count++;
					}
					if(count==qty)
						break;
				}
			}
			return qty +" Quantity Checked out successfully !";
		}
	}

	public static int countQty(String name) {
		int count = 0;
		for (StockBean sb : stock) {
			if (sb.getName().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public void generateInventoryReport() {
		for (StockBean sb : stock) {
			System.out.println(sb.getId() + "\t" + sb.getName() + "\t" + sb.getCost());
		}
	}
}
