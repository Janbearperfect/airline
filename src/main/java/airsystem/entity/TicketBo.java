package airsystem.entity;

import java.util.Date;

import airsystem.util.DateUtil;

public class TicketBo {
    private String uname;
    private String flightNumber;
    private Date orderDate;
    private int classes;
    private int passengerType;

    private String saleName;
    private double tPrice;
	public TicketBo(String uname, String flightNumber, Date orderDate, int classes, int passengerType, 
			String saleName,double tPrice) {
		super();
		this.uname = uname;
		this.flightNumber = flightNumber;
		this.orderDate = orderDate;
		this.classes = classes;
		this.passengerType = passengerType;
	
		this.tPrice = tPrice;
		this.saleName=saleName;
	}
	/**
	 * @return the saleName
	 */
	public String getSaleName() {
		return saleName;
	}
	/**
	 * @param saleName the saleName to set
	 */
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	public TicketBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the name
	 */
	
	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = DateUtil.toDateTime(orderDate)   ;
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
	 * @return the passengerType
	 */
	public int getPassengerType() {
		return passengerType;
	}
	/**
	 * @param passengerType the passengerType to set
	 */
	public void setPassengerType(int passengerType) {
		this.passengerType = passengerType;
	}
	/**
	 * @return the salesId
	 */

	/**
	 * @return the tPrice
	 */
	public double gettPrice() {
		return tPrice;
	}
	/**
	 * @param tPrice the tPrice to set
	 */
	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketBo [uname=" + uname + ", flightNumber=" + flightNumber + ", orderDate=" + orderDate + ", classes="
				+ classes + ", passengerType=" + passengerType + ", saleName=" + saleName + ", tPrice=" + tPrice + "]";
	}

	
	
    
}
