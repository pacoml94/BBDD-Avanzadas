package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dominio.Jugador;

public class Gestor_jugador {

	private ArrayList<Jugador> jugadores;

	public Gestor_jugador() {
		jugadores = new ArrayList<>();
	}

	public ArrayList<Jugador> readAll() throws SQLException {
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

	public ArrayList<Jugador> alineacionIdeal(ArrayList<Jugador> jugadores, String formacion) throws SQLException {
		ArrayList<Jugador> alineacion = new ArrayList<>();
		
		ResultSet rs = SQLManager.select("playerData", "PreferredPositions='GK' order by Overall desc");
		alineacion.add(sacarMejor(rs, alineacion));
		SQLManager.desconectar();
		
		switch (formacion) {
		case "3-4-2-1":
			rs = SQLManager.selectMejor("playerData", "CB");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "LM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CM");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "LF");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "ST");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RF");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			/**
			 * TODO: COMPLETAR LAS ALINEACIONES SIGUIENDO EL TXT formaciones.txt
			 */

			break;

		case "4-1-2-1-2":
			
			rs = SQLManager.selectMejor("playerData", "LB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CB");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CDM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "LM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "ST");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "ST");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			break;
			
		case "5-2-1-2":
			rs = SQLManager.selectMejor("playerData", "LWB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CB");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RWB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CM");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.select("playerData", "PreferredPositions='CAM' or PreferredPositions='CAM%' or PreferredPositions='%CAM' or PreferredPositions='%CAM%' order by Overall desc");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "ST");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			break;
		case "4-4-2":
			rs = SQLManager.selectMejor("playerData", "LB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CB");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "LM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CM");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "ST");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			break;
		case "4-3-3":
			rs = SQLManager.selectMejor("playerData", "LB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CB");
			alineacion.add(sacarMejor(rs, alineacion));
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RB");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CDM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "CM");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "LW");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "ST");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			
			rs = SQLManager.selectMejor("playerData", "RW");
			alineacion.add(sacarMejor(rs, alineacion));
			SQLManager.desconectar();
			break;

		}

		return alineacion;
	}

	public Jugador sacarMejor(ResultSet rs, ArrayList<Jugador> jugadores) throws SQLException {
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
			 * TODO: BUSCAR EL ID DEL JUGADOR EN EL ARRAYLIST DE ALINEACION Y SI EXISTE
			 * HACER NEXT EN EL RESULTSET HASTA QUE COJA UN JUGADOR QUE NO ESTÉ ELEGIDO AÚN
			 */
		}
		for (int i = 1; i < jugadores.size(); i++) {
			if (jugadores.get(i).id == j.id) {
				i = 0;
				rs.next();
				j = new Jugador(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17),
						rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getInt(21), rs.getInt(22), rs.getString(23),
						rs.getInt(24), rs.getInt(25), rs.getInt(26), rs.getInt(27), rs.getInt(28), rs.getInt(29),
						rs.getInt(30), rs.getInt(31), rs.getInt(32), rs.getInt(33), rs.getInt(34), rs.getInt(35),
						rs.getInt(36), rs.getInt(37), rs.getInt(38), rs.getInt(39), rs.getInt(40), rs.getInt(41),
						rs.getInt(42), rs.getInt(43));
			} 

		}
		
		return j;
	}
}
