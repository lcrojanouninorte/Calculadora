package com.example.calculadora;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	 private TextView campoTexto;
	 
	 private double operando1;
	 private double operando2;
	 private String operacion;
	 private boolean operandoIngresado;
	 private double resultado;
	 private boolean desdeIgual;
	 private String signo = "";
	 private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        campoTexto = (TextView) findViewById(R.id.textView1);
        campoTexto.setText("0");
        operacion = "";
        operandoIngresado = false;
        desdeIgual =false;
        
    }
    
    public void ButtonOnClick(View v) {
    	 String t;
    	 t = (String) campoTexto.getText();
    	 if(t == "0"){
    		campoTexto.setText("");
    	}
    	if(operandoIngresado){
    	 
  		  campoTexto.setText("");
  		  operandoIngresado = false;
  	  }
    	
        switch (v.getId()) {
          case R.id.button1:  	  
        	   campoTexto.setText(campoTexto.getText() + "1"); 	   
            break;
          case R.id.button2:
        	  campoTexto.setText(campoTexto.getText() + "2");
            break;
          case R.id.button3:
        	  campoTexto.setText(campoTexto.getText() + "3");
        	    break;
          case R.id.button4:
        	  campoTexto.setText(campoTexto.getText() + "4");
        	    break;
          case R.id.button5:
        	  campoTexto.setText(campoTexto.getText() + "5");
        	    break;
          case R.id.button6:
        	  campoTexto.setText(campoTexto.getText() + "6");
        	    break;
          case R.id.button7:
        	  campoTexto.setText(campoTexto.getText() + "7");
        	    break;
          case R.id.button8:
        	  campoTexto.setText(campoTexto.getText() + "8");
        	    break;
          case R.id.button9:
        	  campoTexto.setText(campoTexto.getText() + "9");
        	    break;
          case R.id.button0:
        	  campoTexto.setText(campoTexto.getText() + "0");
              
              break;
          case R.id.buttonClear:
        	  campoTexto.setText("0");
        	  operando1 = 0.0f;
        	  operando2 = 0.0f;
            
              break;
              
              
          case R.id.buttonEquals:
        	  counter++;
        	  if(operando1  != 0.0f ){
        		  desdeIgual = true;
        		  switch(operacion){
        		  case "+":
        			  sumar(); 
        			  ;break;
        		  case "*":
        			  multiplicar();
        			  ;break;
        		  case "/":
        			  dividir(); 
        			  ;break;
        		  case "-":
        			  restar();
        			  ;break;
        		  
        		  }
        		  
        	  }
        	  break;
          case R.id.buttonAdd:
        	  counter = 0;
        	  sumar();     	  
        	  break;
          case R.id.buttonMultiply:
        	  counter = 0;
        	  multiplicar();
        	  ;break;
          case R.id.buttonDivide:
        	  counter = 0;
        	  dividir();
        	  ;break;
          case R.id.buttonSubtract:
        	  counter = 0;
        	  restar();
        	  break;
          case R.id.buttonToggleSign:
        	  counter = 0;
        	 
        	  if(t.contains("-")){
        		  campoTexto.setText(t.replace("-", ""));
        		  
        	  }else{
        		  campoTexto.setText("-"+t);
        	  }
        	  
        	  ;break;
          case R.id.buttonDecimalPoint:
        	  counter = 0;
        	  if(!t.contains(".")){
        		  campoTexto.setText((String)t+"."); 
        	  }
        	  ;break;
          }
    }
private void sumar(){
	 operacion = "+";
	  if( campoTexto.getText() != "" && operando1 == 0.0f){
		  operando1 = Double.parseDouble((String) campoTexto.getText());
		  campoTexto.setText(""+operando1);
		  operandoIngresado = true;
	  }else{
		  if(campoTexto.getText()!= "" ){
			  if(counter > 1){
				  operando1 = operando1 + operando2;
			  }else{
			operando2 = Double.parseDouble((String) campoTexto.getText()); 
			operando1 = operando1 + operando2;
			}
		  	campoTexto.setText(""+operando1);
     	    operandoIngresado = true;
     	    }else{
     	    	if(operando1!=0.0f){
     	    		if(counter > 0){
   					  operando1 = operando1 + operando2;
   				  }
     	    		campoTexto.setText(""+operando1);
     	    		operandoIngresado = true;
     	    		
     	    	}
     	    }
		  }
	desdeIgual =false;
}
private void restar(){
	 operacion = "-";
	  if( campoTexto.getText() != "" && operando1 == 0.0f){
		  operando1 = Double.parseDouble((String) campoTexto.getText());
		  campoTexto.setText(""+operando1);
		  operandoIngresado = true;
	  }else{
		  if(campoTexto.getText()!= "" ){
			  if(counter > 1){
				  operando1 = operando1 - operando2;
			  }else{
			operando2 = Double.parseDouble((String) campoTexto.getText()); 
			operando1 = operando1 - operando2;
			}
		  	campoTexto.setText(""+operando1);
    	    operandoIngresado = true;
    	    }else{
    	    	if(operando1!=0.0f){
    	    		if(counter > 0){
  					  operando1 = operando1 - operando2;
  				  }
    	    		campoTexto.setText(""+operando1);
    	    		operandoIngresado = true;
    	    		
    	    	}
    	    }
		  }
	desdeIgual =false;
}
private void dividir(){
	 operacion = "/";
	  if( campoTexto.getText() != "" && operando1 == 0.0f){
		  operando1 = Double.parseDouble((String) campoTexto.getText());
		  campoTexto.setText(""+operando1);
		  operandoIngresado = true;
	  }else{
		  if(campoTexto.getText()!= "" ){
			  if(counter > 1){
				  operando1 = operando1 / operando2;
			  }else{
			operando2 = Double.parseDouble((String) campoTexto.getText()); 
			operando1 = operando1 / operando2;
			}
		  	campoTexto.setText(""+operando1);
    	    operandoIngresado = true;
    	    }else{
    	    	if(operando1!=0.0f){
    	    		if(counter > 0){
  					  operando1 = operando1 / operando2;
  				  }
    	    		campoTexto.setText(""+operando1);
    	    		operandoIngresado = true;
    	    		
    	    	}
    	    }
		  }
	desdeIgual =false;
}
private void multiplicar(){
	 operacion = "*";
	  if( campoTexto.getText() != "" && operando1 == 0.0f){
		  operando1 = Double.parseDouble((String) campoTexto.getText());
		  campoTexto.setText(""+operando1);
		  operandoIngresado = true;
	  }else{
		  if(campoTexto.getText()!= "" ){
			  if(counter > 1){
				  operando1 = operando1 * operando2;
			  }else{
			operando2 = Double.parseDouble((String) campoTexto.getText()); 
			operando1 = operando1 * operando2;
			}
		  	campoTexto.setText(""+operando1);
    	    operandoIngresado = true;
    	    }else{
    	    	if(operando1!=0.0f){
    	    		if(counter > 0){
  					  operando1 = operando1 * operando2;
  				  }
    	    		campoTexto.setText(""+operando1);
    	    		operandoIngresado = true;
    	    		
    	    	}
    	    }
		  }
	desdeIgual =false;
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Calc c = new Calc();
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
