package mx.ipn.upiicsa.poo.streamAPI;

import java.util.ArrayList;
import java.util.List;

public class QueryUsingStreams {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		
		// add four products to the list
		products.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));
		products.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
		products.add(new Product("1234567", "Zenith", "Fridge", 151.98));
		products.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));
		
		// display all items
		System.out.println("ALL ITEMS");
		products.stream().forEach(product -> System.out.println(product));
		System.out.println();
		
		// filter the list and display items costing less than 170
		System.out.println("ITEMS UNDER 170");
		products.stream().filter(product -> product.getUnitPrice() < 170).forEach(product -> System.out.println(product));

		// count items costing less than 170
		long count = products.stream().filter(product -> product.getUnitPrice() < 170).count();
		System.out.println();
		System.out.println("There are " + count + " items costing less then 170");

	}
}
