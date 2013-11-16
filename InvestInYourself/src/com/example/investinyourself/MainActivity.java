package com.example.investinyourself;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.KeyEvent;
import android.view.Window;
import android.view.View.OnKeyListener;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.*;


public class MainActivity extends Activity {
	//need custom IME, save feature, password protection, helpful hints

	private EditText edittext;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      IntroDialog cdd = new IntroDialog(this); //creating dialog box
      cdd.show();
    }
    
    protected void onPause(){
    	super.onPause();
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	addKeyListener();
    }
    
    public void addKeyListener(){
    	    // get edittext component
    	    edittext = (EditText) findViewById(R.id.myText);
    	    // add a keylistener to monitor the keyboard activity...
    	    edittext.setOnKeyListener(new OnKeyListener() {//anonymous method
    	    public boolean onKey(View v, int keyCode, KeyEvent event) {
    	    	
    	        // if the users press enter, create a new line
    	        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_0)) {
    	        	if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
    	        		edittext.setText("\n");
    	        		return true;
    	        	}
    	        }
    	        return false;
    	        }
    	    });
    	}

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    
}

class IntroDialog extends Dialog implements OnClickListener{
	public Activity c;
	public Dialog d;
	public Button confirm;
	
	public IntroDialog(Activity a){
		super(a);
		this.c = a;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.intro);
		confirm = (Button) findViewById(R.id.btn_confirm);
		confirm.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.btn_confirm:
			dismiss();
			break;
		default:
			break;
		}
		dismiss();
	}
}
