package es.iesfranciscodelosrios;

import java.net.URL;
import java.util.ResourceBundle;

import es.iesfranciscodelosrios.currency.Contador;
import es.iesfranciscodelosrios.currency.ContadorTotal;
import es.iesfranciscodelosrios.currency.Productor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SecondaryController implements Initializable {
	
	@FXML
	private Label oneCents;
	
	@FXML
	private Label twoCents;
	
	@FXML
	private Label fiveCents;
	
	@FXML
	private Label tenCents;
	
	@FXML
	private Label twentyCents;
	
	@FXML
	private Label fiftyCents;
	
	@FXML
	private Label oneEur;
	
	@FXML
	private Label twoEur;
	
	@FXML
	private Label totalCoins;
	
	@FXML
	private Label totalCount;
	
	@FXML
	public void startProgram() {
		try {
			ContadorTotal ct= new ContadorTotal();
	        int monedas= 60/3;
	        Object candado1= new Object();
	        Object candado2= new Object();
	        Object candado3= new Object();
	        Productor p1 = new Productor(monedas,candado1);
	        Productor p2 = new Productor(monedas,candado2);
	        Productor p3 = new Productor(monedas,candado3);
	        Contador c1 = new Contador(p1,ct,candado1);
	        Contador c2 = new Contador(p2,ct,candado2);
	        Contador c3 = new Contador(p3,ct,candado3);
	        c1.start();
	        c2.start();
	        c3.start();
	        c1.join();
	        c2.join();
	        c3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		oneCents.setText("0");
		twoCents.setText("0");
		fiveCents.setText("0");
		tenCents.setText("0");
		twentyCents.setText("0");
		fiftyCents.setText("0");
		oneEur.setText("0");
		twoEur.setText("0");
		totalCoins.setText("99");
		totalCount.setText("0");
	}
}