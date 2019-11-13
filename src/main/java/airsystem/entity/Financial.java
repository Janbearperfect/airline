package airsystem.entity;

public class Financial {
	private double tprice;

	public Financial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Financial(double tprice) {
		super();
		this.tprice = tprice;
	}

	/**
	 * @return the tprice
	 */
	public double getTprice() {
		return tprice;
	}

	/**
	 * @param tprice the tprice to set
	 */
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Financial [tprice=" + tprice + "]";
	}
	
	
}
