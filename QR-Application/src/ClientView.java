import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ClientView extends JFrame{

	public final JLabel lblContent;
	public final JButton btnPhoto;
	
	public ClientView(){
		setTitle("QR Reader | Dise\u00F1o Detallado de Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblContenido = new JLabel("Client View");
		lblContenido.setBounds(170, 34, 200, 23);
		panel.add(lblContenido);
		
		lblContent = new JLabel("");
		lblContent.setBounds(213, 38, 500, 14);
		panel.add(lblContent);
		
		btnPhoto = new JButton("Take QR Photo");
		btnPhoto.setBounds(110, 174, 200, 23);
		panel.add(btnPhoto);
	}
}
