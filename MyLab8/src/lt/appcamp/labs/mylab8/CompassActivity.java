package lt.appcamp.labs.mylab8;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class CompassActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_compass);

		final CompassView compass = (CompassView) findViewById(R.id.compassView);
		final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar_bearing);
		final TextView bearingText = (TextView) findViewById(R.id.textView_bearing);

		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				bearingText.setText("Compass Bearing: "+progress);
				compass.setBearing(progress);
				compass.invalidate();
			}
		});

	}
}
