package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;

public class ContadorTotal {
    private int TotalDine;

    public synchronized void incrementaDinero(ArrayList<Integer> monedas){
        ArrayList<Integer> tipoMoneda = new ArrayList<>();

        if (monedas.get(0) > 0){
            tipoMoneda.add(0, monedas.get(0) * 1);
        }
        if (monedas.get(1) > 0){
            tipoMoneda.add(1, monedas.get(1) * 2);
        }
        if (monedas.get(2) > 0){
            tipoMoneda.add(2, monedas.get(2) * 5);
        }
        if (monedas.get(3) > 0){
            tipoMoneda.add(3, monedas.get(3) * 10);
        }
        if (monedas.get(4) > 0){
            tipoMoneda.add(4, monedas.get(4) * 20);
        }
        if (monedas.get(5) > 1){
            tipoMoneda.add(5, monedas.get(5) * 50);
        }
        if (monedas.get(6) > 1){
            tipoMoneda.add(6, monedas.get(6) * 100);
        }
        if (monedas.get(7) > 1){
            tipoMoneda.add(7, monedas.get(7) * 200);
        }
    }
}
