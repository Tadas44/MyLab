package lt.appcamp.labs.mylab8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/**
 * 
 * @author Meier R.,Tadas Valaitis
 * 
 * 
 * @see http://developer.android.com/training/custom-views/index.html
 * @see http://developer.android.com/guide/topics/ui/custom-components.html
 * @see http://developer.android.com/guide/topics/graphics/2d-graphics.html
 * 
 * @see http://developer.android.com/reference/android/graphics/Paint.html
 * @see http://developer.android.com/reference/android/view/View.html
 */
public class CompassView extends View {

	private static final String TAG = "CompassView";
	private float bearing;

	/**
	 * Set Commpass bearing in deegrees
	 * 
	 * @param _bearing
	 *            0 - 360
	 */
	public void setBearing(float _bearing) {
		bearing = _bearing;
	}

	public float getBearing() {
		return bearing;
	}

	private Paint markerPaint;
	private Paint textPaint;
	private Paint circlePaint;
	private String northString;
	private String eastString;
	private String southString;
	private String westString;
	private int textHeight;

	public CompassView(Context context) {
		super(context);
		initCompassView();
	}

	public CompassView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCompassView();
	}

	public CompassView(Context context, AttributeSet ats, int defaultStyle) {
		super(context, ats, defaultStyle);
		initCompassView();
	}

	protected void initCompassView() {
		setFocusable(true);

		Resources r = this.getResources();

		circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePaint.setColor(r.getColor(R.color.background_color));
		circlePaint.setStrokeWidth(1);
		circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);

		northString = "N";
		eastString = "E";
		southString = "S";
		westString = "W";

		textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		textPaint.setColor(r.getColor(R.color.text_color));

		// measure textHeight
		textHeight = (int) textPaint.measureText("yY");

		markerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		markerPaint.setColor(r.getColor(R.color.marker_color));
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// The compass is a circle that fills as much space as possible.
		// Set the measured dimensions by figuring out the shortest boundary,
		// height or width.
		int measuredWidth = measure(widthMeasureSpec);
		int measuredHeight = measure(heightMeasureSpec);

		int d = Math.min(measuredWidth, measuredHeight);

		setMeasuredDimension(d, d);
	}

	private int measure(int measureSpec) {
		int result = 0;

		// Decode the measurement specifications.
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if (specMode == MeasureSpec.UNSPECIFIED) {
			// Return a default size of 200 if no bounds are specified.
			result = 200;
		} else {
			// As you want to fill the available space
			// always return the full available bounds.
			result = specSize;
		}
		return result;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int mMeasuredWidth = getMeasuredWidth();
		int mMeasuredHeight = getMeasuredHeight();

		// circle center coordinates
		int px = mMeasuredWidth / 2;
		int py = mMeasuredHeight / 2;
		
		//debug
		Log.d(TAG,"Center points px="+px+", py="+py);
		
		int radius = Math.min(px, py);

		// Draw the background
		canvas.drawCircle(px, py, radius, circlePaint);

		// Rotate our perspective so that the Ôtop' is
		// facing the current bearing.
		canvas.save();
		canvas.rotate(-bearing, px, py);

		// measure text height
		int textWidth = (int) textPaint.measureText("W");

		int cardinalX = px - textWidth / 2;
		int cardinalY = py - radius + textHeight;

		// Draw the marker every 15 degrees and text every 45.
		// 24 markers at all
		for (int i = 0; i < 24; i++) {
			// Draw a marker.
			canvas.drawLine(px, py - radius, px, py - radius + 10, markerPaint);

			// for debug
			Log.d(TAG, "Draw marker[" + i + "] line  startX=" + px
					+ ", startY=" + (py - radius) + ", stopX=" + px + " stopY="
					+ (py - radius + 10));

			canvas.save();
			canvas.translate(0, textHeight);

			// Draw the cardinal points
			if (i % 6 == 0) {
				String dirString = "";
				switch (i) {
				case (0): {
					dirString = northString;
					int arrowY = 2 * textHeight;
					//draw arrow pointer to N
					canvas.drawLine(px, arrowY, px - 5, 3 * textHeight,
							markerPaint);
					canvas.drawLine(px, arrowY, px + 5, 3 * textHeight,
							markerPaint);
					
					break;
				}
				case (6):
					dirString = eastString;
					break;
				case (12):
					dirString = southString;
					break;
				case (18):
					dirString = westString;
					break;
				}
				
				//draw text N,E,W etc.
				canvas.drawText(dirString, cardinalX, cardinalY, textPaint);
				Log.d(TAG,"DrawText text="+dirString+", x="+cardinalX+", y="+cardinalY);
			}

			else if (i % 3 == 0) {
				// Draw the text every alternate 45deg
				String angle = String.valueOf(i * 15);
				float angleTextWidth = textPaint.measureText(angle);

				int angleTextX = (int) (px - angleTextWidth / 2);
				int angleTextY = py - radius + textHeight;
				canvas.drawText(angle, angleTextX, angleTextY, textPaint);
				
				//debug
				Log.d(TAG,"DrawAngleText text="+angle+", x="+angleTextX+", y="+angleTextY);
			}
			//restore matrix
			canvas.restore();

			//rotate canvas 15 degrees
			canvas.rotate(15, px, py);
		}
		canvas.restore();
	}


}
