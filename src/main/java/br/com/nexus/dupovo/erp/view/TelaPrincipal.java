package br.com.nexus.dupovo.erp.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    private JDesktopPane desktop;

    public TelaPrincipal() {
        // Configurações da Janela Principal do Mercado DuPovo
        setTitle("Nexus ERP - Mercado DuPovo");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // O JDesktopPane funciona como o painel onde flutuam os JInternalFrames
        desktop = new JDesktopPane();
        desktop.setBackground(new Color(220, 225, 230)); 
        setContentPane(desktop);

        criarMenu();
    }

    private void criarMenu() {
        JMenuBar barraMenu = new JMenuBar();

        // Menu de Cadastros obrigatórios do TCC
        JMenu menuCadastros = new JMenu("Cadastros");
        JMenuItem itemProdutos = new JMenuItem("Produtos");
        JMenuItem itemFuncionarios = new JMenuItem("Funcionários");
        
        menuCadastros.add(itemProdutos);
        menuCadastros.add(itemFuncionarios);

        // Menu do Sistema
        JMenu menuSistema = new JMenu("Sistema");
        JMenuItem itemSair = new JMenuItem("Sair");
        menuSistema.add(itemSair);

        barraMenu.add(menuCadastros);
        barraMenu.add(menuSistema);
        setJMenuBar(barraMenu);

        // Abre a tela de Produtos (Código do Davi isolado)
        itemProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                try {
                    CadastroProdutoInternalFrame telaProd = new CadastroProdutoInternalFrame();
                    desktop.add(telaProd);
                    telaProd.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir tela de produtos.");
                }
                */
            }
        });

        // Abre a tela de Cadastro de Funcionários (CRUD)
        itemFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CadastroFuncionarioInternalFrame telaFunc = new CadastroFuncionarioInternalFrame();
                    desktop.add(telaFunc);
                    telaFunc.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir tela de funcionários: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Sair
        itemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}