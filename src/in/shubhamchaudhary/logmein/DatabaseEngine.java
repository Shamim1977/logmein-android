
package in.shubhamchaudhary.logmein;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseEngine {

	SQLiteOpenHelper DBHELPER;
	SQLiteDatabase database;
	Cursor cursor;

	void saveToDatabase(String username, String password){
		try{
			//make a db connect to it add values to it (next task)
			//WTH
			System.out.print("breakpoint1");

			System.out.print("breakpoint 2");
			database=DBHELPER.getWritableDatabase();
			ContentValues values=new ContentValues();
			if(username!=null && password!=null)
			{
				values.put(dbhelper.USERNAME,username);
				values.put(dbhelper.PASSWORD,password);

				database.insert(dbhelper.TABLE,null, values);
				String[] columns=new String[]{"USERNAME","PASSWORD"};
				cursor=database.query("INVENTORY", columns, null, null, null,null, null);
				Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(cursor));
				//Debug message
				Log.d("tag: main, onClick, try", "database connected and values inserted with primary key");    //Fuck you Vivek
				//Toast.makeText(getApplicationContext(), username+" entered into your inventory", Toast.LENGTH_SHORT).show();
			}

		}catch(Exception e){
			System.out.println("ud gaya");
		}

		database.close();
	}
	String getUsername(){
		String username = null;
		try{
			database=DBHELPER.getReadableDatabase();
			String[] columns=new String[]{"USERNAME","PASSWORD"};
			cursor=database.query("INVENTORY", columns, null, null, null,null, null);
			int indexUsername = cursor.getColumnIndex("USERNAME");
			cursor.moveToLast();
			username  = cursor.getString(0);    //XXX
		}catch(Exception e){
			System.out.println("ud gaya");
			e.printStackTrace();
		}

		database.close();
		return username;
	}
	String getPassword(){
		String password = null;
		try{
			database=DBHELPER.getReadableDatabase();
			String[] columns=new String[]{"USERNAME","PASSWORD"};
			System.out.println("1");
			cursor=database.query("INVENTORY", columns, null, null, null,null, null);
			int indexUsername = cursor.getColumnIndex("PASSWORD");

			cursor.moveToLast();
			password  = cursor.getString(1);    //XXX
		}catch(Exception e){
			System.out.println("ud gaya");
			e.printStackTrace();
		}

		database.close();
		return password;
	}




}
