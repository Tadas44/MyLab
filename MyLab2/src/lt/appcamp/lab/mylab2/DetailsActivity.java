package lt.appcamp.lab.mylab2;

import android.os.Bundle;
/**
 * 
 * @author Tadas Valaitis
 *
 */
public class DetailsActivity extends BaseActivity{

	protected static final String TAG = "DetailsActivity";

	@Override
	String tag() {
		// TODO Auto-generated method stub
		return TAG;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
	}
	
	
}
