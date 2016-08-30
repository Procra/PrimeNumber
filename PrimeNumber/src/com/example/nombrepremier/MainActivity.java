package com.example.nombrepremier;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
	@SuppressLint("ShowToast")
	public void sendMessage(View view){
		try{
			EditText nombreATesterString = (EditText) findViewById(R.id.input);
			Integer nombreATesterInt = Integer.parseInt(nombreATesterString.getText().toString());
			if(nombreATesterInt > 100000){Toast.makeText(getBaseContext(), "Le nombre est trop grand", 5).show();}
			else{
				Boolean test = true;
				if(nombreATesterInt < 0){test = false;}
				else if(nombreATesterInt != 0 && nombreATesterInt != 1){
					for(int i = 2; i <= nombreATesterInt/2; i++){
						if(nombreATesterInt != i && nombreATesterInt%i == 0){
							test = false;
							break;
						}
					}
				}
		
				String message = "";
				if(test == true){message = "C'est un nombre premier";}
				else if(test == false){message = "Ce n'est pas un nombre premier";}
				Toast.makeText(getBaseContext(), message, 5).show();
			}
		}
		catch(Exception e){
			Toast.makeText(getBaseContext(), "Le nombre est trop grand", 5).show();
		}
	}
}
