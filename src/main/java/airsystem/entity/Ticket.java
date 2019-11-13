package airsystem.entity;

public class Ticket {
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", userId=" + userId + ", flightId=" + flightId + ", idNumber=" + idNumber
				+ ", orderDate=" + orderDate + ", classes=" + classes + ", salesId=" + salesId + ", status=" + status
				+ ", tPrice=" + tPrice + ", passengerType=" + passengerType + "]";
	}
	private  int id;
    private  int  userId;
    private int flightId;
    private String idNumber;
    private String orderDate;
    private int    classes;
    private int  salesId;
    private int status;
    private double tPrice;
    private int passengerType;
    public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int id, int userId, int flightId, String idNumber, String orderDate, int classes,int passengerType, int salesId, int status,
			double tPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.flightId = flightId;
		this.idNumber = idNumber;
		this.orderDate = orderDate;
		this.classes = classes;
		this.passengerType=passengerType;
		this.salesId = salesId;
		this.status = status;
		this.tPrice = tPrice;
	}
	public Ticket(int userId, int flightId, String idNumber, int classes, int salesId, int status, double tPrice,
			int passengerType) {
		super();
		this.userId = userId;
		this.flightId = flightId;
		this.idNumber = idNumber;
		this.classes = classes;
		this.salesId = salesId;
		this.status = status;
		this.tPrice = tPrice;
		this.passengerType = passengerType;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}
	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
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
	/**
	 * @return the passengerType
	 */
	public int getpassengerType() {
		return passengerType;
	}
	/**
	 * @param passengerType the passengerType to set
	 */
	public void setpassengerType(int passengerType) {
		this.passengerType = passengerType;
	}
}