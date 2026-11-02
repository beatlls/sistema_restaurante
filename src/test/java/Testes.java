import org.example.cardapio.ComCheddar;
import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.cardapio.LancheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Testes {
    @Test
    void doisMaisDoisSaoQuatro() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void deveRecusarPrecoNegativo() {
        // Tenta criar um lanche com preço -5. O assertThrows verifica se a IllegalArgumentException foi lançada.
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("Lanche Teste", -5.00);
        });
    }

    @Test
    void xBaconComCheddarCusta26() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26.0, lanche.getPreco(), 0.001);
    }
}
