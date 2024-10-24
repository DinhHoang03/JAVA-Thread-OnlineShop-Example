package Model;

import Service.OnlineShop;

import static Service.OnlineShop.listOfProduct;

public class Customer extends Thread{

	private OnlineShop onlineShop;
	private String customerName;

	public Customer(OnlineShop onlineShop, String customerName) {
		this.onlineShop = onlineShop;
		this.customerName = customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			synchronized (listOfProduct){
				boolean matchProduct = false;

				for(Product prouduct : listOfProduct){
					if(onlineShop.getProduct().getProductName().equals(prouduct.getProductName())){
						matchProduct = true;
						break;
					}
				}
					if(matchProduct){
						System.out.println("["+customerName+"] start order");
						onlineShop.order(onlineShop.getProduct(), customerName);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}else{
						System.out.println(onlineShop.getProduct().getProductName() + " not exists");
						System.out.println("List wait");
                    try {
                        listOfProduct.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
					listOfProduct.notifyAll();
			}
		}
	}
}

	
