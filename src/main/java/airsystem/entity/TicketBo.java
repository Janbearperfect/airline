package airsystem.entity;

import java.util.Date;

import airsystem.util.DateUtil;

public class TicketBo {
    private String name;
    private String flightNumber;
    private Date orderDate;
    private int classes;
    private int passengerType;
    private int  salesId;
    private double tPrice;
	public TicketBo(String name, String flightNumber, Date orderDate, int classes, int passengerType, int salesId,
			double tPrice) {
		super();
		this.name = name;
		this.flightNumber = flightNumber;
		this.orderDate = orderDate;
		this.classes = classes;
		this.passengerType = passengerType;
		this.salesId = salesId;
		this.tPrice = tPrice;
	}
	public TicketBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
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
	public int getSalesId() {
		return salesId;
	}
	/**
	 * @param salesId the salesId to set
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
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
	@Override
	public String toString() {
		return "TicketBo [name=" + name + ", flightNumber=" + flightNumber + ", orderDate=" + orderDate + ", classes="
				+ classes + ", passengerType=" + passengerType + ", salesId=" + salesId + ", tPrice=" + tPrice + "]";
	}
	
	
    
}
