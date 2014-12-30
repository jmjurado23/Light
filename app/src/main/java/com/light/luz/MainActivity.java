package com.light.luz;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Contains all the functionality of the applicaction. It is composed for a button to turn on/off the light and an ActionBar
 * button to go to the author information
 * 
 * @author juanma
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	private Camera camera = null;
	private Parameters parameters;
	private TextView text;
	private ImageButton button;
	   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = (TextView) findViewById(R.id.textView1);
        button = (ImageButton) findViewById(R.id.imageButton1);
   
        text.setText(getString(R.string.state_off));
        button.setOnClickListener(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.helpicon:
            	Intent your_intent = new Intent(this, AboutActivity.class);
        		startActivity(your_intent);
                return true;
        }
		return false;
    }

    public void finish(){
    	if (camera != null){
    	         parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
    	         camera.setParameters(parameters);
    	         camera.release();
    	         camera = null;
    	     }
    	     super.finish();
     }
    
    
    public void setState(){
    	try{
            // Turn on/off the camera light
            if(camera == null){
               camera = Camera.open();
               parameters = camera.getParameters();
               parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
               camera.setParameters(parameters);
               text.setText(getString(R.string.state_on));
               button.setImageResource(R.drawable.buttonon);
               
            }else{
               parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
               camera.setParameters(parameters);
               camera.release();
               camera = null;
               text.setText(getString(R.string.state_off));
               button.setImageResource(R.drawable.buttonoff);
            }
         }catch(Exception e){
            //Control errores
         }
    }
    
	

	public void onClick(View arg0) {
		if(arg0.equals(button)){
			setState();
		}
		
	}
	
	

    
}
