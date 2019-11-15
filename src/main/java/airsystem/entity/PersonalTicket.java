package airsystem.entity;

import java.util.Date;

/**
 * 查询个人票务信息
 * @author 赵胜涛
 *
 */
public class PersonalTicket {
	private int id;  //订单编号
	private String flightNumber;  //航班编号
	private String name;    //姓名
	private String IdNumber;  //证件号码
	private Date orderDate;     //出票时间
	private String classes;			//舱位类型
	private String passengerType;   //乘客类型
	private String status;			// 票务状态
	private double tPrice;			// 价格
	private Date departureTime;		//离港时间
	private Date arrivalTime;			//到达时间
	private int sailLength;			// 航程
	private String  fromCity;     //机场名
	private String toCity;		//到达机场名
	
	
	public String getIdNumber() {
		return IdNumber;
	}
	public void setIdNumber(String IdNumber) {
		this.IdNumber = IdNumber;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double gettPrice() {
		return tPrice;
	}
	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
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
	public int getSailLength() {
		return sailLength;
	}
	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
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
	
	public PersonalTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalTicket(int id, String flightNumber, String name, String IdNumber, Date orderDate, String classes,
			String passengerType, String status, double tPrice, Date departureTime, Date arrivalTime, int sailLength,
			String fromCity, String toCity) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.name = name;
		this.IdNumber = IdNumber;
		this.orderDate = orderDate;
		this.classes = classes;
		this.passengerType = passengerType;
		this.status = status;
		this.tPrice = tPrice;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.sailLength = sailLength;
		this.fromCity = fromCity;
		this.toCity = toCity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdNumber == null) ? 0 : IdNumber.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((passengerType == null) ? 0 : passengerType.hashCode());
		result = prime * result + sailLength;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PersonalTicket other = (PersonalTicket) obj;
		if (IdNumber == null) {
			if (other.IdNumber != null)
				return false;
		} else if (!IdNumber.equals(other.IdNumber))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (passengerType == null) {
			if (other.passengerType != null)
				return false;
		} else if (!passengerType.equals(other.passengerType))
			return false;
		if (sailLength != other.sailLength)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(tPrice) != Double.doubleToLongBits(other.tPrice))
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
		return "PersonalTicket [id=" + id + ", flightNumber=" + flightNumber + ", name=" + name + ", IdNumber="
				+ IdNumber + ", orderDate=" + orderDate + ", classes=" + classes + ", passengerType=" + passengerType
				+ ", status=" + status + ", tPrice=" + tPrice + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", sailLength=" + sailLength + ", fromCity=" + fromCity + ", toCity=" + toCity + "]";
	}


	
	
	
	
	
}
