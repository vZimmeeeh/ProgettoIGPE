package application.net.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DBConnectionHandler {
	
	private static DBConnectionHandler instance = null;
	private Connection connection = null;
	public boolean connectionError = false;
	
	private DBConnectionHandler() {		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:BubbleBobbleDB.bd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnectionHandler getInstance() {
		if(instance == null)
			instance = new DBConnectionHandler();
		return instance;
	}
	
	public synchronized boolean insertUser(User user) throws SQLException { //va bene cosi
		if(connection == null || connection.isClosed() || user == null) {
			connectionError = true;
			return false;
		}
		
		if(existsUser(user))
			return false;
		
		PreparedStatement p = connection.prepareStatement("INSERT INTO Users values(?, ?);");
		p.setString(1, user.getUsername());
		String salt = BCrypt.gensalt(12);
		p.setString(2, BCrypt.hashpw(user.getPassword(), salt));
		p.executeUpdate();
		p.close();		
		return true;		
	}
	
	public synchronized boolean existsUser(User user) throws SQLException {
		if(connection == null || connection.isClosed() || user == null) {
			connectionError = true;
			return false;
		}
		
		String query = "SELECT * FROM Users WHERE username=?;";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, user.getUsername());
		ResultSet rs = p.executeQuery();
		boolean result = rs.next();
		p.close();
		return result;
	}
	
	public synchronized boolean checkUser(User user) throws SQLException { 
		if(connection == null || connection.isClosed() || user == null) {
			connectionError = true;
			return false;
		}
		
		String query = "SELECT * FROM Users WHERE username=?;";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, user.getUsername());		
		ResultSet rs = p.executeQuery();
		boolean result = false;
		if(rs.next()) {
			String password = rs.getString("password");
			result = BCrypt.checkpw(user.getPassword(), password);
		}
		p.close();
		return result;
	}
	
	public synchronized boolean updateGames(String username, int score, int time) {
		return true;
	}
	
	public synchronized boolean getClassification() {  //gestisci questo
		return true;
	}

}
