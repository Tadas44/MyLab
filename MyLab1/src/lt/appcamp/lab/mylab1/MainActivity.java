package lt.appcamp.lab.mylab1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Lab 1 - Activity Lifecycle
 * 
 * @author Tadas
 * 
 * @see http://developer.android.com/training/basics/activity-lifecycle/index.html
 * @see http://developer.android.com/guide/components/activities.html
 * @see http://developer.android.com/reference/android/app/Activity.html
 * 
 * 
 */
public class MainActivity extends Activity {

	protected static final String TAG = "MainActivity";

	/**
	 * Called when the activity is first created. This is where you should do
	 * all of your normal static set up Ñ create views, bind data to lists, and
	 * so on.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "onCreate(Bundle savedInstanceState)");
	}

	/**
	 * Called after the activity has been stopped, just prior to it being
	 * started again.
	 */
	@Override
	protected void onRestart() {
		Log.d(TAG, "onRestart()");
		super.onRestart();

	}

	/**
	 * Called just before the activity becomes visible to the user.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onStart()");
		super.onStart();
	}

	/**
	 * This method is called after onStart() when the activity is being
	 * re-initialized from a previously saved state, given here in
	 * savedInstanceState
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onRestoreInstanceState(Bundle savedInstanceState)");
		super.onRestoreInstanceState(savedInstanceState);
	}

	/**
	 * Called just before the activity starts interacting with the user.
	 */
	@Override
	protected void onResume() {
		Log.d(TAG, "onResume()");
		super.onResume();

	}

	/************************* ACTIVITY IS CREATED AND INTERACTING WITH USER ***************************/

	/**
	 * Called when the system is about to start resuming another activity.
	 */
	@Override
	protected void onPause() {
		Log.d(TAG, "onPause()");
		super.onPause();

	}

	/**
	 * Called when the activity is no longer visible to the user. This may
	 * happen because it is being destroyed, or because another activity (either
	 * an existing one or a new one) has been resumed and is covering it.
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onStop()");
		super.onStop();
	}

	/**
	 * The system calls onSaveInstanceState() before making the activity
	 * vulnerable to destruction
	 * 
	 * Not called when Back button pressed
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onSaveInstanceState(Bundle outState)");
		super.onSaveInstanceState(outState);
	}

	/**
	 * Called before the activity is destroyed. This is the final call that the
	 * activity will receive.
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onDestroy()");
		super.onDestroy();
	}

	/********** ACTIVITY IS DESTROYED *******/

}
