import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Horizon {

	public static void connect() throws ClassNotFoundException{
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/"+
		"d6d38dp6fnlb5u","nxomzfynxtfbwx", "CTNlpUsfCT4DJj6ke7FpTkTHzK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
