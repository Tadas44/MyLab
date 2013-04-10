package lt.appcamp.lab.mylab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Lab 5 - GridView with ArrayAdapter
 * 
 * @author Vykintas Valkaitis
 * 
 * @see http://developer.android.com/reference/android/widget/ArrayAdapter.html
 * @see http://developer.android.com/reference/android/widget/GridView.html
 */
public class ArrayGridViewActivity extends Activity {

	/** Output data */
	protected static final ArrayList<String> countries = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_grid_view);

		// generate output data
		countries.add("Lithuania.png");
		countries.add("Latvia.png");
		countries.add("Estonia.png");
		countries.add("Finland.png");
		countries.add("Norway.png");
		countries.add("Austria.png");
		countries.add("Slovakia.png");
		countries.add("Hungary.png");
		countries.add("Croatia.png");
		countries.add("Italy.png");
		countries.add("France.png");
		countries.add("China.png");

		// find ListView
		GridView list = (GridView) findViewById(R.id.CountryList);

		// create adapter
		CountryArrayAdapter adapter = new CountryArrayAdapter(this, R.layout.view_array_list_item, R.id.CountryTitle, countries);

		// assign adapter to ListView
		list.setAdapter(adapter);
	}

	private class CountryArrayAdapter extends ArrayAdapter<String> {

		public CountryArrayAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
			super(context, resource, textViewResourceId, objects);
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			if (view == null) {
				// create new view by inflating form XML
				view = View.inflate(ArrayGridViewActivity.this, R.layout.view_array_grid_item, null);
			}

			// find ImageView
			ImageView image = (ImageView) view.findViewById(R.id.CountryFlag);

			try {
				// get drawable from assets
				Drawable drawable = Drawable.createFromStream(getAssets().open(countries.get(position)), null);

				// assign image drawable
				image.setImageDrawable(drawable);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return view;
		}
	}
}
