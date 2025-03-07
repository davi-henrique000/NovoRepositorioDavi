import davi.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SistemaInventarioTest {

    SistemaInventarioMain sistema = new SistemaInventarioMain();

    @Test
    void testCadastroItem() throws ItemJaExisteException, ItemInexistenteException {
        sistema.cadastraItem("Machado de Almas", "555",
                "Um machado capaz de invocar as almas daqueles que são mortos por sua lâmina",
                1, Raridade.EPICA);

        assertNotNull(sistema.pesquisaItem("Machado de Almas", "555"));
    }

    @Test
    void testCadastroItemDuplicado() {
        assertThrows(ItemJaExisteException.class, () -> {
            sistema.cadastraItem("Machado de Almas", "555",
                    "Um machado capaz de invocar as almas daqueles que são mortos por sua lâmina",
                    1, Raridade.EPICA);
            sistema.cadastraItem("Machado de Almas", "555",
                    "Item duplicado", 1, Raridade.EPICA);
        });
    }

    @Test
    void testRemocaoItem() throws ItemJaExisteException, ItemInexistenteException {
        sistema.cadastraItem("Espada do Caos", "654",
                "Uma espada capaz de trazer uma terrível maldição de azar", 1, Raridade.LENDARIA);

        sistema.removeItem("Espada do Caos", "654", 1);

        assertThrows(ItemInexistenteException.class, () -> {
            sistema.pesquisaItem("Espada do Caos", "654");
        });
    }

    @Test
    void testSalvarERecuperarDados() throws IOException, ItemJaExisteException, ItemInexistenteException {
        sistema.cadastraItem("Orbe da Avareza", "888",
                "Um orbe capaz de aumentar a mana do portador", 4, Raridade.EPICA);

        sistema.salvarDados();
        sistema.recuperarDados();

        assertNotNull(sistema.pesquisaItem("Orbe da Avareza", "888"));
    }
}
