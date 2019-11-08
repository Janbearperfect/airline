package airsystem.entity;

import java.util.Date;

import airsystem.util.DateUtil;

public class FlightScheduler {
	private int id;
	private String flightNumber;  //航班编号
	private Date startDate;			//开始时间
	private Date endDate;				//结束时间
	private String fromCity;			//出发机场
	private String toCity;				//到达机场
	private Date departureTime;	   //离港时间
	private Date arrivalTime;			//结束时间
	private String airplane;				//飞机编号
	private String scheduler;			//班期
	private int sailLength;				//航程
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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
	public String getAirplane() {
		return airplane;
	}
	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}
	public String getScheduler() {
		return scheduler;
	}
	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}
	public int getSailLength() {
		return sailLength;
	}
	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}
	public FlightScheduler(int id, String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String airplane, String scheduler, int sailLength) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airplane = airplane;
		this.scheduler = scheduler;
		this.sailLength = sailLength;
	}
	public FlightScheduler() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplane == null) ? 0 : airplane.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + id;
		result = prime * result + sailLength;
		result = prime * result + ((scheduler == null) ? 0 : scheduler.hashCode());
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
		FlightScheduler other = (FlightScheduler) obj;
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
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (sailLength != other.sailLength)
			return false;
		if (scheduler == null) {
			if (other.scheduler != null)
				return false;
		} else if (!scheduler.equals(other.scheduler))
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
		return "FlightScheduler [id=" + id + ", flightNumber=" + flightNumber + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", airplane=" + airplane + ", scheduler=" + scheduler
				+ ", sailLength=" + sailLength + "]";
	}
	
	
	

	
}
