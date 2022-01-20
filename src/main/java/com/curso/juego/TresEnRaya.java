package com.curso.juego;

public class TresEnRaya {

	    
	    private Character[][] tablero;
	    
	    private Character proximoJugador;

	    public TresEnRaya() {
	        
	        proximoJugador = 'X';
	                 
	         tablero = new Character[3][3];
	         
	         for(int i = 0 ; i < 3; i++){
	            for(int j = 0 ; j < 3; j++){
	                 tablero[i][j] = new Character('\0');
	             }
	         }
	         
	    }
	    
	    public String jugar(int x, int y){
	        validarCoordX(x);
	        validarCoordY(y);
	        
	        Character ficha = getProximoJugador();
	      //  System.out.println(" ficha " + ficha);
	        colocarFicha(x,y);  
	        
	      
	        for(int i = 0 ; i < 3; i++){
	            //linea horizontal
	            if(tablero[i][0] == ficha &&
	                tablero[i][1] == ficha &&
	                tablero[i][2] == ficha ){
	                return "" + ficha + " es el ganador";
	            }
	            //linea vertical
	             if(tablero[0][i] == ficha &&
	                tablero[1][i] == ficha &&
	                tablero[2][i] == ficha ){
	                return "" + ficha + " es el ganador";
	            }
	            
	        }
	         //linea diagonal izda
	        if(tablero[0][0] == ficha &&
	                tablero[1][1] == ficha &&
	                tablero[2][2] == ficha ){
	                return "" + ficha + " es el ganador";
	        }
	         //linea diagonal drcha
	        if(tablero[2][0] == ficha &&
	                tablero[1][1] == ficha &&
	                tablero[0][2] == ficha ){
	                return "" + ficha + " es el ganador";
	        }
	        return "No hay ganador";
	    }
	    
	    private void validarCoordX(int x){
	        if(x < 1 || x > 3){
	            throw new RuntimeException("X esta fuera del tablero");
	        }
	    }
	    
	    private void validarCoordY(int y){
	        if(y < 1 || y > 3){
	            throw new RuntimeException("Y esta fuera del tablero");
	        }
	    }
	    
	    private void colocarFicha(int x, int y){
	        if(tablero[x-1][y-1] != '\0'){
	            throw new RuntimeException("Esta posición ya está ocupada");
	        }else{
	            tablero[x-1][y-1] = proximoJugador;
	            proximoJugador = calcularProximoJugador();
	        }
	    }

	    public Character getProximoJugador() {
	        return proximoJugador;
	    }
	   
	    private Character calcularProximoJugador(){
	        if(proximoJugador == 'X'){
	            return 'O';
	        }else{
	            return 'X';
	        }
	    }
	    
	    
	    
	    
	}
