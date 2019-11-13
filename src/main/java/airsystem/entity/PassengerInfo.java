package airsystem.entity;

public class PassengerInfo {
	private int adultNumber;
	private int badyNumber;
	private int childNumber;
	private String flightNumber;
	private String classes;
	private double price;
	public int getAdultNumber() {
		return adultNumber;
	}
	public void setAdultNumber(int adultNumber) {
		this.adultNumber = adultNumber;
	}
	public int getBadyNumber() {
		return badyNumber;
	}
	public void setBadyNumber(int badyNumber) {
		this.badyNumber = badyNumber;
	}
	public int getChildNumber() {
		return childNumber;
	}
	public void setChildNumber(int childNumber) {
		this.childNumber = childNumber;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getclasses() {
		return classes;
	}
	public void setclasses(String classes) {
		this.classes = classes;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public PassengerInfo(int adultNumber, int badyNumber, int childNumber, String flightNumber, String classes,
			double price) {
		super();
		this.adultNumber = adultNumber;
		this.badyNumber = badyNumber;
		this.childNumber = childNumber;
		this.flightNumber = flightNumber;
		this.classes = classes;
		this.price = price;
	}
	public PassengerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adultNumber;
		result = prime * result + badyNumber;
		result = prime * result + childNumber;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerInfo other = (PassengerInfo) obj;
		if (adultNumber != other.adultNumber)
			return false;
		if (badyNumber != other.badyNumber)
			return false;
		if (childNumber != other.childNumber)
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PassengerInfo [adultNumber=" + adultNumber + ", badyNumber=" + badyNumber + ", childNumber="
				+ childNumber + ", flightNumber=" + flightNumber + ", classes=" + classes + ", price=" + price
				+ "]";
	}
	
	

	
}
