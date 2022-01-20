package com.curso.juego;

public class TresEnRaya {
	
	private char[][] tablero = new char[3][3];
	private char jugadorActual = 'X';
	
	
	public void jugar(int x, int y) {
		
		//validar que x esta entre 1 y 3  
		if(x <1 || x >3) {
			throw new RuntimeException("X fuera de rango");
		}
		//validar que y esta entre 1 y 3  
		if(y <1 || y >3) {
			throw new RuntimeException("Y fuera de rango");
		}
		
		
		if(tablero[x-1][y-1] != '\0' ) {
		
			throw new RuntimeException("Celda ocupada");
		}
		
		tablero[x-1][y-1] = jugadorActual;
		if(jugadorActual == 'X') {
			jugadorActual = 'O';
		}else {
			jugadorActual = 'X';			
		}
		
		
	}//fin jugar
	
	public char getContenidoCelda(int x, int y) {
		return tablero[x-1][y-1];
	}
	
	public char getJugadorActual() {
		return jugadorActual;
	}
	
	

}
