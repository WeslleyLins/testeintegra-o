import cliente.Consumidor;
import ingressos.Ingresso;
import ingressos.LugarDisponivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class TestLugarDisponivel {



    @Test
    public void testarSeEpossivelComprarLugar(){
        LugarDisponivel lugar = new LugarDisponivel(0,100);

        Consumidor consumidor = Mockito.mock(Consumidor.class);
        Mockito.when(consumidor.getQtdCliente()).thenReturn(50F);

        Ingresso ingresso = Mockito.mock(Ingresso.class);
        Mockito.when(ingresso.getIngresso()).thenReturn(true);


        Assertions.assertEquals("Lugar Comprado", lugar.local(consumidor,ingresso));
        Mockito.verify(consumidor, times(2)).getQtdCliente();
    }

    @Test
    public void testarSeNãoEpossivelComprarLugar(){
        LugarDisponivel lugar = new LugarDisponivel(0,100);

        Consumidor consumidor = Mockito.mock(Consumidor.class);
        Mockito.when(consumidor.getQtdCliente()).thenReturn(120F);

        Ingresso ingresso = Mockito.mock(Ingresso.class);
        Mockito.when(ingresso.getIngresso()).thenReturn(false);


        Assertions.assertEquals("Não foi possivel", lugar.local(consumidor,ingresso));

    }

    @Test
    public void testarSeTemLugarDisponivel(){
        LugarDisponivel lugar = new LugarDisponivel(0F,80);

        Consumidor consumidor = Mockito.mock(Consumidor.class);
        Mockito.when(consumidor.getQtdCliente()).thenReturn(2F);

        Ingresso ingresso = Mockito.mock(Ingresso.class);
        Mockito.when(ingresso.getIngresso()).thenReturn(true);

        Assertions.assertTrue(lugar.localLivre(consumidor,ingresso));

        Mockito.verify(consumidor, Mockito.never()).comprar();
    }

    @Test
    public void testarSeTemNãoLugarDisponivel(){
        LugarDisponivel lugar = new LugarDisponivel(0,80);

        Consumidor consumidor = Mockito.mock(Consumidor.class);
        Mockito.when(consumidor.getQtdCliente()).thenReturn(100F);

        Ingresso ingresso = Mockito.mock(Ingresso.class);
        Mockito.when(ingresso.getIngresso()).thenReturn(true);

        Assertions.assertFalse(lugar.localLivre(consumidor,ingresso));
    }






}
