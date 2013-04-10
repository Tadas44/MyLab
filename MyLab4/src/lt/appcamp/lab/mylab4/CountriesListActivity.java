package lt.appcamp.lab.mylab4;

import java.io.IOException;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * 
 * CountriesListActivity. SearchView for search implementation (API 11+).
 * MyDatabase for CountryCursorAdapter.
 * 
 * @see http://developer.android.com/guide/topics/search/index.html
 * @see http://developer.android.com/training/search/index.html
 * 
 * @author Tadas Valaitis
 */

public class CountriesListActivity extends Activity {

	/** Database **/
	private MyDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countries_list);

		// setup search
		setupSearch();

		// find ListView
		ListView list = (ListView) findViewById(R.id.CountryList);

		// Delete database, and create new one
		MyDatabase.deleteDatabase(getApplicationContext());

		// DataBase
		database = new MyDatabase(this);

		// Populate database
		ContentPopulator populator = new ContentPopulator(database);
		populator.populatePeoples();
		populator.populateCountries();

		// create adapter
		CountryCursorAdapter adapter = new CountryCursorAdapter(this,
				database.getCountryCursor());

		// assign adapter to ListView
		list.setAdapter(adapter);

		// set onClick listener
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int pos, long id) {
				// TODO Auto-generated method stub

				// StartCountryActivity
				Intent i = new Intent(CountriesListActivity.this,
						CountryActivity.class);
				i.putExtra("id", id);
				startActivity(i);
			}
		});
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

	private class CountryCursorAdapter extends CursorAdapter {

		public CountryCursorAdapter(Context context, Cursor cursor) {
			super(context, cursor, 0);
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			// find TextView
			TextView textview = (TextView) view.findViewById(R.id.CountryTitle);
			TextView countView = (TextView) view
					.findViewById(R.id.CountryPeopleCount);

			// get title from cursor
			String title = cursor.getString(cursor.getColumnIndex("title"));

			// get Count
			String count = cursor.getString(cursor
					.getColumnIndex(BaseColumns._COUNT));

			// set title
			textview.setText(title);

			// set People Count
			countView.setText(count);

			// find ImageView
			ImageView image = (ImageView) view.findViewById(R.id.CountryFlag);

			try {
				// get drawable from assets
				Drawable drawable = Drawable.createFromStream(
						getAssets()
								.open(cursor.getString(cursor
										.getColumnIndex("flag"))), null);

				// assign image drawable
				image.setImageDrawable(drawable);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			return View.inflate(context, R.layout.view_country_cursor_list_item, null);
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		database.close();

	}
}
