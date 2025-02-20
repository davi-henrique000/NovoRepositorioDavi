import davi.GravadorDeItens;
import davi.ItemJaExisteException;
import davi.Raridade;
import davi.SistemaInventarioPOO;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaInventarioTest {
    public void testaInventarioItens(){
        SistemaInventarioPOO sistema = new SistemaInventarioPOO();
        GravadorDeItens gravadorTest = new GravadorDeItens();

        try{
            sistema.cadastraItem("Machado de Guerra", "789", "Um macho de guerra com bom corte", 2, Raridade.COMUM);
            sistema.cadastraItem("Machado de Guerra", "789", "Um macho de guerra com bom corte", 2, Raridade.COMUM);
            sistema.cadastraItem("Escudo Protetor", "555", "Um escudo com capacidade de gerar uma cúpula de proteção", 1,
                    Raridade.SUPERIOR);

            sistema.listarTodosOsItens();

        } catch(ItemJaExisteException e){

        }
    }
}
