
package lt.appcamp.lab.mylab4;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * 
 * MyDatabase class
 * 
 * @author Tadas Valaitis
 * 
 * 
 * @see http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
 * @see http://developer.android.com/training/basics/data-storage/databases.html
 */
public class MyDatabase extends MyDataBaseHelper {

    public MyDatabase(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /****************** QUERY ****************/

    /**
     * getCountry Cursor
     * 
     * @return Cursor at position -1
     */
    public Cursor getCountryCursor() {

        final SQLiteDatabase db = getReadableDatabase();

        // Subquery to get People Count
        String Subquery = "(SELECT COUNT(*) FROM " + TABLE_PEOPLES + " WHERE " + KEY_COUNTRY_ID
                + " = " + TABLE_COUNTRIES + "." + KEY_ID + " ) as " + BaseColumns._COUNT;

        // table name
        String table = TABLE_COUNTRIES;
        // projection - columns to select
        String[] columns = {
                KEY_ID, KEY_COUNTRY_TITLE, KEY_FLAG, Subquery
        };
        // selection where
        String selection = null;
        // selecton args if we use ? ? ?
        String[] selectionArgs = null;
        // Group By
        String groupBy = null;
        // Having
        String having = null;
        // Order By title DESC
        String orderBy = KEY_COUNTRY_TITLE + " DESC";

        return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    /************ INSERT *********/

    /**
     * Insert using transactions
     * 
     * @param contentValues
     */
    public void insertPeople(ArrayList<ContentValues> contentValues) {
        final SQLiteDatabase db = getWritableDatabase();

        // begin transaction
        db.beginTransaction();
        try {

            for (int i = 0; i < contentValues.size(); i++) {
                db.insert(TABLE_PEOPLES, "", contentValues.get(i));
            }

            // If no exceptions set transaction succesfull
            db.setTransactionSuccessful();

            Log.i("MyDatabase", "Inserted Rows:" + contentValues.size());
        } finally {

            db.endTransaction();
        }
    }

    /**
     * Simple insert
     * 
     * @param country
     * @param name
     * @param about
     * @return Row ID or -1 if error
     */
    public long insertCountry(int id, String title, String flag) {
        final SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, id);
        values.put(KEY_COUNTRY_TITLE, title);
        values.put(KEY_FLAG, flag);

        return db.insert(TABLE_COUNTRIES, "", values);

    }

    /*** UPDATE FOR SELF STUDIES **/

    /** DELETE FOR SELF STUDIES **/

}
