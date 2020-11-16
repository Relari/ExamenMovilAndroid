package com.example.test;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Procesar extends Activity {

	private TextView textView;
	private StringBuilder mensaje = new StringBuilder();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_procesar);
		
		//Referencia a los objetos del layout
		textView = (TextView) findViewById( R.id.txtresultado);
		//Recupera parametros y los muestra en el TextView
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		 if ( bundle != null ) {
			 mensaje.append( bundle.getString("Mostrar"));
		 }
		 textView.setText( mensaje );
		 
		//++++++++
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.procesar, menu);
		return true;
	}

}
