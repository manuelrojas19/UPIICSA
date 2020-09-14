package mx.ipn.upiicsa.poo.practica04.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import mx.ipn.upiicsa.poo.practica04.bs.Calculadora;
import mx.ipn.upiicsa.poo.practica04.exception.DivZeroException;

public class VentanaCalculadoraBasica extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Integer CERO = 0;
	private static final Integer UNO = 1;
	private static final Integer DOS = 2;
	private static final Integer TRES = 3;
	private static final Integer CUATRO = 4;
	private static final Integer CINCO = 5;
	private static final Integer SEIS = 6;
	private static final Integer SIETE = 7;
	private static final Integer OCHO = 8;
	private static final Integer NUEVE = 9;
	private static final String PUNTO = ".";
	private static final String EMPTY_STRING = "";

	private static final String M_ERROR = "MATH ERROR";
	private static final String S_ERROR = "SINTAX ERROR";

	protected static final int STATE_INIT = 0;
	protected static final int STATE_CAPTURE = 1;
	protected static final int STATE_OPERATOR = 2;
	protected static final int STATE_CALCULATE = 3;

	protected static final int ACTION_NUMBER = 0;
	protected static final int ACTION_OPERATOR = 1;
	protected static final int ACTION_EQUAL = 2;
	protected static final int ACTION_CLEAN = 3;

	protected int state;
	protected int operator;
	protected Double valor1;
	protected Double valor2;
	protected Double resultado;
	protected Calculadora calculadora;

	protected JTextField display;
	protected JButton button0;
	protected JButton button1;
	protected JButton button2;
	protected JButton button3;
	protected JButton button4;
	protected JButton button5;
	protected JButton button6;
	protected JButton button7;
	protected JButton button8;
	protected JButton button9;
	protected JButton buttonPunto;
	protected JButton buttonLimpiar;
	protected JButton buttonPorcentaje;
	protected JButton buttonDivision;
	protected JButton buttonProducto;
	protected JButton buttonSuma;
	protected JButton buttonResta;
	protected JButton buttonIgual;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	public VentanaCalculadoraBasica() {
		state = STATE_INIT;
		calculadora = new Calculadora();
		initComponents();
	}

	protected void initComponents() {
		instantiateComponents();
		buildGrid();
		initializeListener();
		setVisible(true);
	}

	protected void initializeListener() {
		button0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CERO.toString());

			}
		});

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(UNO.toString());

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(DOS.toString());

			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(TRES.toString());

			}
		});

		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CUATRO.toString());

			}
		});

		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CINCO.toString());

			}
		});

		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(SEIS.toString());

			}
		});

		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(SIETE.toString());

			}
		});

		button8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(OCHO.toString());

			}
		});

		button9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(NUEVE.toString());

			}
		});

		buttonPunto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(PUNTO);

			}
		});

		buttonLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
			}
		});

		buttonSuma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_SUMA);

			}
		});

		buttonResta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RESTA);

			}
		});

		buttonProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PRODUCTO);

			}
		});

		buttonDivision.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_DIVISION);

			}
		});

		buttonPorcentaje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PORCENTAJE);

			}
		});

		buttonIgual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarEstado(ACTION_EQUAL);
				actualizarDisplay(display.getText());
			}
		});

	}

	protected void buildGrid() {
		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();

		setLayout(calculadoraGrid);

		calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridConstraints.weightx = 0.5;
		calculadoraGridConstraints.weighty = 0.5;
		calculadoraGridConstraints.ipady = 20;

		calculadoraGridConstraints.ipady = 40;
		calculadoraGridConstraints.ipadx = 20;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 0;
		calculadoraGridConstraints.gridwidth = 4;
		add(display, calculadoraGridConstraints);

		/* Primer Rnglon */

		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 1;
		add(buttonLimpiar, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPorcentaje, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 1;
		add(buttonDivision, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 1;
		add(buttonProducto, calculadoraGridConstraints);

		/* Segundo Renglon */

		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 2;
		add(button7, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 2;
		add(button8, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 2;
		add(button9, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 2;
		add(buttonSuma, calculadoraGridConstraints);

		/* Tercer Renglon */

		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 3;
		add(button4, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 3;
		add(button5, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 3;
		add(button6, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 3;
		add(buttonResta, calculadoraGridConstraints);

		/* Cuarto Renglon */

		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 4;
		add(button1, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 4;
		add(button2, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 4;
		add(button3, calculadoraGridConstraints);

		calculadoraGridConstraints.ipady = 109;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 4;
		add(buttonIgual, calculadoraGridConstraints);

		/* Quinto Renglon */

		calculadoraGridConstraints.ipady = 40;
		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridwidth = 2;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 5;
		add(button0, calculadoraGridConstraints);

		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 5;
		add(buttonPunto, calculadoraGridConstraints);

	}

	protected void instantiateComponents() {
		display = new JTextField("");
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);

		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPunto = new JButton(".");
		buttonLimpiar = new JButton("AC");
		buttonPorcentaje = new JButton("%");
		buttonDivision = new JButton("/");
		buttonProducto = new JButton("x");
		buttonSuma = new JButton("+");
		buttonResta = new JButton("-");
		buttonIgual = new JButton("=");
	}

	protected void actualizarEstado(int action) {
		if (action == ACTION_CLEAN) {
			state = STATE_INIT;
		} else if (state == STATE_INIT && action == ACTION_NUMBER || state == STATE_OPERATOR && action == ACTION_NUMBER
				|| state == STATE_CALCULATE && action == ACTION_NUMBER) {
			state = STATE_CAPTURE;
		} else if (state == STATE_CAPTURE && action == ACTION_OPERATOR
				|| state == STATE_CALCULATE && action == ACTION_OPERATOR) {
			state = STATE_OPERATOR;
		} else if (state == STATE_CAPTURE && action == ACTION_EQUAL) {
			state = STATE_CALCULATE;
		}
		System.out.println("ESTADO: " + state);
	}

	protected void actualizarDisplay(String valor) {
		if (state == STATE_INIT) {
			display.setText(valor);
		} else if (state == STATE_CAPTURE) {
			String valorActual = display.getText();
			display.setText(valorActual + valor);
		} else if (state == STATE_OPERATOR) {
			String valorString = display.getText();
			display.setText(valor);
			try {
				valor1 = Double.parseDouble(valorString);
			} catch (NumberFormatException e) {
				display.setText(S_ERROR);
				JOptionPane.showMessageDialog(this, S_ERROR);
				actualizarEstado(ACTION_CLEAN);
			}
		} else if (state == STATE_CALCULATE) {
			String resultadoString = null;
			String valorString = display.getText();
			try {
				valor2 = Double.parseDouble(valorString);
				try {
					resultado = calculadora.calculate(operator, valor1, valor2);
					resultadoString = resultado.toString();
				} catch (DivZeroException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "División entre 0");
					actualizarEstado(ACTION_CLEAN);
				} finally {
					display.setText(resultadoString);
					System.out.println("OPERACION -----> " + valor1 + " operador:" + operator + " " + valor2 + " = "
							+ resultadoString);
					actualizarEstado(ACTION_CLEAN);
					valor1 = resultado;
				}
			} catch (NumberFormatException e) {
				display.setText(S_ERROR);
				JOptionPane.showMessageDialog(this, S_ERROR);
				actualizarEstado(ACTION_CLEAN);
			} catch (NullPointerException e) {
				resultadoString = S_ERROR;
				JOptionPane.showMessageDialog(this, "NO");
				actualizarEstado(ACTION_CLEAN);
			}

			display.setText(resultadoString);
		}
	}

	protected void capturarNumero(String numero) {
		actualizarDisplay(numero);
		actualizarEstado(ACTION_NUMBER);
	}

	protected void capturarOperador(int operator) {
		setOperator(operator);
		actualizarEstado(ACTION_OPERATOR);
	}

	public void limpiarDisplay() {
		display.setText(EMPTY_STRING);
		actualizarEstado(ACTION_CLEAN);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public Double getValor1() {
		return valor1;
	}

	public void setValor1(Double valor1) {
		this.valor1 = valor1;
	}

	public Double getValor2() {
		return valor2;
	}

	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
}
