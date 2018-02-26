package presentacion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Jugador;

class Principal {

	public static void main(String[] args) {
		List<Jugador> jugadores = new ArrayList<>();
		Jugador jugador = new Jugador();
		try {
			jugadores = jugador.leerTodos();
			for (Jugador jugador1 : jugadores) {
				System.out.println(jugador1.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
