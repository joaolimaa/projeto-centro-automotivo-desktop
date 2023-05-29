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
import java.util.List;
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
import projetomecanica.entidades.NotaFiscal;
import projetomecanica.entidades.Orcamento;
import projetomecanica.entidades.OrdemDeServico;
import projetomecanica.entidades.Peca;
import projetomecanica.entidades.Servico;
import projetomecanica.entidades.Veiculo;
import projetomecanica.entidades.dao.ClienteDAO;
import projetomecanica.entidades.dao.ColaboradorDAO;
import projetomecanica.entidades.dao.NotaFiscalDAO;
import projetomecanica.entidades.dao.OrcamentoDAO;
import projetomecanica.entidades.dao.OrdemDeServicoDAO;
import projetomecanica.entidades.dao.PecaDAO;
import projetomecanica.entidades.dao.ServicoDAO;
import projetomecanica.entidades.dao.VeiculoDAO;
import projetomecanica.entidades.enums.FasesDocumento;
import projetomecanica.entidades.enums.StatusVeiculo;
import projetomecanica.telas.clientes.*;
import projetomecanica.telas.funcionarios.*;
/**
 *
 * @author Dell
 */
public class TelaGerarNF extends javax.swing.JFrame {
    
    OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    PecaDAO pecaDAO = new PecaDAO();
    ServicoDAO servicoDAO = new ServicoDAO();
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
    OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
    Orcamento orcamento = new Orcamento();
    OrdemDeServico ordemDeServico = new OrdemDeServico();
    Cliente cliente = new Cliente();
    Peca peca = new Peca();
    Servico servico = new Servico();
    Veiculo veiculo = new Veiculo();
    Colaborador colaborador = new Colaborador();
    ArrayList<Integer> idOSs = new ArrayList<>();
    ArrayList<Peca> pecas = new ArrayList<>();
    ArrayList<Servico> servicos = new ArrayList<>();
    NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO();
    NotaFiscal notaFiscal = new NotaFiscal();
    
    boolean validador = false;

