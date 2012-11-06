import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ServerView {

	private JFrame frmPriceReader;
	private JTextField idInput;
	private JTextField priceInput;
	private JButton btnNewPrice;
	private JTextField searchInput;
	private ServerData serverData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerView window = new ServerView();
					window.frmPriceReader.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerView() {
		initialize();
		serverData = new ServerData(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPriceReader = new JFrame();
		frmPriceReader.setTitle("Price Reader | Server");
		frmPriceReader.setBounds(100, 100, 450, 316);
		frmPriceReader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPriceReader.getContentPane().setLayout(null);
		
		JButton btnStartData = new JButton("Start Data");
		btnStartData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverData.start();
			}
		});
		btnStartData.setBounds(309, 11, 115, 23);
		frmPriceReader.getContentPane().add(btnStartData);
		
		JButton btnPrintInConsole = new JButton("Print in Console");
		btnPrintInConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverData.printDataConsole();
			}
		});
		btnPrintInConsole.setBounds(309, 45, 115, 23);
		frmPriceReader.getContentPane().add(btnPrintInConsole);
		
		idInput = new JTextField();
		idInput.setBounds(309, 79, 115, 20);
		frmPriceReader.getContentPane().add(idInput);
		idInput.setColumns(10);
		
		priceInput = new JTextField();
		priceInput.setBounds(309, 110, 115, 20);
		frmPriceReader.getContentPane().add(priceInput);
		priceInput.setColumns(10);
		
		btnNewPrice = new JButton("New Price");
		btnNewPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverData.saveNewPrice(idInput.getText(), priceInput.getText());
			}
		});
		btnNewPrice.setBounds(309, 141, 115, 23);
		frmPriceReader.getContentPane().add(btnNewPrice);
		
		Label label = new Label("Inicializar los Datos.");
		label.setBounds(10, 11, 293, 22);
		frmPriceReader.getContentPane().add(label);
		
		Label label_1 = new Label("Imprimir los Datos en Consola.");
		label_1.setBounds(10, 46, 293, 22);
		frmPriceReader.getContentPane().add(label_1);
		
		Label label_2 = new Label("ID de un nuevo precio.");
		label_2.setBounds(10, 79, 293, 22);
		frmPriceReader.getContentPane().add(label_2);
		
		Label label_3 = new Label("Valor de un nuevo precio.");
		label_3.setBounds(10, 110, 293, 22);
		frmPriceReader.getContentPane().add(label_3);
		
		Label label_4 = new Label("Guardar los nuevos valores.");
		label_4.setBounds(10, 141, 293, 22);
		frmPriceReader.getContentPane().add(label_4);
		
		searchInput = new JTextField();
		searchInput.setColumns(10);
		searchInput.setBounds(309, 175, 115, 20);
		frmPriceReader.getContentPane().add(searchInput);
		
		final Label searchResult = new Label("");
		searchResult.setBounds(309, 230, 115, 22);
		frmPriceReader.getContentPane().add(searchResult);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPrice;
				int value = serverData.getPrice(searchInput.getText());
				
				if( value < 0 )
					newPrice = "";
				else
					newPrice = "" + value;
				
				searchResult.setText(newPrice);
			}
		});
		btnSearch.setBounds(309, 201, 115, 23);
		frmPriceReader.getContentPane().add(btnSearch);
		
		Label label_5 = new Label("ID del precio que se desea buscar.");
		label_5.setBounds(10, 169, 293, 22);
		frmPriceReader.getContentPane().add(label_5);
		
		Label label_6 = new Label("Buscar.");
		label_6.setBounds(10, 201, 293, 22);
		frmPriceReader.getContentPane().add(label_6);
		
		Label label_7 = new Label("Resultado de la b\u00FAsqueda:");
		label_7.setBounds(10, 229, 293, 22);
		frmPriceReader.getContentPane().add(label_7);
		
	}
}
