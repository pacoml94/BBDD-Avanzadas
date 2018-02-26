package dominio;

import java.sql.SQLException;
import java.util.List;

import persistencia.Gestor_jugador;

public class Jugador {

	private Gestor_jugador gestor_jugador;
	private String nombre, foto, nac, flag, club, logo, valor, salario;
	private int id, edad, potencial, overall, salEspecial;
	
	public Jugador() {
		gestor_jugador = new Gestor_jugador();
	}
	
	
	
	public Jugador(int id2, String nombre2, int edad2, String foto2, String nac2, String flag2, int overall2,
			int potencial2, String club2, String logo2, String valor2, String salario2, int salEspecial2) {
		this.id = id2;
		this.nombre = nombre2;
		this.edad = edad2;
		this.foto = foto2;
		this.nac = nac2;
		this.flag = flag2;
		this.overall = overall2;
		this.potencial = potencial2;
		this.club = club2;
		this.logo = logo2;
		this.valor = valor2;
		this.salario = salario2;
		this.salEspecial = salEspecial2;
	}



	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", foto=" + foto + ", nac=" + nac
				+ ", flag=" + flag + ", club=" + club + ", logo=" + logo + ", id=" + id + ", edad=" + edad
				+ ", potencial=" + potencial + ", overall=" + overall + ", salario=" + salario + ", salEspecial="
				+ salEspecial + ", valor=" + valor + "]\n";
	}

	public List<Jugador> leerTodos() throws SQLException {
		return gestor_jugador.readAll();
	}

}
