package davi;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class InventarioGUI extends JFrame {

    private JLabel titulo, imagemLabel;
    private JButton botaoIniciar;
    private JButton cadastrarItem, listarTodosItens, pesquisarItem, removerItem, salvarDados, recuperarDados, sairSistema;

    ImageIcon inventarioIcon = new ImageIcon("src/main/resources/icons/inventarioImg.png");

    public InventarioGUI(){
        setTitle("Inventário de Itens");
        setSize(750, 600); //tamanho da tela
        setLocationRelativeTo(null);
        setResizable(false); //janela não redimensionável
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //painel principal com layout vertical
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(Color.BLACK);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.setBackground(Color.BLACK);

        //Criando e configurando o título
        titulo = new JLabel ("Sistema de Inventário", SwingConstants.CENTER);
        titulo.setForeground(Color.RED);

        //mudando a fonte para uma fonte personalizada
        try{
            Font fontePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/HelpMe.ttf")).deriveFont(24f);
            titulo.setFont(fontePersonalizada);
        } catch(Exception e){

            e.printStackTrace();
            titulo.setFont(new Font ("Serif", Font.BOLD, 24));
        }

        botaoIniciar = new JButton("Iniciar Inventário"); //criação do botao que inicia o inventário
        botaoIniciar.setBackground(Color.BLACK);
        botaoIniciar.setForeground(Color.RED);
        botaoIniciar.setFocusPainted(false);
        botaoIniciar.setBorderPainted(false);
        botaoIniciar.setFont(new Font("Serif", Font.BOLD, 30));

        botaoIniciar.addActionListener(e -> abrirNovoPainel()); //adicionando a função ao botão

        JPanel painelBotao = new JPanel(new GridLayout()); //criação do painel para adicionar o botao horizontalmente
        painelBotao.setBackground(Color.BLACK);

        GridBagConstraints gbc  = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 50, 10, 50);

        //criando e configurando o sistema
        ImageIcon originalIcon = new ImageIcon("src/main/resources/icons/inventarioImg.png");

        int alturaDesejada = 380;
        int larguraCalculada = (alturaDesejada *16)/9;

        //redimensionando para a imagem caber na tela
        Image imagemRedimensionada = originalIcon.getImage().getScaledInstance(larguraCalculada, alturaDesejada, Image.SCALE_SMOOTH);
        ImageIcon novoIcon = new ImageIcon(imagemRedimensionada);

        imagemLabel = new JLabel(novoIcon, SwingConstants.CENTER);

        //Adicionando componentes no painel
        painelPrincipal.add(titulo, BorderLayout.NORTH); //título no topo
        painelPrincipal.add(imagemLabel, BorderLayout.CENTER); //imagem centralizada
        painelPrincipal.add(painelBotao, BorderLayout.SOUTH);
        painelBotao.add(botaoIniciar, gbc); //adicionando o botao no painel


        //adicionando painel na janela
        add(painelPrincipal);
        }

    private void abrirNovoPainel(){

        JPanel novoPainelIniciarInventario = new JPanel();
        novoPainelIniciarInventario.setLayout(new GridLayout(4, 2, 10, 10));
        novoPainelIniciarInventario.setBackground(Color.BLACK);

        cadastrarItem = new JButton("Cadastrar Item");
        ImageIcon iconeCadastrar = new ImageIcon("src/main/resources/icons/cadastrarItem.png");
        cadastrarItem.setIcon(iconeCadastrar);
        cadastrarItem.setHorizontalTextPosition(SwingConstants.CENTER);
        cadastrarItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image img = iconeCadastrar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        cadastrarItem.setIcon(new ImageIcon(img));

        listarTodosItens = new JButton("Listar Todos os Itens");
        ImageIcon iconeListar = new ImageIcon("src/main/resources/icons/listarItens.png");
        listarTodosItens.setIcon(iconeListar);
        listarTodosItens.setHorizontalTextPosition(SwingConstants.CENTER);
        listarTodosItens.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image imgListar = iconeListar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        listarTodosItens.setIcon(new ImageIcon(imgListar));

        pesquisarItem = new JButton("Pesquisar Item");
        ImageIcon iconePesquisar = new ImageIcon("src/main/resources/icons/pesquisarItem.png");
        pesquisarItem.setIcon(iconePesquisar);
        pesquisarItem.setHorizontalTextPosition(SwingConstants.CENTER);
        pesquisarItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image imgPesquisar = iconePesquisar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pesquisarItem.setIcon(new ImageIcon(imgPesquisar));

        removerItem = new JButton("Remover Item");
        ImageIcon iconeRemover = new ImageIcon("src/main/resources/icons/removerItem.png");
        removerItem.setIcon(iconeRemover);
        removerItem.setHorizontalTextPosition(SwingConstants.CENTER);
        removerItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image imgRemover = iconeRemover.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        removerItem.setIcon(new ImageIcon(imgRemover));

        salvarDados = new JButton("Salvar Dados");
        ImageIcon iconeSalvar = new ImageIcon("src/main/resources/icons/salvarDados.png");
        salvarDados.setIcon(iconeSalvar);
        salvarDados.setHorizontalTextPosition(SwingConstants.CENTER);
        salvarDados.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image imgSalvar = iconeSalvar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        salvarDados.setIcon(new ImageIcon(imgSalvar));

        recuperarDados = new JButton("Recuperar Dados");
        ImageIcon iconeRecuperar = new ImageIcon("src/main/resources/icons/recuperarDados.png");
        recuperarDados.setIcon(iconeRecuperar);
        recuperarDados.setHorizontalTextPosition(SwingConstants.CENTER);
        recuperarDados.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image imgRecuperar = iconeRecuperar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        recuperarDados.setIcon(new ImageIcon(imgRecuperar));

        sairSistema = new JButton("Sair do Sistema");
        ImageIcon iconeSair = new ImageIcon("src/main/resources/icons/saidaSistema.png");
        sairSistema.setIcon(iconeSair);
        sairSistema.setHorizontalTextPosition(SwingConstants.CENTER);
        sairSistema.setVerticalTextPosition(SwingConstants.BOTTOM);
        Image imgSair = iconeSair.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        sairSistema.setIcon(new ImageIcon(imgSair));

        JButton[] botoes = {cadastrarItem, listarTodosItens, pesquisarItem, removerItem, salvarDados, recuperarDados, sairSistema};

        for(JButton botao: botoes){
            botao.setBackground(Color.BLACK);
            botao.setForeground(Color.RED);
            botao.setFocusPainted(false);
            botao.setBorderPainted(false);
            novoPainelIniciarInventario.add(botao);
        }

        setContentPane(novoPainelIniciarInventario);
        revalidate();
        repaint();
    }

    public static void main(String [] args){

        //instanciação para evitar travamentos durante a apresentação da interface gráfica
        SwingUtilities.invokeLater(() -> {
            InventarioGUI janela = new InventarioGUI();
            janela.setVisible(true);
        });

    }
}
