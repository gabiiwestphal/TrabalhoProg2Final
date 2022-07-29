/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import Controller.caixa.ControllerAddRevistaCaixa;
import Controller.caixa.ControllerBuscarRevista;
import Controller.caixa.ControllerCaixaCreate;
import Controller.caixa.ControllerCaixaList;
import Controller.caixa.ControllerCaixaRemoverRevista;
import Controller.pessoa.ControllerDevolver;
import Controller.pessoa.ControllerEmprestar;
import Controller.pessoa.ControllerPessoaCreate;
import Controller.pessoa.ControllerPessoaList;
import Controller.revistas.ControllerRevistaCreate;
import Controller.revistas.ControllerRevistaList;
import DAO.AmigoDAO;
import DAO.CaixaDAO;
import DAO.DonoDAO;
import DAO.EmprestimoDAO;
import DAO.MultaDAO;
import DAO.RevistaDAO;
import Model.tabela.CaixaTableModel;
import Model.tabela.RevistaTableModel;
import View.Pessoa.DevolverView;
import View.Pessoa.EmprestarView;
import View.Pessoa.PessoaCreateView;
import View.Pessoa.PessoaListView;
import View.caixa.AddRevistaCaixaView;
import View.caixa.BuscarRevistaView;
import View.caixa.CaixaCreateView;
import View.caixa.CaixaListView;
import View.caixa.CaixaRemoverRevistaView;
import View.revista.RevistaCreateView;
import View.revista.RevistaListView;

public class TelaPrincipalView extends javax.swing.JFrame {
 
