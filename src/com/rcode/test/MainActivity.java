package com.rcode.test;

import com.google.zxing.WriterException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private EditText et_message;
	private ImageView iv_Rcode;
	private int widthPixels;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_message = (EditText) findViewById(R.id.editText1);
		iv_Rcode = (ImageView) findViewById(R.id.bitmap_code);
		// 获取屏幕分辨率
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		widthPixels = dm.widthPixels;

	}

	public void onCreatCode(View v) {
		String string = et_message.getText().toString();
		try {
			// Bitmap bitmap = BitmapUtil.create2DCoderBitmap(string,
			// widthPixels, 800);
			Bitmap bitmap = BitmapUtil.createQRCode(string, widthPixels);
			if (bitmap != null) {
				iv_Rcode.setImageBitmap(bitmap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
