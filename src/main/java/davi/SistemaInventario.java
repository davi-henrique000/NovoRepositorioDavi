package davi;

import java.io.IOException;
import java.util.ArrayList;

public interface SistemaInventario {

    void cadastraItem (String nomeItem, String codigoItem, String descricaoItem, int quantidadeItem, Raridade raridade) throws ItemJaExisteException;

    ArrayList<Item> listarTodosOsItens();

    Item pesquisaItem (String nomeItem, String codigoItem) throws ItemInexistenteException;

    boolean removeItem (String nomeItem, String codigoItem, int quantidadeItem) throws ItemInexistenteException;

    void salvarDados() throws IOException;

    void recuperarDados() throws IOException;

}
