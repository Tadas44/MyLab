package lt.appcamp.labs.mylab9;

import android.content.Intent;
import android.widget.RemoteViewsService;


/**
 * App Widget remote view bind service
 * http://developer.android.com/reference/android/widget/RemoteViewsService.html
 * @author vykintas
 *
 */
public class WidgetService extends RemoteViewsService {
	@Override
	public RemoteViewsFactory onGetViewFactory(Intent arg0) {
		return new WidgetFactory(getApplicationContext());
	}
}