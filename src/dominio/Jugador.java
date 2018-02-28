package dominio;

import java.sql.SQLException;
import java.util.List;

import persistencia.Gestor_jugador;

public class Jugador {

	private Gestor_jugador gestor_jugador;
	private String nombre, foto, nac, flag, club, logo, valor, salario, precio, preferedPosition;
	private int id, edad, potencial, overall, salEspecial, GK,
	LB,LWB,CB,RB,RWB,CDM,CM,LM,RM,LW,RW,LF,RF,ST, Acceleration, Agility, BallControl, Crossing, Dribbling, Interceptions,
	LongPassing, LongShots, Marking, ShortPassing, ShortPower, SlidingTackle, SprintSpeed, Stamina, StandingTackle,
	Strength, GK_Diving, GK_Handling, GK_Positioning, GK_Reflexes, acceleration;
	
	public Jugador() {
		gestor_jugador = new Gestor_jugador();
	}
	
	public Jugador(String nombre) {
		gestor_jugador = new Gestor_jugador();
		this.nombre = nombre;
	}

	public Jugador(String nombre, String nac, String club, String valor, int id, int edad,
			int potencial, int overall, String precio) {
		this.nombre = nombre;
		this.nac = nac;
		this.club = club;
		this.valor = valor;
		this.id = id;
		this.edad = edad;
		this.potencial = potencial;
		this.overall = overall;
		this.precio = precio;
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
	
	public Jugador (int id, String name, int age, String nationality, int overall, int potential, String club, String value, int LB, 
			int LWB, int CB, int RB, int RWB, int CDM, int CM, int LM, int RM, int LW, int RW, int LF, int RF, int ST, 
			String preferedPosition, int acceleration, int agility, int ballControl, int crossing, int dribbling, int interceptions, 
			int longPassing, int longShots, int marking, int shortPassing, int shortPower, int slidingTackle, int sprintSpeed, 
			int stamina, int standingTackle, int strength, int GK_diving, int GK_handling, int GK_positioning, int GK_reflexes) {
		this.id = id;
		this.nombre= name;
		this.edad=age;
		this.nac = nationality;
		this.overall = overall;
		this.potencial = potential;
		this.club= club;
		this.valor = value;
		this.LB=LB;
		this.LWB = LWB;
		this.CB = CB;
		this.RB = RB;
		this.RWB = RWB;
		this.CDM=CDM;
		this.CM=CM;
		this.LM=LM;
		this.RM=RM;
		this.LW=LW;
		this.RW=RW;
		this.LF=LF;
		this.RF=RF;
		this.ST=ST;
		this.preferedPosition = preferedPosition;
		this.acceleration = acceleration;
		this.Agility = agility;
		this.BallControl = ballControl;
		this.Crossing = crossing;
		this.Dribbling= dribbling;
		this.Interceptions = interceptions;
		this.LongPassing = longPassing;
		this.LongShots = longShots;
		this.Marking = marking;
		this.ShortPassing = shortPassing;
		this.ShortPower = shortPower;
		this.SlidingTackle = slidingTackle;
		this.SprintSpeed = sprintSpeed;
		this.Stamina = stamina;
		this.StandingTackle = standingTackle;
		this.Strength = strength;
		this.GK_Diving = GK_diving;
		this.GK_Handling = GK_handling;
		this.GK_Positioning = GK_positioning;
		this.GK_Reflexes = GK_reflexes;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", nac=" + nac + ", club=" + club + ", id=" + id + ", edad=" + edad
				+ ", potencial=" + potencial + ", overall=" + overall + ", valor=" + valor + "]\n";
	}

	public List<Jugador> leerTodos() throws SQLException {
		return gestor_jugador.readAll();
	}
	
	public Jugador leerJugador() throws SQLException {
		return gestor_jugador.readJugador(this.nombre);
	}

}
