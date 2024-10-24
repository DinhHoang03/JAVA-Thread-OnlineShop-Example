package Service;

import java.util.ArrayList;
import java.util.List;

//import DAO.DAOShopAdmin;
import Model.Customer;
import Model.Product;

public class OnlineShop {
		//Quan hệ hợp thành(Compostion), mô tả: Một cửa hàng online có thể có nhiều gói hàng!
		private Product product;
		public static List<Product> listOfProduct = new ArrayList<Product>();

		public OnlineShop(Product product) {
			this.product = product;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		//Hàm đặt sản phẩm cho khách
		public void order(Product product, String customerName) {
			synchronized (listOfProduct) {
				for(int i = 0; i < listOfProduct.size(); i++) {
					Product p = listOfProduct.get(i);
					if(p.getProductName().equals(product.getProductName()) && p.getQuantity() >= 1) {
						p.setQuantity(p.getQuantity() - 1);
						System.out.println("["+customerName+"] ordered");

						if(p.getQuantity() == 0) {
							listOfProduct.remove(i);
						}
					}
				}
			}
		}

		//Hàm thêm sản phẩm vào kho
		public void add() {
			listOfProduct.add(product);
			System.out.println(product.getProductName() + " added!");
		}
	}

