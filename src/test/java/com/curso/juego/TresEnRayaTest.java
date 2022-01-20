package com.curso.juego;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TresEnRayaTest {
	
	private TresEnRaya tresEnRaya;
		
	
	//metodo que se ejecuta antes de cada test
	@Before
	public void prepararPrueba() {
		this.tresEnRaya = new TresEnRaya(); 
	}

    //REQUISITO 1 PRUEBA 1
	@Test(expected = RuntimeException.class)
    public void whenCoordXEstaFueraTableroThenRuntimeException() throws Exception {  
        tresEnRaya.jugar(5, 2); //coordenada X y Coordenada Y
    }
	
	 //REQUISITO 1 PRUEBA 2
	@Test(expected = RuntimeException.class)
    public void whenCoordYEstaFueraTableroThenRuntimeException() throws Exception {  
        tresEnRaya.jugar(2, 5); //coordenada X y Coordenada Y
    }

    @Test(expected = RuntimeException.class)
   public void whenPosicionadoSobrePosicionOcupadaThenRuntimeException() throws RuntimeException {
    	tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(2, 1); //ocupado debe lanzar una excepcion 
   }
    
    //Poner una ficha en una posicion vacia

    @Test
    public void whenXYBienYPosicionVaciaThenPoneFichaXY() {
    	
    	// preparo la prueba
    	//TresEnRaya tresEnRaya = new TresEnRaya();
    	
    	//espero que en la posicion del array 1, 0 este dibujada una X
    	char espero = 'X';
    	
    	//ejecuta la funcionalidad a probar
    	tresEnRaya.jugar(2, 1);
    	
    	char resultado = tresEnRaya.getContenidoCelda(2,1);
    	
    	if ( espero !=resultado ) {
    		fail("Espero una x en la posicon 2 1 pero he recibidfo " + resultado);
    	}
    	
    }
    
    
    @Test
    public void whenPrimeraTiradaThenJugadorEsX() {
    	
    	// preparo los datos iniciales de la prueba
    	//TresEnRaya tresEnRaya = new TresEnRaya();
    	
    	// defini que espero 
    	char jugadorEsperado = 'X';
    	
    	//ejecuto el metodo
    	// recogo el resultado 
    	char jugador = tresEnRaya.getJugadorActual();
    	
    	//si lo que espero es distinto a lo esperado lanzo fail
    	if ( jugadorEsperado !=jugador ) {
    		fail("Esperoque el jugador sea X pero es " + jugador);
    	}
    	
    }
    
    
    // Si jugador anterior X ahora O
    @Test
    public void whenJugadorAntesXThenJugadorActualEsO() {
    	
    	tresEnRaya.jugar(1, 1);  // X ha jugado
    	char jugador = tresEnRaya.getJugadorActual();
    	
    	assertTrue(jugador == 'O');
    	
    }
    
    @Test
    public void whenJugadorAntesOThenJugadorActualEsX() {
    	
    	tresEnRaya.jugar(1, 1);  // X ha jugado
    	tresEnRaya.jugar(1, 2);  // O ha jugado
    	char jugador = tresEnRaya.getJugadorActual();
    	
    	assertTrue(jugador == 'X');
    	
    }
    
    @Test
    public void cuandoJugadorHaceLineaHorizontalThenGana(){
        String ganador = null;
        ganador = tresEnRaya.jugar(2, 1); //X
        ganador = tresEnRaya.jugar(1, 1); //O
        ganador = tresEnRaya.jugar(2, 2); //X
        ganador = tresEnRaya.jugar(1, 2); //O
        ganador = tresEnRaya.jugar(2, 3); //X
        assertEquals(ganador, "X es el ganador");
        
    }
    
    @Test
    public void cuandoJugadorHaceLineaVertialThenGana(){
        String ganador = null;
        ganador = tresEnRaya.jugar(1, 2); //X
        ganador = tresEnRaya.jugar(1, 1); //O
        ganador = tresEnRaya.jugar(2, 2); //X
        ganador = tresEnRaya.jugar(2, 1); //O
        ganador = tresEnRaya.jugar(3, 2); //X
        assertEquals(ganador, "X es el ganador");
        
    }
          
    
    @Test
    public void cuandoJugadorHaceLineaDiagonalIzdaThenGana(){
        String ganador = null;
        ganador = tresEnRaya.jugar(1, 1); //X
        ganador = tresEnRaya.jugar(1, 2); //O
        ganador = tresEnRaya.jugar(2, 2); //X
        ganador = tresEnRaya.jugar(2, 1); //O
        ganador = tresEnRaya.jugar(3, 3); //X
        assertEquals(ganador, "X es el ganador");
        
    }
    
     @Test
    public void cuandoJugadorHaceLineaDiagonalDrchThenGana(){
        String ganador = null;
        ganador = tresEnRaya.jugar(3, 1); //X
        ganador = tresEnRaya.jugar(1, 2); //O
        ganador = tresEnRaya.jugar(2, 2); //X
        ganador = tresEnRaya.jugar(3, 3); //O
        ganador = tresEnRaya.jugar(1, 3); //X
        assertEquals(ganador, "X es el ganador");
        
    }
    
    
    
    
    
    
       
    
    
    

}
