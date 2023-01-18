package es.iesfranciscodelosrios.currency;

public class Consumidor extends Thread{
    private Productor pro;
    private ContadorTotal contTotal;
    private Integer[] Monedas;
    private final Object cand;
    private Hucha hucha;
    
    public Consumidor(Object cand) {
        this.cand = cand;
    }

    /**
     * Constructor del hilo contador
     * @param p el hilo productor al que se le va a asociar para realizar la sincronización
     * @param ct el objeto donde se va a guardar el dinero
     * @param candado el objeto Object que se va a utilizar de candado para sincronizar productor y consumidor
     * @param hucha el objeto hucha al que va a acceder para coger la moneda
     */
    public Consumidor(Productor p, ContadorTotal ct, Object candado,Hucha hucha){
        this.pro=p;
        this.contTotal=ct;
        Monedas = new Integer[8];
        Monedas[0]=0;
        Monedas[1]=0;
        Monedas[2]=0;
        Monedas[3]=0;
        Monedas[4]=0;
        Monedas[5]=0;
        Monedas[6]=0;
        Monedas[7]=0;
        this.cand=candado;
        this.hucha=hucha;
    }

    public Productor getPro() {
        return pro;
    }

    public ContadorTotal getContTotal() {
        return contTotal;
    }

    public Integer[] getMonedas() {
        return Monedas;
    }

    @Override
    public void run() {
        pro.start();
        try {
            while(hucha.getnMonedas()>0){
                synchronized (cand){
                    cand.wait();
                }
                hucha.CuentaMoneda(pro.getBuffer());
                synchronized (cand){
                    Thread.sleep(500);
                    cand.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (cand){
            cand.notifyAll();
        }
        System.out.println("Consumidor acabado");
    }
}
