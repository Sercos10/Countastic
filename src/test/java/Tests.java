import es.iesfranciscodelosrios.currency.Consumidor;
import es.iesfranciscodelosrios.currency.ContadorTotal;
import es.iesfranciscodelosrios.currency.Hucha;
import es.iesfranciscodelosrios.currency.Productor;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void TestContarHijos() throws InterruptedException {
        int monedas=1;
        Hucha hucha = new Hucha(monedas);
        ContadorTotal ct= new ContadorTotal();
        Object candado1= new Object();
        Productor p1 = new Productor(candado1);
        Consumidor c1 = new Consumidor(p1,ct,candado1,hucha);
        c1.start();
        c1.join();
    }


    @Test
    public void TestContarHijos2() throws InterruptedException {
        ContadorTotal ct= new ContadorTotal();
        int monedas= 60;
        Hucha hucha = new Hucha(monedas);
        Object candado1= new Object();
        Object candado2= new Object();
        Object candado3= new Object();
        Productor p1 = new Productor(candado1,hucha);
        Productor p2 = new Productor(candado2,hucha);
        Productor p3 = new Productor(candado3,hucha);
        Consumidor c1 = new Consumidor(p1,ct,candado1,hucha);
        Consumidor c2 = new Consumidor(p2,ct,candado2,hucha);
        Consumidor c3 = new Consumidor(p3,ct,candado3,hucha);
        c1.start();
        c2.start();
        c3.start();
        c1.join();
        c2.join();
        c3.join();
    }
}
