package lt.appcamp.labs.mylab9;

import com.example.labs.mylab9.R;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * App Widget Provider
 * http://developer.android.com/reference/android/appwidget/AppWidgetProvider.html
 * @author vykintas
 *
 */
public class WidgetProvider extends AppWidgetProvider {
	public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
		for (int id : ids) {
			// load layout
			RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			// adapter
			Intent intent = new Intent(context, WidgetService.class);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
			intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

			// set stackview adapter
			view.setRemoteAdapter(R.id.AdapterView, intent);
			
			// set textview content
			view.setTextViewText(R.id.TextView, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ac tristique ligula. Cras ut risus elit. Morbi consectetur scelerisque enim in molestie. Nunc facilisis accumsan ipsum sed tristique.");
			
			// set textview content
			view.setImageViewResource(R.id.ImageView, R.drawable.ic_launcher);
			

			// perform an update on the current app widget
			manager.updateAppWidget(id, view);
		}

		super.onUpdate(context, manager, ids);
	}
}
