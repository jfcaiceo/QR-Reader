
public class QRApp extends Application{
	private QRController controller;
	
	public void run(){
		/*
		//Si es notebook, queda como servidor
		if(this.currentDevice.getType() == 0){
			controller = new ServerController();
		}
		//Si no, queda como cliente
		else{
			controller = new ClientController();
		}
		*/
		controller = new ClientController();
		controller.start();
	}
}
