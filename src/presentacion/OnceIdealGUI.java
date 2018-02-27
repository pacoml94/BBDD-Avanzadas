package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import dominio.Jugador;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class OnceIdealGUI {

	private JFrame frame;
	private List<Jugador> listaJugadores;
	private final JTabbedPane tbFIFA18 = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel pnlJugadoresDisponibles = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JList lstJugadores = new JList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnceIdealGUI window = new OnceIdealGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. 
	 */
	public OnceIdealGUI() {
		Jugador aux = new Jugador();
		this.listaJugadores = new ArrayList<>();
		try {
			this.listaJugadores = aux.leerTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		{
			frame.getContentPane().add(tbFIFA18, BorderLayout.CENTER);
		}
		{
			tbFIFA18.addTab("Jugadores disponibles", null, pnlJugadoresDisponibles, null);
		}
		pnlJugadoresDisponibles.setLayout(null);
		{
			scrollPane.setBounds(23, 45, 174, 396);
			pnlJugadoresDisponibles.add(scrollPane);
		}
		{
			DefaultListModel modeloLista = new DefaultListModel<>();
			lstJugadores.addListSelectionListener(new LstJugadoresListSelectionListener());
			lstJugadores.setModel(modeloLista);
			for (int i = 0; i < listaJugadores.size(); i++) {
				modeloLista.addElement(listaJugadores.get(i).getNombre());
			}
			scrollPane.setViewportView(lstJugadores);
		}
		{
			DefaultListModel modeloLista = new DefaultListModel<>();
			for (int i = 0; i < listaJugadores.size(); i++) {
				modeloLista.addElement(listaJugadores.get(i).getNombre());
			}
		}
	}
	private class LstJugadoresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			String nombre = lstJugadores.getSelectedValue().toString();
			Jugador aux = new Jugador(nombre);
			try {
				Jugador jugador = aux.leerJugador();
				System.out.println(jugador);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
