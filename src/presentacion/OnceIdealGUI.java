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
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import com.sun.prism.Image;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class OnceIdealGUI {

	private JFrame frame;
	private List<Jugador> listaJugadores;
	private final JTabbedPane tbFIFA18 = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel pnlJugadoresDisponibles = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JList lstJugadores = new JList();
	private final JLabel lblIdDelJugador = new JLabel("ID del jugador:");
	private final JLabel lblID = new JLabel("");
	private final JLabel lblNombreDelJugador = new JLabel("Nombre del jugador:");
	private final JLabel lblEdad = new JLabel("Edad:");
	private final JLabel lblNacionalidad = new JLabel("Nacionalidad:");
	private final JLabel lblOverall = new JLabel("Overall:");
	private final JPanel panel = new JPanel();
	private final JLabel lblClub = new JLabel("Club:");
	private final JLabel lblPrecioDeMercado = new JLabel("Precio de mercado:");
	private final JLabel lblNom = new JLabel("");
	private final JLabel lblE = new JLabel("");
	private final JLabel lblNac = new JLabel("");
	private final JLabel lblOV = new JLabel("");
	private final JLabel lblCl = new JLabel("");
	private final JLabel lblPrecio = new JLabel("");
	private final JPanel pnlAlineacion = new JPanel();
	private final JComboBox cbFormacion = new JComboBox();
	private final JPanel pnlCampo = new JPanel();
	private final JLabel lblImagenCampo = new JLabel("");
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
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del jugador", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panel.setBounds(239, 68, 323, 358);
			pnlJugadoresDisponibles.add(panel);
		}
		panel.setLayout(new GridLayout(8, 2, 0, 0));
		panel.add(lblIdDelJugador);
		panel.add(lblID);
		panel.add(lblNombreDelJugador);
		{
			panel.add(lblNom);
		}
		panel.add(lblEdad);
		{
			panel.add(lblE);
		}
		panel.add(lblNacionalidad);
		{
			panel.add(lblNac);
		}
		panel.add(lblOverall);
		{
			panel.add(lblOV);
		}
		{
			panel.add(lblClub);
		}
		{
			panel.add(lblCl);
		}
		{
			panel.add(lblPrecioDeMercado);
		}
		{
			panel.add(lblPrecio);
		}
		{
			tbFIFA18.addTab("Alineación", null, pnlAlineacion, null);
		}
		pnlAlineacion.setLayout(null);
		{
			cbFormacion.setBounds(161, 6, 236, 27);
			cbFormacion.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una formación…", "4-4-2", "4-3-3", "4-3-2-1"}));
			pnlAlineacion.add(cbFormacion);
		}
		{
			pnlCampo.setBounds(27, 38, 520, 437);
			pnlAlineacion.add(pnlCampo);
		}
		{
			/*
			 * ImageIcon fot = new ImageIcon(path_ala_imagen);
Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
jLabel1.setIcon(icono);
this.repaint();
			 */
			pnlCampo.setLayout(null);
			{
				lblImagenCampo.setBounds(0, 0, pnlCampo.getWidth(), pnlCampo.getHeight());
				pnlCampo.add(lblImagenCampo);
			}
			
			ImageIcon campo = new ImageIcon(OnceIdealGUI.class.getResource("/presentacion/campo-de-chapas-para-futbol.jpg"));
			Icon imCampo = new ImageIcon(campo.getImage().getScaledInstance(lblImagenCampo.getWidth(), lblImagenCampo.getHeight(), 
					java.awt.Image.SCALE_DEFAULT));
			lblImagenCampo.setIcon(imCampo);
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
				lblID.setText(String.valueOf(jugador.getId()));
				lblNom.setText(jugador.getNombre());
				lblE.setText(String.valueOf(jugador.getEdad()));
				lblNac.setText(jugador.getNac());
				lblOV.setText(String.valueOf(jugador.getOverall()));
				lblCl.setText(jugador.getClub());
				lblPrecio.setText(jugador.getPrecio());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
