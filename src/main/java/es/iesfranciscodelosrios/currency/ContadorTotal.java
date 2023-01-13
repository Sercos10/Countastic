package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;

public class ContadorTotal {
    private int TotalDine;

    public synchronized void incrementaDinero(ArrayList<Integer> monedas){

        if (monedas.get(0) > 0){
            TotalDine=TotalDine+ monedas.get(0) * 1;
        }
        if (monedas.get(1) > 0){
            TotalDine=TotalDine+ monedas.get(11) * 2;
        }
        if (monedas.get(2) > 0){
            TotalDine=TotalDine+ monedas.get(2) * 5;
        }
        if (monedas.get(3) > 0){
            TotalDine=TotalDine+ monedas.get(3) * 10;
        }
        if (monedas.get(4) > 0){
            TotalDine=TotalDine+ monedas.get(4) * 20;
        }
        if (monedas.get(5) > 1){
            TotalDine=TotalDine+ monedas.get(5) * 50;
        }
        if (monedas.get(6) > 1){
            TotalDine=TotalDine+ monedas.get(6) * 100;
        }
        if (monedas.get(7) > 1){
            TotalDine=TotalDine+ monedas.get(7) * 200;
        }
    }
}
