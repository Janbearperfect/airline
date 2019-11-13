package airsystem.entity;

public class FinancialType {
	private int type;
	private double price;
	public FinancialType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinancialType(int type, double price) {
		super();
		this.type = type;
		this.price = price;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
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
		return "FinancialType [type=" + type + ", price=" + price + "]";
	}
}
