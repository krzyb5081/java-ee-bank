package dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import model.Account;

public class DataBase {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:C:\\Users\\ja\\eclipse\\bank\\database.db";
	
	Connection conn;
	Statement statement;
	
	public DataBase() {
		try {
			Class.forName(DRIVER);
		} catch(ClassNotFoundException e) {
			System.out.print("Driver loading error"+e.getMessage());
			System.err.println("Driver loading error "+e.getMessage());
		}
		
		try {
			conn = DriverManager.getConnection(DB_URL);
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.print("Connection getting error"+e.getMessage());
			System.err.println("Connection getting error "+e.getMessage());
		}
		
		
		createTables();
		
	}
	
	public boolean createTables() {
		String account = "CREATE TABLE IF NOT EXISTS account (id INTEGER PRIMARY KEY AUTOINCREMENT, user_name VARCHAR(255), password VARCHAR(255), name VARCHAR(255), surname VARCHAR(255), birth_date DATE, current_money FLOAT(2))";
		String moneyTransfer = "CREATE TABLE IF NOT EXISTS money_transfer (id INTEGER PRIMARY KEY AUTOINCREMENT, id_account INTEGER, transfer_date DATE, transfer_time TIME, transfered_money FLOAT(2), id_user_sender INTEGER, id_user_receiver INTEGER)";
		
		try {
			statement.execute(account);
			statement.execute(moneyTransfer);
		} catch(SQLException e) {
			System.err.println("Tables creating error "+e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean createAccount(String userName, String password, String name, String surname, LocalDate birthDate, Float currentMoney) {
		boolean created = false;
		try {
			PreparedStatement prepState = conn.prepareStatement("INSERT INTO account VALUES (NULL,?,?,?,?,?,?)");
			prepState.setString(1, userName);
			prepState.setString(2, password);
			prepState.setString(3, name);
			prepState.setString(4, surname);
			prepState.setDate(5, Date.valueOf(birthDate));
			prepState.setFloat(6, currentMoney);
			int exeResult =	prepState.executeUpdate();
			if(exeResult == 0) {
				System.out.println("tu cie mam tu cie mam");
				created = false;
			}else {
				created = true;
			}
			
			
		} catch (SQLException e) {
			System.err.println("Creating account error "+e.getMessage());
			return false;
		}
		
		return created;
	}
	
	public boolean makeMoneyTransfer(int idAccount, LocalDate transferDate, LocalTime transferTime, float transferedMoney, int idUserSender, int idUserReceiver) {
		
		try {
			PreparedStatement prepState = conn.prepareStatement("INSERT INTO money_transfer VALUES (NULL,?,?,?,?,?,?)");
			prepState.setInt(1, idAccount);
			prepState.setDate(2, Date.valueOf(transferDate));
			prepState.setTime(3, Time.valueOf(transferTime));
			prepState.setFloat(4, transferedMoney);
			prepState.setInt(5, idUserSender);
			prepState.setInt(6, idUserReceiver);
			prepState.execute();
			
		} catch(SQLException e) {
			System.err.println("Money transfer making error "+e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean passwordIsCorrect(Account account) {
		boolean passCorrect = false;
		try {
			PreparedStatement prepStat = conn.prepareStatement("SELECT * FROM account WHERE user_name=? AND password=?");
			prepStat.setString(1, account.getUserName());
			prepStat.setString(2, account.getPassword());
			ResultSet result = prepStat.executeQuery();
			
			
			if(result.next() == false) {
				passCorrect = false;
			} else {
				passCorrect = true;
			}
		} catch (SQLException e) {
			System.err.println("Password check error "+e.getMessage());
			return false;
		}
		
		return passCorrect;
	}
	
	public boolean registerNewAccount(Account account) {
		try {
			
			PreparedStatement prepStat = conn.prepareStatement("SELECT user_name FROM account WHERE user_name=?");
			prepStat.setString(1, account.getUserName());
			ResultSet result = prepStat.executeQuery();
			
			if(result.next() == true) {
				return false;
			}
			if(!createAccount(account.getUserName(), account.getPassword(), account.getName(), account.getSurname(), account.getBirthDate(), account.getCurrentMoney())) {
				return false;
			}
			
		}catch(SQLException e) {
			System.err.println("Account register error "+e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch(SQLException e) {
			System.err.println("Connection closing problem "+e.getMessage());
			
		}
	}
}
