package brief5.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

public interface CandidateDAO {
	
	public static boolean getCandiate(int id) {
		
		
		return true;
//	    Connection connection = connectionFactory.getConnection();
//	    try {
//	        Statement stmt = connection.createStatement();
//	        ResultSet rs = stmt.executeQuery("SELECT * FROM candidates WHERE id=" + id);
//
//	        if(rs.next())
//	        {
//	            return extractUserFromResultSet(rs);
//	        }
//
//	    } catch (SQLException ex) {
//	        ex.printStackTrace();
//	    }

//	    return null;
	}
	
    // public Set getAllUsers() {
    //     Connector connector = new Connector();
    //     Connection connection = connector.getConnection();
    //     try {
    //         Statement stmt = connection.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT * FROM user");

    //         Set users = new HashSet();

    //         while(rs.next())
    //         {
    //             User user = extractUserFromResultSet(rs);
    //             users.add(user);
    //         }

    //         return users;

    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }

    //     return null;
    // }
    
    // public User getUserByUserNameAndPassword(String user, String pass) {
    //     Connector connector = new Connector();
    //     Connection connection = connector.getConnection();
    //     try {
    //         PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE user=? AND pass=?");
    //         ps.setString(1, user);
    //         ps.setString(2, pass);
    //         ResultSet rs = ps.executeQuery();

    //         if(rs.next())
    //         {
    //     return extractUserFromResultSet(rs);
    //         }

    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }

    //     return null;
    // }
    
    // public boolean insertUser(User user) {
    //     Connector connector = new Connector();
    //     Connection connection = connector.getConnection();
    //     try {
    //         PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?)");
    //         ps.setString(1, user.getName());
    //         ps.setString(2, user.getPass());
    //         ps.setInt(3, user.getAge());
    //         int i = ps.executeUpdate();

    //       if(i == 1) {
    //         return true;
    //       }

    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }

    //     return false;
    // }
    
    // public boolean updateCandidate(User user) {
    //     Connector connector = new Connector();
    //     Connection connection = connector.getConnection();
    //     try {
    //         PreparedStatement ps = connection.prepareStatement("UPDATE user SET name=?, pass=?, age=? WHERE id=?");
    //         ps.setString(1, user.getName());
    //         ps.setString(2, user.getPass());
    //         ps.setInt(3, user.getAge());
    //         ps.setInt(4, user.getId());
    //         int i = ps.executeUpdate();

    //       if(i == 1) {
    //     return true;
    //       }

    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }

    //     return false;
    // }
    
    
    
    // public boolean deleteCandidate(int id) {
    //     Connector connector = new Connector();
    //     Connection connection = connector.getConnection();
    //     try {
    //         Statement stmt = connection.createStatement();
    //         int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);

    //       if(i == 1) {
    //     return true;
    //       }

    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }

    //     return false;
    // }
}