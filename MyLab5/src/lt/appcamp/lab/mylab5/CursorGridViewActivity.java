package lt.appcamp.lab.mylab5;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Lab 5 - GridView with CursorAdapter
 * 
 * @author Vykintas Valkaitis
 * 
 * @see http://developer.android.com/reference/android/widget/GridView.html
 * @see http://developer.android.com/reference/android/widget/CursorAdapter.html
 */
public class CursorGridViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cursor_grid_view);
		
		// find ListView
		GridView grid = (GridView) findViewById(R.id.CountryList);

		// DataBase
		MyDataBase database = new MyDataBase(this);

		// create adapter
		CountryCursorAdapter adapter = new CountryCursorAdapter(this, database.getCountryCursor());

		// assign adapter to ListView
		grid.setAdapter(adapter);
	}

	private class CountryCursorAdapter extends CursorAdapter {

		public CountryCursorAdapter(Context context, Cursor cursor) {
			super(context, cursor, 0);
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			// find TextView
			TextView textview = (TextView) view.findViewById(R.id.CountryTitle);
			
			// get title from cursor
			String title = cursor.getString(cursor.getColumnIndex("title"));
			
			// set title
			textview.setText(title);
			
			// find ImageView
			ImageView image = (ImageView) view.findViewById(R.id.CountryFlag);

			try {
				// get drawable from assets
				Drawable drawable = Drawable.createFromStream(getAssets().open(cursor.getString(cursor.getColumnIndex("flag"))), null);

				// assign image drawable
				image.setImageDrawable(drawable);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			return View.inflate(context, R.layout.view_cursor_grid_item, null);
		}
	}}
