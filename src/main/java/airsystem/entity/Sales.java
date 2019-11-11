package airsystem.entity;

public class Sales {
	private int id;
	private String saleName;
	private String number;
	private String password;
	private int branchId;
	private String name;
//	private String province;
//public String getProvince() {
//		return province;
//	}
//	public void setProvince(String province) {
//		this.province = province;
//	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sales() {
		super();
	}
	public Sales(int id, String name, String number, String password, int branchId) {
		super();
		this.id = id;
		this.saleName = name;
		this.number = number;
		this.password = password;
		this.branchId = branchId;
	}
	public Sales(String name, String number, String password, int branchId) {
		super();
		this.saleName = name;
		this.number = number;
		this.password = password;
		this.branchId = branchId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + branchId;
		result = prime * result + id;
		result = prime * result + ((saleName == null) ? 0 : saleName.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Sales other = (Sales) obj;
		if (branchId != other.branchId)
			return false;
		if (id != other.id)
			return false;
		if (saleName == null) {
			if (other.saleName != null)
				return false;
		} else if (!saleName.equals(other.saleName))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", saleName=" + saleName + ", number=" + number + ", password=" + password
				+ ", branchId=" + branchId + ", name=" + name + "]";
	}

	
}
