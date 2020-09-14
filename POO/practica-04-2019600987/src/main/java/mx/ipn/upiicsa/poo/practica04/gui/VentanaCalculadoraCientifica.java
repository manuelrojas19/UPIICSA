package mx.ipn.upiicsa.poo.practica04.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import mx.ipn.upiicsa.poo.practica04.bs.Calculadora;
import mx.ipn.upiicsa.poo.practica04.exception.DivZeroException;
import mx.ipn.upiicsa.poo.practica04.exception.FactorialFractionException;
import mx.ipn.upiicsa.poo.practica04.exception.NegativeLogException;
import mx.ipn.upiicsa.poo.practica04.exception.NegativeSqrtException;

public class VentanaCalculadoraCientifica extends VentanaCalculadoraBasica {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton buttonRaisedPower2;
	private JButton buttonRaisedPower3;
	private JButton buttonExpN;
	private JButton buttonEulerExp;
	private JButton buttonRaised10;
	private JButton buttonFraction;
	private JButton buttonSquareRoot;
	private JButton buttonCubeRoot;
	private JButton buttonNRoot;
	private JButton buttonLn;
	private JButton buttonLog;
	private JButton buttonFactorial;
	private JButton buttonSin;
	private JButton buttonCos;
	private JButton buttonTan;
	private JButton buttonEuler;
	private JButton buttonPi;

	private int function;

	private static final String M_ERROR = "MATH ERROR";
	private static final String S_ERROR = "SINTAX ERROR";

	private static final int STATE_FUNCTION = 4;

	private static final int ACTION_FUNCTION = 4;

	@Override
	protected void instantiateComponents() {
		super.instantiateComponents();
		buttonRaisedPower2 = new JButton("x²");
		buttonRaisedPower3 = new JButton("x³");
		buttonExpN = new JButton("x^");
		buttonEulerExp = new JButton("e^");
		buttonRaised10 = new JButton("10^");
		buttonFraction = new JButton("1/x");
		buttonSquareRoot = new JButton("2√x");
		buttonCubeRoot = new JButton("3√x");
		buttonNRoot = new JButton("n√x");
		buttonLn = new JButton("ln");
		buttonLog = new JButton("log");
		buttonFactorial = new JButton("x!");
		buttonSin = new JButton("sin");
		buttonCos = new JButton("cos");
		buttonTan = new JButton("tan");
		buttonEuler = new JButton("e");
		buttonPi = new JButton("π");
	}

