package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Jugador;

public class Gestor_jugador {

	private List<Jugador> jugadores;
	
	public Gestor_jugador() {
		jugadores = new ArrayList<>();
	}
	
	public List<Jugador> readAll() throws SQLException {
		this.jugadores=new ArrayList<>();
		
		ResultSet rs = SQLManager.select("playerdata");
		
		while (rs.next()) {
			jugadores.add(new Jugador(
					rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getInt(5),
					rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),
					rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),
					rs.getInt(16),rs.getInt(17),rs.getInt(18),rs.getInt(19),rs.getInt(20),
					rs.getInt(21),rs.getInt(22),rs.getString(23),rs.getInt(24),rs.getInt(25),
					rs.getInt(26),rs.getInt(27),rs.getInt(28),rs.getInt(29),rs.getInt(30),
					rs.getInt(31),rs.getInt(32),rs.getInt(33),rs.getInt(34),rs.getInt(35),
					rs.getInt(36),rs.getInt(37),rs.getInt(38),rs.getInt(39),rs.getInt(40),
					rs.getInt(41),rs.getInt(42),rs.getInt(43)));
		}
		
		SQLManager.desconectar();
		return jugadores;
	}
	
	public Jugador readJugador(String nombre) throws SQLException {
		Jugador j = null;
		
		ResultSet rs = SQLManager.select("playerdata",nombre);
		if (rs.next()) {
			j = new Jugador(
					rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getInt(5),
					rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),
					rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),
					rs.getInt(16),rs.getInt(17),rs.getInt(18),rs.getInt(19),rs.getInt(20),
					rs.getInt(21),rs.getInt(22),rs.getString(23),rs.getInt(24),rs.getInt(25),
					rs.getInt(26),rs.getInt(27),rs.getInt(28),rs.getInt(29),rs.getInt(30),
					rs.getInt(31),rs.getInt(32),rs.getInt(33),rs.getInt(34),rs.getInt(35),
					rs.getInt(36),rs.getInt(37),rs.getInt(38),rs.getInt(39),rs.getInt(40),
					rs.getInt(41),rs.getInt(42),rs.getInt(43));
		}
		SQLManager.desconectar();
		return j;
	}
}
