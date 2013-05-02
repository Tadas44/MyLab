package lt.appcamp.labs.mylab8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 
 * @author Tadas Valaitis
 * 
 * 
 * @see http://developer.android.com/reference/android/widget/TextView.html
 * @see http://developer.android.com/guide/topics/ui/custom-components.html
 */
public class CheckListItemView extends TextView {

	private Paint marginPaint;
	private Paint linePaint;
	private int paperColor;
	private float margin;

	
	public CheckListItemView(Context context, AttributeSet ats, int ds) {
		super(context, ats, ds);
		init();
	}

	public CheckListItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	//We use this constructor, when creating programmatically
	public CheckListItemView(Context context) {
		super(context);
		init();
	}

	/**
	 * Initiate View, get references and create objects
	 */
	private void init() {
		// Get a reference to our resource table.
		Resources myResources = getResources();

		// Create the paint brushes we will use in the onDraw method.
		// Margin for Red Line
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
		
		//Blue Line
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(myResources.getColor(R.color.notepad_lines));

		// Get the paper background color and the margin width.
		paperColor = myResources.getColor(R.color.notepad_paper);
		margin = myResources.getDimension(R.dimen.notepad_margin);
	}

	@Override
	public void onDraw(Canvas canvas) {
		// Color as paper
		canvas.drawColor(paperColor);

		// Draw ruled lines
		// vertical blue line in front
		canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
		//horizontal blue line
		canvas.drawLine(0, getMeasuredHeight()-1, getMeasuredWidth(),
				getMeasuredHeight(), linePaint);

		// Draw red margin
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

		// Move the text across from the margin
		canvas.save();
		canvas.translate(margin, 0);

		// Use the TextView to render the text
		super.onDraw(canvas);
		// remove all modifications to the matrix
		canvas.restore();
	}

}