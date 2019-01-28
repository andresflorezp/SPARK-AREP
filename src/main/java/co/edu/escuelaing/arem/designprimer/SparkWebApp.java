package co.edu.escuelaing.arem.designprimer;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import java.util.*;
public class SparkWebApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		port(getPort());
		get("/index",(req,resp)->pageIndex(req,resp));
		get("/calculo",(req,resp)->Calculo(req,resp));
		get("/results",(req,resp)->answer(req, resp));
		
	}
	
	public static String pageIndex(Request req,Response resp){
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>AREP-Lab 2</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>AREP-LAB 2</h1>\n" +
				"    <p>Este es un programa que calcula la media y la desviacion estandar para iniciar de click en el siguiente\n" +
				"        vinculo <a href=\"\\calculo\">Oprime</a>\n" +
				"    </p>\n" +
				"</body>\n" +
				"</html>";
		return respuesta;
	}
	public static String Calculo(Request req,Response resp){
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>AREP-LAB 2</h1>\n" +
				"    <br/>\n" +
				"    <h2>Digita el conjunto de datos de la siguiente forma</h2>\n" +
				"    <p>Ej:\n" +
				"        4;5.2;6;2.3;........;..\n" +
				"    </p>\n" +
				"    <form action=\"/results\">\n" +
				"        <h3>Conjunto de datos numero 1</h3>\n" +
				"        <input type=\"text\" placeholder=\"Numeros espaciados con ';'\" name=\"DataOne\">\n" +
				"        <h3>Conjunto de datos numero 2</h3>\n" +
				"        <input type=\"text\" placeholder=\"Numeros espaciados con ';'\" name=\"DataTwo\">\n" +
				"        <br><br><br>\n" +
				"        <input type=\"submit\" value=\"Calcular\">\n" +
				"\n" +
				"    </form>\n" +
				"\n" +
				"</body>\n" +
				"</html>";
		return respuesta;
	}
	public static String answer(Request req,Response resp){
		String set1 = req.queryParams("DataOne");
		String set2 = req.queryParams("DataTwo");
		String[] particion1=set1.split(";");
		String[] particion2=set2.split(";");
		LinkedList<Double> Data1=new LinkedList();
		LinkedList<Double> Data2=new LinkedList();
		for(String num:particion1) {
			Data1.add(Double.parseDouble(num));
		}
		for(String num:particion2) {
			Data2.add(Double.parseDouble(num));
		}
		int N1 = Data1.size();
		int N2 = Data2.size();
		//Calculo de desvicacion estandar
		Mean media1 = new Mean(N1);
		Mean media2 = new Mean(N2);
		devStand des1 = new devStand(N1);
		devStand des2 = new devStand(N2);
		
		media1.setData(Data1);
		media2.setData(Data2);
		
		des1.setData(Data1);
		des2.setData(Data2);
		double media1r = media1.calculateMean();
		double media2r = media2.calculateMean();
		double desviacion1=des1.calculatedevStand();
		double desviacion2=des2.calculatedevStand();
		
		String tabla="";
		for(int i=0;i<Math.max(particion1.length, particion2.length);i++) {
			if(i==particion1.length)tabla+=genTable("-", particion2[i]);
			else if(i==particion2.length)tabla+=genTable(particion1[i],"-");
			else tabla+=genTable(particion1[i],particion2[i]);
			
		}
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>AREP-LAB 2</h1>\n" +
				"\n" +
				"    <h2>Los resultados se presentan a continuacion</h2>\n" +
				"    <table>\n" +
				"        <tr>\n" +
				"            <th>Column 1</th>\n" +
				"            <th>Column 2</th>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <th>Conjuto de datos #1</th>\n" +
				"            <th>Conjunto de datos #2</th>\n" +
				"        </tr>\n" +
					tabla+
				"    </table>\n" +
				"\n" +
				"La media para los datos 1 es: "+String.format("%.2f",media1r)+"\n"+"<br>"+
				"La desviacion para los datos 1 es: "+String.format("%.2f",desviacion1)+"\n"+"<br>"+
				"La media para los datos 2 es: "+String.format("%.2f",media2r)+"\n"+"<br>"+
				"La desviacion para los datos 2 es: "+String.format("%.2f",desviacion2)+"\n"+"<br>"+
				"\n" +
				"\n" +
				"\n" +
				"</body>\n" +
				"</html>";
		return respuesta;
	}
	static String genTable(String num1,String num2) {
		return 	"<tr>\n" +
				"<th>"+num1+"</th>\n" +
				"<th>"+num2+"</th>\n" +
				"</tr>\n";
		
	}
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
	}


}
