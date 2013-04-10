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
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class CountryActivity extends Activity {

	private long countryId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country);

		// get country id from Intent
		countryId = getIntent().getLongExtra("id", 0);

		// get Cursor From ContentResolver
		ContentResolver cr = getContentResolver();

		// Buil Uri
		Uri uri = MyProvider.CONTENT_URI_PEOPLE.buildUpon()
				.appendPath("country").appendPath(String.valueOf(countryId))
				.build();

		// get Cursor From Uri content://lt.appcamp.lab.mylab4/people/country/id
		Cursor cursor = cr.query(uri, null, null, null, null);

		// Cursor Adapter
		CountryCursorAdapter adapter = new CountryCursorAdapter(
				CountryActivity.this, cursor, false);

		// get List View
		ListView list = (ListView) findViewById(android.R.id.list);

		// Set Adapter
		list.setAdapter(adapter);

		// set Click listener
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long id) {
				// StartCountryActivity
				Intent i = new Intent(CountryActivity.this,
						PeopleActivity.class);
				i.putExtra("id", id);
				startActivity(i);

			}
		});
	}

	public class CountryCursorAdapter extends CursorAdapter {

		public CountryCursorAdapter(Context context, Cursor c,
				boolean autoRequery) {
			super(context, c, autoRequery);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			// TODO Auto-generated method stub

			// get View
			TextView nameView = (TextView) view.findViewById(R.id.PeopleName);

			// get name
			String name = cursor.getString(cursor
					.getColumnIndex(MyDataBaseHelper.KEY_NAME));

			// set Name
			nameView.setText(name);

		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup vg) {
			// TODO Auto-generated method stub
			return View.inflate(context,
					R.layout.view_country_cursor_list_item, null);
		}

	}

}
