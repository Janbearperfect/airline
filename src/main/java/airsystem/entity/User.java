package airsystem.entity;

import java.util.Date;

import airsystem.util.DateUtil;

public class User {
    private int id;
    private String phone;
    private String uname;
    private String sex;
    private Date age;
    private String address;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", uname=" + uname + ", sex=" + sex + ", age=" + age
				+ ", address=" + address + "]";
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the age
	 */
	public Date getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = DateUtil.toDate(age) ;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int id, String phone, String uname, String sex, Date age, String address) {
		super();
		this.id = id;
		this.phone = phone;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
