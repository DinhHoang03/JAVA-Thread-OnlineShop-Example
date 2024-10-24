package Controller;


import Model.Administrator;
import Model.Customer;
import Model.Product;
import Service.OnlineShop;

public class ShopManagement {
	public static void main(String[] args) throws InterruptedException {


		Product product1 = new Product("P003", "Vina Milk 123", 1);
        Product product2 = new Product("P002", "Tivi LG 223", 1);

		OnlineShop adminAdd1 = new OnlineShop(product1);
		OnlineShop adminAdd2 = new OnlineShop(product2);

		OnlineShop customerOrder1 = new OnlineShop(product1);
		OnlineShop customerOrder2 = new OnlineShop(product2);

		Customer customer1 = new Customer(customerOrder1, "Customer 1");
		Customer customer2 = new Customer(customerOrder2, "Customer 2");

		Administrator admin1 = new Administrator(adminAdd1);
		Administrator admin2 = new Administrator(adminAdd2);

		System.out.println("Begin Thread!");

		admin1.start();
		admin2.start();
		customer1.start();
		customer2.start();

		admin1.join();
		admin2.join();
		customer1.join();
		customer2.join();

		System.out.println("End Thread!");
	}
}
