package lt.appcamp.lab.mylab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 
 * @author Tadas Valaitis
 *
 */
public abstract class BaseActivity extends Activity {

	/**
	 * get TAG for logging
	 */
	abstract String tag();

	/**
	 * Called when the activity is first created. This is where you should do
	 * all of your normal static set up Ñ create views, bind data to lists, and
	 * so on.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onCreate(Bundle savedInstanceState)");
		super.onCreate(savedInstanceState);
	}

	/**
	 * Called after the activity has been stopped, just prior to it being
	 * started again.
	 */
	@Override
	protected void onRestart() {
		Log.d(tag(), "onRestart()");
		super.onRestart();

	}

	/**
	 * Called just before the activity becomes visible to the user.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onStart()");
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
		Log.d(tag(), "onRestoreInstanceState(Bundle savedInstanceState)");
		super.onRestoreInstanceState(savedInstanceState);
	}

	/**
	 * Called just before the activity starts interacting with the user.
	 */
	@Override
	protected void onResume() {
		Log.d(tag(), "onResume()");
		super.onResume();

	}

	/************************* ACTIVITY IS CREATED AND INTERACTING WITH USER ***************************/

	/**
	 * Called when the system is about to start resuming another activity.
	 */
	@Override
	protected void onPause() {
		Log.d(tag(), "onPause()");
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
		Log.d(tag(), "onStop()");
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
		Log.d(tag(), "onSaveInstanceState(Bundle outState)");
		super.onSaveInstanceState(outState);
	}

	/**
	 * Called before the activity is destroyed. This is the final call that the
	 * activity will receive.
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onDestroy()");
		super.onDestroy();
	}

	/********** ACTIVITY IS DESTROYED *******/

	/**** OTHER IMPORTANT CALLBACKS **/
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onActivityResult(int requestCode, int resultCode, Intent data)");
		super.onActivityResult(requestCode, resultCode, data);
	}
	
}
