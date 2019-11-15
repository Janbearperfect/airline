package airsystem.entity;

public class Branch {
	private int id;
	private String name;
	private String address;
	private String telephone;
	private String province;
	private String bNumber;
	private String bPassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getbNumber() {
		return bNumber;
	}
	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}
	public String getbPassword() {
		return bPassword;
	}
	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}
	public Branch(int id, String name, String address, String telephone, String province, String bNumber,
			String bPassword) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.province = province;
		this.bNumber = bNumber;
		this.bPassword = bPassword;
	}
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bNumber == null) ? 0 : bNumber.hashCode());
		result = prime * result + ((bPassword == null) ? 0 : bPassword.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		Branch other = (Branch) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bNumber == null) {
			if (other.bNumber != null)
				return false;
		} else if (!bNumber.equals(other.bNumber))
			return false;
		if (bPassword == null) {
			if (other.bPassword != null)
				return false;
		} else if (!bPassword.equals(other.bPassword))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", address=" + address + ", telephone=" + telephone
				+ ", province=" + province + ", bNumber=" + bNumber + ", bPassword=" + bPassword + "]";
	}

	

	
	
	
}
