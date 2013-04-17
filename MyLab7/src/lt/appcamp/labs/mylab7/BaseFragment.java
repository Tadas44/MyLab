package lt.appcamp.labs.mylab7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	public abstract String tag();

	/** FRAGMENT IS ADDED TO ACTIVITY **/

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onAttach()");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onCreate()");
		super.onCreate(savedInstanceState);
	}

	/** If fragment is from backstack it starts with onCreateView method **/

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onViewStateRestored(Bundle savedInstanceState)");
		super.onViewStateRestored(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onCreateView()");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onActivityCreated()");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onStart()");
		super.onStart();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onResume()");
		super.onResume();
	}

	/** FRAGMENT IS ACTIVE **/

	/** FRAGMENT IS STOPING **/

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		Log.d(tag(), "onSaveInstanceState(Bundle outState)");
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onStop()");
		super.onStop();
	}

	/** After onDestroyView fragment go to backstack **/

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onDestroyView()");
		super.onDestroyView();
	}

	/** If fragment dont go to back stack it is removed **/

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.d(tag(), "onDetach()");
		super.onDetach();
	}

	/** FRAGMENT IS REMOVED FROM ACTIVITY **/

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(tag(),
				"onActivityResult(int requestCode, int resultCode, Intent data)");
		super.onActivityResult(requestCode, resultCode, data);
	}
}
