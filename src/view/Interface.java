/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManterCampeonato;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author notle
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonImportarPilotos = new javax.swing.JButton();
        jButtonImportarCalendarioDeCorridas = new javax.swing.JButton();
        jButtonImportarResultadoDeCorrida = new javax.swing.JButton();
        jButtonVisualizarClassificacaoGeralDePilotos = new javax.swing.JButton();
        jButtonImportarCalendarioDeCorridas1 = new javax.swing.JButton();
        jButtonImportarResultadoDeCorrida1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonImportarPilotos.setText("Importar Pilotos");
        jButtonImportarPilotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarPilotosActionPerformed(evt);
            }
        });

        jButtonImportarCalendarioDeCorridas.setText("Importar Calendário de Corridas");
        jButtonImportarCalendarioDeCorridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarCalendarioDeCorridasActionPerformed(evt);
            }
        });

        jButtonImportarResultadoDeCorrida.setText("Importar Resultado de Corrida");
        jButtonImportarResultadoDeCorrida.setEnabled(false);
        jButtonImportarResultadoDeCorrida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarResultadoDeCorridaActionPerformed(evt);
            }
        });

        jButtonVisualizarClassificacaoGeralDePilotos.setText("Visualizar Classificação Geral de Pilotos");
        jButtonVisualizarClassificacaoGeralDePilotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarClassificacaoGeralDePilotosActionPerformed(evt);
            }
        });

        jButtonImportarCalendarioDeCorridas1.setText("Visualizar Classificação Geral de Equipes");
        jButtonImportarCalendarioDeCorridas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarCalendarioDeCorridas1ActionPerformed(evt);
            }
        });

        jButtonImportarResultadoDeCorrida1.setText("Visualizar Resultado de Corrida");
        jButtonImportarResultadoDeCorrida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarResultadoDeCorrida1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonImportarResultadoDeCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonImportarResultadoDeCorrida1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonImportarPilotos, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVisualizarClassificacaoGeralDePilotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonImportarCalendarioDeCorridas, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonImportarCalendarioDeCorridas1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonImportarPilotos, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jButtonVisualizarClassificacaoGeralDePilotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImportarCalendarioDeCorridas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImportarCalendarioDeCorridas1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImportarResultadoDeCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImportarResultadoDeCorrida1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jMenuArquivo.setText("Arquivo");
        jMenuBar1.add(jMenuArquivo);

        jMenuSair.setText("Sair");
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImportarPilotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarPilotosActionPerformed
        
        //Exibir caixa de diálogo
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);
        //Efetuar importação
        if(retorno == JFileChooser.APPROVE_OPTION){
            ManterCampeonato.importarPilotos(fileChooser.getSelectedFile());
        }
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            //Verificar se os pilotos já foram importados, confirmar e efetuar importação
            if(ManterCampeonato.pilotosJaForamImportados()){
                int confirma = JOptionPane.showOptionDialog(jPanel1, "Os pilotos já foram importados uma vez. Deseja sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirma == JOptionPane.YES_OPTION){
                    ManterCampeonato.importarPilotos(fileChooser.getSelectedFile());
                }
            }else{
                ManterCampeonato.importarPilotos(fileChooser.getSelectedFile());
            }
        }
        
        //Habilidar botão de importação de resultados
        if(ManterCampeonato.pilotosJaForamImportados() && ManterCampeonato.calendarioDeCorridasJaFoiImportado()){
            jButtonImportarResultadoDeCorrida.setEnabled(true);
        }
        
    }//GEN-LAST:event_jButtonImportarPilotosActionPerformed

    private void jButtonImportarCalendarioDeCorridasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarCalendarioDeCorridasActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
            //Verificar se o calendário já foi importado,confirmar e efetuar importação
            if(ManterCampeonato.calendarioDeCorridasJaFoiImportado()){
                int confirma = JOptionPane.showOptionDialog(jPanel1, "O calendário de corridas já foi importado uma vez. Deseja sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirma == JOptionPane.YES_OPTION){
                    ManterCampeonato.importarCalendarioDeCorridas(fileChooser.getSelectedFile());
                }
            }else{
                ManterCampeonato.importarCalendarioDeCorridas(fileChooser.getSelectedFile());
            }
        }
        
        //Habilidar botão de importação de resultados
        if(ManterCampeonato.pilotosJaForamImportados() && ManterCampeonato.calendarioDeCorridasJaFoiImportado()){
            jButtonImportarResultadoDeCorrida.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonImportarCalendarioDeCorridasActionPerformed

    private void jButtonImportarResultadoDeCorridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarResultadoDeCorridaActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
            if(ManterCampeonato.resultadoDeCorridaJaFoiImportado(fileChooser.getSelectedFile())){
                int confirma = JOptionPane.showOptionDialog(jPanel1, "O resultado desta corrida já foi importado uma vez. Deseja sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirma == JOptionPane.YES_OPTION){
                    ManterCampeonato.importarResultadoDeCorrida(fileChooser.getSelectedFile());
                }
            }else{
                ManterCampeonato.importarResultadoDeCorrida(fileChooser.getSelectedFile());
            }
        }
    }//GEN-LAST:event_jButtonImportarResultadoDeCorridaActionPerformed

    private void jButtonVisualizarClassificacaoGeralDePilotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarClassificacaoGeralDePilotosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVisualizarClassificacaoGeralDePilotosActionPerformed

    private void jButtonImportarCalendarioDeCorridas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarCalendarioDeCorridas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImportarCalendarioDeCorridas1ActionPerformed

    private void jButtonImportarResultadoDeCorrida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarResultadoDeCorrida1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImportarResultadoDeCorrida1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImportarCalendarioDeCorridas;
    private javax.swing.JButton jButtonImportarCalendarioDeCorridas1;
    private javax.swing.JButton jButtonImportarPilotos;
    private javax.swing.JButton jButtonImportarResultadoDeCorrida;
    private javax.swing.JButton jButtonImportarResultadoDeCorrida1;
    private javax.swing.JButton jButtonVisualizarClassificacaoGeralDePilotos;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}