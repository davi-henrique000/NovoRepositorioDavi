package davi;

import java.util.ArrayList;
import java.util.Collection;

public interface SistemaInventario {

    void cadastraItem (String nomeItem, String codigoItem, String descricaoItem, int quantidadeItem, Raridade raridade) throws ItemJaExisteException;

    ArrayList<Item> trazerTodosOsItens ();

    Collection<Item> pesquisaItem (String nomeItem, String codigoItem) throws ItemInexistenteException;

    boolean removeItem (String nomeItem, String codigoItem, int quantidadeItem) throws ItemInexistenteException;


}
