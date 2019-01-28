
package co.edu.escuelaing.arem.designprimer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.io.InputStreamReader;
import java.util.*;

/**
 * Esta clase permite hacer la lectura de los datos
 * @author Andres
 *
 */
public class Lectura {

	public int N;//Numero de datos que van a entrar para calcular la desviacion estandar
	public List<Double> Data;//Lista que permite almacenar los datos de la entrada

	/**
	 * @param test//Me indica el archivo de test que se va a escoger
	 * @throws Exception//Se coloca la exception por los Buffers
	 */
	public Lectura(String test) throws Exception {
		
		try {
			
			Data = new ArrayList();
			Path file = Paths.get("src/main/java/edu/escuelaing/arem/ASE/app/"+test);
			BufferedReader in = new BufferedReader(new FileReader(file.toString()));
			N =Integer.parseInt(in.readLine());
			String linea;
			while((linea=in.readLine())!=null) {
				Data.add(Double.parseDouble(linea));
			}
			in.close();
			
		} catch (Exception e) {
			System.out.println("HAY UN ERROR");
			
		}
		
		
	}

	public int getN() {
		return N;
	}


	public void setN(int n) {
		N = n;
	}

	public List<Double> getData() {
		return Data;
	}

	public void setData(List<Double> data) {
		Data = data;
	}
	

}
