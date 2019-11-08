package airsystem.entity;

public class Ticket {
    private  int id;
    private  int  userId;
    private int flightId;
    private String idNum;
    private String orderDate;
    private int    rank;
    private int  saleId;
    private int status;
    private int price;
	public Ticket(int id, int userId, int flightId, String idNum, String orderDate, int rank, int saleId, int status,
			int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.flightId = flightId;
		this.idNum = idNum;
		this.orderDate = orderDate;
		this.rank = rank;
		this.saleId = saleId;
		this.status = status;
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", userId=" + userId + ", flightId=" + flightId + ", idNum=" + idNum
				+ ", orderDate=" + orderDate + ", rank=" + rank + ", saleId=" + saleId + ", status=" + status
				+ ", price=" + price + "]";
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
	 * @return the idNum
	 */
	public String getIdNum() {
		return idNum;
	}
	/**
	 * @param idNum the idNum to set
	 */
	public void setIdNum(String idNum) {
		this.idNum = idNum;
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
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * @return the saleId
	 */
	public int getSaleId() {
		return saleId;
	}
	/**
	 * @param saleId the saleId to set
	 */
	public void setSaleId(int saleId) {
		this.saleId = saleId;
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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