	@Override
	protected void buildGrid() {
		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();

		setLayout(calculadoraGrid);

		calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridConstraints.weightx = 0.5;
		calculadoraGridConstraints.weighty = 0.5;
		calculadoraGridConstraints.ipady = 1;

		calculadoraGridConstraints.ipady = 40;
		calculadoraGridConstraints.ipadx = 20;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 0;
		calculadoraGridConstraints.gridwidth = 8;
		add(display, calculadoraGridConstraints);

		/* Primer Rnglon */
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 1;
		add(buttonRaisedPower2, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 1;
		add(buttonRaisedPower3, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 1;
		add(buttonExpN, calculadoraGridConstraints);

		calculadoraGridConstraints.ipady = 107;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPi, calculadoraGridConstraints);

		calculadoraGridConstraints.ipady = 40;
		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 1;
		add(buttonLimpiar, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPorcentaje, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 1;
		add(buttonDivision, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 1;
		add(buttonProducto, calculadoraGridConstraints);

		/* Segundo Renglon */

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 2;
		add(buttonSquareRoot, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 2;
		add(buttonCubeRoot, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 2;
		add(buttonNRoot, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 2;
		add(button7, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 2;
		add(button8, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 2;
		add(button9, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 2;
		add(buttonSuma, calculadoraGridConstraints);

		/* Tercer Renglon */

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 3;
		add(buttonSin, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 3;
		add(buttonCos, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 3;
		add(buttonTan, calculadoraGridConstraints);

		calculadoraGridConstraints.ipady = 104;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 3;
		add(buttonEuler, calculadoraGridConstraints);

		calculadoraGridConstraints.ipady = 40;
		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 3;
		add(button4, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 3;
		add(button5, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 3;
		add(button6, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 3;
		add(buttonResta, calculadoraGridConstraints);

		/* Cuarto Renglon */

		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 4;
		add(buttonFraction, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 4;
		add(buttonFactorial, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 4;
		add(buttonRaised10, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 4;
		add(button1, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 4;
		add(button2, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 4;
		add(button3, calculadoraGridConstraints);

		calculadoraGridConstraints.ipady = 109;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 4;
		add(buttonIgual, calculadoraGridConstraints);

		/* Quinto Renglon */

		calculadoraGridConstraints.ipady = 40;
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 5;
		add(buttonEulerExp, calculadoraGridConstraints);

		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 5;
		add(buttonLn, calculadoraGridConstraints);

		calculadoraGridConstraints.gridwidth = 2;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 5;
		add(buttonLog, calculadoraGridConstraints);

		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridwidth = 2;
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 5;
		add(button0, calculadoraGridConstraints);

		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 5;
		add(buttonPunto, calculadoraGridConstraints);

	}

	@Override
	protected void actualizarEstado(int action) {
		if (action == ACTION_CLEAN) {
			state = STATE_INIT;
		} else if (state == STATE_FUNCTION && action == ACTION_NUMBER || state == STATE_INIT && action == ACTION_NUMBER
				|| state == STATE_OPERATOR && action == ACTION_NUMBER
				|| state == STATE_CALCULATE && action == ACTION_NUMBER) {
			state = STATE_CAPTURE;
		} else if (state == STATE_FUNCTION && action == ACTION_OPERATOR
				|| state == STATE_CAPTURE && action == ACTION_OPERATOR
				|| state == STATE_CALCULATE && action == ACTION_OPERATOR) {
			state = STATE_OPERATOR;
		} else if (state == STATE_CAPTURE && action == ACTION_EQUAL) {
			state = STATE_CALCULATE;
		} else if (state == STATE_INIT && action == ACTION_FUNCTION
				|| state == STATE_CALCULATE && action == ACTION_FUNCTION
				|| state == STATE_CAPTURE && action == ACTION_FUNCTION) {
			state = STATE_FUNCTION;
		}
		System.out.println("ESTADO: " + state);
	}

	@Override
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
					resultadoString = S_ERROR;
					JOptionPane.showMessageDialog(this, "División entre 0");
					actualizarEstado(ACTION_CLEAN);
				} catch (NullPointerException e) {
					resultadoString = S_ERROR;
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
				JOptionPane.showMessageDialog(this, "División entre 0");
				actualizarEstado(ACTION_CLEAN);
			}
			display.setText(resultadoString);
		} else if (state == STATE_FUNCTION) {
			String valorString = display.getText();
			String resultadoString = null;
			try {
				valor1 = Double.parseDouble(valorString);
				try {
					resultado = calculadora.calculateFunction(function, valor1);
					resultadoString = resultado.toString();
				} catch (NegativeLogException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "Log de un número cero o negativo");
					actualizarEstado(ACTION_CLEAN);
				} catch (NegativeSqrtException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "Raiz de un número negativo");
					actualizarEstado(ACTION_CLEAN);
				} catch (FactorialFractionException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "Factorial de una fracción");
					actualizarEstado(ACTION_CLEAN);
				} finally {
					display.setText(resultadoString);
					System.out.println("FUNCION -----> " + valor1 + " funcion:" + function + " = " + resultadoString);
					actualizarEstado(ACTION_CLEAN);
					valor1 = resultado;
				}
			} catch (NumberFormatException e) {
				if (e.getCause() == null) {
					System.out.println("No se ingreso un numero");
					actualizarEstado(ACTION_CLEAN);
				} else {
					resultadoString = S_ERROR;
					actualizarEstado(ACTION_CLEAN);
				}
			} catch (NullPointerException e) {
				resultadoString = S_ERROR;
				actualizarEstado(ACTION_CLEAN);
			}
			display.setText(resultadoString);
		}
	}

	@Override
	protected void initializeListener() {
		super.initializeListener();
		buttonSin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_SIN);
			}
		});
		buttonCos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_COS);
			}
		});
		buttonTan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_TAN);
			}
		});
		buttonEuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
				capturarNumero(Calculadora.E_CONSTANT.toString());
			}
		});
		buttonPi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
				capturarNumero(Calculadora.PI_CONSTANT.toString());
			}
		});

		buttonCubeRoot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_CUBE_ROOT);

			}
		});

		buttonSquareRoot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_SQUARE_ROOT);

			}
		});

		buttonEulerExp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_EULER_EXP);

			}
		});

		buttonLn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_LOG_NAT);
			}
		});

		buttonLog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_LOG_10);

			}
		});

		buttonFraction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_FRACTION);

			}
		});

		buttonFactorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_FACTORIAL);

			}
		});

		buttonRaisedPower2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_RAISED_POWER_2);

			}
		});

		buttonRaisedPower3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_RAISED_POWER_3);

			}
		});

		buttonRaised10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_RAISED_10);

			}
		});

		buttonNRoot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_N_ROOT);
			}
		});

		buttonExpN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RAISED_POWER_N);

			}
		});

	}

	private void capturarFuncion(int function) {
		setFunction(function);
		actualizarEstado(ACTION_FUNCTION);
		actualizarDisplay(display.getText());
	}

	public int getFunction() {
		return function;
	}

	public void setFunction(int function) {
		this.function = function;
	}

}
