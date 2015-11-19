package source;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeBreakerTest {
	
	
	CodeBreaker codeBreaker=new CodeBreaker();
	

	@Test
	public void testRandom() {
		
		String numeroSecreto=codeBreaker.generarRandom(0, 9999);
		Integer numeroSecretoInteger=Integer.parseInt(numeroSecreto); 
		assertEquals(numeroSecretoInteger>=0 && numeroSecretoInteger<=9999, true);
		
	}
	
	@Test
	public void testComprobarRayita4Rayitas(){
		
		codeBreaker.setNumeroUsuario("1234");
		codeBreaker.setNumeroSecreto("4321");
		String rayitas=codeBreaker.comprobarRayita();		
		assertEquals("_ _ _ _ ",rayitas);
		
		
	}
	
	@Test
	public void testComprobar4X(){
		
		codeBreaker.setNumeroUsuario("1234");
		codeBreaker.setNumeroSecreto("1234");
		String xS=codeBreaker.comprobarX();		
		assertEquals("X X X X ",xS);
		
	}
	
	@Test 
	public void testCadenaSinBlancos(){		
	
		String cadenaSinBlancos=codeBreaker.cadenaSinBlancos("X X X X ");		
		assertEquals("XXXX",cadenaSinBlancos);
		
	}
	
	@Test
	public void testcambiarRayitaPorX2Rayitas2X(){
		
		codeBreaker.setNumeroUsuario("3212");
		codeBreaker.setNumeroSecreto("3212");
		String rayitasYX=codeBreaker.cambiarRayitaPorX();
		assertEquals("X X X X ", rayitasYX);
		
	}
	
	
	
	@Test
	public void testGenerarNumeroSecreto(){
		
		
		codeBreaker.generarNumeroSecreto();	
		String numeroSecreto=codeBreaker.getNumeroSecreto();
		assertEquals(numeroSecreto,codeBreaker.getNumeroSecreto());
		
	}
	
	@Test
	public void testJugar4X(){
		
		codeBreaker.setNumeroSecreto("3212");
		String resultadoJuego=codeBreaker.jugar("3212");
		assertEquals("X X X X ", resultadoJuego);		
		
	}
	

	

}
