package dominio;

import java.sql.SQLException;
import java.util.List;

import persistencia.Gestor_jugador;

public class Jugador {

	private Gestor_jugador gestor_jugador;
	private String nombre, foto, nac, flag, club, logo, valor, salario;
	private int id, edad, potencial, overall, salEspecial;
	//id nombre edad nacion potencial overall club valor
	public Jugador() {
		gestor_jugador = new Gestor_jugador();
	}
	
	public Jugador(String nombre, String nac, String flag, String club, String logo, String valor, int id, int edad,
			int potencial, int overall) {
		this.nombre = nombre;
		this.nac = nac;
		this.flag = flag;
		this.club = club;
		this.logo = logo;
		this.valor = valor;
		this.id = id;
		this.edad = edad;
		this.potencial = potencial;
		this.overall = overall;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNac() {
		return nac;
	}

	public void setNac(String nac) {
		this.nac = nac;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPotencial() {
		return potencial;
	}

	public void setPotencial(int potencial) {
		this.potencial = potencial;
	}

	public int getOverall() {
		return overall;
	}

	public void setOverall(int overall) {
		this.overall = overall;
	}

	public int getSalEspecial() {
		return salEspecial;
	}

	public void setSalEspecial(int salEspecial) {
		this.salEspecial = salEspecial;
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
