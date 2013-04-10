
package lt.appcamp.lab.mylab4;

import java.util.HashMap;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

public class MyProvider extends ContentProvider {

    private MyDataBaseHelper mMyDatabaseHelper;

    /** Authority **/
    public static final String AUTHORITY = "lt.appcamp.lab.mylab4";

    /** CONTENT URI VALUES **/
    public static final Uri CONTENT_URI_PEOPLE = Uri
            .parse("content://lt.appcamp.lab.mylab4/people");

    public static final Uri CONTENT_URI_COUNTRY = Uri
            .parse("content://lt.appcamp.lab.mylab4/country");

    /** PROJECTION MAP FOR SEARCH **/
    private static final HashMap<String, String> SEARCH_PROJECTION_MAP;
    static {
        SEARCH_PROJECTION_MAP = new HashMap<String, String>();
        SEARCH_PROJECTION_MAP.put(SearchManager.SUGGEST_COLUMN_TEXT_1, MyDatabase.KEY_NAME + " AS "
                + SearchManager.SUGGEST_COLUMN_TEXT_1);
        SEARCH_PROJECTION_MAP.put("_id", MyDatabase.KEY_ID + " AS " + "_id");
    }

    /** constants used to differentiate between the different URI requests. **/
    private static final int PEOPLE = 100;
    private static final int PEOPLE_FROM_COUNTRY = 101;
    private static final int PEOPLE_DETAILS = 102;
    private static final int COUNTRIES = 200;
    private static final int COUNTRY = 201;
    private static final int SEARCH = 900;

    /** URI MATCHER **/
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // lt.appcamp.app.db.impulsprovider/gym_list
        uriMatcher.addURI(AUTHORITY, "people", PEOPLE);
        uriMatcher.addURI(AUTHORITY, "people/#", PEOPLE_DETAILS);
        uriMatcher.addURI(AUTHORITY, "people/country/#", PEOPLE_FROM_COUNTRY);
        uriMatcher.addURI(AUTHORITY, "country", COUNTRIES);
        uriMatcher.addURI(AUTHORITY, "country/#", COUNTRY);

        // For search
        uriMatcher.addURI(AUTHORITY, SearchManager.SUGGEST_URI_PATH_QUERY + "/*", SEARCH);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case PEOPLE:
                return "vnd.android.cursor.dir/vnd.appcamp.lab.lab4.people";
            case PEOPLE_DETAILS:
                return "vnd.android.cursor.item/vnd.appcamp.lab.lab4.people";
            case PEOPLE_FROM_COUNTRY:
                return "vnd.android.cursor.dir/vnd.appcamp.lab.lab4.people";
            case COUNTRIES:
                return "vnd.android.cursor.dir/vnd.appcamp.lab.lab4.country";
            case COUNTRY:
                return "vnd.android.cursor.item/vnd.appcamp.lab.lab4.country";
            case SEARCH:
                return SearchManager.SUGGEST_MIME_TYPE;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();

        mMyDatabaseHelper = new MyDataBaseHelper(context);
        return true;

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder) {

        SQLiteDatabase db = mMyDatabaseHelper.getReadableDatabase();

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // find matcher uri
        int match = uriMatcher.match(uri);

        Log.d("MyProvider", "Uri " + uri + " Match " + match);

        switch (match) {

            case PEOPLE_FROM_COUNTRY:

                // set Table Name
                qb.setTables(MyDataBaseHelper.TABLE_PEOPLES);

                // get countryId from uri
                // content://lt.appcamp.lab.mylab4/people/country/id
                String countryId = uri.getPathSegments().get(2);

                qb.appendWhere(MyDataBaseHelper.KEY_COUNTRY_ID + " = " + countryId);
                break;
            case PEOPLE_DETAILS:
                // set Table Name
                qb.setTables(MyDataBaseHelper.TABLE_PEOPLES);

                // get countryId from uri
                // content://lt.appcamp.lab.mylab4/people/id
                String id = uri.getPathSegments().get(1);

                qb.appendWhere(MyDataBaseHelper.KEY_ID + " = " + id);
                break;

            case SEARCH:
                qb.setTables(MyDataBaseHelper.TABLE_PEOPLES);
                qb.appendWhere(MyDatabase.KEY_NAME + " LIKE \"%" + uri.getPathSegments().get(1)
                        + "%\"");
                qb.setProjectionMap(SEARCH_PROJECTION_MAP);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        return qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO Auto-generated method stub
        return 0;
    }

}
