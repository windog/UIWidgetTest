package com.example.uiwidgettest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private Button b,b1,b2,b3;
	private EditText et;
	private ImageView iv;
	private ProgressBar pr,pr1;
	
   
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);
        
        et =  (EditText) findViewById(R.id.edit_text);
        
        iv = (ImageView) findViewById(R.id.image_view);
        
        b1 = (Button) findViewById(R.id.button_1);
        b1.setOnClickListener(this);
        
        pr = (ProgressBar) findViewById(R.id.progressbar);
        
        b2 = (Button) findViewById(R.id.button_2);
        b2.setOnClickListener(this);
        
        pr1 = (ProgressBar) findViewById(R.id.progressbar_1);
        
        b3 = (Button) findViewById(R.id.button_3);
        b3.setOnClickListener(this);
    }
	
	//当一个活动中button比较多时可以使此活动实现点击事件监听的接口，在类中声明onclick方法，用switch分别实现各个button的功能会清楚明白一些
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button:
//			String i = String.valueOf(v.getId());
//			Log.d("all", i);
			String input = et.getText().toString();
			if (input == null) {
				Toast.makeText(MainActivity.this, "请输入内容，不要耍我！", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
			}
			
			break;
		
		case R.id.button_1:
			//一个button，一个imageview，两张图片来回切换的效果
			int p = iv.getDrawable().getLevel();
			
			if (p == 1) {
				iv.getDrawable().setLevel(2);
			} else {
				iv.getDrawable().setLevel(1);
			}
			
			break;
			
		case R.id.button_2:
			if (pr.getVisibility() == View.VISIBLE) {
				pr.setVisibility(View.GONE);
			} else {
				pr.setVisibility(View.VISIBLE);
			}
		
		//每点击一次，就在横向进度条上增加10的进度，最高100
		case R.id.button_3:
			int prog = pr1.getProgress();
			prog = prog + 10;
			pr1.setProgress(prog);
		default:
			break;
		}
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
