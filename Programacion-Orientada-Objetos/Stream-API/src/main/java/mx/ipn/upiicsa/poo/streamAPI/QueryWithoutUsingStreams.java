package mx.ipn.upiicsa.poo.streamAPI;

import java.util.ArrayList;
import java.util.List;

public class QueryWithoutUsingStreams {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		int count = 0;

		products.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));
		products.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
		products.add(new Product("1234567", "Zenith", "Fridge", 151.98));
		products.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));

		System.out.println("ITEMS");

		products.forEach(product -> System.out.println(product));

		System.out.println();

		System.out.println("ITEMS COSTING LESS THAN 170");

		for (Product p : products) {
			if (p.getUnitPrice() < 170) {
				System.out.println(p);
				count++;
			}
		}
		System.out.println();
		System.out.println("There are " + count + " items costing less then 170");
	}

}
