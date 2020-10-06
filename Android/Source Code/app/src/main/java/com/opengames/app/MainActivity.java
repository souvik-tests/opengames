package com.opengames.app;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Typeface;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout full_area;
	private LinearLayout footer_area;
	private LinearLayout logo_area;
	private TextView appname;
	private TextView tagline;
	private TextView footer_txt;
	
	private TimerTask time1;
	private Intent int1 = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		full_area = (LinearLayout) findViewById(R.id.full_area);
		footer_area = (LinearLayout) findViewById(R.id.footer_area);
		logo_area = (LinearLayout) findViewById(R.id.logo_area);
		appname = (TextView) findViewById(R.id.appname);
		tagline = (TextView) findViewById(R.id.tagline);
		footer_txt = (TextView) findViewById(R.id.footer_txt);
	}
	private void initializeLogic() {
		appname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/msemibold.ttf"), 0);
		tagline.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/montserrat_light.ttf"), 0);
		footer_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/montserrat_light.ttf"), 0);
		time1 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						int1.setClass(getApplicationContext(), HomeActivity.class);
						startActivity(int1);
						time1.cancel();
						finish();
					}
				});
			}
		};
		_timer.schedule(time1, (int)(2000));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
