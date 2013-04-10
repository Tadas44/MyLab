package lt.appcamp.lab.mylab5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Lab 5 - SQLiteOpenHelper
 * 
 * @author Vykintas Valkaitis
 * 
 * @see http://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html
 */
public class MyDataBase extends SQLiteOpenHelper {
	/** database settings */
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "my.db";
	
	/** table list */
	private static final String TABLE_COUNTRIES = "countries";
	
	/** table create statements */
	private static final String SQL_CREATE_TABLE_COUNTRIES = "CREATE TABLE " + TABLE_COUNTRIES + " (id  INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL DEFAULT '', flag TEXT NOT NULL DEFAULT '')";

	public MyDataBase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create table
		db.execSQL(SQL_CREATE_TABLE_COUNTRIES);
		
		ContentValues values;
		
		// insert debug data
		values = new ContentValues();
		values.put("title", "Lithuania");
		values.put("flag", "Lithuania.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Latvia");
		values.put("flag", "Latvia.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Estonia");
		values.put("flag", "Estonia.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Finland");
		values.put("flag", "Finland.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Norway");
		values.put("flag", "Norway.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Austria");
		values.put("flag", "Austria.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Slovakia");
		values.put("flag", "Slovakia.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Hungary");
		values.put("flag", "Hungary.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Croatia");
		values.put("flag", "Croatia.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "Italy");
		values.put("flag", "Italy.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "France");
		values.put("flag", "France.png");
		db.insert(TABLE_COUNTRIES, null, values);
		
		values = new ContentValues();
		values.put("title", "China");
		values.put("flag", "China.png");
		db.insert(TABLE_COUNTRIES, null, values);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public Cursor getCountryCursor() {
		return getReadableDatabase().query(TABLE_COUNTRIES, new String[]{"*", "id AS _id"}, null, null, null, null, null);
	}
}
