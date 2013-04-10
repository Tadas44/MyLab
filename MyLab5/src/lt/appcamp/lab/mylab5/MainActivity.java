package lt.appcamp.lab.mylab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Lab 5 - Views
 * 
 * @author Vykintas Valkaitis
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onVerticalLinearLayoutClick(View view) {
		startActivity(new Intent(this, VerticalLinearLayoutActivity.class));
	}

	public void onHorizontalLinearLayoutClick(View view) {
		startActivity(new Intent(this, HorizontalLinearLayoutActivity.class));
	}

	public void onRelativeLayoutClick(View view) {
		startActivity(new Intent(this, RelativeLayoutActivity.class));
	}

	public void onTextViewClick(View view) {
		startActivity(new Intent(this, TextViewActivity.class));
	}

	public void onEditTextClick(View view) {
		startActivity(new Intent(this, EditTextActivity.class));
	}

	public void onButtonsClick(View view) {
		startActivity(new Intent(this, ButtonsActivity.class));
	}

	public void onArrayListViewClick(View view) {
		startActivity(new Intent(this, ArrayListViewActivity.class));
	}

	public void onCursorListViewClick(View view) {
		startActivity(new Intent(this, CursorListViewActivity.class));
	}

	public void onArrayGridViewClick(View view) {
		startActivity(new Intent(this, ArrayGridViewActivity.class));
	}

	public void onCursorGridViewClick(View view) {
		startActivity(new Intent(this, CursorGridViewActivity.class));
	}

}
