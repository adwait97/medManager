import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addTemplate {
	protected static Connection con = null;
	protected static Statement statement = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public final void addAction() throws SQLException, IOException {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		requestParameters(request);
		dbConnect();
		executeQuery(response);
	}

	
public void requestParameters(HttpServletRequest request) {
}

public void dbConnect() throws SQLException {
	if (con == null || con.isClosed()) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        con = (Connection) DriverManager
			      .getConnection("jdbc:mysql://127.0.0.1:3306/mmdb?"
	  			          + "useSSL=false&user=admin&password=admin1234");
    }
}

public void executeQuery( HttpServletResponse response) throws SQLException, IOException{
	
}

}
