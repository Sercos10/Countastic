package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;

public class ContadorTotal {
    private int totalDine;

    public ContadorTotal() {
        this.totalDine=0;
    }

    public ContadorTotal(int totalDine) {
        this.totalDine = totalDine;
    }

    public synchronized void incrementaDinero(ArrayList<Integer> monedas){

        if (monedas.get(0) > 0){
            totalDine=totalDine+ monedas.get(0) * 1;
        }
        if (monedas.get(1) > 0){
            totalDine=totalDine+ monedas.get(11) * 2;
        }
        if (monedas.get(2) > 0){
            totalDine=totalDine+ monedas.get(2) * 5;
        }
        if (monedas.get(3) > 0){
            totalDine=totalDine+ monedas.get(3) * 10;
        }
        if (monedas.get(4) > 0){
            totalDine=totalDine+ monedas.get(4) * 20;
        }
        if (monedas.get(5) > 0){
            totalDine=totalDine+ monedas.get(5) * 50;
        }
        if (monedas.get(6) > 0){
            totalDine=totalDine+ monedas.get(6) * 100;
        }
        if (monedas.get(7) > 0){
            totalDine=totalDine+ monedas.get(7) * 200;
        }
    }
}
