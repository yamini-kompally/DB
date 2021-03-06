package Hepler;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;

public class DBHelper {
	private Statement stmt = null;
	private Connection con = null;

	public Boolean getConnection() {

		boolean isDBconnectionOpen = true;
		try {
			FileReader reader = new FileReader(
					"C:\\Users\\ADMIN\\eclipse-workspace\\DatabasePractice\\Properities\\DBDetails.Properities");

			Properties p = new Properties();
			p.load(reader);
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:" + p.getProperty("port") + "/java",
					p.getProperty("username"), p.getProperty("password"));
			
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println(e);

			isDBconnectionOpen = false;
		}
		return isDBconnectionOpen;
	}

	public void closeConnection() {

		if (null == con) {
			return;
		}

		if (null != con)
			try {
				stmt = null;
				con.close();
				con = null;
			} catch (SQLException ex) {
				con = null;
			}
	}

	public  void create() {
		try {
			stmt = null;
			getConnection();
			stmt = con.createStatement();
            System.out.println("Database created");
			ResultSet rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			closeConnection();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public  void insert() {
		String id = "1002";
		String age = "20";
		String name = "geeks";

		try {
			stmt = null;
			getConnection();
			stmt = con.createStatement();

			String q1 = "insert into emp values('" + id + "', '" + name + "', '" + age + "')";
			int x = stmt.executeUpdate(q1);
			if (x > 0)
				System.out.println("Successfully Inserted");
			else
				System.out.println("Insert Failed");
			ResultSet rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public  void update() {
		try {
			stmt = null;
			getConnection();
			stmt = con.createStatement();

			String q1 = "update emp set name='Michael Sam' where id=1002";
			int x = stmt.executeUpdate(q1);

			if (x > 0)
				System.out.println("name Successfully Updated");
			else
				System.out.println("ERROR OCCURED :(");
			ResultSet rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public  void delete() {

		try {
			stmt = null;
			getConnection();
			stmt = con.createStatement();

			String q1 = "DELETE FROM EMP WHERE ID >= 1002";

			int x = stmt.executeUpdate(q1);

			if (x > 0)
				System.out.println(" Successfully Deleted");
			else
				System.out.println("ERROR OCCURED :(");

			ResultSet rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
