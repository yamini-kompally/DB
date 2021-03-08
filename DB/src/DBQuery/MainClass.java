package DBQuery;

import Database.HelperDB;

public class MainClass {
	public static void main(String[] args) {
		HelperDB databasehelper = new HelperDB();
		
		databasehelper.create();
		databasehelper.insert();
		databasehelper.update();
		databasehelper.delete();
		databasehelper.closeConnection();
	}
}
