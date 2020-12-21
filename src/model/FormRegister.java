package model;

public class FormRegister {
	
	private String userName;
	private String password;
	private String name;
	private String surname;
	private String birthDate;
	private float currentMoney;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public float getCurrentMoney() {
		return currentMoney;
	}
	
	public void setCurrentMoney(float currentMoney) {
		this.currentMoney = currentMoney;
	}
}
