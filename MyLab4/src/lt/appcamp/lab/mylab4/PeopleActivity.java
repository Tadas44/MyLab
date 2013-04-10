
package lt.appcamp.lab.mylab4;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PeopleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_people);

        // get Name
        TextView nameView = (TextView)findViewById(R.id.PeopleName);

        // get Description
        TextView descriptionView = (TextView)findViewById(R.id.PeopleDescription);

        // get Intent
        Intent intent = getIntent();

        Log.d("PeopleActivity",
                "Intent Action and details " + intent.toString() + " " + intent.toURI());

        // get Id from bundle
        long peopleId = intent.getLongExtra("id", 0);

        // get Content Resolver
        ContentResolver cr = getContentResolver();

        // build uri
        Uri uri = MyProvider.CONTENT_URI_PEOPLE.buildUpon().appendPath(String.valueOf(peopleId))
                .build();

        // get Cursor
        Cursor c = cr.query(uri, null, null, null, null);

        if (c != null) {
            c.moveToFirst();
            String name = c.getString(c.getColumnIndex(MyDataBaseHelper.KEY_NAME));
            String description = c.getString(c.getColumnIndex(MyDataBaseHelper.KEY_DESCRIPTION));

            nameView.setText(name);
            descriptionView.setText(description);
        }
    }

}
