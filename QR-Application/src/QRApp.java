
public class QRApp extends Application{
	private QRController controller;
	
	public void run(){
		/*Metodos de device no implementados todavia
		 * 
		//Si es notebook, queda como servidor
		if(this.currentDevice.getType() == 0){
			controller = new ServerData();
		}
		//Si no, queda como cliente
		else{
			controller = new ClientController();
		}
		*/
		
		//controller = new ClientController();
		controller = new ServerData();
		
		controller.start();
	}
}
