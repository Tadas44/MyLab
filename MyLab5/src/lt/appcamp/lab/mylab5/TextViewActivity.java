package lt.appcamp.lab.mylab5;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 * Lab 5 - TextView
 * 
 * @author Vykintas Valkaitis
 * 
 * @see http://developer.android.com/reference/android/widget/TextView.html
 */
public class TextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_view);
		
		// set text from HTML
		((TextView) findViewById(R.id.HTMLTextView)).setText(Html.fromHtml("TextView with HTML formatting.<br /><b>Etiam porta</b> sem malesuada magna <i>mollis euismod</i>.<br /><br />Praesent commodo cursus magna, vel scelerisque nisl consectetur et. <strong>Donec ullamcorper nulla non metus auctor fringilla.</strong>"));
	}

}
