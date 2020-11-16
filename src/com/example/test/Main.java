package com.example.test;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{
	
	EditText eNombre, eApellido, eEdad, eEstatura, ePeso;
	Button bCalcular, bLimpiar;
	Spinner Opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
        eNombre = (EditText)findViewById(R.id.txtNombre);
        eApellido = (EditText)findViewById(R.id.txtApellido);
        eEdad = (EditText)findViewById(R.id.txtEdad);
        eEstatura = (EditText)findViewById(R.id.txtEstatura);
        ePeso = (EditText)findViewById(R.id.txtPeso);
        Opc = (Spinner)findViewById(R.id.spinner1);
        bCalcular = (Button)findViewById(R.id.btnCalcular);
        bLimpiar = (Button)findViewById(R.id.btnLimpiar);
        
        bCalcular.setOnClickListener(this);
        bLimpiar.setOnClickListener(this);
    }
    
    public void Limpiar(){
    	eNombre.setText(null);
    	eApellido.setText(null);
    	eEdad.setText(null);
    	eEstatura.setText(null);
    	ePeso.setText(null);
    	Opc.setSelection(0);
    }

    public String Condicion(){
    	String Nom = eNombre.getText().toString();
    	String Ape = eApellido.getText().toString();
    	Integer Edad = Integer.parseInt(eEdad.getText().toString());
    	Double Estatura = Double.parseDouble(eEstatura.getText().toString());
    	Double Peso = Double.parseDouble(ePeso.getText().toString());
    	    	
    	int i = Opc.getSelectedItemPosition();
    	
    	if(i == 1){
    	
    		return Operacion(Nom, Ape, 1, Edad, Peso, Estatura);
   		
    	}else if(i == 2){
   			
   			return Operacion(Nom, Ape, 0, Edad, Peso, Estatura);
   		
   		}else{
   		
   			return "Seleccione Sexo para realizar la operacion";
       	
   		}
    	
    }
    
    public String DecisionDatos(int sexo, String nombre, String apellido){
    	if(sexo == 1){
    		return "El señor o joven: " + apellido + ", " + nombre;
    	}else{
    		return "La señora o señorita: " + apellido + ", " + nombre;
    	}
    }
    
    public String DecisionIMC(double IMC){
	    if(IMC >= 0 && IMC <= 5){
			return "Tiene Delgadez III y sus futuras enfermedades pueden ser:\n" +
    				"Postración, Astenia, Adinamia, Enfermedades Degeneretivas\n" +
    				"y Peligro de Muerte.";
	    }else if(IMC >= 6 && IMC <= 10){
	    	return "Tiene Delgadez II y sus futuras enfermedades pueden ser:\n" +
	    			"Anorexia, Bulimia, Osteoporosis y Autoconsumo de Masa " +
	    			"Muscular.";
	    }else if(IMC >= 11 && IMC <= 18.5){
	    	return "Tiene Delgadez I y sus futuras enfermedades pueden ser:\n" +
	    			"Transtornos Digestivos, Debilidad, Fatiga Cronica, Estrés, " +
	    			"Ansiedad y Difunción Hormonal.";
	    }else if(IMC >= 18.6 && IMC <= 24.9){
	    	return "Tiene Peso Normal y esta de:\n" +
	    			"Estado Normal, Buen Nivel de Energia, Vitalidad y Buena " +
    				"Condición Fisica.";
	    }else if(IMC >= 25 && IMC <= 29.9){
	    	return "Tiene Sobrepeso y sus futuras enfermedades pueden ser:\n" +
 	   				"Fatiga, Enfermedades Digestivas, Problemas Cardiacos, " +
    				"Mala Circulación en Piernas y Varices.";
    	}else if(IMC >= 30 && IMC <= 34.9){
    		return "Tiene Obesidad I y sus futuras enfermedades pueden ser:\n" +
    				"Diabetes, Hipertensión, Enfermedades Cardiovasculares," +
    				"Problemas Articulares, Rodilla y Columna, Cálculos Billares.";
    	}else if(IMC >= 35 && IMC <= 39.9){
    		return "Tiene Obesidad II y sus futuras enfermedades pueden ser:\n" +
    				"Diabetes, Cáncer, Angina de Pecho, Infartos, Troboflebitis," +
    				"Arteroscierosis, Embolias, Alteraciones Menstruación.";
    	}else {
    		return "Tiene Obesidad III y sus futuras enfermedades pueden ser:\n" +
    				"Falta de aire, Apnea, Somnolencia, Trombosis Pulmonar, Ulceras " +
    				"Varicosas, Reflujo Esofático, Cáncer de Prostata de Colon Uterino " +
    				"y Mamario, Discriminación Social, Laboral y Sexual, Susceptible a " +
    				"Accidentes.";
    	}
    	
    }
    
    public String DecisionGrasa(int sexo, int edad, double grasa){
    	
    	if(sexo == 1){
    		if(edad >= 10 && edad <= 30){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 12% a 18% en grasa";
    		}else if(edad >= 31 && edad <= 40){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 13% a 19% en grasa";
    		}else if(edad >= 41 && edad <= 50){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 14% a 20% en grasa";
    		}else if(edad >= 51 && edad <= 60){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 16% a 20% en grasa";
    		}else{
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 17% a 21% en grasa";
    		}
    	}else{
    		if(edad >= 10 && edad <= 30){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 20% a 26% en grasa";
    		}else if(edad >= 31 && edad <= 40){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 21% a 27% en grasa";
    		}else if(edad >= 41 && edad <= 50){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 22% a 28% en grasa";
    		}else if(edad >= 51 && edad <= 60){
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 22% a 30% en grasa";
    		}else{
    			return "El porcentaje de grasa es " + grasa +"%\n" +
    					"Lo cual debes tener entre 22% a 31% en grasa";
    		}
    	}
    }
    
    public String MostrarPeso(double peso){
    	return "Tu peso ideal seria " + peso + " Kilos aprox.";
    }
    
    public double redondear(double numero) {
        return Math.round(numero * Math.pow(10, 1)) / Math.pow(10, 1);
    }
    
    public String Operacion(String Nombre, String Apellido, int Sexo, int Edad, double Peso, double Estatura){
    	
    	double IMC, Grasa, Ideal;
    	
    	IMC = Peso/(Math.pow(Estatura, 2));
		Grasa = (1.20 * redondear(IMC)) + (0.23 * Edad) - (10.8 * Sexo) - 5.4;
		Ideal = 0.75 * ( (Estatura * 100) - 150 ) + 50;
		
		return DecisionDatos(Sexo, Nombre, Apellido)+"\n"+
				DecisionIMC(IMC)+"\n"+
				"Su edad es: " + Edad + " años.\n" +
				"Su peso es: " + Peso + " Kilos.\n" +
				"Su estatura es: " + Estatura + " metros.\n" +
				"El porcentaje de IMC es: " + redondear(IMC) + "%\n" +
				DecisionGrasa(Sexo, Edad, redondear(Grasa))+"\n"+
				"El peso ideal seria "+ redondear(Ideal)  + " Kilos aprox.";
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
   	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btnLimpiar:
			Limpiar();
			break;
		case R.id.btnCalcular:
			try{
				Bundle bundle = new Bundle();
				bundle.putString("Mostrar" , Condicion() );
				
				//Intent nos permite enlazar dos actividades
				Intent intent = new Intent( Main.this, Procesar.class );
				//añadir parametros
				intent.putExtras( bundle );
				//ejuta intent
				startActivity( intent );
			}catch(Exception e){
				Toast msj = Toast.makeText(this, "Ingrese todos los Datos.", Toast.LENGTH_LONG);
	    		msj.show();
			}
			break;
			}
		}
   	}


