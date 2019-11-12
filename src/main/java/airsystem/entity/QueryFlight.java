package airsystem.entity;

import java.util.Date;

/**
 * 查询航班
 * @author 赵胜涛
 *
 */
public class QueryFlight {
	private int id;   //id
	private String fromCity;   //机场名
	private String toCity;   //
	private String flightNumber;  // 航班编号
	private String model;   // 机型
	private Date departureTime;   // 出发时间
	private Date arrivalTime;    // 达到时间
	private int firstClassRemainSeats;  //
	private int businessClassRemainSeats;  //
	private int economyClassRemainSeats; //
	private double seasonDiscount;   //
	private double price;  //
	private int sailLength;
	private Date startDate; //
	private Date endDate;
	private String airplane; // 飞机编号
	
	public QueryFlight(int id, String fromCity, String toCity, String flightNumber, String model, Date departureTime,
			Date arrivalTime, int firstClassRemainSeats, int businessClassRemainSeats, int economyClassRemainSeats,
			double seasonDiscount, double price, int sailLength, Date startDate, Date endDate, String airplane) {
		super();
		this.id = id;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightNumber = flightNumber;
		this.model = model;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstClassRemainSeats = firstClassRemainSeats;
		this.businessClassRemainSeats = businessClassRemainSeats;
		this.economyClassRemainSeats = economyClassRemainSeats;
		this.seasonDiscount = seasonDiscount;
		this.price = price;
		this.sailLength = sailLength;
		this.startDate = startDate;
		this.endDate = endDate;
		this.airplane = airplane;
	}
	public QueryFlight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	public int getSailLength() {
		return sailLength;
	}
	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAirplane() {
		return airplane;
	}
	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplane == null) ? 0 : airplane.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + businessClassRemainSeats;
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + economyClassRemainSeats;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + firstClassRemainSeats;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sailLength;
		temp = Double.doubleToLongBits(seasonDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
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
		QueryFlight other = (QueryFlight) obj;
		if (airplane == null) {
			if (other.airplane != null)
				return false;
		} else if (!airplane.equals(other.airplane))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (businessClassRemainSeats != other.businessClassRemainSeats)
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (economyClassRemainSeats != other.economyClassRemainSeats)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (firstClassRemainSeats != other.firstClassRemainSeats)
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (fromCity == null) {
			if (other.fromCity != null)
				return false;
		} else if (!fromCity.equals(other.fromCity))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (sailLength != other.sailLength)
			return false;
		if (Double.doubleToLongBits(seasonDiscount) != Double.doubleToLongBits(other.seasonDiscount))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (toCity == null) {
			if (other.toCity != null)
				return false;
		} else if (!toCity.equals(other.toCity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QueryFlight [id=" + id + ", fromCity=" + fromCity + ", toCity=" + toCity + ", flightNumber="
				+ flightNumber + ", model=" + model + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", firstClassRemainSeats=" + firstClassRemainSeats + ", businessClassRemainSeats="
				+ businessClassRemainSeats + ", economyClassRemainSeats=" + economyClassRemainSeats
				+ ", seasonDiscount=" + seasonDiscount + ", price=" + price + ", sailLength=" + sailLength
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", airplane=" + airplane + "]";
	}

	

}
