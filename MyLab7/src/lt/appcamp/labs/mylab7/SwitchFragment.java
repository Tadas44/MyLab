package lt.appcamp.labs.mylab7;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.labs.mylab7.R;

/**
 * 
 * SwitchFragment
 * 
 * 
 * @author Tadas Valaitis
 *
 */
public class SwitchFragment extends BaseFragment implements OnClickListener {
	public static final String TAG = "SwitchFragment";
	
	private OnSwitchButtonClickListener listener;
	
	public interface OnSwitchButtonClickListener{
		public void onButtonClick(int id);
	}
	
	/**
	 * get reference to listener
	 * 
	 * this is how to communicate with activity
	 */
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		try{
			listener = (OnSwitchButtonClickListener) activity;
		}catch (ClassCastException e) {
			throw new ClassCastException("Activity ["+activity.toString()+"] must implement OnSwitchButtonClickListener");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_switch, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		Button btn1 = (Button) getView().findViewById(
				R.id.button_switch_fragment_1);
		btn1.setOnClickListener(this);

		Button btn2 = (Button) getView().findViewById(
				R.id.button_switch_fragment_2);
		btn2.setOnClickListener(this);
	}

	@Override
	public String tag() {
		// TODO Auto-generated method stub
		return TAG;
	}

	/**
	 * Implemented from OnClickListener interface
	 */
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case (R.id.button_switch_fragment_1):
			listener.onButtonClick(1);
			break;
		case (R.id.button_switch_fragment_2):
			listener.onButtonClick(2);
			break;
		}
	}
}
