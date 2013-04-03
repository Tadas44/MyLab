package lt.appcamp.lab.mylab2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Lab 2 - Using Intents
 * 
 * @author Tadas Valaitis
 * 
 *         Intent - An Intent object is a bundle of information. It contains
 *         information of interest to the component that receives the intent
 *         (such as the action to be taken and the data to act on) plus
 *         information of interest to the Android system (such as the category
 *         of component that should handle the intent and instructions on how to
 *         launch a target activity)
 * 
 * @see http://developer.android.com/guide/components/intents-filters.html
 * @see http://developer.android.com/training/basics/intents/index.html
 * @see http://developer.android.com/reference/android/content/Intent.html
 */
public class MainActivity extends BaseActivity {

	protected static final String TAG = "MainActivity";

	protected static final String INTENT_ACTION = "lt.appcamp.lab.doesntmatter.LETS_DO_SOMETHING";

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

	/**
	 * Button event
	 * 
	 * @param v
	 */
	public void onClickDetailsActivity(View v) {
		Intent intent = new Intent(this, DetailsActivity.class);
		startActivity(intent);
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
	 * Button event
	 * 
	 * @param v
	 */
	public void onClickIntentFilterActivity(View v) {
		// INTENT_ACTION = "lt.appcamp.lab.doesntmatter.LETS_DO_SOMETHING"
		// Same action in manifest file
		Intent intent = new Intent(INTENT_ACTION);
		startActivity(intent);
	}

	/**
	 * Button event
	 * 
	 * @param v
	 */
	public void onClickCall(View v) {

		// start native android component Intent.ACTION_DIAL
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:102"));
		startActivity(intent);
	}

	/**
	 * Button event
	 * 
	 * @param v
	 */
	public void onClickClose(View v) {
		//Finish Main Activity
		finish();
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
				TextView tv = (TextView) findViewById(R.id.textView_select_info);
				tv.setText("Launch Select Activity - SelectedId:" + selectedId);

				break;
			case RESULT_CANCELED:
				Log.w(TAG, "onActivityResults Canceled");
				break;
			}

		}
	}

}
