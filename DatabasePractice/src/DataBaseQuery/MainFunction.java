package DataBaseQuery;

import Hepler.DBHelper;

public class MainFunction {
	public static void main(String[] args) {
		DBHelper databasehelper = new DBHelper();
		
		databasehelper.create();
		databasehelper.insert();
		databasehelper.update();
		databasehelper.delete();
		databasehelper.closeConnection();
	}
}
