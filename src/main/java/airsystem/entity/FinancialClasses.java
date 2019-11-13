package airsystem.entity;

public class FinancialClasses {
	private int classes;
	private double price;
	public FinancialClasses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinancialClasses(int classes, double price) {
		super();
		this.classes = classes;
		this.price = price;
	}
	/**
	 * @return the classes
	 */
	public int getClasses() {
		return classes;
	}
	/**
	 * @param classes the classes to set
	 */
	public void setClasses(int classes) {
		this.classes = classes;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FinancialClasses [classes=" + classes + ", price=" + price + "]";
	}
	
	
}
