import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class ServerData implements QRController{
	
	private JSONParser parser;
	private JSONObject jsonData;
	private static String path = "Data/data.json";
	
	public ServerData() {
	}
	
	public void start() {
		readData();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final ServerView window = new ServerView();
					//Events
					window.btnPrintInConsole.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							printDataConsole();
						}
					});
					window.btnNewPrice.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							saveNewPrice(window.idInput.getText(), window.priceInput.getText());
						}
					});
					window.btnSearch.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String newPrice;
							int value = getPrice(window.searchInput.getText());
							
							if( value < 0 )
								newPrice = "";
							else
								newPrice = "" + value;
							
							window.searchResult.setText(newPrice);
						}
					});
					
					window.frmPriceReader.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private void readData(){
		parser = new JSONParser();
		
		try {
			FileReader file = new FileReader(path);
			System.out.println("Archivo encontrado.");
			jsonData = (JSONObject) parser.parse(file);
			System.out.println("Archivo Json leido.");
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
			System.out.println("Error: Data no ha sido inicializada. Precione el bot�n start");
			return false;
		}
		return true;
	}
	
	void printDataConsole() {
		if(checkData()) {
			System.out.println("===== Todos los Datos =====");
			System.out.println(jsonData.toString());
		}
	}
	
	int getPrice(String id) {
		if(id.equalsIgnoreCase("")) {
			System.out.println("ID ingresado es inv�lido.");
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
	
	private void saveNewPrice(String id, String price) {
		
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
