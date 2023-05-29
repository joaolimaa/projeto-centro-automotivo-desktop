/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetomecanica.telas.documentos;

import projetomecanica.telas.pecas.*;
import projetomecanica.telas.servicos.*;
import projetomecanica.telas.visao.*;
import projetomecanica.telas.veiculos.*;
import projetomecanica.telas.clientes.*;
import projetomecanica.telas.funcionarios.*;
import projetomecanica.telas.visao.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import projetomecanica.entidades.Cliente;
import projetomecanica.entidades.Colaborador;
import projetomecanica.entidades.Orcamento;
import projetomecanica.entidades.OrdemDeServico;
import projetomecanica.entidades.Peca;
import projetomecanica.entidades.Servico;
import projetomecanica.entidades.Veiculo;
import projetomecanica.entidades.dao.ClienteDAO;
import projetomecanica.entidades.dao.ColaboradorDAO;
import projetomecanica.entidades.dao.OrcamentoDAO;
import projetomecanica.entidades.dao.OrdemDeServicoDAO;
import projetomecanica.entidades.dao.PecaDAO;
import projetomecanica.entidades.dao.ServicoDAO;
import projetomecanica.entidades.dao.VeiculoDAO;
import projetomecanica.entidades.enums.FasesDocumento;
import projetomecanica.telas.clientes.*;
import projetomecanica.telas.funcionarios.*;
/**
 *
 * @author Dell
 */
public class TelaGerarOrcamento extends javax.swing.JFrame {
    
    OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    PecaDAO pecaDAO = new PecaDAO();
    ServicoDAO servicoDAO = new ServicoDAO();
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
    OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
    Orcamento orcamento = new Orcamento();
    Cliente cliente = new Cliente();
    Peca peca = new Peca();
    Servico servico = new Servico();
    Veiculo veiculo = new Veiculo();
    Colaborador colaborador = new Colaborador();
    ArrayList<Peca> pecas = new ArrayList<>();
    ArrayList<Peca> pecasEscolhidas = new ArrayList<>();
    ArrayList<Servico> servicos = new ArrayList<>();
    ArrayList<Servico> servicosEscolhidos = new ArrayList<>();
    ArrayList<Veiculo> veiculos = new ArrayList<>();
    ArrayList<Colaborador> colaboradores = new ArrayList<>();
    ArrayList<Integer> idVeiculos = new ArrayList<>();
    ArrayList<Integer> idColaboradores = new ArrayList<>();
    ArrayList<Integer> idPecas = new ArrayList<>();
    ArrayList<Integer> idServicos = new ArrayList<>();
    DefaultTableModel tabelaOrcamento = new DefaultTableModel();
    int total = 0;
    int totalPecas = 0;
    int totalServicos = 0;
    boolean validador = false;

