import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class ServerData {
	
	private JSONParser parser;
	private JSONObject jsonData;
	private static String path = "Data/data.json";
	
	public ServerData() {
	}
	
	public void start() {
	parser = new JSONParser();
		
		try {
			FileReader file = new FileReader(path);
			System.out.println("Archivo encontrado.");
			jsonData = (JSONObject) parser.parse(file);
			System.out.println("Archivo Json leído.");
			file.close();
		}
		catch (Exception e) {
			File file = new File("Data/data.json");
			System.out.println("Archivo no encontrado");
			try {
				file.createNewFile();
				file.canRead();
				file.canWrite();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			jsonData = new JSONObject();
		} 
	}
	
	public boolean checkData() {
		if(jsonData == null) {
			System.out.println("Error: Data no ha sido inicializada. Precione el botón start");
			return false;
		}
		return true;
	}
	
	public void printDataConsole() {
		if(checkData()) {
			System.out.println("===== Todos los Datos =====");
			System.out.println(jsonData.toString());
		}
	}
	
	public int getPrice(String id) {
		if(id.equalsIgnoreCase("")) {
			System.out.println("ID ingresado es inválido.");
			return -1;
		}
		
		if(checkData()) {
			
			try {
			String price = (String) jsonData.get(id);
			return Integer.parseInt(price);
			}
			
			catch (Exception e) {
				System.out.println("Dato no encontrado.");
			}
		}
		
		return -1;
	}
	
	public void saveNewPrice(String id, String price) {
		
		if(id.equalsIgnoreCase(""))
		{
			System.out.println("El ID ingresado no es correcto.");
			return;
		}
		
		if(price.equalsIgnoreCase(""))
		{
			System.out.println("El precio ingresado no es correcto.");
			return;
		}

		if(checkData()) {
			jsonData.put(id, price);
			this.saveData();
		}
	}
	
	public void saveData() {
		try {
			 
			FileWriter file = new FileWriter(path);
			file.write(jsonData.toJSONString());
			file.flush();
			file.close();
			System.out.println("Datos guardados.");
		}
		catch (IOException e) {
			System.out.println("No se pudo guardar los datos.");
		}
	}
	
	
}
