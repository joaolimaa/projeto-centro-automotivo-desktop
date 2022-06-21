/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetomecanica.telas.funcionarios;

import projetomecanica.telas.visao.*;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import projetomecanica.entidades.Colaborador;
import projetomecanica.entidades.Endereco;
import projetomecanica.entidades.Telefone;
import projetomecanica.entidades.dao.ColaboradorDAO;
import projetomecanica.entidades.enums.StatusPessoa;
import projetomecanica.entidades.enums.TipoDeColaborador;
import projetomecanica.entidades.enums.TipoDeLogradouro;
import projetomecanica.entidades.enums.TipoDeTelefone;
import projetomecanica.telas.clientes.*;
import projetomecanica.telas.documentos.TelaExibirOrcamentoNF;
import projetomecanica.telas.documentos.TelaListagemOS;
import projetomecanica.telas.funcionarios.*;
import projetomecanica.telas.pecas.TelaPecas;
import projetomecanica.telas.servicos.TelaServicos;
import projetomecanica.telas.veiculos.TelaCadastrarMarcas;
import projetomecanica.telas.veiculos.TelaExibirVeiculos;
/**
 *
 * @author Dell
 */
public class TelaCadastrarColaborador extends javax.swing.JFrame {

    Colaborador colaborador = new Colaborador();
    ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
    boolean validador = false;
    /**
     * Creates new form TelaTechnocar
     */
    public TelaCadastrarColaborador() {
        
        initComponents();
         if(this.getExtendedState()!= TelaCadastrarColaborador.MAXIMIZED_BOTH){
            this.setExtendedState(TelaCadastrarColaborador.MAXIMIZED_BOTH);
        }
        setLocationRelativeTo(null);
    }
    
