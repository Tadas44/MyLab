
package lt.appcamp.lab.mylab4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


/**
 * MyDatabaseHelper
 * 
 * @author Tadas Valaitis
 * 
 * @see http://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html
 *
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {
    /** database settings */
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "my.db";

    /** table list */
    protected static final String TABLE_COUNTRIES = "countries";
    protected static final String TABLE_PEOPLES = "peoples";
    
    /** Constant for _id column**/
    protected static final String KEY_ID = BaseColumns._ID;
    
    /** Other columns for Countries table **/
    protected static final String KEY_COUNTRY_TITLE = "title";
    protected static final String KEY_FLAG = "flag";
    
    /** Other columns for Countries table **/
    protected static final String KEY_NAME = "name";
    protected static final String KEY_DESCRIPTION = "description";
    protected static final String KEY_COUNTRY_ID = "country_id";
    
    /** table create statements */
    private static final String SQL_CREATE_TABLE_COUNTRIES = "CREATE TABLE "
            + TABLE_COUNTRIES+ " ("
            +KEY_ID+"  INTEGER PRIMARY KEY, "
            +KEY_COUNTRY_TITLE +" TEXT NOT NULL DEFAULT '',"
            +KEY_FLAG +" TEXT NOT NULL DEFAULT '')";
    
    private static final String SQL_CREATE_TABLE_PEOPLES = "CREATE TABLE "
            + TABLE_PEOPLES+ " ("
            +KEY_ID+"  INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_COUNTRY_ID+" INTEGER, "
            +KEY_NAME +" TEXT NOT NULL DEFAULT '',"
            +KEY_DESCRIPTION +" TEXT NOT NULL DEFAULT '')";

    
    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table
        db.execSQL(SQL_CREATE_TABLE_COUNTRIES);
        db.execSQL(SQL_CREATE_TABLE_PEOPLES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("MyDatabase","Upgrading from ["+oldVersion+"] to ["+newVersion+"]");
    
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRIES);
        onCreate(db);
    }

    /**
     * Removes Database file
     * @param context
     */
    public static void deleteDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }
    

}
