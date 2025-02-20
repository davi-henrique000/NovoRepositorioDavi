package davi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaInventarioPOO implements SistemaInventario{

    private GravadorDeItens gravadorDeItens;
    private Map<String, Map> itensMap;
    private Map<String, Item> itemInventario;

    public SistemaInventarioPOO(){
        this.itemInventario = new HashMap<>();
        this.gravadorDeItens = new GravadorDeItens();
    }

    public void cadastraItem (String nomeItem, String codigoItem, String descricaoItem, int quantidadeItem, Raridade raridade) throws ItemJaExisteException{
        Item i = this.itemInventario.get(codigoItem);

        if(i==null){
            Item item = new Item (nomeItem, codigoItem, descricaoItem, quantidadeItem, raridade);
            itemInventario.put(codigoItem, item);
        } else {
            throw new ItemJaExisteException("Ops, aparentemente esse item já foi cadastrado.");
        }
    }

    public ArrayList<Item> listarTodosOsItens (){
        ArrayList<Item> listaComTodosOsItens = new ArrayList<>();
        listaComTodosOsItens.addAll(this.itemInventario.values());
        return listaComTodosOsItens;

    }

    public Item pesquisaItem (String nomeItem, String codigoItem) throws ItemInexistenteException{
        Item i = this.itemInventario.get(codigoItem);
        if(i != null && i.getNomeItem().equalsIgnoreCase(nomeItem)){
            return i;
        } else {
            throw new ItemInexistenteException("Ops, parece que o item não está cadastrado no sistema.");
        }
    }

    public boolean removeItem (String nomeItem, String codigoItem, int quantidadeItem) throws ItemInexistenteException{

        Item i = this.itemInventario.get(codigoItem);
        boolean itemRemovido = false;

        if(i != null){
            this.itemInventario.remove(codigoItem);
            itemRemovido = true;
        } else {
            throw new ItemInexistenteException ("Ops, aparentemente o item não está cadastrado no sistema.");
        }
        return itemRemovido;
    }

    @Override
    public void salvarDados() throws IOException {
    }

    @Override
    public void recuperarDados() throws IOException {

    }
}

