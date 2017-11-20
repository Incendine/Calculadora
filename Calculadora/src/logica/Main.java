package logica;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Stack<Double> operando = new Stack<>();
	static Stack<String> operador = new Stack<>();

	static boolean numeroNegativo = false;

	public void realizarEcuacion(String ecu) {
		// TODO Auto-generated method stub

		try {
			String ecuacion = ecu;

			ArrayList<Jerarquia> prioridad = new ArrayList<Jerarquia>();
			Jerarquia sum = new Jerarquia("Suma", 1, 1, 0, 0, 0, 1, 0);
			Jerarquia res = new Jerarquia("Resta", 1, 1, 0, 0, 0, 1, 0);
			Jerarquia div = new Jerarquia("Division", 1, 1, 1, 1, 0, 1, 0);
			Jerarquia mul = new Jerarquia("Multiplicacion", 1, 1, 1, 1, 0, 1, 0);
			Jerarquia pAbierto = new Jerarquia("pAbierto", 0, 0, 0, 0, 0, 0, 0);
			Jerarquia pCerrado = new Jerarquia("pCerrado", 0, 0, 0, 0, 0, 0, 0);
			Jerarquia potencia = new Jerarquia("potencia", 1, 1, 1, 1, 0, 0, 1);

			prioridad.add(sum);

			prioridad.add(div);
			prioridad.add(res);
			prioridad.add(mul);
			prioridad.add(pAbierto);
			prioridad.add(pCerrado);
			prioridad.add(potencia);

			System.out.println("La ecuacion: ");
			System.out.println(ecuacion);
			int entro = 0;
			StringTokenizer st = new StringTokenizer(ecuacion, "-+*/()^", true);
			String ecuacionP[] = new String[st.countTokens()];
			int contador = 0;
			while (st.hasMoreTokens()) {
				ecuacionP[contador] = st.nextToken();
				contador++;
			}
			for (int i = 0; i < ecuacionP.length; i++) {
				String caracter = ecuacionP[i];
				String siguiente = "";
				if (i < (ecuacionP.length - 1))
					siguiente = ecuacionP[i + 1];
				if (caracter.equals("-") && !siguiente.equals("(")) {
					numeroNegativo = true;
				}
				if (caracter.equals("+") || caracter.equals("*") || caracter.equals("-") || caracter.equals("/")
						|| caracter.equals("^") || caracter.equals("(") || caracter.equals(")")) {

					if (entro == 0 || caracter.equals("(")) {
						if (operador.isEmpty() && numeroNegativo == true)
							operador.push("+");
						if (operador.isEmpty() && numeroNegativo == false)
							operador.push(caracter);
						else {
							for(int repetir=0; repetir < 2; repetir++)
							{
								if (operador.isEmpty()){
								 repetir=2;
								}else {
									String op = operador.peek();
									switch (op) {
									case "+":
										revisarPrioridad(caracter, sum);
										break;
									case "-":
										revisarPrioridad(caracter, res);
										break;
									case "*":
										revisarPrioridad(caracter, mul);
										break;
									case "/":
										revisarPrioridad(caracter, div);
										break;
									case "^":
										revisarPrioridad(caracter, potencia);
										break;
									case "(":
										repetir=2;
										break;
									default:
										break;
									}
								}
							}
							if(!caracter.equals(")"))
							 operador.push(caracter);
						}
						entro++;
					}
					if (caracter.equals(")"))
						entro = 0;

				} else {
					entro = 0;
					if (numeroNegativo) {
						operando.push(Double.parseDouble(caracter) * -1);
						numeroNegativo = false;

					} else {
						operando.push(Double.parseDouble(caracter));
					}

				}

			}
			limpiarPilaOperadores();
			System.out.println("Resultado = " + operando.peek());
			operando.pop();
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Error aritmetico ");

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Entrada no reconocida");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	public static void revisarPrioridad(String caracter, Jerarquia je) throws Exception {
		switch (caracter) {
		case "+":
			if (je.getSumar() > 0) {
				realizarOperacion(operador.peek());
			}
			break;
		case "-":
			if (je.getRestar() > 0) {
				realizarOperacion(operador.peek());
			}
			break;
		case "*":
			if (je.getMultiplicar() > 0) {
				realizarOperacion(operador.peek());
			}
			break;
		case "/":
			if (je.getDividir() > 0) {
				realizarOperacion(operador.peek());
			}
			break;
		case "^":
			if (je.getPotencia() > 0) {
				realizarOperacion(operador.peek());
			}
			break;
		case ")":
			while (!operador.peek().equals("(")) {
				realizarOperacion(operador.peek());
			}
			operador.pop();
			break;
		case "(":
			operador.push("(");
			break;
		}

	}

	public static void realizarOperacion(String operador2) throws Exception {

		if (operador2.equals("(")) {
			operador.pop();
		} else {
			double operando2 = operando.pop();
			double operando1;
			if (operando.isEmpty())
				operando1 = 0;
			else {
				operando1 = operando.pop();
			}
			switch (operador2) {
			case "+":
			case "-":
				operando.push(operando1 + operando2);
				operador.pop();
				break;
			case "*":
				operando.push(operando1 * operando2);
				operador.pop();
				break;
			case "^":
				operando.push(Math.pow(operando1, operando2));
				operador.pop();
				break;
			case "/":
				if (operando2 == 0)
					throw new Exception("Division por cero");
				else {
					operando.push(operando1 / operando2);
					operador.pop();
				}
				break;

			}
		}

	}

	public static void limpiarPilaOperadores() throws Exception {
		while (!operador.isEmpty()) {

			realizarOperacion(operador.peek());
		}
	}
}
