package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class CandidateDaoImpl implements CandidateDao{
	
	
public Set<Candidate> getAllCandidates() {
		  Connection connection = DBConnection.getConnection();

		    try {
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");

		        Set<Candidate> candidates = new HashSet<Candidate>();
		        
		   	 while ( rs.next() ) {
		            Candidate candidate = extractCandidateFromResultSet(rs);
		            candidates.add(candidate);
		        }

		       return candidates;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
		}

 
public boolean getCandiate(int id) {
	
Connection connection = DBConnection.getConnection();

try {
    Statement stmt = connection.createStatement();
    System.out.print(id);
    ResultSet rs = stmt.executeQuery("SELECT * FROM candidates WHERE id=" + id);

    if(rs.next())
    {
        return true;
    }

} catch (SQLException ex) {
    ex.printStackTrace();
}

return false;
}

   
 public boolean insertCandidate(Candidate candidate)  {
	  Connection connection = DBConnection.getConnection();

    try {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO candidates (email, first_name, last_name, address, city, country) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, candidate.getEmail());
        stmt.setString(2, candidate.getFirst_name());
        stmt.setString(3, candidate.getLast_name());
        stmt.setString(4, candidate.getAddress());
        stmt.setString(5, candidate.getCity());
        stmt.setString(6, candidate.getCountry());
        int i = stmt.executeUpdate();

      if(i == 1) {
        return true;
      }
	    stmt.close();
	    connection.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return false;
}
    
 public boolean updateCandidate(int id, Candidate candidate) {
	 Connection connection = DBConnection.getConnection();

	    try {
	        PreparedStatement stmt = connection.prepareStatement("UPDATE candidates SET email=?, first_name=?, last_name=?, address=?, city=?, country=? WHERE id=?");
	        stmt.setString(1, candidate.getEmail());
	        stmt.setString(2, candidate.getFirst_name());
	        stmt.setString(3, candidate.getLast_name());
	        stmt.setString(4, candidate.getAddress());
	        stmt.setString(5, candidate.getCity());
	        stmt.setString(6, candidate.getCountry());
	        stmt.setInt(7, id);

	        int i = stmt.executeUpdate();
	      if(i == 1) {
	  	    return true;
	      }
		    stmt.close();
		    connection.close();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return false;
	}
    
    
 public boolean deleteCandidate(int id) {
	 Connection connection = DBConnection.getConnection();

	    try {
	        Statement stmt = connection.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM candidates WHERE id=" + id);

	      if(i == 1) {
	        return true;
	      }
		    stmt.close();
		    connection.close();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    
	    return false;
	}
 
 private static Candidate extractCandidateFromResultSet(ResultSet rs) throws SQLException {
	  Candidate candidate = new Candidate();
	  candidate.setId( rs.getInt("id") );
	  candidate.setEmail( rs.getString("email") );
	  candidate.setFirst_name( rs.getString("first_name") );
	  candidate.setLast_name( rs.getString("last_name") );
	  candidate.setAddress( rs.getString("address") );
	  candidate.setCity( rs.getString("city") );
	  candidate.setCountry( rs.getString("country") );
	  candidate.setCountry( rs.getString("country") );
	    
	  System.out.print(candidate);

	  return candidate;
	}


}