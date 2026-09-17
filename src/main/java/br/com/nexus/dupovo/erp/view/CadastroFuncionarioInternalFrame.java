package br.com.nexus.dupovo.erp.view;

import br.com.nexus.dupovo.erp.model.Funcionario;
import br.com.nexus.dupovo.erp.repository.FuncionarioRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CadastroFuncionarioInternalFrame extends JInternalFrame {

    private JTextField txtId, txtNome, txtCpf, txtCargo, txtSalario;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private FuncionarioRepository repository = new FuncionarioRepository();

    public CadastroFuncionarioInternalFrame() {
        super("Cadastro de Funcionários", true, true, true, true);
        setSize(650, 450);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Dados do Funcionário"));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtNome = new JTextField();
        txtCpf = new JTextField();
        txtCargo = new JTextField();
        txtSalario = new JTextField();

        panelForm.add(new JLabel("ID:"));
        panelForm.add(txtId);
        panelForm.add(new JLabel("Nome:"));
        panelForm.add(txtNome);
        panelForm.add(new JLabel("CPF:"));
        panelForm.add(txtCpf);
        panelForm.add(new JLabel("Cargo:"));
        panelForm.add(txtCargo);
        panelForm.add(new JLabel("Salário R$:"));
        panelForm.add(txtSalario);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnLimpar = new JButton("Limpar");

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnLimpar);

        JPanel panelNorth = new JPanel(new BorderLayout());
        panelNorth.add(panelForm, BorderLayout.CENTER);
        panelNorth.add(panelBotoes, BorderLayout.SOUTH);

        add(panelNorth, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF", "Cargo", "Salário"}, 0);
        tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        btnSalvar.addActionListener(e -> salvar());
        btnExcluir.addActionListener(e -> excluir());
        btnLimpar.addActionListener(e -> limparCampos());

        tabela.getSelectionModel().addListSelectionListener(e -> {
            int row = tabela.getSelectedRow();
            if (row != -1) {
                txtId.setText(tableModel.getValueAt(row, 0).toString());
                txtNome.setText(tableModel.getValueAt(row, 1).toString());
                txtCpf.setText(tableModel.getValueAt(row, 2).toString());
                txtCargo.setText(tableModel.getValueAt(row, 3).toString());
                txtSalario.setText(tableModel.getValueAt(row, 4).toString());
            }
        });

        atualizarTabela();
    }

    private void salvar() {
        try {
            Long id = txtId.getText().isEmpty() ? null : Long.parseLong(txtId.getText());
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String cargo = txtCargo.getText();
            double salario = Double.parseDouble(txtSalario.getText().replace(",", "."));

            Funcionario f = new Funcionario(id, nome, cpf, cargo, salario);
            repository.salvar(f);

            JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
            limparCampos();
            atualizarTabela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluir() {
        if (!txtId.getText().isEmpty()) {
            Long id = Long.parseLong(txtId.getText());
            repository.deletar(id);
            JOptionPane.showMessageDialog(this, "Funcionário excluído!");
            limparCampos();
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela para excluir.");
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        tabela.clearSelection();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Funcionario> lista = repository.listarTodos();
        for (Funcionario f : lista) {
            tableModel.addRow(new Object[]{f.getId(), f.getNome(), f.getCpf(), f.getCargo(), f.getSalario()});
        }
    }
}