package lt.appcamp.lab.mylab5;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Lab 5 - ListView with ArrayAdapter
 * 
 * @author Vykintas Valkaitis
 * 
 * @see http://developer.android.com/reference/android/widget/ArrayAdapter.html
 * @see http://developer.android.com/reference/android/widget/ListView.html
 */
public class ArrayListViewActivity extends Activity {

	/** Output data */
	protected static final ArrayList<String> countries = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_list_view);

		// generate output data
		countries.add("Lithuania");
		countries.add("Latvia");
		countries.add("Estonia");
		countries.add("Finland");
		countries.add("Norway");
		countries.add("Austria");
		countries.add("Slovakia");
		countries.add("Hungary");
		countries.add("Croatia");
		countries.add("Italy");
		countries.add("France");
		countries.add("China");
		countries.add("Belarus");
		countries.add("Ukraine");
		countries.add("Poland");
		countries.add("Russia");
		countries.add("Georgia");
		countries.add("Azerbaijan");
		countries.add("Armenia");
		countries.add("Iran");
		countries.add("Turkey");
		countries.add("Greece");
		countries.add("Republic of Macedonia");
		countries.add("Bulgaria");

		// find ListView
		ListView list = (ListView) findViewById(R.id.CountryList);

		// create adapter
		CountryArrayAdapter adapter = new CountryArrayAdapter(this, R.layout.view_array_list_item, R.id.CountryTitle, countries);

		// assign adapter to ListView
		list.setAdapter(adapter);
	}

	private class CountryArrayAdapter extends ArrayAdapter<String> {

		public CountryArrayAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
			super(context, resource, textViewResourceId, objects);
		}
	}
}
