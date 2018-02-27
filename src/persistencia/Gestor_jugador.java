package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Jugador;

public class Gestor_jugador {

	private Agente agenteBD;
	private List<Jugador> jugadores;
	
	public Gestor_jugador() {
		agenteBD = Agente.getAgente();
		jugadores = new ArrayList<>();
	}
	
	public List<Jugador> readAll() throws SQLException {
		String sql = "SELECT * FROM playerpersonaldata";
		
		String nombre, foto, nac, flag, club, logo, valor, salario;
		int id, edad, potencial, overall, salEspecial;
		ResultSet rs = agenteBD.read(sql);
		
		while (rs.next()) {
			id = rs.getInt(1);
			nombre = rs.getString(2);
			edad = rs.getInt(3);
			foto = rs.getString(4);
			nac = rs.getString(5);
			flag = rs.getString(6);
			overall = rs.getInt(7);
			potencial = rs.getInt(8);
			club = rs.getString(9);
			logo = rs.getString(10);
			valor = rs.getString(11);
			salario = rs.getString(12);
			salEspecial = rs.getInt(13);
			jugadores.add(new Jugador(id,nombre,edad,foto,nac,flag,overall,potencial,club,logo,valor,salario,salEspecial));
		}
		
		return jugadores;
	}
	
	public Jugador read() {
		String sql =
	}
}
