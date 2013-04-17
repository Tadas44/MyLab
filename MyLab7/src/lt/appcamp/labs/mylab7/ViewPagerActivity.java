package lt.appcamp.labs.mylab7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.labs.mylab7.R;

/**
 * 
 * @author Tadas Valaitis
 * 
 * 
 * @see http://developer.android.com/training/animation/screen-slide.html
 * @see http
 *      ://developer.android.com/reference/android/support/v4/view/ViewPager.
 *      html
 * 
 */
public class ViewPagerActivity extends FragmentActivity {

	private ViewPager pager;
	private MyPagerAdapter pagerAdapter;
	private static final int NUM_PAGES = 50;

	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		setContentView(R.layout.activity_view_pager);

		///get ViewPager
		pager = (ViewPager) findViewById(R.id.pager);
		
		//get FragmentPagerAdapter
		pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
		
		//setAdapter
		pager.setAdapter(pagerAdapter);

	}

	/**
	 * FragmentPagerAdapter
	 * 
	 * try FragmentStatePagerAdapter and see lifecycle differences 
	 * 
	 * @author Tadas Valaitis
	 *
	 */
	private class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {

			// create color fragment
			ColorFragment colorFragment = new ColorFragment();
			// put arguments
			Bundle bundle = new Bundle();
			bundle.putInt("id", position);
			colorFragment.setArguments(bundle);

			return colorFragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_PAGES;
		}

	}
}
