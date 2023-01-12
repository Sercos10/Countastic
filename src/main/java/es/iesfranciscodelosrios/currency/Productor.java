package es.iesfranciscodelosrios.currency;

import java.util.Random;

public class Productor extends Thread{
    private int nMonedas;

    public Productor(){
        this.nMonedas=100;
    }

    public Productor(int NumMonedas){
        this.nMonedas=NumMonedas;
    }

    public synchronized int cogerMoneda(){
        if (nMonedas>0){
            Random randomGenerator=new Random();
            int tipo =randomGenerator.nextInt(7) + 1;
            int moneda= 0;
            switch (tipo){
                case 1: moneda=1;
                        break;
                case 2: moneda=2;
                    break;
                case 3: moneda=5;
                    break;
                case 4: moneda=10;
                    break;
                case 5: moneda=20;
                    break;
                case 6: moneda=50;
                    break;
                case 7: moneda=100;
                    break;
                case 8: moneda=200;
                    break;
            }
            return moneda;
        }
        return 0;
    }
}
