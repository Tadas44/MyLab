package lt.appcamp.labs.mylab7;

import com.example.labs.mylab7.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * Fragments Main Activity
 * 
 * 
 * @author Tadas Valaitis
 * 
 * @see http://developer.android.com/training/basics/fragments/index.html
 * @see http://developer.android.com/guide/components/fragments.html
 * @see http://developer.android.com/reference/android/app/Fragment.html
 * 
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClickFlexibleUi(View v) {
		Intent intent = new Intent(this, FlexibleUiActivity.class);
		startActivity(intent);
	}

	public void onClickFlexibleStaticUi(View v) {
		Intent intent = new Intent(this, FlexibleStaticUiActivity.class);
		startActivity(intent);
	}

	public void onClickViewPager(View v) {
		Intent intent = new Intent(this, ViewPagerActivity.class);
		startActivity(intent);
	}

}
