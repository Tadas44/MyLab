package lt.appcamp.lab.mylab06;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * LoaderActivity. Load tweets from Twitter API to local DB
 * 
 * @see http://developer.android.com/reference/android/os/AsyncTask.html
 * @author Vykintas Valkatis
 */
public class LoaderActivity extends Activity {

	protected static enum DataLoadTaskResults {
		SUCCESS, ERROR
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);
	}

	@Override
	public void onResume() {
		super.onResume();

		// spinner animation
		Animation animation = AnimationUtils.loadAnimation(LoaderActivity.this, R.anim.spinner);
		animation.setRepeatCount(Animation.INFINITE);

		// set animation
		ImageView vSpinner = (ImageView) findViewById(R.id.Spinner);
		vSpinner.startAnimation(animation);

		// start data load async task
		new DataLoadTask().execute();
	}

	protected void onDataLoadTaskComplete(DataLoadTaskResults result) {
		// start result activity
		startActivity(new Intent(this, ResultActivity.class));
	}

	private class DataLoadTask extends AsyncTask<Void, Void, DataLoadTaskResults> {
		@Override
		protected DataLoadTaskResults doInBackground(Void... params) {
			WebServiceClient ws = WebServiceClient.getInstance();
			MyDatabase db = new MyDatabase(LoaderActivity.this);

			try {
				JSONObject result = ws.search(ResultActivity.TWEET_QUERY);
				Log.d("MyLab", "Exception " + result.toString());
				db.insertTweets(result.getJSONArray("results"));
			} catch (JSONException e) {
				return DataLoadTaskResults.ERROR;
			}

			return DataLoadTaskResults.SUCCESS;
		}

		@Override
		protected void onCancelled(DataLoadTaskResults result) {
			onDataLoadTaskComplete(DataLoadTaskResults.ERROR);
		}

		@Override
		protected void onPostExecute(DataLoadTaskResults result) {
			onDataLoadTaskComplete(result);
		}
	}
}
