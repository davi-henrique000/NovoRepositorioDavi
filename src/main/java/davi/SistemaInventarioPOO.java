package davi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaInventarioPOO implements SistemaInventario{
    private Map<String, Item> itemInventario;

    public SistemaInventarioPOO(){
        this.itemInventario = new HashMap<>();
    }

    public void cadastraItem (String nomeItem, String codigoItem, String descricaoItem, int quantidadeItem, Raridade raridade) throws ItemJaExisteException{
        Item i = this.itemInventario.get(codigoItem);

        if(i!=null){
            Item item = new Item (nomeItem, codigoItem, descricaoItem, quantidadeItem, raridade);
            itemInventario.put(codigoItem, item);
        } else {
            throw new ItemJaExisteException("Ops, aparentemente esse item já foi cadastrado.");
        }
    }

    public ArrayList<Item> trazerTodosOsItens (){

    }

    public Collection<Item> pesquisaItem (String nomeItem, String codigoItem) throws ItemInexistenteException{

    }

    public boolean removeItem (String nomeItem, String codigoItem, int quantidadeItem) throws ItemInexistenteException{

    }

}