    public TelaPrincipalView() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pessoa = new javax.swing.JMenuBar();
        mnCaixa = new javax.swing.JMenu();
        miCriarCaixa = new javax.swing.JMenuItem();
        miListarCaixas = new javax.swing.JMenuItem();
        miAddRevista = new javax.swing.JMenuItem();
        miBuscarRevista = new javax.swing.JMenuItem();
        miRemoverRevista = new javax.swing.JMenuItem();
        mnRevista = new javax.swing.JMenu();
        miCriarRevista = new javax.swing.JMenuItem();
        miListarRevistas = new javax.swing.JMenuItem();
        mnPessoa = new javax.swing.JMenu();
        miCriarPessoa = new javax.swing.JMenuItem();
        miListarPessoa = new javax.swing.JMenuItem();
        mnEmprestimo = new javax.swing.JMenu();
        miEmprestar = new javax.swing.JMenuItem();
        miDevolver = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnCaixa.setText("Caixa");
        mnCaixa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miCriarCaixa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCriarCaixa.setText("Criar");
        miCriarCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarCaixaView(evt);
            }
        });
        mnCaixa.add(miCriarCaixa);

        miListarCaixas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miListarCaixas.setText("Listar Caixas");
        miListarCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListarCaixasActionPerformed(evt);
            }
        });
        mnCaixa.add(miListarCaixas);

        miAddRevista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAddRevista.setText("Adicionar Revista");
        miAddRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddRevistaActionPerformed(evt);
            }
        });
        mnCaixa.add(miAddRevista);

        miBuscarRevista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miBuscarRevista.setText("Buscar Revista");
        miBuscarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarRevistaActionPerformed(evt);
            }
        });
        mnCaixa.add(miBuscarRevista);

        miRemoverRevista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRemoverRevista.setText("Remover Revista da Caixa");
        miRemoverRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoverRevistaActionPerformed(evt);
            }
        });
        mnCaixa.add(miRemoverRevista);

        Pessoa.add(mnCaixa);

        mnRevista.setText("Revista");
        mnRevista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miCriarRevista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCriarRevista.setText("Criar");
        miCriarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCriarRevistacriarRevistaView(evt);
            }
        });
        mnRevista.add(miCriarRevista);

        miListarRevistas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miListarRevistas.setText("Listar revistas");
        miListarRevistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListarRevistasActionPerformed(evt);
            }
        });
        mnRevista.add(miListarRevistas);

        Pessoa.add(mnRevista);

        mnPessoa.setText("Pessoa");
        mnPessoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miCriarPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCriarPessoa.setText("Criar pessoa");
        miCriarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCriarPessoaActionPerformed(evt);
            }
        });
        mnPessoa.add(miCriarPessoa);

        miListarPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miListarPessoa.setText("Listar Pessoas");
        miListarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListarPessoaActionPerformed(evt);
            }
        });
        mnPessoa.add(miListarPessoa);

        Pessoa.add(mnPessoa);

        mnEmprestimo.setText("Empréstimo");
        mnEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miEmprestar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miEmprestar.setText("Emprestar");
        miEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmprestarActionPerformed(evt);
            }
        });
        mnEmprestimo.add(miEmprestar);

        miDevolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miDevolver.setText("Devolver");
        miDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDevolverActionPerformed(evt);
            }
        });
        mnEmprestimo.add(miDevolver);

        Pessoa.add(mnEmprestimo);

        setJMenuBar(Pessoa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void criarCaixaView(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarCaixaView
        ControllerCaixaCreate ccc = new ControllerCaixaCreate(new CaixaCreateView());
        
        ccc.exibirTela();
    }//GEN-LAST:event_criarCaixaView

    private void miCriarRevistacriarRevistaView(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCriarRevistacriarRevistaView
        ControllerRevistaCreate crc = new ControllerRevistaCreate(new RevistaCreateView());
        
        crc.exibirTela();
    }//GEN-LAST:event_miCriarRevistacriarRevistaView

    private void miAddRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddRevistaActionPerformed

        ControllerAddRevistaCaixa carc = new ControllerAddRevistaCaixa(new AddRevistaCaixaView());
        
        carc.exibirTela();
    }//GEN-LAST:event_miAddRevistaActionPerformed

    private void miListarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListarCaixasActionPerformed
        ControllerCaixaList ccl = new ControllerCaixaList(new CaixaListView(), new CaixaTableModel(CaixaDAO.recuperarTodasCaixas()));
        
        ccl.exibir();
    }//GEN-LAST:event_miListarCaixasActionPerformed

    private void miBuscarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarRevistaActionPerformed
       ControllerBuscarRevista cbr = new ControllerBuscarRevista(new BuscarRevistaView());
        
        cbr.exibirTela();
    }//GEN-LAST:event_miBuscarRevistaActionPerformed

    private void miRemoverRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoverRevistaActionPerformed
        ControllerCaixaRemoverRevista ccrr = new ControllerCaixaRemoverRevista(new CaixaRemoverRevistaView());
        
        ccrr.exibirTela();
    }//GEN-LAST:event_miRemoverRevistaActionPerformed

    private void miListarRevistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListarRevistasActionPerformed
        ControllerRevistaList cpl = new ControllerRevistaList(new RevistaListView(), new RevistaTableModel(RevistaDAO.recuperarTodasRevistas()));
        
        cpl.exibir();
    }//GEN-LAST:event_miListarRevistasActionPerformed

    private void miCriarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCriarPessoaActionPerformed
       ControllerPessoaCreate cpc = new ControllerPessoaCreate(new PessoaCreateView());
       
       cpc.exibirTela();
    }//GEN-LAST:event_miCriarPessoaActionPerformed

    private void miEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmprestarActionPerformed
        ControllerEmprestar ce = new ControllerEmprestar(new EmprestarView());
        
        ce.exibirTela();
    }//GEN-LAST:event_miEmprestarActionPerformed

    private void miDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDevolverActionPerformed
        ControllerDevolver cd = new ControllerDevolver(new DevolverView());
        
        cd.exibirTela();
    }//GEN-LAST:event_miDevolverActionPerformed

    private void miListarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListarPessoaActionPerformed
            
        ControllerPessoaList cpl = new ControllerPessoaList(new PessoaListView());
        cpl.exibirTela();
    }//GEN-LAST:event_miListarPessoaActionPerformed

    public static void main(String args[]) {
        TelaPrincipalView tpv = new TelaPrincipalView();
        
        CaixaDAO.createTable();
        RevistaDAO.createTable();
        DonoDAO.createTable();
        AmigoDAO.createTable();
        EmprestimoDAO.createTable();
        MultaDAO.createTable();
        
        tpv.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Pessoa;
    private javax.swing.JMenuItem miAddRevista;
    private javax.swing.JMenuItem miBuscarRevista;
    private javax.swing.JMenuItem miCriarCaixa;
    private javax.swing.JMenuItem miCriarPessoa;
    private javax.swing.JMenuItem miCriarRevista;
    private javax.swing.JMenuItem miDevolver;
    private javax.swing.JMenuItem miEmprestar;
    private javax.swing.JMenuItem miListarCaixas;
    private javax.swing.JMenuItem miListarPessoa;
    private javax.swing.JMenuItem miListarRevistas;
    private javax.swing.JMenuItem miRemoverRevista;
    private javax.swing.JMenu mnCaixa;
    private javax.swing.JMenu mnEmprestimo;
    private javax.swing.JMenu mnPessoa;
    private javax.swing.JMenu mnRevista;
    // End of variables declaration//GEN-END:variables
}
