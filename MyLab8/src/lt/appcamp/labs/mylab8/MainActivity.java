package lt.appcamp.labs.mylab8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * @author Tadas Valaitis
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onClickCheckList(View v){
		Intent intent = new Intent(this,CheckListActivity.class);
		startActivity(intent);
	}
	
	public void onClickCompass(View v){
		Intent intent = new Intent(this,CompassActivity.class);
		startActivity(intent);
	}
	
	public void onClickGyrometer(View v){
		Intent intent = new Intent(this,GyrometerActivity.class);
		startActivity(intent);
	}

}
