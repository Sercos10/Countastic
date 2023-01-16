package es.iesfranciscodelosrios.currency;

import java.util.Random;

public class Productor extends Thread{
    private int nMonedas;
    private Object cand;
    private int buffer;

    public Productor(Object candado){
        this.nMonedas=100;
        this.cand=candado;
    }

    public Productor(int NumMonedas,Object candado){
        this.nMonedas=NumMonedas;
        this.cand=candado;
    }


    public int getnMonedas() {
        return nMonedas;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public synchronized int cogerMoneda(){
        if (nMonedas>0){
            Random randomGenerator=new Random();
            int tipo =randomGenerator.nextInt(8) + 1;
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

    @Override
    public void run() {
        try {
            while(nMonedas>0){
                System.out.println("Productor: Produciendo moneda");
                buffer=cogerMoneda();
                synchronized (cand){
                    Thread.sleep(1000);
                    System.out.println("Productor: notificando a consumidor");
                    cand.notifyAll();
                    System.out.println("Productor: a mimir");
                    nMonedas--;
                    cand.wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
