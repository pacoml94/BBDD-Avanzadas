package dominio;

import java.sql.SQLException;
import java.util.List;

import persistencia.Gestor_jugador;

public class Jugador {

	private Gestor_jugador gestor_jugador;
	public String nombre, foto, nac, flag, club, logo, valor, salario, precio, preferedPosition;
	public int id, edad, potencial, overall, salEspecial, GK,
	LB,LWB,CB,RB,RWB,CDM,CM,LM,RM,LW,RW,LF,RF,ST, Acceleration, Agility, BallControl, Crossing, Dribbling, Interceptions,
	LongPassing, LongShots, Marking, ShortPassing, ShortPower, SlidingTackle, SprintSpeed, Stamina, StandingTackle,
	Strength, GK_Diving, GK_Handling, GK_Positioning, GK_Reflexes, acceleration;
	
	
	public Jugador (
			int id, String name, int age, String nationality, int overall, 
			int potential, String club, String value, int LB, int LWB, 
			int CB, int RB, int RWB, int CDM, int CM, 
			int LM, int RM, int LW, int RW, int LF, 
			int RF, int ST, String preferedPosition, int acceleration, int agility, 
			int ballControl, int crossing, int dribbling, int interceptions, int longPassing, 
			int longShots, int marking, int shortPassing, int shortPower, int slidingTackle, 
			int sprintSpeed, int stamina, int standingTackle, int strength, int GK_diving, 
			int GK_handling, int GK_positioning, int GK_reflexes) {
		this.gestor_jugador = new Gestor_jugador();
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

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", nac=" + nac + ", club=" + club + ", id=" + id + ", edad=" + edad
				+ ", potencial=" + potencial + ", overall=" + overall + ", valor=" + valor + "]\n";
	}
	public Jugador(String nombre) {
		this.nombre=nombre;
	}

	
	public Jugador leerJugador() throws SQLException {
		return gestor_jugador.readJugador(this.nombre);
	}

}
