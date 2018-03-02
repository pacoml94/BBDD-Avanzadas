package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dominio.Jugador;

public class Gestor_jugador {

	private List<Jugador> jugadores;

	public Gestor_jugador() {
		jugadores = new ArrayList<>();
	}

	public List<Jugador> readAll() throws SQLException {
		this.jugadores = new ArrayList<>();

		ResultSet rs = SQLManager.select("playerdata");

		while (rs.next()) {
			jugadores.add(new Jugador(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
					rs.getInt(6), rs.getString(7), rs.getString("Value"), rs.getInt(9), rs.getInt(10), rs.getInt(11),
					rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17),
					rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getInt(21), rs.getInt(22), rs.getString(23),
					rs.getInt(24), rs.getInt(25), rs.getInt(26), rs.getInt(27), rs.getInt(28), rs.getInt(29),
					rs.getInt(30), rs.getInt(31), rs.getInt(32), rs.getInt(33), rs.getInt(34), rs.getInt(35),
					rs.getInt(36), rs.getInt(37), rs.getInt(38), rs.getInt(39), rs.getInt(40), rs.getInt(41),
					rs.getInt(42), rs.getInt(43)));
		}

		SQLManager.desconectar();
		return jugadores;
	}

	public Jugador readJugador(String nombre) throws SQLException {
		Jugador j = null;

		ResultSet rs = SQLManager.select("playerdata", nombre);
		if (rs.next()) {
			j = new Jugador(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),
					rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
					rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getInt(18),
					rs.getInt(19), rs.getInt(20), rs.getInt(21), rs.getInt(22), rs.getString(23), rs.getInt(24),
					rs.getInt(25), rs.getInt(26), rs.getInt(27), rs.getInt(28), rs.getInt(29), rs.getInt(30),
					rs.getInt(31), rs.getInt(32), rs.getInt(33), rs.getInt(34), rs.getInt(35), rs.getInt(36),
					rs.getInt(37), rs.getInt(38), rs.getInt(39), rs.getInt(40), rs.getInt(41), rs.getInt(42),
					rs.getInt(43));
		}
		SQLManager.desconectar();
		return j;
	}

	public ArrayList<Jugador> alineacionIdeal(ArrayList<Jugador> jugadores, String formacion) throws SQLException {
		ArrayList<Jugador> alineacion = new ArrayList<>();
		switch (formacion) {
		case "3-4-2-1":
			ResultSet rs=SQLManager.select("playerData", "PreferredPositions='GK' order by Overall desc");
			alineacion.add(sacarMejor(rs,alineacion));
			
			rs=SQLManager.selectMejor("playerData","CB");
			alineacion.add(sacarMejor(rs,alineacion));
			
			/**
			 * TODO: COMPLETAR LAS ALINEACIONES SIGUIENDO EL TXT formaciones.txt
			 */
			
			break;
			
			

		case "4-1-2-1-2":

			break;
		case "5-2-1-2":

			break;
		case "4-4-2":

			break;
		case "4-3-3":

			break;

		}

		return alineacion;
	}

	public Jugador sacarMejor(ResultSet rs,ArrayList<Jugador> jugadores) throws SQLException {
		Jugador j = null;
		if (rs.next()) {
			j = new Jugador(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),
					rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
					rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getInt(18),
					rs.getInt(19), rs.getInt(20), rs.getInt(21), rs.getInt(22), rs.getString(23), rs.getInt(24),
					rs.getInt(25), rs.getInt(26), rs.getInt(27), rs.getInt(28), rs.getInt(29), rs.getInt(30),
					rs.getInt(31), rs.getInt(32), rs.getInt(33), rs.getInt(34), rs.getInt(35), rs.getInt(36),
					rs.getInt(37), rs.getInt(38), rs.getInt(39), rs.getInt(40), rs.getInt(41), rs.getInt(42),
					rs.getInt(43));
			/**
			 * TODO: BUSCAR EL ID DEL JUGADOR EN EL ARRAYLIST DE ALINEACION Y SI EXISTE HACER NEXT EN EL RESULTSET HASTA QUE COJA UN JUGADOR QUE NO ESTÉ ELEGIDO AÚN
			 */
			
		}
		SQLManager.desconectar();
		return j;
	}
}
