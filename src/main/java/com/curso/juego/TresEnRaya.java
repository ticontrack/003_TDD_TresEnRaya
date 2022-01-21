package com.curso.juego;

public class TresEnRaya {

	    
	    private Character[][] tablero;
	    
	    private Character proximoJugador;
	    
	    private int contador = 0;

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
	        System.out.println(" ficha " + ficha);
	        colocarFicha(x,y);  
	        contador ++;
	        
	      
	       if(esGanador(ficha, x, y)){
	                return "" + ficha + " es el ganador"; 
	        }else if(esEmpate()){
	            return "Hay empate!!";
	        }else{
	  
	        return "No hay ganador";
	        
	        }
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
	    
	    
	    private boolean esGanador(Character ficha, int x, int y){
	        
	       int total = ficha * 3;
	        char horizontal, vertical, diagonal1, diagonal2;
	        horizontal = vertical = diagonal1 = diagonal2 = '\0';
	        for (int i = 0; i < 3; i++) {
	            horizontal += tablero[i][y - 1];
	            vertical += tablero[x - 1][i];
	            diagonal1 += tablero[i][i];
	            diagonal2 += tablero[i][3 - i - 1];
	        }
	        if (horizontal == total
	                || vertical == total
	                || diagonal1 == total
	                || diagonal2 == total) {
	            return true;
	        }
	        return false;
	    }
	    
	    private boolean esEmpate(){
	        if(contador == 9){
	            return true;
	        }
	        return false;
	    }
	    
}