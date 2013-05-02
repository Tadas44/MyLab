package lt.appcamp.labs.mylab8;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * 
 * @author Tadas Valaitis
 * 
 */
public class CheckListActivity extends Activity {

	private LinearLayout linearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_checklist);

		// Layout for EditText and CheckList items
		linearLayout = (LinearLayout) findViewById(R.id.linearLayout_checkList);

		// Edit text
		final EditText editText = (EditText) findViewById(R.id.editText_chechList);

		// listen when user press Enter
		editText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
							|| (keyCode == KeyEvent.KEYCODE_ENTER)) {
						String newItem = editText.getText().toString();
						addItem(newItem);
						editText.setText("");
						return true;
					}
				return false;
			}
		});

	}

	private void addItem(String newItem) {

		// Create LayoutParams
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		// Create New CheckListItemView
		CheckListItemView itemView = new CheckListItemView(this);
		itemView.setLayoutParams(lp);
		itemView.setText(newItem);

		// add view to layout
		linearLayout.addView(itemView);
	}
}
