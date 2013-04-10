package lt.appcamp.lab.mylab4;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * 
 * People Activity
 * 
 * Uses SearchView
 * Uses ContentResolver
 * 
 * 
 * @author Tadas Valaitis
 *
 */
public class PeopleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_people_details);

		//setup search
		setupSearch();
		
		// get info from intent
		parseIntent(getIntent());

	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		
		//parse intent
		parseIntent(intent);
	}

	/**
	 * Setup SearchView
	 */
	private void setupSearch() {

		// Use the Search Manager to find the SearchableInfo related to this
		// Activity.
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchableInfo searchableInfo = searchManager
				.getSearchableInfo(getComponentName());

		// Bind the Activity's SearchableInfo to the Search View
		SearchView searchView = (SearchView) findViewById(R.id.searchView);
		searchView.setSearchableInfo(searchableInfo);
	}
	/**
	 * Determines if intent has SEARCH_ACTION or has "id" passed from CountryActivity
	 * @param intent
	 */
	private void parseIntent(Intent intent) {
		
		//Log Intent info
		Log.d("PeopleActivity", "Intent: " + intent.toString());
		if (intent.getExtras() != null)
			Log.d("PeopleActivity", "Extras: " + intent.getExtras().toString());
		if (intent.getData() != null)
			Log.d("PeopleActivity", "Data: " + intent.getData().toString());

		//If intent has ACTION_SEARCH 
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {

			//Check if Data exists
			if (intent.getData() != null) {

				// Eg. content://lt.appcamp.lab.mylab4/people/242
				Uri uri = intent.getData();

				//update UI
				updateUi(uri);
			}

		} else {

			// get id from intent
			long id = intent.getLongExtra("id", 0);

			if (id > 0) {
				
				// build uri appending id
				Uri uri = MyProvider.CONTENT_URI_PEOPLE.buildUpon()
						.appendPath(String.valueOf(id)).build();

				//update UI
				updateUi(uri);
			}

		}
	}

	private void updateUi(Uri uri) {

		// get Name
		TextView nameView = (TextView) findViewById(R.id.PeopleName);

		// get Description
		TextView descriptionView = (TextView) findViewById(R.id.PeopleDescription);

		// get Content Resolver
		ContentResolver cr = getContentResolver();

		// get Cursor
		Cursor c = cr.query(uri, null, null, null, null);

		if (c != null) {
			
			//Move to first element
			c.moveToFirst();
			
			//get Name
			String name = c.getString(c
					.getColumnIndex(MyDataBaseHelper.KEY_NAME));
			//get Description
			String description = c.getString(c
					.getColumnIndex(MyDataBaseHelper.KEY_DESCRIPTION));

			//set name and description
			nameView.setText(name);
			descriptionView.setText(description);
			
			//Close cursor
			c.close();
		}
	}

}
