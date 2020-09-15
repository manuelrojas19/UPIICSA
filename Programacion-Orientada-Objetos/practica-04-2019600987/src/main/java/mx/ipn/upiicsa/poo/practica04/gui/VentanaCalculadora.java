package mx.ipn.upiicsa.poo.practica04.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class VentanaCalculadora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VentanaCalculadoraBasica ventanaCalculadoraBasica;
	private VentanaCalculadoraCientifica ventanaCalculadoraCientifica;

	private JMenuBar menuBar;
	private JMenu menuVista;
	private JMenuItem menuItemCalculadoraBasica;
	private JMenuItem menuItemCalculadoraCientifica;

	private JPanel calculadorasPanel;

	public VentanaCalculadora() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Calculadora básica");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(390, 430);
		setResizable(false);
		instantiateComponents();
		initListeners();
		buildGrid();
		setVisible(true);
	}

	private void buildGrid() {
		Container pane = getContentPane();
		pane.add(calculadorasPanel);

	}

	private void initListeners() {
		menuItemCalculadoraBasica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSize(390, 430);
				setTitle("Calculadora básica");
				CardLayout cardLayout = (CardLayout) calculadorasPanel.getLayout();
				cardLayout.show(calculadorasPanel, "key_calculadora_basica");
				menuItemCalculadoraBasica.setEnabled(false);
				menuItemCalculadoraCientifica.setEnabled(true);
			}
		});

		menuItemCalculadoraCientifica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSize(680, 430);
				setTitle("Calculadora científica");
				CardLayout cardLayout = (CardLayout) calculadorasPanel.getLayout();
				cardLayout.show(calculadorasPanel, "key_calculadora_cientifica");
				menuItemCalculadoraCientifica.setEnabled(false);
				menuItemCalculadoraBasica.setEnabled(true);
			}
		});

	}

	private void instantiateComponents() {
		menuBar = new JMenuBar();
		menuVista = new JMenu("Opciones");
		menuBar.add(menuVista);
		menuItemCalculadoraBasica = new JMenuItem("Calculadora básica");
		menuItemCalculadoraBasica.setEnabled(false);
		menuItemCalculadoraCientifica = new JMenuItem("Calculadora científica");
		menuItemCalculadoraCientifica.setEnabled(true);
		menuVista.add(menuItemCalculadoraBasica);
		menuVista.add(menuItemCalculadoraCientifica);
		setJMenuBar(menuBar);
		ventanaCalculadoraBasica = new VentanaCalculadoraBasica();
		ventanaCalculadoraCientifica = new VentanaCalculadoraCientifica();
		calculadorasPanel = new JPanel(new CardLayout());
		calculadorasPanel.add(ventanaCalculadoraBasica, "key_calculadora_basica");
		calculadorasPanel.add(ventanaCalculadoraCientifica, "key_calculadora_cientifica");
	}

}
