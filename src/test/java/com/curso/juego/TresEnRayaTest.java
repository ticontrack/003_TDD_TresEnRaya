package com.curso.juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author begonaolea
 */
public class TresEnRayaTest {
    
    private TresEnRaya tresEnRaya;
    
    public TresEnRayaTest() {
    }
    
    @Before
    public void setUp() {
        tresEnRaya = new TresEnRaya();
    }
    
    @After
    public void tearDown() {
    }

   @Test(expected = RuntimeException.class)
    public void whenCoordXEstaFueraTableroThenRuntimeException() {     
        tresEnRaya.jugar(5, 2);
    }

    @Test(expected = RuntimeException.class)
    public void whenCoordYEstaFueraTableroThenRuntimeException() {
        tresEnRaya.jugar(2, 5);
    }

     @Test(expected = RuntimeException.class)
    public void whenPosicionadoSobrePosicionOcupadaThenRuntimeException() {
        tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(2, 1);
    }
    
    @Test
    public void givenPrimerTurnoThenX(){
        assertEquals(new Character('X'), tresEnRaya.getProximoJugador());
    }
    
    @Test
    public void givenJugadorActualOThenX(){
        tresEnRaya.jugar(1,1);  //juega X
         tresEnRaya.jugar(1,2);  //juega 0
         assertEquals(new Character('X'), tresEnRaya.getProximoJugador());
    }

    
    @Test
    public void givenJugadorActualXThenO(){
            tresEnRaya.jugar(1,1);  //juega X
            //Siguiente jugador debe ser X
            assertEquals(new Character('O'), tresEnRaya.getProximoJugador());
    }
    
    @Test
    public void cuandoJugadorNoGana(){
        String ganador = tresEnRaya.jugar(1, 1);
        assertEquals("No hay ganador" , ganador );
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
     
     @Test
     public void cuandoTodasCeldasLLenasThenEmpate(){
         String ganador = null;
         ganador = tresEnRaya.jugar(1, 1); //X
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(1, 2); //O
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(1, 3); //X
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(2, 2); //O
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(3, 2); //X
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(2, 3); //O
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(2, 1); //X
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(3, 1); //O
         assertEquals(ganador,"No hay ganador");
         ganador = tresEnRaya.jugar(3, 3); //X
         assertEquals(ganador, "Hay empate!!");
         
     }
     
     
     
     
     
}
