package Model;

public class Product {

	//Các thuộc tính của gói hàng trong shop
	private String code;
	private String productName;
	private int quantity;

	public Product(String code, String productName, int quantity) {
		this.code = code;
		this.productName = productName;
		this.quantity = quantity;
	}

	//Getter setter
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[code = "+code+" ,productName = "+productName+", quantity = "+quantity+"]";
	}
}
