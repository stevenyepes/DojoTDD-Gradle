package source;

import java.util.Random;
import java.util.StringTokenizer;

public class CodeBreaker {
	
	private String numeroSecreto;
	private String numeroUsuario;	
	
	public CodeBreaker() {
		super();		
		this.generarNumeroSecreto();
	}	
	
	public String getNumeroSecreto() {
		return numeroSecreto;
	}
	public void setNumeroSecreto(String numeroSecreto) {
		this.numeroSecreto = numeroSecreto;
	}
	public String getNumeroUsuario() {
		return numeroUsuario;
	}
	public void setNumeroUsuario(String numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public  String generarRandom(int min, int max) {
				
		if (min >= max) {
			
			throw new IllegalArgumentException("max debe ser mayor que min");
		}

		Random r = new Random();	
		
		Integer numeroRandom=r.nextInt((max - min) + 1) + min;
		String numeroRandomString=numeroRandom.toString(); 		
		
		return numeroRandomString;		
	}
	
	public void generarNumeroSecreto(){
		
		String random=this.generarRandom(0, 9999);
		StringBuffer sb = new StringBuffer(4);
		sb.insert(0, random);	
		
			for(int i=0;i<(4-random.length());i++){
				
				sb.insert(0, "0");			
			}
			
			this.numeroSecreto=sb.toString();		
	}
	
	public String eliminarCaracteresRepetidos(){
		
		String sinRepetir="";
		String aux="";
		for(int i=0; i<numeroUsuario.length();i++){
			aux=numeroUsuario.substring(i, i+1);
			if(!sinRepetir.contains(aux)){
				
				sinRepetir=sinRepetir.concat(aux);								
			}			
		}
		return sinRepetir;				
	}	
	
	public String comprobarRayita(){
		
		char [] numeroSecretoString=this.numeroSecreto.toCharArray();
		char [] numeroUsuarioString=this.eliminarCaracteresRepetidos().toCharArray();
		String rayitas="";
		
		for(char numeroS : numeroSecretoString){			
			for(char numeroU : numeroUsuarioString){
				
				if(numeroS==numeroU){
					
					rayitas=rayitas.concat("_ ");
				}				
			}			
		}
		
		return rayitas;		
	}
	
	public String comprobarX(){
		
		char [] numeroSecretoString=this.numeroSecreto.toCharArray();
		char [] numeroUsuarioString=this.numeroUsuario.toCharArray();
		String xS="";
		
		for(int i=0; i<numeroSecretoString.length;i++){					
				
				if(numeroSecretoString[i]==numeroUsuarioString[i]){
					
					xS=xS.concat("X ");					 
				}			
		}
		
		return xS;		
	}
	
	public String cadenaSinBlancos(String cadena){
		
		String cadenaSinBlancos="";
		StringTokenizer token = new StringTokenizer(cadena);		
		 
		while (token.hasMoreElements()){
			
		   cadenaSinBlancos+= token.nextElement();		
		}		
		
		return cadenaSinBlancos;		
	}
	
	public String cambiarRayitaPorX(){
		
		String rayitas=this.comprobarRayita();
		String x=this.comprobarX();
		String xSinBlancos=this.cadenaSinBlancos(x);
				
		for(int i=0;i<xSinBlancos.length();i++){
			
			rayitas=rayitas.concat("X ");			
		}
		
		String resultado=rayitas.substring(2*xSinBlancos.length(),rayitas.length());
		
		return resultado;		
	}	
	
	public String jugar(String numeroUs){		
		
		this.setNumeroUsuario(numeroUs);
		String resultado=this.cambiarRayitaPorX();			
		return resultado;		
	}
}