    /**
     * Creates new form TelaTechnocar
     */
    public TelaGerarOrcamento() {
        try {
            initComponents();
            if(this.getExtendedState()!= TelaGerarOrcamento.MAXIMIZED_BOTH){
                this.setExtendedState(TelaGerarOrcamento.MAXIMIZED_BOTH);
            }
            setLocationRelativeTo(null);
            
            veiculos = veiculoDAO.obterTodasEntidades();
            DefaultTableModel tabelaVeiculo = (DefaultTableModel) jTableInformacoesVeiculo.getModel();
            for(int i = 0; i < veiculos.size(); i++) {
                idVeiculos.add(veiculos.get(i).getId());
                tabelaVeiculo.addRow(veiculos.get(i).listaValoresTabelaOS());
            }
            
            colaboradores = colaboradorDAO.obterTodasEntidades();
            DefaultTableModel tabelaColaborador = (DefaultTableModel) jTableInformacoesColaborador.getModel();
            for(int i = 0; i < colaboradores.size(); i++) {
                idColaboradores.add(colaboradores.get(i).getId());
                tabelaColaborador.addRow(colaboradores.get(i).listaValoresTabelaOrcamento());
            }
            
            pecas = pecaDAO.obterTodasEntidades();
            DefaultTableModel tabelaPeca = (DefaultTableModel) jTableInformacoesPeca.getModel();
            for(int i = 0; i < pecas.size(); i++) {
                idPecas.add(pecas.get(i).getId());
                tabelaPeca.addRow(pecas.get(i).listaValoresTabelaOS());
            }
            
            servicos = servicoDAO.obterTodasEntidades();
            DefaultTableModel tabelaServico = (DefaultTableModel) jTableInformacoesServico.getModel();
            for(int i = 0; i < servicos.size(); i++) {
                idServicos.add(servicos.get(i).getId());
                tabelaServico.addRow(servicos.get(i).listaValoresTabela());
            }
            
            tabelaOrcamento = (DefaultTableModel) jTableInformacoesOrcamento.getModel();
            
            jTextFieldTotal.setEnabled(false);
            jTextFieldTotal.setText(total+"");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public TelaGerarOrcamento(int id) {
        try {
            initComponents();
            if(this.getExtendedState()!= TelaGerarOrcamento.MAXIMIZED_BOTH){
                this.setExtendedState(TelaGerarOrcamento.MAXIMIZED_BOTH);
            }
            setLocationRelativeTo(null);
            
            orcamento = orcamentoDAO.consultarPorId(id);
            
            veiculos = veiculoDAO.obterTodasEntidades();
            DefaultTableModel tabelaVeiculo = (DefaultTableModel) jTableInformacoesVeiculo.getModel();
            for(int i = 0; i < veiculos.size(); i++) {
                idVeiculos.add(veiculos.get(i).getId());
                tabelaVeiculo.addRow(veiculos.get(i).listaValoresTabelaOS());
            }
            
            colaboradores = colaboradorDAO.obterTodasEntidades();
            DefaultTableModel tabelaColaborador = (DefaultTableModel) jTableInformacoesColaborador.getModel();
            for(int i = 0; i < colaboradores.size(); i++) {
                idColaboradores.add(colaboradores.get(i).getId());
                tabelaColaborador.addRow(colaboradores.get(i).listaValoresTabelaOrcamento());
            }
            
            pecas = pecaDAO.obterTodasEntidades();
            DefaultTableModel tabelaPeca = (DefaultTableModel) jTableInformacoesPeca.getModel();
            for(int i = 0; i < pecas.size(); i++) {
                idPecas.add(pecas.get(i).getId());
                tabelaPeca.addRow(pecas.get(i).listaValoresTabelaOS());
            }
            
            servicos = servicoDAO.obterTodasEntidades();
            DefaultTableModel tabelaServico = (DefaultTableModel) jTableInformacoesServico.getModel();
            for(int i = 0; i < servicos.size(); i++) {
                idServicos.add(servicos.get(i).getId());
                tabelaServico.addRow(servicos.get(i).listaValoresTabela());
            }
            
            tabelaOrcamento = (DefaultTableModel) jTableInformacoesOrcamento.getModel();
            
            veiculo = veiculoDAO.consultarPorId(orcamento.getIdVeiculo());
            colaborador = colaboradorDAO.consultarPorId(orcamento.getIdColaborador());
            
            jTextFieldTotal.setEnabled(false);
            jButtonAdicionarColaborador.setEnabled(false);
            jButtonAdicionarVeiculos.setEnabled(false);
            jTextFieldTotal.setText(orcamento.getTotal()+"");
            jTextFieldCodigo.setText(orcamento.getCodigo()+"");
            jFormattedTextFieldData.setText(orcamento.getDataOrcamentoGerado());
            jTextFieldDesconto.setText(orcamento.getDesconto()+"");
            
            tabelaOrcamento.addRow(veiculo.listaValoresTabelaOS());
            tabelaOrcamento.addRow(colaborador.listaValoresTabelaOrcamentoFinal());
            
            for(int i = 0; i < orcamento.getQtdServicos(); i++) {
                tabelaOrcamento.addRow(orcamento.getServicos().get(i).listaValoresTabela());
            }
            
            for(int i = 0; i < orcamento.getQtdPecas(); i++) {
                tabelaOrcamento.addRow(orcamento.getPecas().get(i).listaValoresTabelaOrcamento());
            }
            
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInformacoesPeca = new javax.swing.JTable();
        jButtonAdicionarServicos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerQtdPecas = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInformacoesServico = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButtonAdicionarPecas = new javax.swing.JButton();
        jButtonRemoverDados = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInformacoesVeiculo = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButtonAdicionarVeiculos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableInformacoesColaborador = new javax.swing.JTable();
        jButtonAdicionarColaborador = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableInformacoesOrcamento = new javax.swing.JTable();
        jTextFieldDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButtonGerarOrcamento = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 27)); // NOI18N
        jLabel1.setText("Orçamento");

        jTableInformacoesPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInformacoesPeca.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableInformacoesPeca);
        if (jTableInformacoesPeca.getColumnModel().getColumnCount() > 0) {
            jTableInformacoesPeca.getColumnModel().getColumn(0).setResizable(false);
            jTableInformacoesPeca.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonAdicionarServicos.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdicionarServicos.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonAdicionarServicos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarServicos.setText("Adicionar");
        jButtonAdicionarServicos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAdicionarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarServicosActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 22.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 27)); // NOI18N
        jLabel2.setText("Novo Orçamento");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setText("Peças");

        jTableInformacoesServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInformacoesServico.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableInformacoesServico);
        if (jTableInformacoesServico.getColumnModel().getColumnCount() > 0) {
            jTableInformacoesServico.getColumnModel().getColumn(0).setResizable(false);
            jTableInformacoesServico.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setText("Serviços");

        jButtonAdicionarPecas.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdicionarPecas.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonAdicionarPecas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarPecas.setText("Adicionar");
        jButtonAdicionarPecas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAdicionarPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPecasActionPerformed(evt);
            }
        });

        jButtonRemoverDados.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonRemoverDados.setText("Remover");
        jButtonRemoverDados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonRemoverDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverDadosActionPerformed(evt);
            }
        });

        jTableInformacoesVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Placa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInformacoesVeiculo.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableInformacoesVeiculo);
        if (jTableInformacoesVeiculo.getColumnModel().getColumnCount() > 0) {
            jTableInformacoesVeiculo.getColumnModel().getColumn(0).setResizable(false);
            jTableInformacoesVeiculo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel7.setText("Veículos");

        jButtonAdicionarVeiculos.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdicionarVeiculos.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonAdicionarVeiculos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarVeiculos.setText("Adicionar");
        jButtonAdicionarVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAdicionarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarVeiculosActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel8.setText("Colaborador");

        jTableInformacoesColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInformacoesColaborador.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableInformacoesColaborador);
        if (jTableInformacoesColaborador.getColumnModel().getColumnCount() > 0) {
            jTableInformacoesColaborador.getColumnModel().getColumn(0).setResizable(false);
            jTableInformacoesColaborador.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonAdicionarColaborador.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdicionarColaborador.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonAdicionarColaborador.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarColaborador.setText("Adicionar");
        jButtonAdicionarColaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAdicionarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarColaboradorActionPerformed(evt);
            }
        });

        jTableInformacoesOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInformacoesOrcamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableInformacoesOrcamento);
        if (jTableInformacoesOrcamento.getColumnModel().getColumnCount() > 0) {
            jTableInformacoesOrcamento.getColumnModel().getColumn(0).setResizable(false);
            jTableInformacoesOrcamento.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel9.setText("Desconto*");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setText("Total*");

        jButtonGerarOrcamento.setBackground(new java.awt.Color(0, 0, 0));
        jButtonGerarOrcamento.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonGerarOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerarOrcamento.setText("Gerar Orçamento");
        jButtonGerarOrcamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonGerarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarOrcamentoActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setText("Número*");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel22.setText("Data*");

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionarPecas)
                                    .addComponent(jButtonAdicionarServicos)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerQtdPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(111, 111, 111)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionarVeiculos)
                                    .addComponent(jButtonAdicionarColaborador))
                                .addGap(73, 73, 73)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonGerarOrcamento))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                .addComponent(jButtonRemoverDados, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)))))
                .addGap(49, 49, 49))
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonRemoverDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jSpinnerQtdPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFundoLayout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jButtonGerarOrcamento))
                                .addGroup(jPanelFundoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFundoLayout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(10, 10, 10)
                                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addGap(4, 4, 4)
                                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonCancelar))))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelFundoLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(10, 10, 10)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelFundoLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(10, 10, 10)
                                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(26, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelFundoLayout.createSequentialGroup()
                                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonAdicionarVeiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5))
                                    .addGap(6, 6, 6))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                    .addGap(194, 194, 194)
                                    .addComponent(jButtonAdicionarPecas)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonAdicionarColaborador, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAdicionarServicos, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(8, 83, 148));

        jButtonMenu.setBackground(new java.awt.Color(0, 0, 0));
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/New Car white.png"))); // NOI18N
        jButtonMenu.setBorder(null);
        jButtonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 43.png"))); // NOI18N
        jButtonSair.setBorder(null);
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSairMouseClicked(evt);
            }
        });

        jButtonConfigurar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 42.png"))); // NOI18N
        jButtonConfigurar.setBorder(null);
        jButtonConfigurar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(83, 578));

        jButtonCadastrarCliente.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 4.png"))); // NOI18N
        jButtonCadastrarCliente.setBorder(null);
        jButtonCadastrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarClienteActionPerformed(evt);
            }
        });

        jButtonCadastrarVeiculo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 5.png"))); // NOI18N
        jButtonCadastrarVeiculo.setBorder(null);
        jButtonCadastrarVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarVeiculoActionPerformed(evt);
            }
        });

        jButtonOrdemServico.setBackground(new java.awt.Color(0, 0, 0));
        jButtonOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 7.png"))); // NOI18N
        jButtonOrdemServico.setBorder(null);
        jButtonOrdemServico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdemServicoActionPerformed(evt);
            }
        });

        jButtonServico.setBackground(new java.awt.Color(0, 0, 0));
        jButtonServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 8.png"))); // NOI18N
        jButtonServico.setBorder(null);
        jButtonServico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicoActionPerformed(evt);
            }
        });

        jButtonPagar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 9.png"))); // NOI18N
        jButtonPagar.setBorder(null);
        jButtonPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        jButtonCadastrarColaborador.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 10.png"))); // NOI18N
        jButtonCadastrarColaborador.setBorder(null);
        jButtonCadastrarColaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCadastrarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarColaboradorActionPerformed(evt);
            }
        });

        jButtonCadastrarPecas.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarPecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 18.png"))); // NOI18N
        jButtonCadastrarPecas.setBorder(null);
        jButtonCadastrarPecas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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
                TelaExibirOrcamentoNF orcamento = new TelaExibirOrcamentoNF();
                orcamento.setVisible(true);
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

    private void jButtonAdicionarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarServicosActionPerformed
        try {
            int index = jTableInformacoesServico.getSelectedRow();
            if (index < 0) throw new Exception("Selecione um serviço na tabela");
            else {
                servico = servicoDAO.consultarPorId(idServicos.get(index));
                totalServicos += servico.getValor();
                total += totalServicos;
                jTextFieldTotal.setText(total+"");
                servicosEscolhidos.add(servico);
                tabelaOrcamento.addRow(servico.listaValoresTabela());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarServicosActionPerformed

    private void jButtonAdicionarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPecasActionPerformed
        try {
            int index = jTableInformacoesPeca.getSelectedRow();
            if (index < 0) throw new Exception("Selecione uma peça na tabela");
            else if (jSpinnerQtdPecas.getValue().equals(0)) throw new Exception("Selecione a quantidade");
            else {
                int valor = (int) jSpinnerQtdPecas.getValue();
                int i = 0;
                peca = pecaDAO.consultarPorId(idPecas.get(index));
                if((peca.getQtdEstoque() - valor) <= peca.getQtdMinEstoque()) throw new Exception("Não há a quantidade de peças selecionadas!");
                else {
                    while (i < valor) {
                        totalPecas += peca.getValorUnitario();
                        total += totalPecas;
                        jTextFieldTotal.setText(total+"");
                        pecasEscolhidas.add(peca);
                        tabelaOrcamento.addRow(peca.listaValoresTabelaOrcamento());
                        i++;
                    }
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarPecasActionPerformed

    private void jButtonRemoverDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverDadosActionPerformed
        tabelaOrcamento.setNumRows(0);
        jButtonAdicionarColaborador.setEnabled(true);
        jButtonAdicionarVeiculos.setEnabled(true);
        total = 0;
        jTextFieldTotal.setText(total+"");
    }//GEN-LAST:event_jButtonRemoverDadosActionPerformed

    private void jButtonAdicionarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarVeiculosActionPerformed
        try {
            int index = jTableInformacoesVeiculo.getSelectedRow();
            if (index < 0) throw new Exception("Selecione um Veículo na tabela");
            else {
                veiculo = veiculoDAO.consultarPorId(idVeiculos.get(index));
                tabelaOrcamento.addRow(veiculo.listaValoresTabelaOS());
                jButtonAdicionarVeiculos.setEnabled(false);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarVeiculosActionPerformed

    private void jButtonAdicionarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarColaboradorActionPerformed
        try {
            int index = jTableInformacoesColaborador.getSelectedRow();
            if (index < 0) throw new Exception("Selecione um Colaborador na tabela");
            else {
                colaborador = colaboradorDAO.consultarPorId(idColaboradores.get(index));
                tabelaOrcamento.addRow(colaborador.listaValoresTabelaOrcamentoFinal());
                jButtonAdicionarColaborador.setEnabled(false);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarColaboradorActionPerformed

    private void jButtonGerarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarOrcamentoActionPerformed
        try {
            if (jTextFieldDesconto.getText().equals("") || 
                    jTextFieldTotal.getText().equals("") ||
                    jTextFieldCodigo.getText().equals("") ||
                    jFormattedTextFieldData.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
            else if (jTableInformacoesOrcamento.getRowCount() < 1) throw new Exception("Preencha a tabela de orçamento.");
            else validador = true;
            
            orcamento.setIdCliente(veiculo.getIdCliente());
            orcamento.setIdColaborador(colaborador.getId());
            orcamento.setIdVeiculo(veiculo.getId());
            orcamento.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
            orcamento.setDataOrcamentoGerado(jFormattedTextFieldData.getText());
            orcamento.setDesconto(Integer.parseInt(jTextFieldDesconto.getText()));
            orcamento.setTotal(Integer.parseInt(jTextFieldTotal.getText()));
            orcamento.setFase(FasesDocumento.ATIVO);
            orcamento.setPecas(pecasEscolhidas);
            orcamento.setQtdPecas(pecasEscolhidas.size());
            orcamento.setQtdServicos(servicosEscolhidos.size());
            orcamento.setServicos(servicosEscolhidos);
            orcamento.setTotalPecas(totalPecas);
            orcamento.setTotalServicos(totalServicos);
            for(int i = 0; i < pecasEscolhidas.size(); i++) {
                pecasEscolhidas.get(i).setQtdEstoque(pecasEscolhidas.get(i).getQtdEstoque()-1);
                pecasEscolhidas.get(i).setReservadas(pecasEscolhidas.get(i).getReservadas()+1);
                pecaDAO.alterar(pecasEscolhidas.get(i));
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (validador) {
                    if (orcamento.getId() != 0) {
                        orcamentoDAO.alterar(orcamento);
                        JOptionPane.showMessageDialog(null, "Orçamento editado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        orcamentoDAO.incluir(orcamento);
                        JOptionPane.showMessageDialog(null, "Orçamento cadastrado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    TelaExibirOrcamentoNF telaExibirOrcamentoNF = new TelaExibirOrcamentoNF();
                    telaExibirOrcamentoNF.setVisible(true);
                    dispose();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonGerarOrcamentoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        TelaExibirOrcamentoNF telaExibirOrcamentoNF = new TelaExibirOrcamentoNF();
        telaExibirOrcamentoNF.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerarOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerarOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerarOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerarOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerarOrcamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarColaborador;
    private javax.swing.JButton jButtonAdicionarPecas;
    private javax.swing.JButton jButtonAdicionarServicos;
    private javax.swing.JButton jButtonAdicionarVeiculos;
    private javax.swing.JButton jButtonCadastrarCliente;
    private javax.swing.JButton jButtonCadastrarColaborador;
    private javax.swing.JButton jButtonCadastrarPecas;
    private javax.swing.JButton jButtonCadastrarVeiculo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfigurar;
    private javax.swing.JButton jButtonGerarOrcamento;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonOrdemServico;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonRemoverDados;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonServico;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinnerQtdPecas;
    private javax.swing.JTable jTableInformacoesColaborador;
    private javax.swing.JTable jTableInformacoesOrcamento;
    private javax.swing.JTable jTableInformacoesPeca;
    private javax.swing.JTable jTableInformacoesServico;
    private javax.swing.JTable jTableInformacoesVeiculo;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
