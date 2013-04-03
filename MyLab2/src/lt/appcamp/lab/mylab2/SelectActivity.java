package lt.appcamp.lab.mylab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * 
 * @author Tadas Valaitis
 *
 */
public class SelectActivity extends BaseActivity {
	protected static final String TAG = "SelectActivity";

	private int newId;
	private int oldId;

	@Override
	String tag() {
		// TODO Auto-generated method stub
		return TAG;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);

		// Get Data From MainActivity
		Intent i = getIntent();
		oldId = i.getIntExtra("id", 0);

		// Set Value From MainActivity to TextView
		TextView tv = (TextView) findViewById(R.id.textView_intent_value);
		tv.setText("Value from Main Activity:" + oldId);

		setupSeekBar();
	}

	/**
	 * Setup Seek Bar for new value
	 * 
	 * View objects will be discussed in future
	 */
	private void setupSeekBar() {
		// TODO Auto-generated method stub

		// TextView
		final TextView tv = (TextView) findViewById(R.id.textView_new_value);

		// Get Seek Bar
		SeekBar sb = (SeekBar) findViewById(R.id.seekBar);

		// Set old value to seekBar
		sb.setProgress(oldId);

		// Track Changes
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				tv.setText("New Value:" + progress);
				newId = progress;
			}
		});
	}
	
	/**
	 * Button event
	 * @param v
	 */
	public void onClickSelect(View v) {
		//Add new selected id to intent and send Results to MainActivity
		Intent returnIntent = new Intent();
		returnIntent.putExtra("id", newId);
		setResult(RESULT_OK, returnIntent);
		finish();
	}
}
