package lt.appcamp.lab.mylab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Lab 2 - Using Intents
 * 
 * @author Tadas Valaitis
 * 
 * @see http://developer.android.com/guide/topics/resources/runtime-changes.html
 * @see http://developer.android.com/training/basics/activity-lifecycle/recreating.html
 */
public class MainActivity extends BaseActivity {

	protected static final String TAG = "MainActivity";

	protected static final int REQUEST_ACTIVITY_SELECT = 1;

	/** Value used for SelectActivity **/
	private int selectedId = 0; // Default value

	@Override
	String tag() {
		// TODO Auto-generated method stub
		return TAG;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// Set seletectedId to TextView
		updateUi();
	}

	/**
	 * Button event
	 * 
	 * @param v
	 */
	public void onClickSelectActivity(View v) {
		Intent intent = new Intent(this, SelectActivity.class);
		intent.putExtra("id", selectedId);
		startActivityForResult(intent, REQUEST_ACTIVITY_SELECT);

	}

	/**
	 * Get Results From Activity
	 * 
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, intent);

		if (requestCode == REQUEST_ACTIVITY_SELECT) {
			switch (resultCode) {
			case RESULT_OK:
				// Get Results back from intent
				selectedId = intent.getIntExtra("id", 0);

				// Set Results to TextView
				updateUi();

				break;
			case RESULT_CANCELED:
				Log.w(TAG, "onActivityResults Canceled");
				break;
			}

		}
	}

	/**
	 * updateUi for TextView
	 */
	protected void updateUi() {
		TextView tv = (TextView) findViewById(R.id.textView_select_info);
		tv.setText("Launch Select Activity - SelectedId:" + selectedId);
	}

	/**
	 * Save selectedId
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub

		// Put Id to saved Instance
		outState.putInt("id", selectedId);
		super.onSaveInstanceState(outState);
	}
	
	/**
	 * Restore selectedId
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// Get ID from savedInstance
		selectedId = savedInstanceState.getInt("id");
		super.onRestoreInstanceState(savedInstanceState);
	}

}
