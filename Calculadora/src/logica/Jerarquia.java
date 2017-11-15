package logica;

public class Jerarquia {

	private String nombreOperador;
	private int sumar;
	private int restar;
	private int multiplicar;
	private int dividir;
	private int parentesisAbierto;
	private int parentesisCerrado;
	private int potencia;

	public Jerarquia(String nombreOperador, int sumar, int restar, int multiplicar, int dividir, int parentesisAbierto,
			int parentesisCerrado, int potencia) {
		this.nombreOperador = nombreOperador;
		this.sumar = sumar;
		this.restar = restar;
		this.multiplicar = multiplicar;
		this.dividir = dividir;
		this.parentesisAbierto = parentesisAbierto;
		this.parentesisCerrado = parentesisCerrado;
		this.potencia= potencia;
	}
	public String getNombreOperador() {
		return nombreOperador;
	}
	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}
	public int getSumar() {
		return sumar;
	}
	public void setSumar(int sumar) {
		this.sumar = sumar;
	}
	public int getRestar() {
		return restar;
	}
	public void setRestar(int restar) {
		this.restar = restar;
	}
	public int getMultiplicar() {
		return multiplicar;
	}
	public void setMultiplicar(int multiplicar) {
		this.multiplicar = multiplicar;
	}
	public int getDividir() {
		return dividir;
	}
	public void setDividir(int dividir) {
		this.dividir = dividir;
	}
	public int getParentesisAbierto() {
		return parentesisAbierto;
	}
	public void setParentesisAbierto(int parentesisAbierto) {
		this.parentesisAbierto = parentesisAbierto;
	}
	public int getParentesisCerrado() {
		return parentesisCerrado;
	}
	public void setParentesisCerrado(int parentesisCerrado) {
		this.parentesisCerrado = parentesisCerrado;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
}
