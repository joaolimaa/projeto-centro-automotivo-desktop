/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetomecanica.telas.clientes;

import projetomecanica.telas.funcionarios.*;
import projetomecanica.telas.visao.*;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import projetomecanica.entidades.Cliente;
import projetomecanica.entidades.Endereco;
import projetomecanica.entidades.Telefone;
import projetomecanica.entidades.dao.ClienteDAO;
import projetomecanica.entidades.enums.StatusPessoa;
import projetomecanica.entidades.enums.TipoDeCliente;
import projetomecanica.entidades.enums.TipoDeLogradouro;
import projetomecanica.entidades.enums.TipoDeTelefone;
import projetomecanica.telas.clientes.*;
import projetomecanica.telas.documentos.TelaExibirOrcamentoNF;
import projetomecanica.telas.funcionarios.*;
import projetomecanica.telas.documentos.TelaGerarOS;
import projetomecanica.telas.documentos.TelaListagemOS;
import projetomecanica.telas.pecas.TelaPecas;
import projetomecanica.telas.servicos.TelaServicos;
import projetomecanica.telas.veiculos.TelaCadastrarMarcas;
import projetomecanica.telas.veiculos.TelaCadastrarVeiculos;
import projetomecanica.telas.veiculos.TelaExibirVeiculos;
/**
 *
 * @author Dell
 */
public class TelaCadastrarClientes extends javax.swing.JFrame {
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    boolean validador = false;

    /**
     * Creates new form TelaTechnocar
     */
    public TelaCadastrarClientes() {
        initComponents();
         if(this.getExtendedState()!= TelaCadastrarClientes.MAXIMIZED_BOTH){
            this.setExtendedState(TelaCadastrarClientes.MAXIMIZED_BOTH);
        }
        setLocationRelativeTo(null);
        
    }
    
