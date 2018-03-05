package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;

import dominio.Jugador;
import persistencia.Gestor_jugador;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class OnceIdealGUI {

	private JFrame frame;
	private ArrayList<Jugador> listaJugadores;
	private final JTabbedPane tbFIFA18 = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel pnlJugadoresDisponibles = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JList <String> lstJugadores = new JList<>();
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
	private final JComboBox <String> cbFormacion = new JComboBox<String>();
	private final JPanel pnlCampo = new JPanel();
	private final JLabel lblImagenCampo = new JLabel("");
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JList<String> lstAlineacionInicial = new JList<String>();
	private Gestor_jugador gestor;
	private final JLabel lblPosition = new JLabel("Posición:");
	private final JLabel lblPos = new JLabel("");
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
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gestor=new Gestor_jugador();
		new ArrayList<>();
		try {
			this.listaJugadores = gestor.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			DefaultListModel <String> modeloLista = new DefaultListModel<>();
			lstJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lstJugadores.addListSelectionListener(new LstJugadoresListSelectionListener());
			lstJugadores.setModel(modeloLista);
			for (int i = 0; i < listaJugadores.size(); i++) {
				modeloLista.addElement(listaJugadores.get(i).nombre);
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
			panel.add(lblPosition);
		}
		{
			panel.add(lblPos);
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
			cbFormacion.addItemListener(new cbItemListener());
			cbFormacion.setBounds(161, 6, 236, 27);
			cbFormacion.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione una formación…", "4-4-2", "4-3-3", "3-4-2-1", "4-1-2-1-2", "5-2-1-2"}));
			pnlAlineacion.add(cbFormacion);
		}
		{
			pnlCampo.setBounds(27, 38, 520, 437);
			pnlAlineacion.add(pnlCampo);
		}
		{
			pnlCampo.setLayout(null);
			{
				scrollPane_1.setBounds(161, 59, 190, 314);
				pnlCampo.add(scrollPane_1);
			}
			{
				lstAlineacionInicial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane_1.setViewportView(lstAlineacionInicial);
			}
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
			DefaultListModel<String> modeloLista = new DefaultListModel<>();
			for (int i = 0; i < listaJugadores.size(); i++) {
				modeloLista.addElement(listaJugadores.get(i).nombre);
			}
		}
	}
	
	private class LstJugadoresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			String nombre = lstJugadores.getSelectedValue().toString();
			new Jugador(nombre);
			Jugador jugador = listaJugadores.get(lstJugadores.getSelectedIndex());
			lblID.setText(String.valueOf(jugador.id));
			lblNom.setText(jugador.nombre);
			lblE.setText(String.valueOf(jugador.edad));
			lblNac.setText(jugador.nac);
			lblOV.setText(String.valueOf(jugador.overall));
			lblCl.setText(jugador.club);
			lblPrecio.setText(jugador.valor);
			lblPos.setText(jugador.preferedPosition);
			} 
	}
	private class cbItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			String formacion = cbFormacion.getSelectedItem().toString();
			try {
				ArrayList<Jugador> alineacion = gestor.alineacionIdeal(listaJugadores, formacion);
				DefaultListModel <String> modeloLista = new DefaultListModel<>();
				for (int i = 0; i < alineacion.size(); i++) {
					String[]posiciones=(alineacion.get(i).preferedPosition).split(" ");
					modeloLista.addElement(posiciones[0]+" "+alineacion.get(i).nombre+" "+alineacion.get(i).overall);
				}
				lstAlineacionInicial.setModel(modeloLista);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
