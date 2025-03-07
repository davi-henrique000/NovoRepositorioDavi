package davi;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeItens {

    private String arquivoItens;

    public GravadorDeItens(){
        this.arquivoItens = "itens.dat";
    }

    public Collection<Item> recuperaItens() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.arquivoItens))){
            Collection<Item> itensAchados = (ArrayList<Item>) in.readObject();
            return itensAchados;
        } catch (ClassNotFoundException | ClassCastException e){
            e.printStackTrace();
            throw new IOException(e);
        }
    }

    public void gravaItens(Collection<Item> itens) throws IOException{
        ArrayList<Item> itensArrayList = new ArrayList<>();
        itensArrayList.addAll(itens);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoItens))){
            out.writeObject(itensArrayList);
        }
    }
}
