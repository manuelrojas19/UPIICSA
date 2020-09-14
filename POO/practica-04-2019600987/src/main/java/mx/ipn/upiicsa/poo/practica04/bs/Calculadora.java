package mx.ipn.upiicsa.poo.practica04.bs;

import mx.ipn.upiicsa.poo.practica04.exception.DivZeroException;
import mx.ipn.upiicsa.poo.practica04.exception.FactorialFractionException;
import mx.ipn.upiicsa.poo.practica04.exception.NegativeLogException;
import mx.ipn.upiicsa.poo.practica04.exception.NegativeSqrtException;

import java.lang.Math;

public class Calculadora {
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int TEN = 10;

	public static final Double PI_CONSTANT = Math.PI;
	public static final Double E_CONSTANT = Math.E;

	public static final int OPERATOR_SUMA = 1;
	public static final int OPERATOR_RESTA = 2;
	public static final int OPERATOR_PRODUCTO = 3;
	public static final int OPERATOR_DIVISION = 4;
	public static final int OPERATOR_PORCENTAJE = 5;

	public static final int FUNCTION_SIN = 6;
	public static final int FUNCTION_COS = 7;
	public static final int FUNCTION_TAN = 8;

	public static final int FUNCTION_SQUARE_ROOT = 9;
	public static final int FUNCTION_CUBE_ROOT = 10;

	public static final int FUNCTION_EULER_EXP = 11;

	public static final int FUNCTION_LOG_NAT = 12;
	public static final int FUNCTION_LOG_10 = 13;

	public static final int FUNCTION_FRACTION = 14;

	public static final int FUNCTION_FACTORIAL = 15;

	public static final int FUNCTION_RAISED_POWER_2 = 16;
	public static final int FUNCTION_RAISED_POWER_3 = 17;
	public static final int FUNCTION_RAISED_10 = 18;

	public static final int OPERATOR_N_ROOT = 19;
	public static final int OPERATOR_RAISED_POWER_N = 20;

	public Double calculate(int operator, Double valor1, Double valor2) throws DivZeroException {
		Double resultado;
		switch (operator) {
		case OPERATOR_SUMA:
			resultado = suma(valor1, valor2);
			break;
		case OPERATOR_RESTA:
			resultado = resta(valor1, valor2);
			break;
		case OPERATOR_PRODUCTO:
			resultado = producto(valor1, valor2);
			break;
		case OPERATOR_DIVISION:
			resultado = division(valor1, valor2);
			break;
		case OPERATOR_PORCENTAJE:
			resultado = porcentaje(valor1, valor2);
			break;
		case OPERATOR_N_ROOT:
			resultado = nRoot(valor1, valor2);
			break;
		case OPERATOR_RAISED_POWER_N:
			resultado = raisedPowerN(valor1, valor2);
			break;
		default:
			resultado = valor2;
			break;
		}
		return resultado;
	}

	public Double calculateFunction(int operator, Double valor)
			throws NegativeLogException, NegativeSqrtException, FactorialFractionException {
		Double resultado = null;
		switch (operator) {
		case FUNCTION_SIN:
			resultado = sin(valor);
			break;
		case FUNCTION_COS:
			resultado = cos(valor);
			break;
		case FUNCTION_TAN:
			resultado = tan(valor);
			break;
		case FUNCTION_SQUARE_ROOT:
			resultado = squareRoot(valor);
			break;
		case FUNCTION_CUBE_ROOT:
			resultado = cubeRoot(valor);
			break;
		case FUNCTION_EULER_EXP:
			resultado = eulerExp(valor);
			break;
		case FUNCTION_LOG_NAT:
			resultado = logNat(valor);
			break;
		case FUNCTION_LOG_10:
			resultado = log10(valor);
			break;
		case FUNCTION_FRACTION:
			resultado = fraction(valor);
			break;
		case FUNCTION_FACTORIAL:
			resultado = factorial(valor);
			break;
		case FUNCTION_RAISED_POWER_2:
			resultado = raisedPower2(valor);
			break;
		case FUNCTION_RAISED_POWER_3:
			resultado = raisedPower3(valor);
			break;
		case FUNCTION_RAISED_10:
			resultado = raised10(valor);
			break;
		default:
			resultado = -1.0;
			break;
		}
		return resultado;
	}

	public Double suma(Double sumando1, Double sumando2) {
		return sumando1 + sumando2;
	}

	public Double resta(Double minuendo, Double sustraendo) {
		return minuendo - sustraendo;
	}

	public Double producto(Double factor1, Double factor2) {
		return factor1 * factor2;
	}

	public Double division(Double dividendo, Double divisor) throws DivZeroException {
		if (divisor == 0) {
			throw new DivZeroException();
		}
		return dividendo / divisor;
	}

	public Double porcentaje(Double cantidad, Double porcentaje) {
		return (cantidad * porcentaje) / 100;
	}

	public Double sin(Double ang) {
		return Math.sin(Math.toRadians(ang));
	}

	public Double cos(Double ang) {
		return Math.cos(Math.toRadians(ang));
	}

	public Double tan(Double ang) {
		return Math.tan(Math.toRadians(ang));
	}

	private Double cubeRoot(Double valor) {
		return Math.cbrt(valor);
	}

	private Double squareRoot(Double valor) throws NegativeSqrtException {
		if (valor < 0) {
			throw new NegativeSqrtException();
		}
		return Math.sqrt(valor);
	}

	public Double eulerExp(Double valor) {
		return Math.exp(valor);
	}

	public Double logNat(Double valor) throws NegativeLogException {
		if (valor <= 0) {
			throw new NegativeLogException();
		}
		return Math.log(valor); // Returns the natural logarithm (base e) of a double value.
	}

	public Double log10(Double valor) throws NegativeLogException {
		if (valor <= 0) {
			throw new NegativeLogException();
		}
		return Math.log10(valor);
	}

	public Double fraction(Double valor) {
		return 1 / valor;
	}

	public Double factorial(Double valor) throws FactorialFractionException {
		if (valor != valor.intValue()) {
			throw new FactorialFractionException();
		}
		Double res = 1.0;
		while (valor != 0) {
			res = res * valor;
			valor--;
		}
		return res;
	}

	public Double raisedPower2(Double valor) {
		return Math.pow(valor, TWO);
	}

	public Double raisedPower3(Double valor) {
		return Math.pow(valor, THREE);
	}

	public Double raised10(Double valor) {
		return Math.pow(TEN, valor);
	}

	public Double nRoot(Double valor1, Double valor2) {
		return Math.pow(valor1, 1.0 / valor2);
	}

	public Double raisedPowerN(Double valor1, Double valor2) {
		return Math.pow(valor1, valor2);
	}
}