    public TelaCadastrarClientes(int clienteId) {
        try {
            initComponents();
            if(this.getExtendedState()!= TelaCadastrarClientes.MAXIMIZED_BOTH){
                this.setExtendedState(TelaCadastrarClientes.MAXIMIZED_BOTH);
            }
            setLocationRelativeTo(null);
            
            cliente = clienteDAO.consultarPorId(clienteId);
            jTextFieldNome.setText(cliente.getNomeCompleto());
            jFormattedTextFieldCPF.setText(cliente.getCpf_cnpj());
            jTextFieldEmail.setText(cliente.getEmail());
            jFormattedTextFieldCEP.setText(cliente.getEndereco().getCep()+"");
            jFormattedTextFieldDDD1.setText(cliente.getTelefone1().getDdd()+"");
            jFormattedTextFieldDDD2.setText(cliente.getTelefone2().getDdd()+"");
            jFormattedTextFieldDDD3.setText(cliente.getTelefone3().getDdd()+"");
            jFormattedTextFieldDataNascimento.setText(cliente.getDataNascimento());
            jFormattedTextFieldNum1.setText(cliente.getTelefone1().getNumero()+"");
            jFormattedTextFieldNum2.setText(cliente.getTelefone2().getNumero()+"");
            jFormattedTextFieldNum3.setText(cliente.getTelefone3().getNumero()+"");
            if(cliente.getTipo().equals(TipoDeCliente.PESSOA_FISICA)) {
                jCheckBoxPessoaFisica.setSelected(true);
                jTextFieldRazaoSocial.setEnabled(false);
                jTextFieldNomeFantasia.setEnabled(false);
                jFormattedTextFieldCNPJ.setEnabled(false);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldDataNascimento.setEnabled(true);
                jFormattedTextFieldCPF.setEnabled(true);
                jTextFieldNomeFantasia.setText("");
                jTextFieldRazaoSocial.setText("");
                jFormattedTextFieldCNPJ.setText("");
                if (jCheckBoxPessoaJuridica.isSelected()){
                    jCheckBoxPessoaJuridica.setSelected(false);
                }
            }
            if(cliente.getTipo().equals(TipoDeCliente.PESSOA_JURIDICA)) {
                jCheckBoxPessoaJuridica.setSelected(true);
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldDataNascimento.setEnabled(false);
                jFormattedTextFieldCPF.setEnabled(false);
                jTextFieldRazaoSocial.setEnabled(true);
                jTextFieldNomeFantasia.setEnabled(true);
                jFormattedTextFieldCNPJ.setEnabled(true);
                jTextFieldNome.setText("");
                jFormattedTextFieldCPF.setText("");
                jFormattedTextFieldDataNascimento.setText("");
                if (jCheckBoxPessoaFisica.isSelected()){
                    jCheckBoxPessoaFisica.setSelected(false);
                }
                jTextFieldNomeFantasia.setText(cliente.getNomeFantasia());
                jTextFieldRazaoSocial.setText(cliente.getRazaoSocial());
                jFormattedTextFieldCNPJ.setText(cliente.getCpf_cnpj());
            }
            if(cliente.getEndereco().getTipoLogradouro().equals(TipoDeLogradouro.RUA)) jComboBoxTipoLogradouro.setSelectedIndex(0);
            if(cliente.getEndereco().getTipoLogradouro().equals(TipoDeLogradouro.AVENIDA)) jComboBoxTipoLogradouro.setSelectedIndex(1);
            if(cliente.getTelefone1().getTipo().equals(TipoDeTelefone.RESIDENCIAL)) jComboBoxTipoTelefone1.setSelectedIndex(0);
            if(cliente.getTelefone1().getTipo().equals(TipoDeTelefone.TRABALHO)) jComboBoxTipoTelefone1.setSelectedIndex(1);
            if(cliente.getTelefone1().getTipo().equals(TipoDeTelefone.CELULAR)) jComboBoxTipoTelefone1.setSelectedIndex(2);
            if(cliente.getTelefone2().getTipo().equals(TipoDeTelefone.RESIDENCIAL)) jComboBoxTipoTelefone2.setSelectedIndex(0);
            if(cliente.getTelefone2().getTipo().equals(TipoDeTelefone.TRABALHO)) jComboBoxTipoTelefone2.setSelectedIndex(1);
            if(cliente.getTelefone2().getTipo().equals(TipoDeTelefone.CELULAR)) jComboBoxTipoTelefone2.setSelectedIndex(2);
            if(cliente.getTelefone3().getTipo().equals(TipoDeTelefone.RESIDENCIAL)) jComboBoxTipoTelefone3.setSelectedIndex(0);
            if(cliente.getTelefone3().getTipo().equals(TipoDeTelefone.TRABALHO)) jComboBoxTipoTelefone3.setSelectedIndex(1);
            if(cliente.getTelefone3().getTipo().equals(TipoDeTelefone.CELULAR)) jComboBoxTipoTelefone3.setSelectedIndex(2);
            jTextFieldBairro.setText(cliente.getEndereco().getBairro());
            jTextFieldCidade.setText(cliente.getEndereco().getCidade());
            jTextFieldComplemento.setText(cliente.getEndereco().getComplemento());
            jTextFieldEstado.setText(cliente.getEndereco().getEstado());
            jTextFieldLogradouro.setText(cliente.getEndereco().getLogradouro());
            jTextFieldNumEndereco.setText(cliente.getEndereco().getNumero()+"");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanelFundo = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxPessoaFisica = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxPessoaJuridica = new javax.swing.JCheckBox();
        jTextFieldNomeFantasia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTipoLogradouro = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldNumEndereco = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxTipoTelefone1 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jComboBoxTipoTelefone3 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxTipoTelefone2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jButtonIrParaTelaVeiculo = new javax.swing.JButton();
        jButtonSalvarCadastro = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCNPJ = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDDD3 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDDD1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNum1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNum3 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDDD2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNum2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonConfigurar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonCadastrarCliente = new javax.swing.JButton();
        jButtonCadastrarVeiculo = new javax.swing.JButton();
        jButtonOrdemServico = new javax.swing.JButton();
        jButtonServico = new javax.swing.JButton();
        jButtonPagar = new javax.swing.JButton();
        jButtonCadastrarColaborador = new javax.swing.JButton();
        jButtonCadastrarPecas = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setText("Data de Nascimento*");

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel26.setText("E-mail*");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel12.setText("Bairro*");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel15.setText("Número*");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel14.setText("Complemento");

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel27.setText("Cidade");

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel18.setText("Estado*");

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel17.setText("CEP*");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel16.setText("Função*");

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel19.setText("Setor*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFundo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelFundo.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel21.setText("Telefone 1*");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 27)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 22.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 27)); // NOI18N
        jLabel2.setText("Novo Cliente");

        jCheckBoxPessoaFisica.setText("Pessoa Física");
        jCheckBoxPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPessoaFisicaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setText("Nome Completo*");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setText("CPF*");

        jCheckBoxPessoaJuridica.setText("Pessoa Jurídica");
        jCheckBoxPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPessoaJuridicaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel8.setText("Razão Social*");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel9.setText("CNPJ*");

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel20.setText("Nome Fantasia*");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setText("Tipo do Logradouro*");

        jComboBoxTipoLogradouro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUA", "AVENIDA" }));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setText("Logradouro*");

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel32.setText("Estado*");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel13.setText("Bairro*");

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel29.setText("Número*");

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel33.setText("Complemento");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setText("Telefone 3");

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel24.setText("Tipo do Telefone*");

        jComboBoxTipoTelefone1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "TRABALHO", "CELULAR" }));
        jComboBoxTipoTelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoTelefone1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel28.setText("Tipo do Telefone 3");

