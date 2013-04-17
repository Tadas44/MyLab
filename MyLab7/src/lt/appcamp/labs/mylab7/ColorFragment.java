package lt.appcamp.labs.mylab7;

import java.util.Random;

import android.R.color;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Color Fragment with random color contructor
 * 
 * @author Tadas Valaitis
 * 
 */
public class ColorFragment extends BaseFragment {
	public static final String TAG = "ColorFragment";

	private int mColor = -1;

	private TextView colorTv;

	private TextView nameTv;

	public ColorFragment() {
		Random rnd = new Random();
		mColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256),
				rnd.nextInt(256));

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// restore from saved state
		if (savedInstanceState != null) {
			mColor = savedInstanceState.getInt("mColorRes");
		}

		// construct the RelativeLayout
		LinearLayout v = new LinearLayout(getActivity());
		v.setBackgroundColor(mColor);
		v.setOrientation(LinearLayout.VERTICAL);
		
		//set layout padding in pixels
		v.setPadding(30, 30, 30, 30);

		colorTv = new TextView(getActivity());
		nameTv = new TextView(getActivity());

		v.addView(colorTv);
		v.addView(nameTv);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		//set Color
		colorTv.setText("Color : "+mColor);
		
		//get arguments from bundle if exists and set to TextView
		Bundle bundle = getArguments();
		if(bundle!=null && bundle.containsKey("id")){
			nameTv.setText("ID : "+ bundle.getInt("id"));
		}
		
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("mColorRes", mColor);
	}

	@Override
	public String tag() {
		// TODO Auto-generated method stub
		return TAG;
	}

}