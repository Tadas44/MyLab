package lt.appcamp.labs.mylab9;

import com.example.labs.mylab9.R;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * App Adapter View Data Factory
 * http://developer.android.com/reference/android/widget/RemoteViewsService.RemoteViewsFactory.html
 * @author vykintas
 *
 */
public class WidgetFactory implements RemoteViewsService.RemoteViewsFactory {
	
	private Context mContext;
	
	private String[] values = new String[]{
			"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "Nam", "interdum", "nunc", "iaculis", "erat", "iaculis", "pulvinar"
	};
	
	public WidgetFactory(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return values.length;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public RemoteViews getLoadingView() {
		return new RemoteViews(mContext.getPackageName(), R.layout.view_widget_item);
	}

	@Override
	public RemoteViews getViewAt(int position) {
		RemoteViews view = new RemoteViews(mContext.getPackageName(), R.layout.view_widget_item);
		view.setTextViewText(R.id.TextView, values[position]);
		return view;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public void onCreate() {}

	@Override
	public void onDataSetChanged() {}

	@Override
	public void onDestroy() {}
}