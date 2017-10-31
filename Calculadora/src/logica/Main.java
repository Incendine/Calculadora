package logica;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Stack<Double> operando = new Stack<>();
	static Stack<String> operador = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String ecuacion;

			ArrayList<Jerarquia> prioridad = new ArrayList<Jerarquia>();
			Jerarquia sum = new Jerarquia("Suma", 1, 1, 0, 0, 0, 1);
			Jerarquia res = new Jerarquia("Resta", 1, 1, 0, 0, 0, 1);
			Jerarquia div = new Jerarquia("Division", 1, 1, 1, 1, 0, 1);
			Jerarquia mul = new Jerarquia("Multiplicacion", 1, 1, 1, 1, 0, 1);
			Jerarquia pAbierto = new Jerarquia("pAbierto", 0, 0, 0, 0, 0, 0);
			Jerarquia pCerrado = new Jerarquia("pCerrado", 0, 0, 0, 0, 0, 0);
			
			prioridad.add(sum);
			prioridad.add(div);
			prioridad.add(res);
			prioridad.add(mul);
			prioridad.add(pAbierto);
			prioridad.add(pCerrado);

			System.out.println("Ingrese la ecuacion: ");
			int numeroNegativo=0;
			Scanner entradaEscaner = new Scanner(System.in);
			ecuacion = entradaEscaner.nextLine();

			StringTokenizer st = new StringTokenizer(ecuacion, "-+*/()", true);
			String ecuacionP[] = new String[st.countTokens()];
			int contador = 0;
			while (st.hasMoreTokens()) {
				ecuacionP[contador] = st.nextToken();
				contador++;
			}
			for (int i = 0; i < ecuacionP.length; i++) {
				String caracter = ecuacionP[i];
				if(caracter.equals("-")){
					numeroNegativo=-1;
				}
				if (caracter.equals("+") ||  caracter.equals("*") || caracter.equals("-") || caracter.equals("/")
						|| caracter.equals("(") || caracter.equals(")")) {
					if (operador.isEmpty())
						operador.push(caracter);
					else {
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
						case "(":
							operador.push(caracter);
							break;
						default:
							break;
						}
					}
				} else{
					if(numeroNegativo==-1){
						operando.push(Double.parseDouble(caracter) * numeroNegativo);
						numeroNegativo=0;
					}
					else
						operando.push(Double.parseDouble(caracter));
				}
					
			}
			limpiarPilaOperadores();
			System.out.println(operando.peek());
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Error aritmetico ");
		} catch (EmptyStackException e) {
			// TODO: handle exception
			System.out.println("Faltan operandos");
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
				operador.push("+");
			} else
				operador.push(caracter);
			break;
		case "-":
			if (je.getRestar() > 0) {
				realizarOperacion(operador.peek());
				operador.push("+");
			} else
				operador.push(caracter);
			break;
		case "*":
			if (je.getMultiplicar() > 0) {
				realizarOperacion(operador.peek());
				operador.push("*");
			} else
				operador.push(caracter);
			break;
		case "/":
			if (je.getDividir() > 0) {
				realizarOperacion(operador.peek());
				operador.push("/");
			} else
				operador.push(caracter);
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
			if(operando.isEmpty())
				operando1=0;
			else
			   operando1 = operando.pop();
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
