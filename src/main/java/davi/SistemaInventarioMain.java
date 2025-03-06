package davi;
import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SistemaInventarioMain extends SistemaInventarioPOO {
    public static void main(String [] args){

        SistemaInventarioPOO sistema = new SistemaInventarioPOO();
        boolean continuar = true;

        while(continuar){
            String opcao = JOptionPane.showInputDialog ("Escolha uma opção selecionando um número: " +
                    " \n 1 - [Cadastrar Item]" +
                    " \n 2 - [Listar Todos os Itens]" +
                    " \n 3 - [Pesquisar Item]" +
                    " \n 4 - [Remover Item]" +
                    " \n 5 - [Salvar Dados]" +
                    " \n 6 - [Recuperar Dados]" +
                    " \n 7 - [Sair]");

            if (opcao == null){
                break;
            }

            switch (opcao){
                case "1":
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do Item que será cadastrado: ");
                        String codigo = JOptionPane.showInputDialog("Digite o código do Item que deseja cadastrar: ");
                        String descricao = JOptionPane.showInputDialog("Digite uma pequena descrição do Item: ");
                        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do Item cadastrado: "));
                        String raridadeStr = JOptionPane.showInputDialog("Digite a raridade do Item (Comum, Superior, Épico, Lendário, Cósmico): ");
                        Raridade raridade = Raridade.valueOf(raridadeStr.toUpperCase());

                        sistema.cadastraItem(nome, codigo, descricao, quantidade, raridade);
                        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso !");
                    } catch (ItemJaExisteException e ) {
                        JOptionPane.showMessageDialog(null, "Erro ! Esse Item já foi cadastrado.");

                    }
                    break;

                case "2":
                    ArrayList<Item> listaDeItens = sistema.listarTodosOsItens();

                        if (listaDeItens.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Erro ! A lista de itens está vazia !");
                        } else {
                            String itensCadastrados = "Itens Cadastrados: \n";

                            for (Item item: listaDeItens){
                                itensCadastrados += "Nome: " +item.getNomeItem()+
                                        "\n Código: " +item.getCodigoItem()+
                                        "\n Descrição: " + item.getDescricaoItem()+
                                        "\n Quantidade: " + item.getQuantidadeItem()+
                                        "\n Raridade: " +item.getRaridade()+
                                        "--------------------------------------------\n";
                            }

                            JOptionPane.showMessageDialog(null, itensCadastrados);
                        }
                    break;
                case "3":

                    try{
                        String nome = JOptionPane.showInputDialog("Qual o nome do Item que deseja buscar ? ");
                        String codigo = JOptionPane.showInputDialog("Qual o código do Item que deseja pesquisar ? ");

                        Item itemEncontrado = sistema.pesquisaItem(nome, codigo);

                        JOptionPane.showMessageDialog(null, "O item encontrado foi: " +itemEncontrado);

                    } catch (ItemInexistenteException e){
                        JOptionPane.showInternalMessageDialog(null, e.getMessage());
                    }
                    break;

                case "4":
                    try{
                        String nome = JOptionPane.showInputDialog("Qual o nome do Item que deseja remover ? ");
                        String codigo = JOptionPane.showInputDialog("Qual o código do Item que deseja remover ? ");
                        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantos deseja remover ? "));

                        boolean removido = sistema.removeItem(nome, codigo, quantidade);

                        if (removido){
                            JOptionPane.showMessageDialog(null, "O Item foi removido com sucesso.");
                        }

                    } catch (ItemInexistenteException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case "5":
                    try{
                        sistema.salvarDados();

                        JOptionPane.showMessageDialog(null, "Pronto, os dados fora, salvos com sucesso!");

                    } catch (IOException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;

                case "6":

                    try{
                        sistema.recuperarDados();
                    } catch(IOException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;

                case "7":
                    String confirmarSaida = JOptionPane.showInputDialog("Deseja realmente sair do programa ? ");

                    if(confirmarSaida.equalsIgnoreCase("sim")){
                        continuar = false;
                        JOptionPane.showMessageDialog(null, "Confirmado. Saindo do sistema... Até mais!");
                    }
                    break;
            }
        }
    }
}
