package Model;

import Service.OnlineShop;

import static Service.OnlineShop.listOfProduct;

public class Administrator extends Thread{

	OnlineShop onlineShop;

	public Administrator(OnlineShop onlineShop) {
		this.onlineShop = onlineShop;
	}

	@Override
	public void run() {
		System.out.println("[Admin] start work");
		for(int i = 0; i < 2; i++){

			System.out.println("[Admin] adding a new product");
			onlineShop.add();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			synchronized (listOfProduct) {
				listOfProduct.notifyAll();
			}
		}
	}
}



