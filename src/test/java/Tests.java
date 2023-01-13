import es.iesfranciscodelosrios.currency.Contador;
import es.iesfranciscodelosrios.currency.ContadorTotal;
import es.iesfranciscodelosrios.currency.Productor;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void TestContarHijos() throws InterruptedException {
        ContadorTotal ct= new ContadorTotal();
        Object candado1= new Object();
        Productor p1 = new Productor(candado1);
        Contador c1 = new Contador(p1,ct,candado1);
        c1.start();
        c1.join();
    }


    @Test
    public void TestContarHijos2() throws InterruptedException {
        ContadorTotal ct= new ContadorTotal();
        int monedas= 60/3;
        Object candado1= new Object();
        Object candado2= new Object();
        Object candado3= new Object();
        Productor p1 = new Productor(monedas,candado1);
        Productor p2 = new Productor(monedas,candado2);
        Productor p3 = new Productor(monedas,candado3);
        Contador c1 = new Contador(p1,ct,candado1);
        Contador c2 = new Contador(p2,ct,candado2);
        Contador c3 = new Contador(p3,ct,candado3);
        c1.start();
        c2.start();
        c3.start();
        c1.join();
        c2.join();
        c3.join();
    }
}
