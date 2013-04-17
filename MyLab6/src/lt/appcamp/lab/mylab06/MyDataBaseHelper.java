package lt.appcamp.lab.mylab06;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * MyDatabaseHelper
 * 
 * @author Tadas Valaitis
 * @see http 
 *      ://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper
 *      .html
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {
	/** database settings */
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "my.db";

	/** table list */
	protected static final String TABLE_TWEETS = "tweets";

	/** Constant for _id column **/
	protected static final String KEY_ID = BaseColumns._ID;

	/** Other columns for Countries table **/
	protected static final String KEY_TWEET_USER = "user";
	protected static final String KEY_TWEET_DATETIME = "datetime";
	protected static final String KEY_TWEET_CONTENT = "content";

	/** table create statements */
	private static final String SQL_CREATE_TABLE_TWEETS = "CREATE TABLE " + TABLE_TWEETS + " (" + KEY_ID + "  INTEGER PRIMARY KEY, " + KEY_TWEET_USER + " TEXT NOT NULL DEFAULT ''," + KEY_TWEET_DATETIME + " TEXT NOT NULL DEFAULT ''," + KEY_TWEET_CONTENT + " TEXT NOT NULL DEFAULT '')";

	public MyDataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create table
		db.execSQL(SQL_CREATE_TABLE_TWEETS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TWEETS);
		onCreate(db);
	}

	/**
	 * Removes Database file
	 * 
	 * @param context
	 */
	public static void deleteDatabase(Context context) {
		context.deleteDatabase(DATABASE_NAME);
	}

}