        jComboBoxTipoTelefone3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "TRABALHO", "CELULAR" }));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel35.setText("Telefone 2");

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel25.setText("Tipo do Telefone 2");

        jComboBoxTipoTelefone2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "TRABALHO", "CELULAR" }));

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel36.setText("Cidade*");

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel37.setText("CEP*");

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel38.setText("E-mail*");

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel22.setText("Data de Nascimento*");

        jButtonIrParaTelaVeiculo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonIrParaTelaVeiculo.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonIrParaTelaVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIrParaTelaVeiculo.setText("Cadastrar Veículo");
        jButtonIrParaTelaVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIrParaTelaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIrParaTelaVeiculoActionPerformed(evt);
            }
        });

        jButtonSalvarCadastro.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalvarCadastro.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonSalvarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarCadastro.setText("Salvar Cadastro");
        jButtonSalvarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarCadastroActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDDD3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDDD1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldNum1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldNum3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDDD2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldNum2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSalvarCadastro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBoxPessoaJuridica)
                                    .addComponent(jLabel20)
                                    .addComponent(jTextFieldRazaoSocial)
                                    .addComponent(jFormattedTextFieldDataNascimento)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNomeFantasia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldDDD1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldNum1))
                                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldDDD3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTipoLogradouro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldBairro)))
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxTipoTelefone1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxTipoTelefone3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldNumEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel38)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32)
                            .addComponent(jLabel35)
                            .addComponent(jTextFieldComplemento)
                            .addComponent(jTextFieldEmail)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldDDD2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)))
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jButtonIrParaTelaVeiculo)
                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxTipoTelefone2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(86, 86, 86))
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jCheckBoxPessoaFisica)
                .addGap(30, 30, 30)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jLabel32)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel37)
                    .addComponent(jLabel33)
                    .addComponent(jLabel29)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22))
                .addGap(10, 10, 10)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 70, Short.MAX_VALUE)
                .addComponent(jCheckBoxPessoaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24)
                    .addComponent(jLabel35)
                    .addComponent(jLabel25))
                .addGap(10, 10, 10)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDDD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28)
                    .addComponent(jLabel38))
                .addGap(8, 8, 8)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIrParaTelaVeiculo)
                    .addComponent(jComboBoxTipoTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDDD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarCadastro)
                    .addComponent(jButtonCancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(8, 83, 148));

        jButtonMenu.setBackground(new java.awt.Color(0, 0, 0));
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/New Car white.png"))); // NOI18N
        jButtonMenu.setBorder(null);
        jButtonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 43.png"))); // NOI18N
        jButtonSair.setBorder(null);
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSairMouseClicked(evt);
            }
        });

        jButtonConfigurar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 42.png"))); // NOI18N
        jButtonConfigurar.setBorder(null);
        jButtonConfigurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfigurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConfigurarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButtonMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfigurar)
                .addGap(18, 18, 18)
                .addComponent(jButtonSair)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonMenu)
                    .addComponent(jButtonConfigurar))
                .addGap(17, 17, 17))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(83, 578));

        jButtonCadastrarCliente.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 4.png"))); // NOI18N
        jButtonCadastrarCliente.setBorder(null);
        jButtonCadastrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarClienteActionPerformed(evt);
            }
        });

        jButtonCadastrarVeiculo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 5.png"))); // NOI18N
        jButtonCadastrarVeiculo.setBorder(null);
        jButtonCadastrarVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarVeiculoActionPerformed(evt);
            }
        });

        jButtonOrdemServico.setBackground(new java.awt.Color(0, 0, 0));
        jButtonOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 7.png"))); // NOI18N
        jButtonOrdemServico.setBorder(null);
        jButtonOrdemServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdemServicoActionPerformed(evt);
            }
        });

        jButtonServico.setBackground(new java.awt.Color(0, 0, 0));
        jButtonServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 8.png"))); // NOI18N
        jButtonServico.setBorder(null);
        jButtonServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicoActionPerformed(evt);
            }
        });

        jButtonPagar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 9.png"))); // NOI18N
        jButtonPagar.setBorder(null);
        jButtonPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        jButtonCadastrarColaborador.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 10.png"))); // NOI18N
        jButtonCadastrarColaborador.setBorder(null);
        jButtonCadastrarColaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastrarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarColaboradorActionPerformed(evt);
            }
        });

        jButtonCadastrarPecas.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarPecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 18.png"))); // NOI18N
        jButtonCadastrarPecas.setBorder(null);
        jButtonCadastrarPecas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastrarPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarPecasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCadastrarPecas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOrdemServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButtonCadastrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrarVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOrdemServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPagar)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonCadastrarPecas)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonCadastrarColaborador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        // TODO add your handling code here:
        TelaPrincipal inicio = new TelaPrincipal();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarClienteActionPerformed
        // TODO add your handling code here:
        TelaExibirClientes cliente = new TelaExibirClientes();
        cliente.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButtonCadastrarClienteActionPerformed

    private void jButtonCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarVeiculoActionPerformed
        // TODO add your handling code here:
        TelaExibirVeiculos veiculo = new TelaExibirVeiculos();
        veiculo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarVeiculoActionPerformed

    private void jButtonOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdemServicoActionPerformed
        // TODO add your handling code here:
        TelaListagemOS ordemServico = new TelaListagemOS();
        ordemServico.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonOrdemServicoActionPerformed

    private void jButtonServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicoActionPerformed
        // TODO add your handling code here:
        TelaServicos servico = new TelaServicos();
        servico.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonServicoActionPerformed

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        // TODO add your handling code here:
        TelaExibirOrcamentoNF pagamento = new TelaExibirOrcamentoNF();
        pagamento.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonPagarActionPerformed

    private void jButtonCadastrarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarPecasActionPerformed
        // TODO add your handling code here:
        TelaPecas pecas = new TelaPecas();
        pecas.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarPecasActionPerformed

    private void jButtonCadastrarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarColaboradorActionPerformed
        // TODO add your handling code here:
        TelaExibirColaboradores funcionario = new TelaExibirColaboradores();
        funcionario.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarColaboradorActionPerformed

    private void jCheckBoxPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPessoaFisicaActionPerformed
        // TODO add your handling code here:
        jTextFieldRazaoSocial.setEnabled(false);
        jTextFieldNomeFantasia.setEnabled(false);
        jFormattedTextFieldCNPJ.setEnabled(false);
        jTextFieldNome.setEnabled(true);
        jFormattedTextFieldDataNascimento.setEnabled(true);
        jFormattedTextFieldCPF.setEnabled(true);
        jTextFieldNomeFantasia.setText("");
        jTextFieldRazaoSocial.setText("");
        jFormattedTextFieldCNPJ.setText("");
        if (jCheckBoxPessoaJuridica.isSelected()){
            jCheckBoxPessoaJuridica.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxPessoaFisicaActionPerformed

    private void jCheckBoxPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPessoaJuridicaActionPerformed
        // TODO add your handling code here:
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldDataNascimento.setEnabled(false);
        jFormattedTextFieldCPF.setEnabled(false);
        jTextFieldRazaoSocial.setEnabled(true);
        jTextFieldNomeFantasia.setEnabled(true);
        jFormattedTextFieldCNPJ.setEnabled(true);
        jTextFieldNome.setText("");
        jFormattedTextFieldCPF.setText("");
        jFormattedTextFieldDataNascimento.setText("");
        if (jCheckBoxPessoaFisica.isSelected()){
            jCheckBoxPessoaFisica.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxPessoaJuridicaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        TelaExibirClientes cliente = new TelaExibirClientes();
        cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarCadastroActionPerformed
        try {
            //Validar Campos Obrigatórios
            if (jCheckBoxPessoaFisica.isSelected()){ //Verifica se a checkbox de pessoa física está selecionada
                
                if (jTextFieldNome.getText().equals("") || //Valida se os campos estão preenchidos
                        jFormattedTextFieldCPF.getText().equals("") ||
                        jFormattedTextFieldDataNascimento.getText().equals("") ||
                        
                        jComboBoxTipoLogradouro.getSelectedItem().equals("") ||
                        jTextFieldLogradouro.getText().equals("") ||
                        jTextFieldEstado.getText().equals("") ||
                        jTextFieldCidade.getText().equals("") ||
                        jTextFieldBairro.getText().equals("") ||
                        jTextFieldNumEndereco.getText().equals("") ||
                        jFormattedTextFieldCPF.getText().equals("") ||
                        jFormattedTextFieldDDD1.getText().equals("") ||
                        jFormattedTextFieldNum1.getText().equals("")||
                        jTextFieldEmail.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
                else validador = true;
            }
            if (jCheckBoxPessoaJuridica.isSelected()){
                
                if (jTextFieldRazaoSocial.getText().equals("") ||
                        jTextFieldNomeFantasia.getText().equals("") ||
                        jFormattedTextFieldDataNascimento.getText().equals("") ||
                        
                        jComboBoxTipoLogradouro.getSelectedItem().equals("") ||
                        jTextFieldLogradouro.getText().equals("") ||
                        jTextFieldEstado.getText().equals("") ||
                        jTextFieldCidade.getText().equals("") ||
                        jTextFieldBairro.getText().equals("") ||
                        jTextFieldNumEndereco.getText().equals("") ||
                        jFormattedTextFieldCEP.getText().equals("") ||
                        jFormattedTextFieldDDD1.getText().equals("") ||
                        jFormattedTextFieldNum1.getText().equals("") ||
                        jTextFieldEmail.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
                else validador = true;
            }
            
            cliente.setNomeCompleto(jTextFieldNome.getText());
            cliente.setEmail(jTextFieldEmail.getText());
            
            if (jCheckBoxPessoaJuridica.isSelected()) cliente.setCpf_cnpj(jFormattedTextFieldCNPJ.getText());
            if (jCheckBoxPessoaFisica.isSelected()) cliente.setCpf_cnpj(jFormattedTextFieldCPF.getText());
            
            cliente.setDataNascimento(jFormattedTextFieldDataNascimento.getText());
            cliente.setRazaoSocial(jTextFieldRazaoSocial.getText());
            cliente.setNomeFantasia(jTextFieldNomeFantasia.getText());
            
            String DDD1 = jFormattedTextFieldDDD1.getText(1, 2);
            String numero1 = jFormattedTextFieldNum1.getText().replace("-", "");
            String DDD2 = jFormattedTextFieldDDD2.getText(1, 2);
            String numero2 = jFormattedTextFieldNum2.getText().replace("-", "");
            String DDD3 = jFormattedTextFieldDDD3.getText(1, 2);
            String numero3 = jFormattedTextFieldNum3.getText().replace("-", "");
            String cep = jFormattedTextFieldCEP.getText().replace("-", "");
            
            Telefone telefone1 = new Telefone();
            telefone1.setNumero(Integer.parseInt(DDD1), Integer.parseInt(numero1));
            TipoDeTelefone tipoTelefone1 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone1.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone1);
            cliente.setTelefone1(telefone1);
            
            if(DDD2.length() > 0) {
                Telefone telefone2 = new Telefone();
                telefone2.setNumero(Integer.parseInt(DDD2), Integer.parseInt(numero2));
                TipoDeTelefone tipoTelefone2 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone2.getSelectedItem().toString());
                telefone1.setTipo(tipoTelefone2);
                cliente.setTelefone2(telefone2);
            }
            
            if(DDD3.length() > 0) {
                Telefone telefone3 = new Telefone();
                telefone3.setNumero(Integer.parseInt(DDD3), Integer.parseInt(numero3));
                TipoDeTelefone tipoTelefone3 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone3.getSelectedItem().toString());
                telefone1.setTipo(tipoTelefone3);
                cliente.setTelefone3(telefone3);
            }
            
            Endereco endereco = new Endereco();
            TipoDeLogradouro tipoDeLogradouro = TipoDeLogradouro.valueOf(jComboBoxTipoLogradouro.getSelectedItem().toString());
            endereco.setTipoLogradouro(tipoDeLogradouro);
            endereco.setBairro(jTextFieldBairro.getText());
            endereco.setCep(Integer.parseInt(cep));
            endereco.setCidade(jTextFieldCidade.getText());
            endereco.setComplemento(jTextFieldComplemento.getText());
            endereco.setLogradouro(jTextFieldLogradouro.getText());
            endereco.setEstado(jTextFieldEstado.getText());
            endereco.setNumero(Integer.parseInt(jTextFieldNumEndereco.getText()));
            cliente.setEndereco(endereco);
            
        } catch (Exception erro) {
            validador = false;
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (validador) {
                    if (cliente.getId() != 0) {
                        cliente.setStatus(StatusPessoa.ATIVO);
                        clienteDAO.alterar(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        clienteDAO.incluir(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    TelaExibirClientes telaListgemClientes = new TelaExibirClientes();
                    telaListgemClientes.setVisible(true);
                    dispose();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSalvarCadastroActionPerformed

    private void jButtonIrParaTelaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIrParaTelaVeiculoActionPerformed
        try {
            //Validar Campos Obrigatórios
            if (jCheckBoxPessoaFisica.isSelected()){ //Verifica se a checkbox de pessoa física está selecionada
                
                if (jTextFieldNome.getText().equals("") || //Valida se os campos estão preenchidos
                        jFormattedTextFieldCPF.getText().equals("") ||
                        jFormattedTextFieldDataNascimento.getText().equals("") ||
                        
                        jComboBoxTipoLogradouro.getSelectedItem().equals("") ||
                        jTextFieldLogradouro.getText().equals("") ||
                        jTextFieldEstado.getText().equals("") ||
                        jTextFieldCidade.getText().equals("") ||
                        jTextFieldBairro.getText().equals("") ||
                        jTextFieldNumEndereco.getText().equals("") ||
                        jFormattedTextFieldCPF.getText().equals("") ||
                        jFormattedTextFieldDDD1.getText().equals("") ||
                        jFormattedTextFieldNum1.getText().equals("")||
                        jTextFieldEmail.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
                else validador = true;
            }
            if (jCheckBoxPessoaJuridica.isSelected()){
                
                if (jTextFieldRazaoSocial.getText().equals("") ||
                        jTextFieldNomeFantasia.getText().equals("") ||
                        jFormattedTextFieldDataNascimento.getText().equals("") ||
                        
                        jComboBoxTipoLogradouro.getSelectedItem().equals("") ||
                        jTextFieldLogradouro.getText().equals("") ||
                        jTextFieldEstado.getText().equals("") ||
                        jTextFieldCidade.getText().equals("") ||
                        jTextFieldBairro.getText().equals("") ||
                        jTextFieldNumEndereco.getText().equals("") ||
                        jFormattedTextFieldCEP.getText().equals("") ||
                        jFormattedTextFieldDDD1.getText().equals("") ||
                        jFormattedTextFieldNum1.getText().equals("") ||
                        jTextFieldEmail.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
                else validador = true;
            }
            
            cliente.setNomeCompleto(jTextFieldNome.getText());
            cliente.setEmail(jTextFieldEmail.getText());
            
            if (jCheckBoxPessoaJuridica.isSelected()) cliente.setCpf_cnpj(jFormattedTextFieldCNPJ.getText());
            if (jCheckBoxPessoaFisica.isSelected()) cliente.setCpf_cnpj(jFormattedTextFieldCPF.getText());
            
            cliente.setDataNascimento(jFormattedTextFieldDataNascimento.getText());
            cliente.setRazaoSocial(jTextFieldRazaoSocial.getText());
            cliente.setNomeFantasia(jTextFieldNomeFantasia.getText());
            
            String DDD1 = jFormattedTextFieldDDD1.getText(1, 2);
            String numero1 = jFormattedTextFieldNum1.getText().replace("-", "");
            String DDD2 = jFormattedTextFieldDDD2.getText(1, 2);
            String numero2 = jFormattedTextFieldNum2.getText().replace("-", "");
            String DDD3 = jFormattedTextFieldDDD3.getText(1, 2);
            String numero3 = jFormattedTextFieldNum3.getText().replace("-", "");
            String cep = jFormattedTextFieldCEP.getText().replace("-", "");
            
            Telefone telefone1 = new Telefone();
            telefone1.setNumero(Integer.parseInt(DDD1), Integer.parseInt(numero1));
            TipoDeTelefone tipoTelefone1 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone1.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone1);
            cliente.setTelefone1(telefone1);
            
            Telefone telefone2 = new Telefone();
            telefone2.setNumero(Integer.parseInt(DDD2), Integer.parseInt(numero2));
            TipoDeTelefone tipoTelefone2 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone2.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone2);
            cliente.setTelefone2(telefone2);
            
            Telefone telefone3 = new Telefone();
            telefone3.setNumero(Integer.parseInt(DDD3), Integer.parseInt(numero3));
            TipoDeTelefone tipoTelefone3 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone3.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone3);
            cliente.setTelefone3(telefone3);
            
            Endereco endereco = new Endereco();
            TipoDeLogradouro tipoDeLogradouro = TipoDeLogradouro.valueOf(jComboBoxTipoLogradouro.getSelectedItem().toString());
            endereco.setTipoLogradouro(tipoDeLogradouro);
            endereco.setBairro(jTextFieldBairro.getText());
            endereco.setCep(Integer.parseInt(cep));
            endereco.setCidade(jTextFieldCidade.getText());
            endereco.setComplemento(jTextFieldComplemento.getText());
            endereco.setLogradouro(jTextFieldLogradouro.getText());
            endereco.setEstado(jTextFieldEstado.getText());
            endereco.setNumero(Integer.parseInt(jTextFieldNumEndereco.getText()));
            cliente.setEndereco(endereco);
            
        } catch (Exception erro) {
            validador = false;
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (validador) {
                    if (cliente.getId() != 0) {
                        cliente.setStatus(StatusPessoa.ATIVO);
                        clienteDAO.alterar(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        clienteDAO.incluir(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    TelaCadastrarVeiculos telaCadastrarVeiculos = new TelaCadastrarVeiculos(cliente.getId(), false);
                    telaCadastrarVeiculos.setVisible(true);
                    dispose();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonIrParaTelaVeiculoActionPerformed

    private void jComboBoxTipoTelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoTelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoTelefone1ActionPerformed

    private void jButtonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseClicked
        // TODO add your handling code here:
        final JPopupMenu popup = new JPopupMenu();
        final JFrame frame = this;
        // New project menu item
        JMenuItem menuItem = new JMenuItem("Voltar",
                new ImageIcon("images/newproject.png"));
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                TelaExibirClientes cliente = new TelaExibirClientes();
                cliente.setVisible(true);
                dispose();
                
            }
        });
        popup.add(menuItem);
        
        
        JMenuItem menuItem2 = new JMenuItem("Sair",
                new ImageIcon("images/newproject.png"));
        menuItem2.setMnemonic(KeyEvent.VK_P);
        menuItem2.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menuItem2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
        });
        popup.add(menuItem2);
        popup.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jButtonSairMouseClicked

    private void jButtonConfigurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfigurarMouseClicked
        // TODO add your handling code here:
        final JPopupMenu popup = new JPopupMenu();
        final JFrame frame = this;
        // New project menu item
        JMenuItem menuItem = new JMenuItem("Cadastrar Marcas de Veículo",
                new ImageIcon("images/newproject.png"));
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                TelaCadastrarMarcas marca = new TelaCadastrarMarcas();
                marca.setVisible(true);
                dispose();
            }
        });
        popup.add(menuItem);
        
        
        JMenuItem menuItem2 = new JMenuItem("Configurar Usuário",
                new ImageIcon("images/newproject.png"));
        menuItem2.setMnemonic(KeyEvent.VK_P);
        menuItem2.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menuItem2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                TelaControleAcesso usuario = new TelaControleAcesso();
                usuario.setVisible(true);
                dispose();
            }
        });
        
        popup.add(menuItem2);
        
        
        popup.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jButtonConfigurarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarCliente;
    private javax.swing.JButton jButtonCadastrarColaborador;
    private javax.swing.JButton jButtonCadastrarPecas;
    private javax.swing.JButton jButtonCadastrarVeiculo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfigurar;
    private javax.swing.JButton jButtonIrParaTelaVeiculo;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonOrdemServico;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvarCadastro;
    private javax.swing.JButton jButtonServico;
    private javax.swing.JCheckBox jCheckBoxPessoaFisica;
    private javax.swing.JCheckBox jCheckBoxPessoaJuridica;
    private javax.swing.JComboBox<String> jComboBoxTipoLogradouro;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone1;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone2;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone3;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCNPJ;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldDDD1;
    private javax.swing.JFormattedTextField jFormattedTextFieldDDD2;
    private javax.swing.JFormattedTextField jFormattedTextFieldDDD3;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldNum1;
    private javax.swing.JFormattedTextField jFormattedTextFieldNum2;
    private javax.swing.JFormattedTextField jFormattedTextFieldNum3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeFantasia;
    private javax.swing.JTextField jTextFieldNumEndereco;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
