package davi;

public class Item {

    private String nomeItem;
    private String codigoItem;
    private String descricaoItem;
    private int quantidadeItem;
    private Raridade raridade;

    public Item (String nomeItem, String codigoItem, String descricaoItem, int quantidadeItem, Raridade raridade){
        this.nomeItem = nomeItem;
        this.codigoItem = codigoItem;
        this.descricaoItem = descricaoItem;
        this.quantidadeItem = quantidadeItem;
        this.raridade = raridade;
    }

    public String getNomeItem(){
        return nomeItem;
    }

    public void setNomeItem(String nomeItem){
        this.nomeItem = nomeItem;
    }

    public String getCodigoItem(){
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem){
        this.codigoItem = codigoItem;
    }

    public String getDescricaoItem(){
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem){
        this.descricaoItem = descricaoItem;
    }

    public int getQuantidadeItem(){
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem){
        this.quantidadeItem = quantidadeItem;
    }

    public Raridade getRaridade(){
        return raridade;
    }

    public void setRaridade(Raridade raridade){
        this.raridade = raridade;
    }

    public String toString (String nomeItem, String codigoItem, String descricaoItem, int quantidadeItem, Raridade raridade){
        return ("}Item: " +getNomeItem()+ " \n }Código: " +getCodigoItem()+ " \n }Descrição: " +getDescricaoItem()+
                " \n }Quantidade: " +getQuantidadeItem()+ " \n }Raridade: " +getRaridade());
    }
}
