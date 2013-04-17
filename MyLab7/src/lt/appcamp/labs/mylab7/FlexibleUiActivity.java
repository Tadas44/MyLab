package lt.appcamp.labs.mylab7;

import lt.appcamp.labs.mylab7.SwitchFragment.OnSwitchButtonClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.example.labs.mylab7.R;

/**
 * 
 * Change orientation and see what happens
 * 
 * Different layouts, master->detail view, in one activity
 * 
 * @see http://developer.android.com/training/basics/fragments/communicating.html
 * 
 * @author Tadas Valaitis
 *
 */
public class FlexibleUiActivity extends FragmentActivity implements
		OnSwitchButtonClickListener {

	private static final String TAG = "FlexibleUiActivity";
	
	/** orientation flag **/
	private static boolean isLandscape = false;
	
	/** fragment manager **/
	private FragmentManager fragmentManager;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);

		setContentView(R.layout.activity_flexible_ui);

		// FragmentManager
		fragmentManager = getSupportFragmentManager();
		
		// FragmentTransaction
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		// define fragments
		SwitchFragment switchFragment;
		ColorFragment colorFragment;

		// ---get the current display info---
		WindowManager wm = getWindowManager();
		Display d = wm.getDefaultDisplay();

		if (d.getWidth() > d.getHeight()) {
			// ---landscape mode---
			Log.d(TAG, "onCreate Landscape");

			// set orientation flag
			isLandscape = true;

			// find fragment if it's already added and remove it
			switchFragment = (SwitchFragment) fragmentManager
					.findFragmentByTag(SwitchFragment.TAG);
			if (switchFragment != null) {
				fragmentTransaction.remove(switchFragment);
			}

			// create new fragments
			colorFragment = new ColorFragment();
			switchFragment = new SwitchFragment();

			// Add fragments
			fragmentTransaction.add(R.id.content_fragment_switch,
					switchFragment, SwitchFragment.TAG);
			fragmentTransaction.add(R.id.content_fragment_color, colorFragment,
					colorFragment.TAG);
		} else {

			// --- portrait mode --
			Log.d(TAG, "onCreate Portrait");

			// set orientation flag
			isLandscape = false;

			// find fragment if it's already added and remove it
			switchFragment = (SwitchFragment) fragmentManager
					.findFragmentByTag(SwitchFragment.TAG);
			if (switchFragment != null) {
				fragmentTransaction.remove(switchFragment);
			}

			// find fragment if it's already added and remove it
			colorFragment = (ColorFragment) fragmentManager
					.findFragmentByTag(ColorFragment.TAG);
			if (colorFragment != null) {
				fragmentTransaction.remove(colorFragment);
			}

			// create new fragments
			switchFragment = new SwitchFragment();

			// android.R.id.content refers to the content
			// view of the activity
			fragmentTransaction.replace(android.R.id.content, switchFragment,
					switchFragment.TAG);
		}

		// commit transactions
		fragmentTransaction.commit();
	}

	/**
	 * Implemented from OnSwitchButtonClickListener
	 */
	@Override
	public void onButtonClick(int id) {

		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		// create color fragment
		ColorFragment colorFragment = new ColorFragment();
		// put arguments
		Bundle bundle = new Bundle();
		bundle.putInt("id", id);
		colorFragment.setArguments(bundle);

		if (isLandscape) {
			// if Landscape

			//replace existing fragment with this
			fragmentTransaction.replace(R.id.content_fragment_color,
					colorFragment, colorFragment.TAG);

		} else {
			// if Portrait

			// android.R.id.content refers to the content
			// view of the activity
			fragmentTransaction.replace(android.R.id.content, colorFragment,
					colorFragment.TAG);

		}

		// addToBackStack
		// Try comment this to see how back button behaves
		fragmentTransaction.addToBackStack(null);

		// comit
		fragmentTransaction.commit();
	}
}
