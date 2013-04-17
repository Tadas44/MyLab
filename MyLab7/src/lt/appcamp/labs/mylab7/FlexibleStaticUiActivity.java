package lt.appcamp.labs.mylab7;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.labs.mylab7.R;

/**
 * Rotate device to see what happens
 * 
 * 
 * @see http://developer.android.com/training/multiscreen/screensizes.html
 * 
 * @author Tadas Valaitis
 * 
 */
public class FlexibleStaticUiActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		setContentView(R.layout.activity_flexible_static_ui);
	}
}
