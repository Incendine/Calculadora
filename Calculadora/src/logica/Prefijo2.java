package logica;

import java.util.Stack;
import java.util.StringTokenizer;

public class Prefijo2 {
	static Stack<String> pilaDefinitiva = new Stack<>();
	static Stack<String> pilaTemp = new Stack<>();
	
	public void realizarEcuacion(String ecu) {
	  String cadena = "(" + ecu + ")";
		StringTokenizer st = new StringTokenizer(cadena, "-+*/()^", true);
		String ecuacionP[] = new String[st.countTokens()];
		int contador = 0;
		while (st.hasMoreTokens()) {
			ecuacionP[contador] = st.nextToken();
			contador++;
		}
		for (int i = (ecuacionP.length - 1) ; i > -1 ; i--) {
			String caracter = ecuacionP[i];
			switch (caracter) {
			case ")":
				pilaTemp.push(caracter);
				break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                if(jerarquia(pilaTemp.peek()) > jerarquia(caracter)){
                  pilaDefinitiva.push(pilaTemp.peek());
                  pilaTemp.pop();
                }
                pilaTemp.push(caracter);
                break;
            case "(":
                while (!pilaTemp.peek().equals(")")) {
				   pilaDefinitiva.push(pilaTemp.peek());
				   pilaTemp.pop();  
				}
                pilaTemp.pop();
                break;
			default:
			      pilaDefinitiva.push(caracter);
				break;
			}
			
		}
		String resultado = "";
		while (!pilaDefinitiva.isEmpty()) {
            resultado += pilaDefinitiva.peek();
			pilaDefinitiva.pop();
		}
		System.out.println(resultado);
	}
	public static int jerarquia (String caracter){
	    int resultado= 0;
		switch (caracter) {
		case "^":
			resultado = 5;
			break;
        case "*":
        case "/":
            resultado = 4;
            break;
        case "+":
        case "-":
            resultado = 3;
            break;
        case ")":
            resultado = 2;
            break;
        case "(":
            resultado = 1;
            break;
		default:
			break;
		}
		return resultado;
	}
}
