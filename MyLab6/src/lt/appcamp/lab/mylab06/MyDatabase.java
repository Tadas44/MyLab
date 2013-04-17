package lt.appcamp.lab.mylab06;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * MyDatabase class
 * 
 * @author Tadas Valaitis
 * @see http 
 *      ://developer.android.com/reference/android/database/sqlite/SQLiteDatabase
 *      .html
 * @see http://developer.android.com/training/basics/data-storage/databases.html
 */
public class MyDatabase extends MyDataBaseHelper {

	public MyDatabase(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/****************** QUERY ****************/

	/**
	 * get Tweet Cursor
	 * 
	 * @return Cursor at position -1
	 */
	public Cursor getTweetCursor() {
		return getReadableDatabase().query(TABLE_TWEETS, new String[] { "*" }, null, null, null, null, KEY_TWEET_DATETIME + " DESC");
	}

	/************ INSERT *********/

	/**
	 * Insert entry
	 * 
	 * @param contentValues
	 * @throws JSONException
	 */
	public void insertTweet(JSONObject result) throws JSONException {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, result.getString("id"));
		values.put(KEY_TWEET_DATETIME, result.getString("created_at"));
		values.put(KEY_TWEET_USER, result.getString("from_user"));
		values.put(KEY_TWEET_CONTENT, result.getString("text"));
		getWritableDatabase().replace(TABLE_TWEETS, null, values);
	}

	/**
	 * Insert using transactions
	 * 
	 * @param contentValues
	 * @throws JSONException
	 */
	public void insertTweets(JSONArray result) {
		final SQLiteDatabase db = getWritableDatabase();

		db.beginTransaction();
		try {

			for (int index = 0; index < result.length(); index++) {
				insertTweet(result.getJSONObject(index));
			}
			db.setTransactionSuccessful();
		} catch (Exception e) {
			Log.d("MyLab", "Exception " + e.getMessage());
		} finally {
			db.endTransaction();
		}
	}

}
