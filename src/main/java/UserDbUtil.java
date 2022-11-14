
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class UserDbUtil {

	private DataSource dataSource;

	public UserDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	public void register(User user) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "INSERT INTO user(fname,lname,login,password,dob,mobile) VALUES(?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user.getFirstName());
			myStmt.setString(2, user.getLastName());
			myStmt.setString(3, user.getLogin());
			myStmt.setString(4, user.getPassword());
			myStmt.setDate(5, user.getDateOfBirth());
			myStmt.setString(6, user.getMobileN());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			close(myConn,myStmt,null);
		}
	}
	public boolean login(User user) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		boolean status=false;
		ResultSet myRs = null;
		try {
			myConn=dataSource.getConnection();
			String sql="SELECT id,fname FROM user WHERE login=? and password=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,user.getLogin());
			myStmt.setString(2,user.getPassword());
			
			// execute query
			myRs = myStmt.executeQuery();
			status=myRs.next();
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		return status;
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
		
}
	
	















