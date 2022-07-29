/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Pessoa;

import Model.Pessoa;
import Model.Amigo;
import Model.Dono;
import Model.Revista;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

public class EmprestarView extends javax.swing.JFrame {

    public EmprestarView()  {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        tfData = new javax.swing.JTextField();
        jAmigo = new javax.swing.JLabel();
        cbAmigo = new javax.swing.JComboBox<>();
        jLRevista = new javax.swing.JLabel();
        cbRevista = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbDono = new javax.swing.JComboBox<>();
        btEmprestar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Emprestar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLData.setText("Data:");
        jLData.setDoubleBuffered(true);

        jAmigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jAmigo.setText("Amigo");

        jLRevista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLRevista.setText("Revista");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Dono");

        btEmprestar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btEmprestar.setLabel("Emprestar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLData)
                        .addGap(18, 18, 18)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLRevista)
                            .addComponent(jAmigo)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbRevista, 0, 389, Short.MAX_VALUE)
                            .addComponent(cbAmigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbDono, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEmprestar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAmigo))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRevista)
                    .addComponent(cbRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btEmprestar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLRevista.getAccessibleContext().setAccessibleName("jLRevista");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   public String getData() {
        return tfData.getText();
    }
    
   public void popularComboBoxDono(List<Dono> donos) {
        for (Dono d : donos) {
            cbDono.addItem(d);           
        }
    }    
    
    public void popularComboBoxAmigo(List<Amigo> amigos) {
        for(Amigo a : amigos) {
            cbAmigo.addItem(a);
        }
    }
    
    public void popularComboBoxRevista(List<Revista> revistas) {
        for(Revista r : revistas) {
            cbRevista.addItem(r);
        }
    }
  
    public Dono getDono() {
        return (Dono) cbDono.getSelectedItem();
    }
    
    public Amigo getAmigo() {
        return (Amigo) cbAmigo.getSelectedItem();
    }
    
    public Revista getRevista() {
        return (Revista) cbRevista.getSelectedItem();
    }
    
    public void adicionarAcaoBotaoEmprestar(ActionListener acao) {
        btEmprestar.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public void limparTela() {
        tfData.setText("");
    }
     
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btEmprestar;
    private javax.swing.JComboBox<Pessoa> cbAmigo;
    private javax.swing.JComboBox<Pessoa> cbDono;
    private javax.swing.JComboBox<Revista> cbRevista;
    private javax.swing.JLabel jAmigo;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLRevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfData;
    // End of variables declaration//GEN-END:variables
}
