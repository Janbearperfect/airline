/**
 * 
 */
package airsystem.entity;

/**
 * @author 何晓庭
 *
 */
public class PiaoObject {
	
	private String departure_time;
	private String arrival_time;
	private String end_date;
	
	public PiaoObject() {
		super();
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "PiaoObject [departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", end_date="
				+ end_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
		result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
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
		PiaoObject other = (PiaoObject) obj;
		if (arrival_time == null) {
			if (other.arrival_time != null)
				return false;
		} else if (!arrival_time.equals(other.arrival_time))
			return false;
		if (departure_time == null) {
			if (other.departure_time != null)
				return false;
		} else if (!departure_time.equals(other.departure_time))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		return true;
	}
	
	
	
	
}
