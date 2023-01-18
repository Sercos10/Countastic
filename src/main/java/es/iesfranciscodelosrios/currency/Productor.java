package es.iesfranciscodelosrios.currency;

public class Productor extends Thread{
    private final Object cand;
    private int buffer;
    private Hucha hucha;

    //Diferentes constructores del hilo productor
    public Productor(Object candado){
        this.cand=candado;
    }

    public Productor(Object candado, Hucha hucha){
        this.cand=candado;
        this.hucha=hucha;
    }

    //gettes y setters
    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    /**
     * Cuando inicia su ejecución guarda una moneda del total en el buffer para que la coja el contador
     * después de haberla guardado notifica al contador de que ha terminado su ejecución y se pone a dormir
     */
    @Override
    public void run() {
        try {
            while(hucha.getnMonedas()>0){
                buffer=hucha.cogerMoneda();
                synchronized (cand){
                    Thread.sleep(500);
                    cand.notifyAll();
                    cand.wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (cand){
            cand.notifyAll();
        }
        System.out.println("Productor acabado");
    }
}
