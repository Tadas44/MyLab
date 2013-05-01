package lt.appcamp.labs.mylab8;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class GyrometerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_gyrometer);

		final CompassGyrometerView gyrometer = (CompassGyrometerView) findViewById(R.id.gyrometerView);
		final SeekBar seekBarBearing = (SeekBar) findViewById(R.id.seekBar_bearing);
		final SeekBar seekBarPitch = (SeekBar) findViewById(R.id.seekBar_pitch);
		final TextView bearingText = (TextView) findViewById(R.id.textView_bearing);
		final TextView pitchText = (TextView) findViewById(R.id.textView_pitch);

		//set initial pitch to zero
		seekBarPitch.setProgress(90);

		seekBarBearing
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						bearingText.setText("Gyrometer Bearing: " + progress);
						gyrometer.setBearing((float) progress);
						gyrometer.invalidate();
					}
				});

		seekBarPitch.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				float pitch = seekBarToPitch(progress);
				pitchText.setText("Gyrometer pitch: " + pitch);
				gyrometer.setPitch(pitch);
				gyrometer.invalidate();
			}
		});

	}

	public float seekBarToPitch(int progress) {
		return (float) progress - 90;
	}
}
