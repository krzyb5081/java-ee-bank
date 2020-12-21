package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MoneyTransfer {
	private int id;
	private int idAccount;
	private LocalDate transferDate;
	private LocalTime transferTime;
	private float transferedMoney;
	private int idUserSender;
	private int idUserReceiver;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	
	public int getIdAccount() {
		return idAccount;
	}
	
	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}
	
	public LocalDate getTransferDate() {
		return transferDate;
	}
	
	public void setTransferTime(LocalTime transferTime) {
		this.transferTime = transferTime;
	}
	
	public LocalTime getTransferTime() {
		return transferTime;
	}
	
	public void setTransferedMoney(float transferedMoney) {
		this.transferedMoney = transferedMoney;
	}
	
	public float getTransferedMoney() {
		return transferedMoney;
	}
	
	public void setIdUserSender(int idUserSender) {
		this.idUserSender = idUserSender;
	}
	
	public int getIdUserSender() {
		return idUserSender;
	}
	
	public void setIdUserReceiver(int idUserReceiver) {
		this.idUserReceiver = idUserReceiver;
	}
	
	public int getIdUserReceiver() {
		return idUserReceiver;
	}
}
