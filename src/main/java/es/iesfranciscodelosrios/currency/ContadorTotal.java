package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;

public class ContadorTotal {
    private int totalDine;
    private Boolean isBusy;

    public ContadorTotal() {
        this.totalDine=0;
        this.isBusy=false;
    }
    public ContadorTotal(int totalDine) {
        this.totalDine = totalDine;
        this.isBusy=false;
    }

    public int getTotalDine() {
        return totalDine;
    }

    public void setTotalDine(int totalDine) {
        this.totalDine = totalDine;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public synchronized void incrementaDinero(Integer[] monedas){
        this.isBusy=true;
        if (monedas[0] > 0){
            totalDine+= (monedas[0]* 1);
        }
        if (monedas[1] > 0){
            totalDine+= (monedas[1] * 2);
        }
        if (monedas[2] > 0){
            totalDine+= (monedas[2] * 5);
        }
        if (monedas[3] > 0){
            totalDine+= (monedas[3] * 10);
        }
        if (monedas[4] > 0){
            totalDine+= (monedas[4] * 20);
        }
        if (monedas[5] > 0){
            totalDine+= (monedas[5] * 50);
        }
        if (monedas[6] > 0){
            totalDine+= (monedas[6] * 100);
        }
        if (monedas[7] > 0){
            totalDine+= (monedas[7] * 200);
        }
        System.out.println(totalDine);
        this.isBusy=false;
    }
}
