package es.iesfranciscodelosrios.currency;

import java.util.Random;

public class Productor extends Thread{
    private int nMonedas;
    private Object cand;
    private int buffer;

    //Diferentes constructores del hilo productor
    public Productor(Object candado){
        this.nMonedas=100;
        this.cand=candado;
    }

    public Productor(int NumMonedas,Object candado){
        this.nMonedas=NumMonedas;
        this.cand=candado;
    }

    //gettes y setters
    public int getnMonedas() {
        return nMonedas;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    /**
     * Metodo en el que genera una de moneda de 1 cent,2 cent,5 cent,10 cent,20 cent,50 cent,1€,2€
     * y lo guarda en el buffer para que el contador pueda coger la moneda y resta una moneda del total
     * @return la moneda de 1,2,5,10,20,50,1€,2€
     */
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
                default:break;
            }
            return moneda;
        }
        return 0;
    }

    /**
     * Cuando inicia su ejecución guarda una moneda del total en el buffer para que la coja el contador
     * después de haberla guardado notifica al contador de que ha terminado su ejecución y se pone a dormir
     */
    @Override
    public void run() {
        try {
            while(nMonedas>0){
                buffer=cogerMoneda();
                synchronized (cand){
                    Thread.sleep(1000);
                    cand.notifyAll();
                    nMonedas--;
                    cand.wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
