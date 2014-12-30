package com.light.luz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.Html;

/**
 * Class with the information about the author of the application
 * @author juanma
 *
 */
public class AboutActivity extends Activity {

	private TextView text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        text = (TextView) findViewById(R.id.about);
        
        //editamos el texto con un código html
        text=(TextView) findViewById(R.id.about);
        text.setText(Html.fromHtml("<p><b>Luz</b></p><p>Juan Manuel Jurado Ruiz " +
        		"</p><p><i>jmj23elviso@gmail.com</i><p><p>"+getString(R.string.application_about) +
        		" dispositivos"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_about, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
