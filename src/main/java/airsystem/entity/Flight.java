package airsystem.entity;

public class Flight {
	private int flightId;   //����id
	private String flightNumber;  //������
	private int firstClassRemainSeats;  //ͷ�Ȳ���λ
	private int businessClassRemainSeats;  //�����
	private int economyClassRemainSeats; //���ò�
	private double seasonDiscount;   //�ۿ�
	private double price;  //�۸�
	public Flight(int flightId, String flightNumber, int firstClassRemainSeats, int businessClassRemainSeats,
			int economyClassRemainSeats, double seasonDiscount, double price) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.firstClassRemainSeats = firstClassRemainSeats;
		this.businessClassRemainSeats = businessClassRemainSeats;
		this.economyClassRemainSeats = economyClassRemainSeats;
		this.seasonDiscount = seasonDiscount;
		this.price = price;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getFirstClassRemainSeats() {
		return firstClassRemainSeats;
	}
	public void setFirstClassRemainSeats(int firstClassRemainSeats) {
		this.firstClassRemainSeats = firstClassRemainSeats;
	}
	public int getBusinessClassRemainSeats() {
		return businessClassRemainSeats;
	}
	public void setBusinessClassRemainSeats(int businessClassRemainSeats) {
		this.businessClassRemainSeats = businessClassRemainSeats;
	}
	public int getEconomyClassRemainSeats() {
		return economyClassRemainSeats;
	}
	public void setEconomyClassRemainSeats(int economyClassRemainSeats) {
		this.economyClassRemainSeats = economyClassRemainSeats;
	}
	public double getSeasonDiscount() {
		return seasonDiscount;
	}
	public void setSeasonDiscount(double seasonDiscount) {
		this.seasonDiscount = seasonDiscount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessClassRemainSeats;
		result = prime * result + economyClassRemainSeats;
		result = prime * result + firstClassRemainSeats;
		result = prime * result + flightId;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(seasonDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Flight other = (Flight) obj;
		if (businessClassRemainSeats != other.businessClassRemainSeats)
			return false;
		if (economyClassRemainSeats != other.economyClassRemainSeats)
			return false;
		if (firstClassRemainSeats != other.firstClassRemainSeats)
			return false;
		if (flightId != other.flightId)
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(seasonDiscount) != Double.doubleToLongBits(other.seasonDiscount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNumber=" + flightNumber + ", firstClassRemainSeats="
				+ firstClassRemainSeats + ", businessClassRemainSeats=" + businessClassRemainSeats
				+ ", economyClassRemainSeats=" + economyClassRemainSeats + ", seasonDiscount=" + seasonDiscount
				+ ", price=" + price + "]";
	}
	
}
