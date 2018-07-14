package cartfactorypackage;

public class Customer {
	private String CustomerId;
	
	public Customer(String CustomerId){
		this.CustomerId = CustomerId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	
}
