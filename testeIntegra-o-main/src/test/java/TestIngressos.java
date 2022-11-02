import cliente.Consumidor;
import ingressos.Ingresso;
import ingressos.LugarDisponivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIngressos {

    Ingresso ingressos;

    @BeforeEach
    public void setUp(){
        ingressos =new Ingresso();
    }





    @Test
    public void VerificarAareaDoCliente(){

        LugarDisponivel lugar = Mockito.mock(LugarDisponivel.class);
        when(lugar.getLugarLivre()).thenReturn(10F);

        Consumidor consumidor = Mockito.mock(Consumidor.class);
        when(consumidor.getCompra()).thenReturn(false);

        Assertions.assertEquals("Area incorreta", ingressos.verificarArea(consumidor,lugar)
        );
    }



}