    /**
     * Creates new form TelaTechnocar
     */
    public TelaGerarNF() {
        try {
            initComponents();
            if(this.getExtendedState()!= TelaGerarNF.MAXIMIZED_BOTH){
                this.setExtendedState(TelaGerarNF.MAXIMIZED_BOTH);
            }
            setLocationRelativeTo(null);
            
            List<OrdemDeServico> listaDeOrdemDeServicos = ordemDeServicoDAO.obterEntidadesPorFase(FasesDocumento.ATIVO);
            
            DefaultTableModel tabela = (DefaultTableModel) jTableOS.getModel();
            for(int i = 0; i < listaDeOrdemDeServicos.size(); i++) {
                idOSs.add(listaDeOrdemDeServicos.get(i).getId());
                tabela.addRow(listaDeOrdemDeServicos.get(i).listaValoresTelaNF());
            }
            jTextFieldColaborador.setEnabled(false);
            jTextFieldTotal.setEnabled(false);
            jTextFieldTotalDesconto.setEnabled(false);
            jTextFieldTotalPecas.setEnabled(false);
            jTextFieldTotalServicos.setEnabled(false);
            jTextFieldDesconto.setEnabled(false);
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public TelaGerarNF(int idNF) {
        try {
            initComponents();
            if(this.getExtendedState()!= TelaGerarNF.MAXIMIZED_BOTH){
                this.setExtendedState(TelaGerarNF.MAXIMIZED_BOTH);
            }
            setLocationRelativeTo(null);
            
            notaFiscal = notaFiscalDAO.consultarPorId(idNF);
            
            List<OrdemDeServico> listaDeOrdemDeServicos = ordemDeServicoDAO.obterEntidadesPorFase(FasesDocumento.ATIVO);
            
            DefaultTableModel tabela = (DefaultTableModel) jTableOS.getModel();
            for(int i = 0; i < listaDeOrdemDeServicos.size(); i++) {
                idOSs.add(listaDeOrdemDeServicos.get(i).getId());
                tabela.addRow(listaDeOrdemDeServicos.get(i).listaValoresTelaNF());
            }
            jTextFieldColaborador.setEnabled(false);
            jTextFieldTotal.setEnabled(false);
            jTextFieldTotalDesconto.setEnabled(false);
            jTextFieldTotalPecas.setEnabled(false);
            jTextFieldTotalServicos.setEnabled(false);
            jTextFieldDesconto.setEnabled(false);
            
            orcamento = orcamentoDAO.consultarPorId(notaFiscal.getIdOrcamento());
            cliente = clienteDAO.consultarPorId(notaFiscal.getIdCliente());
            veiculo = veiculoDAO.consultarPorId(notaFiscal.getIdVeiculo());
            pecas = notaFiscal.getPecas();
            servicos = notaFiscal.getServicos();
            colaborador = colaboradorDAO.consultarPorId(notaFiscal.getIdColaborador());
            jTextFieldColaborador.setText(colaborador.getNomeCompleto());
            float total = 0;
            float totalPecas = 0;
            float totalServicos = 0;
            for(int i = 0; i < notaFiscal.getQtdPecas(); i++) {
                totalPecas += pecas.get(i).getValorUnitario();
            }
            jTextFieldTotalPecas.setText(totalPecas+"");
            for(int i = 0; i < notaFiscal.getQtdServicos(); i++) {
                totalServicos += servicos.get(i).getValor();
            }
            jTextFieldTotalServicos.setText(totalServicos+"");
            total = totalPecas+totalServicos;
            jTextFieldTotal.setText(total+"");
            jFormattedTextFieldData.setText(notaFiscal.getDataGerado());
            jTextFieldTotalDesconto.setText((total - (orcamento.getDesconto()))+"");
            jTextFieldNumero.setText(notaFiscal.getNumeroNF()+"");
            jTextFieldSerie.setText(notaFiscal.getSerieNF()+"");

            DefaultTableModel tabelaCliente = (DefaultTableModel) jTableCliente.getModel();
            tabelaCliente.setNumRows(0);
            tabelaCliente.addRow(cliente.listaValoresTabelaVeiculoEOS());

            DefaultTableModel tabelaVeiculo = (DefaultTableModel) jTableVeiculo.getModel();
            tabelaVeiculo.setNumRows(0);
            tabelaVeiculo.addRow(veiculo.listaValoresTabelaOS());

            DefaultTableModel tabelaPecas = (DefaultTableModel) jTablePecas.getModel();
            tabelaPecas.setNumRows(0);
            for(int i = 0; i < notaFiscal.getQtdPecas(); i++) {
                tabelaPecas.addRow(pecas.get(i).listaValoresTabelaOS());
            }
            DefaultTableModel tabelaServicos = (DefaultTableModel) jTableServicos.getModel();
            tabelaServicos.setNumRows(0);
            for(int i = 0; i < notaFiscal.getQtdServicos(); i++) {
                tabelaServicos.addRow(servicos.get(i).listaValoresTabela());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldColaborador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonSelecionarOS = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableOS = new javax.swing.JTable();
        jTextFieldSerie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTotalServicos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldTotalPecas = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableVeiculo = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablePecas = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableServicos = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldTotalDesconto = new javax.swing.JTextField();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonConfigurar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonCadastrarColaborador = new javax.swing.JButton();
        jButtonCadastrarPecas = new javax.swing.JButton();
        jButtonPagar = new javax.swing.JButton();
        jButtonServico = new javax.swing.JButton();
        jButtonOrdemServico = new javax.swing.JButton();
        jButtonCadastrarVeiculo = new javax.swing.JButton();
        jButtonCadastrarCliente = new javax.swing.JButton();

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
        jLabel1.setText("Nota Fiscal");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setText("Cliente");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel7.setText("Veículo");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel9.setText("Colaborador*");

        jButtonSelecionarOS.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSelecionarOS.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonSelecionarOS.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSelecionarOS.setText("Selecionar Orçamento");
        jButtonSelecionarOS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSelecionarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarOSActionPerformed(evt);
            }
        });

        jTableOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número da OS", "Veículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOS.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableOS);
        if (jTableOS.getColumnModel().getColumnCount() > 0) {
            jTableOS.getColumnModel().getColumn(0).setResizable(false);
            jTableOS.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setText("Série NF*");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setText("Total Serviços*");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel13.setText("Número NF*");

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel20.setText("Total Peças*");

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel21.setText("Valor do Desconto*");

        jTableVeiculo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTableVeiculo);
        if (jTableVeiculo.getColumnModel().getColumnCount() > 0) {
            jTableVeiculo.getColumnModel().getColumn(0).setResizable(false);
            jTableVeiculo.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome / Razão Social", "CPF / CNPJ"
            }
        ));
        jScrollPane7.setViewportView(jTableCliente);

        jButtonSalvar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalvar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
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

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel22.setText("Peças");

        jTablePecas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTablePecas);
        if (jTablePecas.getColumnModel().getColumnCount() > 0) {
            jTablePecas.getColumnModel().getColumn(0).setResizable(false);
            jTablePecas.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTableServicos);
        if (jTableServicos.getColumnModel().getColumnCount() > 0) {
            jTableServicos.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setText("Serviços");

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel25.setText("Total*");

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel28.setText("Total com Desconto*");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel24.setText("Data*");

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jButtonSelecionarOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar))
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jTextFieldTotalServicos)
                                    .addComponent(jTextFieldSerie)
                                    .addComponent(jTextFieldColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldTotalPecas, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTotalDesconto)
                                    .addComponent(jTextFieldTotal)
                                    .addComponent(jLabel24)
                                    .addComponent(jFormattedTextFieldData))))))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel22))
                .addGap(15, 15, 15)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFundoLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                                                        .addComponent(jLabel25)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldTotalPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addGap(10, 10, 10)
                                                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(17, 17, 17))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonSelecionarOS))
                .addContainerGap(29, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1511, Short.MAX_VALUE)
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

        jButtonPagar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 9.png"))); // NOI18N
        jButtonPagar.setBorder(null);
        jButtonPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
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

        jButtonOrdemServico.setBackground(new java.awt.Color(0, 0, 0));
        jButtonOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 7.png"))); // NOI18N
        jButtonOrdemServico.setBorder(null);
        jButtonOrdemServico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdemServicoActionPerformed(evt);
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

        jButtonCadastrarCliente.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetomecanica/telas/visao/icones/Ativo 4.png"))); // NOI18N
        jButtonCadastrarCliente.setBorder(null);
        jButtonCadastrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarClienteActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrarCliente)
                .addGap(60, 60, 60)
                .addComponent(jButtonCadastrarVeiculo)
                .addGap(60, 60, 60)
                .addComponent(jButtonOrdemServico)
                .addGap(60, 60, 60)
                .addComponent(jButtonServico)
                .addGap(60, 60, 60)
                .addComponent(jButtonPagar)
                .addGap(60, 60, 60)
                .addComponent(jButtonCadastrarPecas)
                .addGap(60, 60, 60)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
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

    private void jButtonSelecionarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarOSActionPerformed
        try {
            int index = jTableOS.getSelectedRow();
            if (index < 0) throw new Exception("Selecione uma Ordem de Serviço na tabela");
            else {
                ordemDeServico = ordemDeServicoDAO.consultarPorId(idOSs.get(index));
                
                cliente = clienteDAO.consultarPorId(ordemDeServico.getIdCliente());
                veiculo = veiculoDAO.consultarPorId(ordemDeServico.getIdVeiculo());
                pecas = ordemDeServico.getPecas();
                servicos = ordemDeServico.getServicos();
                colaborador = colaboradorDAO.consultarPorId(ordemDeServico.getIdColaborador());
                jTextFieldColaborador.setText(colaborador.getNomeCompleto());
                float total = 0;
                float totalPecas = 0;
                float totalServicos = 0;
                for(int i = 0; i < ordemDeServico.getQtdPecas(); i++) {
                    totalPecas += pecas.get(i).getValorUnitario();
                }
                jTextFieldTotalPecas.setText(totalPecas+"");
                for(int i = 0; i < ordemDeServico.getQtdServicos(); i++) {
                    totalServicos += servicos.get(i).getValor();
                }
                jTextFieldTotalServicos.setText(totalServicos+"");
                total = totalPecas+totalServicos;
                jTextFieldTotal.setText(total+"");
                jTextFieldDesconto.setText(orcamentoDAO.consultarPorId(ordemDeServico.getIdOrcamento()).getDesconto()+"");
                jTextFieldTotalDesconto.setText((total - (orcamentoDAO.consultarPorId(ordemDeServico.getIdOrcamento()).getDesconto()))+"");
            
                DefaultTableModel tabelaCliente = (DefaultTableModel) jTableCliente.getModel();
                tabelaCliente.setNumRows(0);
                tabelaCliente.addRow(cliente.listaValoresTabelaVeiculoEOS());
                
                DefaultTableModel tabelaVeiculo = (DefaultTableModel) jTableVeiculo.getModel();
                tabelaVeiculo.setNumRows(0);
                tabelaVeiculo.addRow(veiculo.listaValoresTabelaOS());
                
                DefaultTableModel tabelaPecas = (DefaultTableModel) jTablePecas.getModel();
                tabelaPecas.setNumRows(0);
                for(int i = 0; i < ordemDeServico.getQtdPecas(); i++) {
                    tabelaPecas.addRow(pecas.get(i).listaValoresTabelaOS());
                }
                DefaultTableModel tabelaServicos = (DefaultTableModel) jTableServicos.getModel();
                tabelaServicos.setNumRows(0);
                for(int i = 0; i < ordemDeServico.getQtdServicos(); i++) {
                    tabelaServicos.addRow(servicos.get(i).listaValoresTabela());
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSelecionarOSActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            if (jTextFieldTotalServicos.getText().equals("") || 
                    jTextFieldTotal.getText().equals("") ||
                    jTextFieldTotalDesconto.getText().equals("") ||
                    jTextFieldColaborador.getText().equals("") ||
                    jTextFieldNumero.getText().equals("") ||
                    jFormattedTextFieldData.getText().equals("") ||
                    jTextFieldSerie.getText().equals("")) throw new Exception("Preencha todos os campos obrigatórios (*)");
            else if (jTableOS.getSelectedRow() < 0) throw new Exception("Selecione uma ordem de serviço na tabela");
            else validador = true;
            
            ordemDeServico.setFase(FasesDocumento.FINALIZADO);
            ordemDeServico.setDataOrdemDeServicoFinalizada(jFormattedTextFieldData.getText());
            veiculo.setStatus(StatusVeiculo.INATIVO);
            notaFiscal.setNumeroNF(Integer.parseInt(jTextFieldNumero.getText()));
            notaFiscal.setSerieNF(Integer.parseInt(jTextFieldSerie.getText()));
            notaFiscal.setDataGerado(ordemDeServico.getDataOrdemDeServicoFinalizada());
            notaFiscal.setDataPagamento(ordemDeServico.getDataOrdemDeServicoFinalizada());
            notaFiscal.setDataValidade(ordemDeServico.getDataOrdemDeServicoFinalizada());
            notaFiscal.setFase(FasesDocumento.ATIVO);
            notaFiscal.setIdCliente(ordemDeServico.getIdCliente());
            notaFiscal.setIdColaborador(ordemDeServico.getIdColaborador());
            notaFiscal.setIdVeiculo(ordemDeServico.getIdVeiculo());
            notaFiscal.setIdOrcamento(ordemDeServico.getIdOrcamento());
            notaFiscal.setIdOrdemDeServico(ordemDeServico.getId());
            notaFiscal.setQtdPecas(ordemDeServico.getQtdPecas());
            notaFiscal.setQtdServicos(ordemDeServico.getQtdServicos());
            notaFiscal.setDesconto(orcamentoDAO.consultarPorId(ordemDeServico.getIdOrcamento()).getDesconto());
            notaFiscal.setTotalPecas(Float.parseFloat(jTextFieldTotalPecas.getText()));
            notaFiscal.setTotalServicos(Float.parseFloat(jTextFieldTotalServicos.getText()));
            notaFiscal.setTotal(Float.parseFloat(jTextFieldTotal.getText()));
            notaFiscal.setPecas(ordemDeServico.getPecas());
            notaFiscal.setServicos(ordemDeServico.getServicos());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (validador) {
                    if (notaFiscal.getId() != 0) {
                        veiculoDAO.alterar(veiculo);
                        ordemDeServicoDAO.alterar(ordemDeServico);
                        notaFiscalDAO.alterar(notaFiscal);
                        JOptionPane.showMessageDialog(null, "Nota Fiscal editado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ordemDeServicoDAO.alterar(ordemDeServico);
                        notaFiscalDAO.incluir(notaFiscal);
                        JOptionPane.showMessageDialog(null, "Nota Fiscal Serviço cadastrado com sucesso!", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    TelaExibirOrcamentoNF pagamento = new TelaExibirOrcamentoNF();
                    pagamento.setVisible(true);
                    dispose();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro, "Aviso:", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        TelaExibirOrcamentoNF pagamento = new TelaExibirOrcamentoNF();
        pagamento.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCadastrarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarColaboradorActionPerformed
        // TODO add your handling code here:
        TelaExibirColaboradores funcionario = new TelaExibirColaboradores();
        funcionario.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarColaboradorActionPerformed

    private void jButtonCadastrarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarPecasActionPerformed
        // TODO add your handling code here:
        TelaPecas pecas = new TelaPecas();
        pecas.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarPecasActionPerformed

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        // TODO add your handling code here:
        TelaExibirOrcamentoNF pagamento = new TelaExibirOrcamentoNF();
        pagamento.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonPagarActionPerformed

    private void jButtonServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicoActionPerformed
        // TODO add your handling code here:
        TelaServicos servico = new TelaServicos();
        servico.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonServicoActionPerformed

    private void jButtonOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdemServicoActionPerformed
        // TODO add your handling code here:
        TelaListagemOS ordemServico = new TelaListagemOS();
        ordemServico.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonOrdemServicoActionPerformed

    private void jButtonCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarVeiculoActionPerformed
        // TODO add your handling code here:
        TelaExibirVeiculos veiculo = new TelaExibirVeiculos();
        veiculo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarVeiculoActionPerformed

    private void jButtonCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarClienteActionPerformed
        // TODO add your handling code here:
        TelaExibirClientes cliente = new TelaExibirClientes();
        cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerarNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerarNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerarNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerarNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerarNF().setVisible(true);
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
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarOS;
    private javax.swing.JButton jButtonServico;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableOS;
    private javax.swing.JTable jTablePecas;
    private javax.swing.JTable jTableServicos;
    private javax.swing.JTable jTableVeiculo;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldColaborador;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldSerie;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotalDesconto;
    private javax.swing.JTextField jTextFieldTotalPecas;
    private javax.swing.JTextField jTextFieldTotalServicos;
    // End of variables declaration//GEN-END:variables
}
