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
public class MainTransparentActivity extends Activity implements OnClickListener {

	private Camera camera = null;
	private Parameters parameters;
	private ImageButton button;
	   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trans);

        button = (ImageButton) findViewById(R.id.imageButton1);

        try{
            if(camera == null) {
                camera = Camera.open();
                parameters = camera.getParameters();
                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                button.setImageResource(R.drawable.buttonon);
            }
        }catch (Exception e) {

        }

        button.setOnClickListener(this);
        
    }

    public void finish(){
        try{
            if (camera != null){
                 parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                 camera.setParameters(parameters);
                 camera.release();
                 camera = null;
             }
        }catch (Exception e) {

        }
        super.finish();
     }


	public void onClick(View arg0) {
		if(arg0.equals(button)) {
            this.finish();
        }
	}
    
}
