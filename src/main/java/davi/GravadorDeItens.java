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
//public static void main(String [] args){
//    Item item1 = new Item("Espada Demoníaca", "123",
//            "Uma espada capaz de invocar a corrupção do inferno", 3, Raridade.EPICA);
//    Item item2 = new Item("Olho de Raphael", "456",
//            "Um item com formato de olho que permite obter informações de alvos", 1, Raridade.LENDARIA);
//
//    ArrayList<Item> itens = new ArrayList<>();
//    itens.add(item1);
//    itens.add(item2);
//
//    GravadorDeItens gravadorDeItens = new GravadorDeItens();
//    System.out.println("Recuperando Itens...");
//    try{
//        gravadorDeItens.gravaItens(itens);
//        Collection<Item> itensEncontrados = gravadorDeItens.recuperaItens();
//        System.out.println("Itens Encontrados!");
//        for(Item i: itensEncontrados){
//            System.out.println(i.toString());
//        }
//
//        gravadorDeItens.gravaItens(itens);
//    } catch (IOException e){
//        e.printStackTrace();
//    }
//}
}
