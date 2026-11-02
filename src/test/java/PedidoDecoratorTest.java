import org.example.app.RestauranteFacade;
import org.example.cardapio.ItemCardapio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoDecoratorTest {

    @Test
    public void deveCalcularPrecoEDescricaoComMultiplosAdicionais() {

        RestauranteFacade sistema = new RestauranteFacade();

        ItemCardapio lanche = sistema.pedirLanche(3);
        lanche = sistema.adicionarExtra(lanche, 1);
        lanche = sistema.adicionarExtra(lanche, 2);

        assertEquals(32.00, lanche.getPreco(), 0.01);
        assertEquals("X-Bacon + cheddar + bacon extra", lanche.getDescricao());
    }
}