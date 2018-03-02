package persistencia;

import java.sql.*;

import javax.swing.JOptionPane;

import dominio.*;

public class SQLManager {

	static Connection conexion = null;
	static Statement stt = null;

	public static void conectar() {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/fifa18", "root", "");
			stt = conexion.createStatement();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);

		}
	}

	public static void desconectar() {
		try {

			if (conexion != null && stt != null) {
				stt.close();
				conexion.close();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);

		}

	}

	public static ResultSet select(String tabla, String condicion) {
		ResultSet rs = null;
		
		try {
			conectar();
			rs = stt.executeQuery("select * from " + tabla + " where " + condicion);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);

		}
		return rs;
	}

	public static ResultSet select(String tabla) {
		ResultSet rs = null;
		try {
			conectar();
			rs = stt.executeQuery("select * from " + tabla+ " order by Overall desc");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);

		}
		return rs;
	}
	
	public static ResultSet selectMejor(String tabla,String criterio) {
		ResultSet rs = null;
		try {
			conectar();
			rs = stt.executeQuery("select * from " + tabla+" order by "+criterio+" desc");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);

		}
		return rs;
	}

}
