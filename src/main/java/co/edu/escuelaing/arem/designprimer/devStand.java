package co.edu.escuelaing.arem.designprimer;
import java.util.*;

/**
 * Esta clase se encarga de la Desviacion Estandar
 * @author Andres Giovanne Florez Perez
 *
 */
public class devStand {
	public LinkedList<Double> Data;//Lista enlazada para almacenar los datos
	public double N;//Numero de datos que van a entrar para calcular la desviacion estandar
	public Mean mean;//La media que permite calcular la desviacion
	/**
	 * @param N - Numero de datos que van a entrar para calcular la desviacion estandar
	 */
	public devStand(int N) {
	
		this.N=(int)N;
		Data=new LinkedList<Double>();
		mean = new Mean((int) N);
		
	}
	
	/**
	 * Este metodo calcula la desviacion estandar
	 * @return Double
	 */
	public double calculatedevStand() {
		mean.setData(Data);
		double avg = mean.calculateMean();
		double sum=0;
		for(double number:Data) {
			sum+=Math.pow(number-avg, 2);
			
		}
		Double valorParcial = sum/(N-1);
		valorParcial=(double) Math.sqrt(valorParcial);
		//String decimalTemp = String.format("%.2f",valorParcial);
		//double valor=Double.parseDouble(decimalTemp);
		//return valor;
		return valorParcial;
	}
	/**
	 * Este metodo permite llenar la lista enlazada con otra lista 
	 * @param Datax-Datos para llenar la lista enlazada
	 */
	public void fillLinkedList(List<Double> list) {
		for(double num:list) {
			this.Data.add(num);	
		}
	}
	

	public LinkedList<Double> getData() {
		return Data;
	}

	public void setData(LinkedList<Double> data) {
		Data = data;
	}
	

	public Double getN() {
		return N;
	}

	public void setN(double n) {
		N = (double) n;
	}
	

}
