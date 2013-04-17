package lt.appcamp.lab.mylab06;

import lt.appcamp.lab.mylab06.LoaderActivity.DataLoadTaskResults;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * ResultActivity. Display twitter results from database
 * 
 * @see http://developer.android.com/reference/android/os/Handler.html
 * @see http://developer.android.com/reference/android/os/AsyncTask.html
 * @author Vykintas Valkatis
 */
public class ResultActivity extends Activity {

	// twitter search query
	public static final String TWEET_QUERY = "Boston bombing";

	// activity is running flag
	protected boolean isRunning = false;

	// Results list view
	protected ListView vResults;

	// Adapter
	protected TweetAdapter mAdapter;

	/** data refresh */
	protected static final int DATA_REFRESH_INTERVAL = 5000;
	protected Handler mDataRefreshHandler = new Handler();
	protected Runnable mDataRefreshUpdater = new Runnable() {
		@Override
		public void run() {
			// run asynd data update task if activity is active
			if (isRunning) {
				new DataLoadTask().execute();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		// find view
		vResults = (ListView) findViewById(R.id.Results);

		// create adapter
		mAdapter = new TweetAdapter(this, new MyDatabase(this).getTweetCursor());

		// set list adapter
		vResults.setAdapter(mAdapter);
	}

	@Override
	public void onResume() {
		super.onResume();

		// set running flag
		isRunning = true;

		// start periodic update
		mDataRefreshUpdater.run();
	}

	@Override
	public void onPause() {
		super.onPause();

		// set running flag
		isRunning = false;
	}

	private class TweetAdapter extends CursorAdapter {

		public TweetAdapter(Context context, Cursor cursor) {
			super(context, cursor, 0);
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			((TextView) view.findViewById(R.id.User)).setText(cursor.getString(cursor.getColumnIndex(MyDatabase.KEY_TWEET_USER)));
			((TextView) view.findViewById(R.id.Datetime)).setText(cursor.getString(cursor.getColumnIndex(MyDatabase.KEY_TWEET_DATETIME)));
			((TextView) view.findViewById(R.id.Content)).setText(cursor.getString(cursor.getColumnIndex(MyDatabase.KEY_TWEET_CONTENT)));
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			return View.inflate(context, R.layout.view_tweet, null);
		}

	}

	protected void onDataLoadTaskComplete(DataLoadTaskResults result) {
		// change cursor in adapter
		mAdapter.changeCursor(new MyDatabase(this).getTweetCursor());

		// start next periodic update
		mDataRefreshHandler.postDelayed(mDataRefreshUpdater, DATA_REFRESH_INTERVAL);
	}

	private class DataLoadTask extends AsyncTask<Void, Void, DataLoadTaskResults> {
		@Override
		protected DataLoadTaskResults doInBackground(Void... params) {
			WebServiceClient ws = WebServiceClient.getInstance();
			MyDatabase db = new MyDatabase(ResultActivity.this);

			try {
				JSONObject result = ws.search(ResultActivity.TWEET_QUERY);
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
