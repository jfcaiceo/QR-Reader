import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;


public class ClientController implements QRController{

	@Override
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView frame = new ClientView();
					frame.btnPhoto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							takePhoto();
						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void takePhoto(){
		System.out.print("Tamando Foto\n");
	}

}
