package co.edu.escuelaing.arem.designprimer;


import java.util.*;

/**
 * Esta clase se encarga de la Media
 * @author Andres Giovanne Florez Perez
 *
 */
public class Mean {
	public LinkedList<Double> Data;//Lista enlazada para almacenar los datos
	public double N;//Numero de datos que van a entrar para calcular la desviacion estandar

	/**
	 * @param n - Entra el numero de datos para calcular la media
	 */
	public Mean(int n) {
	
		this.N = (double) n;
		Data = new LinkedList<Double>();

	}

	/**
	 * Este metodo permite calcular la media
	 * @return double
	 */
	public double calculateMean() {
		double sum = 0;
		for (double number : Data) {
			
			sum += number;

		}
		
		double ultimoValor = (sum / N);
		//String decimalTemp = String.format("%.2f",ultimoValor);
		//double valor =Double.parseDouble(decimalTemp);
		//return valor;
		return ultimoValor;

	}
	/**
	 * Este metodo permite llenar la lista enlazada con otra lista 
	 * @param Datax-Datos para llenar la lista enlazada
	 */
	public void fillLinkedList(List<Double> Datax) {
		for(double num:Datax) {
			this.Data.add(num);
			
		}
	}

	public LinkedList<Double> getData() {
		return Data;
	}

	
	public void setData(LinkedList<Double> data) {
		Data = data;
	}

	public double getN() {
		return N;
	}


	public void setN(int n) {
		N = n;
	}

}
