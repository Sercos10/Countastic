package es.iesfranciscodelosrios;

import java.net.URL;
import java.util.ResourceBundle;

import es.iesfranciscodelosrios.currency.Contador;
import es.iesfranciscodelosrios.currency.ContadorTotal;
import es.iesfranciscodelosrios.currency.Productor;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SecondaryController implements Initializable, Runnable {

	@FXML
	private Label oneCent;

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

	ContadorTotal ct= new ContadorTotal();
	int monedas= 48/3;
	Object candado1= new Object();
	Object candado2= new Object();
	Object candado3= new Object();
	Productor p1 = new Productor(monedas,candado1);
	Productor p2 = new Productor(monedas,candado2);
	Productor p3 = new Productor(monedas,candado3);
	Contador c1 = new Contador(p1,ct,candado1);
	Contador c2 = new Contador(p2,ct,candado2);
	Contador c3 = new Contador(p3,ct,candado3);
	private Boolean started=false;

	/**
	 * Inicia los contadorse y el Thread para refrescar los label a la misma vez que trabajan los hilos
	 */
	@FXML
	public void startCount() {
		try {
			started=true;
			Thread th = new Thread(this);
			th.start();
			c1.start();
			c2.start();
			c3.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa los label a 0 y totalCoins a la suma de las monedas de los productores
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		oneCent.setText("0");
		twoCents.setText("0");
		fiveCents.setText("0");
		tenCents.setText("0");
		twentyCents.setText("0");
		fiftyCents.setText("0");
		oneEur.setText("0");
		twoEur.setText("0");
		totalCoins.setText(String.valueOf(p1.getnMonedas()+p2.getnMonedas()+p3.getnMonedas()));
		totalCount.setText("0");
	}

	/**
	 * Espera a que terminen de trabajar los hilos y después hace la total y la muestra por pantalla
	 */
	@FXML
	public void contarMoneda(){
		try {
			c1.join();
			c2.join();
			c3.join();
			started=false;
			ct.incrementaDinero(c1.getMonedas());
			ct.incrementaDinero(c2.getMonedas());
			ct.incrementaDinero(c3.getMonedas());
			totalCount.setText(String.valueOf((float)ct.getTotalDine()/100)+"€");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Mientras que los hilos estén en ejecución refresca los label con el numero de monedas de cada tipo que poseen
	 * en total todos los hilos en ese momento
	 */
	@Override
	public void run() {
		while(started) {
			try {
				Thread.sleep(1000);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						oneCent.setText(String.valueOf(c1.getMonedas()[0] + c2.getMonedas()[0] + c3.getMonedas()[0]));
						twoCents.setText(String.valueOf(c1.getMonedas()[1] + c2.getMonedas()[1] + c3.getMonedas()[1]));
						fiveCents.setText(String.valueOf(c1.getMonedas()[2] + c2.getMonedas()[2] + c3.getMonedas()[2]));
						tenCents.setText(String.valueOf(c1.getMonedas()[3] + c2.getMonedas()[3] + c3.getMonedas()[3]));
						twentyCents.setText(String.valueOf(c1.getMonedas()[4] + c2.getMonedas()[4] + c3.getMonedas()[4]));
						fiftyCents.setText(String.valueOf(c1.getMonedas()[5] + c2.getMonedas()[5] + c3.getMonedas()[5]));
						oneEur.setText(String.valueOf(c1.getMonedas()[6] + c2.getMonedas()[6] + c3.getMonedas()[6]));
						twoEur.setText(String.valueOf(c1.getMonedas()[7] + c2.getMonedas()[7] + c3.getMonedas()[7]));
						totalCoins.setText(String.valueOf(p1.getnMonedas()+p2.getnMonedas()+p3.getnMonedas()));
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}