    public TelaCadastrarColaborador(int idColaborador) {
        
        try {
            initComponents();
            if(this.getExtendedState()!= TelaCadastrarColaborador.MAXIMIZED_BOTH){
                this.setExtendedState(TelaCadastrarColaborador.MAXIMIZED_BOTH);
            }
            setLocationRelativeTo(null);
            
            colaborador = colaboradorDAO.consultarPorId(idColaborador);
            jTextFieldNome.setText(colaborador.getNomeCompleto());
            jFormattedTextFieldCPF.setText(colaborador.getCpf());
            jTextFieldEmail.setText(colaborador.getEmail());
            jFormattedTextFieldCEP.setText(colaborador.getEndereco().getCep()+"");
            jFormattedTextFieldDDD1.setText(colaborador.getTelefone1().getDdd()+"");
            jFormattedTextFieldDDD2.setText(colaborador.getTelefone2().getDdd()+"");
            jFormattedTextFieldDDD3.setText(colaborador.getTelefone3().getDdd()+"");
            jFormattedTextFieldDataNascimento.setText(colaborador.getDataNascimento());
            jFormattedTextFieldNumero1.setText(colaborador.getTelefone1().getNumero()+"");
            jFormattedTextFieldNumero2.setText(colaborador.getTelefone2().getNumero()+"");
            jFormattedTextFieldNumero3.setText(colaborador.getTelefone3().getNumero()+"");
            if(colaborador.getTipo().equals(TipoDeColaborador.ATENDENTE)) jComboBoxTipoColaborador.setSelectedIndex(0);
            if(colaborador.getTipo().equals(TipoDeColaborador.CONSULTOR_TECNICO)) jComboBoxTipoColaborador.setSelectedIndex(3);
            if(colaborador.getTipo().equals(TipoDeColaborador.MECANICO)) jComboBoxTipoColaborador.setSelectedIndex(1);
            if(colaborador.getTipo().equals(TipoDeColaborador.ESTOQUISTA)) jComboBoxTipoColaborador.setSelectedIndex(2);
            if(colaborador.getEndereco().getTipoLogradouro().equals(TipoDeLogradouro.RUA)) jComboBoxTipoLogradouro.setSelectedIndex(0);
            if(colaborador.getEndereco().getTipoLogradouro().equals(TipoDeLogradouro.AVENIDA)) jComboBoxTipoLogradouro.setSelectedIndex(1);
            if(colaborador.getTelefone1().getTipo().equals(TipoDeTelefone.RESIDENCIAL)) jComboBoxTipoTelefone1.setSelectedIndex(0);
            if(colaborador.getTelefone1().getTipo().equals(TipoDeTelefone.TRABALHO)) jComboBoxTipoTelefone1.setSelectedIndex(1);
            if(colaborador.getTelefone1().getTipo().equals(TipoDeTelefone.CELULAR)) jComboBoxTipoTelefone1.setSelectedIndex(2);
            if(colaborador.getTelefone2().getTipo().equals(TipoDeTelefone.RESIDENCIAL)) jComboBoxTipoTelefone2.setSelectedIndex(0);
            if(colaborador.getTelefone2().getTipo().equals(TipoDeTelefone.TRABALHO)) jComboBoxTipoTelefone2.setSelectedIndex(1);
            if(colaborador.getTelefone2().getTipo().equals(TipoDeTelefone.CELULAR)) jComboBoxTipoTelefone2.setSelectedIndex(2);
            if(colaborador.getTelefone3().getTipo().equals(TipoDeTelefone.RESIDENCIAL)) jComboBoxTipoTelefone3.setSelectedIndex(0);
            if(colaborador.getTelefone3().getTipo().equals(TipoDeTelefone.TRABALHO)) jComboBoxTipoTelefone3.setSelectedIndex(1);
            if(colaborador.getTelefone3().getTipo().equals(TipoDeTelefone.CELULAR)) jComboBoxTipoTelefone3.setSelectedIndex(2);
            jTextFieldBairro.setText(colaborador.getEndereco().getBairro());
            jTextFieldCidade.setText(colaborador.getEndereco().getCidade());
            jTextFieldComplemento.setText(colaborador.getEndereco().getComplemento());
            jTextFieldEstado.setText(colaborador.getEndereco().getEstado());
            jTextFieldLogradouro.setText(colaborador.getEndereco().getLogradouro());
            jTextFieldNumEndereco.setText(colaborador.getEndereco().getNumero()+"");
            jTextFieldMatricula.setText(colaborador.getMatricula());
            jTextFieldSalarioMensal.setText(colaborador.getSalarioBase()+"");
            jTextFieldValorHora.setText(colaborador.getValorHora()+"");
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
        jPanel1 = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonConfigurar = new javax.swing.JButton();
        jPanelFundo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxTipoTelefone2 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxTipoTelefone1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldNumEndereco = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldValorHora = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldSalarioMensal = new javax.swing.JTextField();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxTipoLogradouro = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxTipoTelefone3 = new javax.swing.JComboBox<>();
        jButtonSalvarCadastro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDDD1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumero1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumero2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDDD2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumero3 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDDD3 = new javax.swing.JFormattedTextField();
        jComboBoxTipoColaborador = new javax.swing.JComboBox<>();
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
                .addGap(30, 30, 30)
                .addComponent(jButtonSair)
                .addGap(35, 35, 35))
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

        jPanelFundo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelFundo.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setText("Nome*");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setText("CPF*");

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel21.setText("Telefone 1*");

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel22.setText("Telefone 2");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setText("Tipo do Telefone 2");

        jComboBoxTipoTelefone2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "TRABALHO", "CELULAR" }));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel24.setText("Tipo do Telefone 1*");

        jComboBoxTipoTelefone1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "TRABALHO", "CELULAR" }));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel7.setText("Data de Nascimento*");

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel28.setText("E-mail*");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel13.setText("Bairro*");

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel29.setText("Número*");

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel30.setText("Complemento");

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel31.setText("Cidade*");

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel32.setText("Estado*");

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel33.setText("CEP*");

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel34.setText("Função*");

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel36.setText("Valor hora*");

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel37.setText("Salário mensal*");

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel38.setText("Matrícula*");

        jComboBoxTipoLogradouro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUA", "AVENIDA" }));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setText("Tipo do Logradouro*");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setText("Logradouro*");

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel35.setText("Telefone 3");

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel39.setText("Tipo do Telefone 3");

        jComboBoxTipoTelefone3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "TRABALHO", "CELULAR" }));

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

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 27)); // NOI18N
        jLabel1.setText("Colaborador");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 22.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 27)); // NOI18N
        jLabel2.setText("Novo Colaborador");

        jButtonCancelar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDDD1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldNumero1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldNumero2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDDD2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldNumero3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDDD3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jComboBoxTipoColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATENDENTE", "MECANICO", "ESTOQUISTA", "CONSULTOR_TECNICO" }));

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoLogradouro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(jLabel34))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldBairro)
                    .addComponent(jComboBoxTipoColaborador, 0, 157, Short.MAX_VALUE)
                    .addComponent(jTextFieldNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSalarioMensal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel29)
                    .addComponent(jTextFieldNumEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextFieldCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldValorHora)
                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jLabel38)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelFundoLayout.createSequentialGroup()
                            .addComponent(jFormattedTextFieldDDD3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextFieldNumero3))
                        .addGroup(jPanelFundoLayout.createSequentialGroup()
                            .addComponent(jFormattedTextFieldDDD2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextFieldNumero2))
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)
                        .addComponent(jLabel35)
                        .addGroup(jPanelFundoLayout.createSequentialGroup()
                            .addComponent(jFormattedTextFieldDDD1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextFieldNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTipoTelefone3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTipoTelefone2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalvarCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTipoTelefone1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addGap(9, 9, 9)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(9, 9, 9)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDDD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel39)
                    .addComponent(jLabel35)
                    .addComponent(jLabel30)
                    .addComponent(jLabel33)
                    .addComponent(jLabel29)
                    .addComponent(jLabel13))
                .addGap(9, 9, 9)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDDD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel38)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel34))
                .addGap(11, 11, 11)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalarioMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvarCadastro)
                    .addComponent(jButtonCancelar)
                    .addComponent(jComboBoxTipoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
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
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonCadastrarVeiculo)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonOrdemServico)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonServico)
                .addGap(18, 18, Short.MAX_VALUE)
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
                    .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)))
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

    private void jButtonSalvarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarCadastroActionPerformed
        try {
            //Validar Campos Obrigatórios
                
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
                    jFormattedTextFieldNumero1.getText().equals("")||
                    jTextFieldMatricula.getText().equals("")||
                    jTextFieldSalarioMensal.getText().equals("")||
                    jTextFieldValorHora.getText().equals("")||
                   jTextFieldEmail.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
            else validador = true;
            
            String DDD1 = jFormattedTextFieldDDD1.getText(1, 2);
            String numero1 = jFormattedTextFieldNumero1.getText().replace("-", "");
            String DDD2 = jFormattedTextFieldDDD2.getText(1, 2);
            String numero2 = jFormattedTextFieldNumero2.getText().replace("-", "");
            String DDD3 = jFormattedTextFieldDDD3.getText(1, 2);
            String numero3 = jFormattedTextFieldNumero3.getText().replace("-", "");
            String cep = jFormattedTextFieldCEP.getText().replace("-", "");
            
            colaborador.setNomeCompleto(jTextFieldNome.getText());
            colaborador.setEmail(jTextFieldEmail.getText());
            colaborador.setCpf(jFormattedTextFieldCPF.getText());
            colaborador.setDataNascimento(jFormattedTextFieldDataNascimento.getText());
            colaborador.setMatricula(jTextFieldMatricula.getText());
            colaborador.setSalarioBase(Float.parseFloat(jTextFieldSalarioMensal.getText()));
            colaborador.setValorHora(Float.parseFloat(jTextFieldValorHora.getText()));
            
            Telefone telefone1 = new Telefone();
            telefone1.setNumero(Integer.parseInt(DDD1), Integer.parseInt(numero1));
            TipoDeTelefone tipoTelefone1 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone1.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone1);
            colaborador.setTelefone1(telefone1);
            
            Telefone telefone2 = new Telefone();
            telefone2.setNumero(Integer.parseInt(DDD2), Integer.parseInt(numero2));
            TipoDeTelefone tipoTelefone2 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone2.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone2);
            colaborador.setTelefone2(telefone2);
            
            Telefone telefone3 = new Telefone();
            telefone3.setNumero(Integer.parseInt(DDD3), Integer.parseInt(numero3));
            TipoDeTelefone tipoTelefone3 = TipoDeTelefone.valueOf(jComboBoxTipoTelefone3.getSelectedItem().toString());
            telefone1.setTipo(tipoTelefone3);
            colaborador.setTelefone3(telefone3);
            
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
            colaborador.setEndereco(endereco);
            
        } catch (Exception erro) {
            validador = false;
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (validador) {
                    if (colaborador.getId() != 0) {
                        colaborador.setStatus(StatusPessoa.ATIVO);
                        colaboradorDAO.alterar(colaborador);
                        JOptionPane.showMessageDialog(null, "Colaborador editado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        colaboradorDAO.incluir(colaborador);
                        JOptionPane.showMessageDialog(null, "Colaborador cadastrado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    TelaExibirColaboradores funcionario = new TelaExibirColaboradores();
                    funcionario.setVisible(true);
                    dispose();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSalvarCadastroActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        TelaExibirColaboradores funcionario = new TelaExibirColaboradores();
        funcionario.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
                TelaExibirColaboradores funcionario = new TelaExibirColaboradores();
                funcionario.setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaCadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarColaborador().setVisible(true);
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
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonOrdemServico;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvarCadastro;
    private javax.swing.JButton jButtonServico;
    private javax.swing.JComboBox<String> jComboBoxTipoColaborador;
    private javax.swing.JComboBox<String> jComboBoxTipoLogradouro;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone1;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone2;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone3;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldDDD1;
    private javax.swing.JFormattedTextField jFormattedTextFieldDDD2;
    private javax.swing.JFormattedTextField jFormattedTextFieldDDD3;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero1;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero2;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero3;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumEndereco;
    private javax.swing.JTextField jTextFieldSalarioMensal;
    private javax.swing.JTextField jTextFieldValorHora;
    // End of variables declaration//GEN-END:variables
}
