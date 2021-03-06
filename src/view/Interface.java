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
        habilitarBotaoDeImportacaoDeResultados();
        atualizarClassificacaoGeralDePilotos();
        atualizarResultadosDeCorridas();
        atualizarClassificacaoDePilotosPorCorrida();
        atualizarClassificacaoGeralDeEquipes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanePrincipal = new javax.swing.JTabbedPane();
        jScrollPaneClassificacaoGeralDePilotos = new javax.swing.JScrollPane();
        jTableClassificacaoGeralDePilotos = new javax.swing.JTable();
        jScrollPaneClassificacaoGeralDeEquipes = new javax.swing.JScrollPane();
        jTableClassificacaoGeralDeEquipes = new javax.swing.JTable();
        jPanelClassificacaoDePilototosPorCorrida = new javax.swing.JPanel();
        jComboBoxCorrida = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClassificacaoDePilotosPorCorrida = new javax.swing.JTable();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemImportarPilotos = new javax.swing.JMenuItem();
        jMenuItemImportarCalendarioDeCorridas = new javax.swing.JMenuItem();
        jMenuItemImportarResultadoDeCorrida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTableClassificacaoGeralDePilotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posição", "Nome", "Equipe", "Pontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneClassificacaoGeralDePilotos.setViewportView(jTableClassificacaoGeralDePilotos);
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(0).setResizable(false);
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(0).setHeaderValue("Posição");
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(1).setResizable(false);
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(1).setHeaderValue("Nome");
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(2).setResizable(false);
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(2).setHeaderValue("Equipe");
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(3).setResizable(false);
        jTableClassificacaoGeralDePilotos.getColumnModel().getColumn(3).setHeaderValue("Pontos");

        jTabbedPanePrincipal.addTab("Classificação Geral de Pilotos", jScrollPaneClassificacaoGeralDePilotos);

        jTableClassificacaoGeralDeEquipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posição", "Nome", "Pontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneClassificacaoGeralDeEquipes.setViewportView(jTableClassificacaoGeralDeEquipes);
        jTableClassificacaoGeralDeEquipes.getColumnModel().getColumn(0).setResizable(false);
        jTableClassificacaoGeralDeEquipes.getColumnModel().getColumn(1).setResizable(false);
        jTableClassificacaoGeralDeEquipes.getColumnModel().getColumn(2).setResizable(false);

        jTabbedPanePrincipal.addTab("Classificação Geral de Equipes", jScrollPaneClassificacaoGeralDeEquipes);

        jComboBoxCorrida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCorridaActionPerformed(evt);
            }
        });

        jTableClassificacaoDePilotosPorCorrida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicao", "Nome", "Equipe", "Pontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableClassificacaoDePilotosPorCorrida);
        jTableClassificacaoDePilotosPorCorrida.getColumnModel().getColumn(0).setResizable(false);
        jTableClassificacaoDePilotosPorCorrida.getColumnModel().getColumn(1).setResizable(false);
        jTableClassificacaoDePilotosPorCorrida.getColumnModel().getColumn(2).setResizable(false);
        jTableClassificacaoDePilotosPorCorrida.getColumnModel().getColumn(3).setResizable(false);

        javax.swing.GroupLayout jPanelClassificacaoDePilototosPorCorridaLayout = new javax.swing.GroupLayout(jPanelClassificacaoDePilototosPorCorrida);
        jPanelClassificacaoDePilototosPorCorrida.setLayout(jPanelClassificacaoDePilototosPorCorridaLayout);
        jPanelClassificacaoDePilototosPorCorridaLayout.setHorizontalGroup(
            jPanelClassificacaoDePilototosPorCorridaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClassificacaoDePilototosPorCorridaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClassificacaoDePilototosPorCorridaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxCorrida, 0, 432, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelClassificacaoDePilototosPorCorridaLayout.setVerticalGroup(
            jPanelClassificacaoDePilototosPorCorridaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClassificacaoDePilototosPorCorridaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPanePrincipal.addTab("Classificação De Pilotos Por Corrida", jPanelClassificacaoDePilototosPorCorrida);

        jMenuArquivo.setText("Arquivo");

        jMenuItemImportarPilotos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemImportarPilotos.setText("Importar Pilotos");
        jMenuItemImportarPilotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarPilotosActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemImportarPilotos);

        jMenuItemImportarCalendarioDeCorridas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemImportarCalendarioDeCorridas.setText("Importar Calendário de Corridas");
        jMenuItemImportarCalendarioDeCorridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarCalendarioDeCorridasActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemImportarCalendarioDeCorridas);

        jMenuItemImportarResultadoDeCorrida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemImportarResultadoDeCorrida.setText("Importar Resultado de Corrida");
        jMenuItemImportarResultadoDeCorrida.setEnabled(false);
        jMenuItemImportarResultadoDeCorrida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarResultadoDeCorridaActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemImportarResultadoDeCorrida);

        jMenuBarPrincipal.add(jMenuArquivo);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemImportarPilotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarPilotosActionPerformed
        //Exibir caixa de diálogo
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);
        //Efetuar importação
        if(retorno == JFileChooser.APPROVE_OPTION){
            //Verificar se os pilotos já foram importados, confirmar e efetuar importação
            if(ManterCampeonato.equipesJaForamImportadas()){
                int confirma = JOptionPane.showOptionDialog(jPanelClassificacaoDePilototosPorCorrida, "Os pilotos já foram importados uma vez. Deseja sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirma == JOptionPane.YES_OPTION){
                    if(ManterCampeonato.resultadoDeCorridaJaFoiImportado()){
                        confirma = JOptionPane.showOptionDialog(jPanelClassificacaoDePilototosPorCorrida, "Os resultados de corridas já importados serão perdidos. Deseja realmente sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        if(confirma == JOptionPane.YES_OPTION){
                            ManterCampeonato.importarEquipes(fileChooser.getSelectedFile());
                        }
                    }else{
                        ManterCampeonato.importarEquipes(fileChooser.getSelectedFile());
                    }
                }
            }else{
                ManterCampeonato.importarEquipes(fileChooser.getSelectedFile());
            }
        }
        habilitarBotaoDeImportacaoDeResultados();
        atualizarClassificacaoGeralDePilotos();
        atualizarResultadosDeCorridas();
        atualizarClassificacaoDePilotosPorCorrida();
        atualizarClassificacaoGeralDeEquipes();
    }//GEN-LAST:event_jMenuItemImportarPilotosActionPerformed

    private void jMenuItemImportarCalendarioDeCorridasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarCalendarioDeCorridasActionPerformed
        //Exibir caixa de diálogo
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);
        //Efetuar importação
        if(retorno == JFileChooser.APPROVE_OPTION){
            //Verificar se o calendário já foi importado,confirmar e efetuar importação
            if(ManterCampeonato.calendarioDeCorridasJaFoiImportado()){
                int confirma = JOptionPane.showOptionDialog(jPanelClassificacaoDePilototosPorCorrida, "O calendário de corridas já foi importado uma vez. Deseja sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirma == JOptionPane.YES_OPTION){
                    if(ManterCampeonato.resultadoDeCorridaJaFoiImportado()){
                        confirma = JOptionPane.showOptionDialog(jPanelClassificacaoDePilototosPorCorrida, "Os resultados de corridas já importados serão perdidos. Deseja realmente sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        if(confirma == JOptionPane.YES_OPTION){
                            ManterCampeonato.importarCalendarioDeCorridas(fileChooser.getSelectedFile());
                        }
                    }else{
                        ManterCampeonato.importarCalendarioDeCorridas(fileChooser.getSelectedFile());
                    }
                }
            }else{
                ManterCampeonato.importarCalendarioDeCorridas(fileChooser.getSelectedFile());
            }
        }
        habilitarBotaoDeImportacaoDeResultados();
        atualizarClassificacaoGeralDePilotos();
        atualizarResultadosDeCorridas();
        atualizarClassificacaoDePilotosPorCorrida();
        atualizarClassificacaoGeralDeEquipes();
    }//GEN-LAST:event_jMenuItemImportarCalendarioDeCorridasActionPerformed

    private void jMenuItemImportarResultadoDeCorridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarResultadoDeCorridaActionPerformed
        //Exibir caixa de diálogo
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);
        //Efetuar importação
        if(retorno == JFileChooser.APPROVE_OPTION){
            if(ManterCampeonato.resultadoDeCorridaJaFoiImportado(fileChooser.getSelectedFile())){
                int confirma = JOptionPane.showOptionDialog(jPanelClassificacaoDePilototosPorCorrida, "O resultado desta corrida já foi importado uma vez. Deseja sobrescrever os dados?", "Confirmação de Importação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirma == JOptionPane.YES_OPTION){
                    ManterCampeonato.importarResultadoDeCorrida(fileChooser.getSelectedFile());
                }
            }else{
                ManterCampeonato.importarResultadoDeCorrida(fileChooser.getSelectedFile());
            }
        }
        atualizarClassificacaoGeralDePilotos();
        atualizarResultadosDeCorridas();
        atualizarClassificacaoDePilotosPorCorrida();
        atualizarClassificacaoGeralDeEquipes();
    }//GEN-LAST:event_jMenuItemImportarResultadoDeCorridaActionPerformed

    private void jComboBoxCorridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCorridaActionPerformed
        atualizarClassificacaoDePilotosPorCorrida();
    }//GEN-LAST:event_jComboBoxCorridaActionPerformed

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
    private javax.swing.JComboBox jComboBoxCorrida;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenuItem jMenuItemImportarCalendarioDeCorridas;
    private javax.swing.JMenuItem jMenuItemImportarPilotos;
    private javax.swing.JMenuItem jMenuItemImportarResultadoDeCorrida;
    private javax.swing.JPanel jPanelClassificacaoDePilototosPorCorrida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneClassificacaoGeralDeEquipes;
    private javax.swing.JScrollPane jScrollPaneClassificacaoGeralDePilotos;
    private javax.swing.JTabbedPane jTabbedPanePrincipal;
    private javax.swing.JTable jTableClassificacaoDePilotosPorCorrida;
    private javax.swing.JTable jTableClassificacaoGeralDeEquipes;
    private javax.swing.JTable jTableClassificacaoGeralDePilotos;
    // End of variables declaration//GEN-END:variables

    private void habilitarBotaoDeImportacaoDeResultados() {
        //Habilidar botão de importação de resultados
        if(ManterCampeonato.equipesJaForamImportadas()&& ManterCampeonato.calendarioDeCorridasJaFoiImportado()){
            jMenuItemImportarResultadoDeCorrida.setEnabled(true);
        }
    }

    private void atualizarClassificacaoGeralDePilotos() {
        if(ManterCampeonato.resultadoDeCorridaJaFoiImportado()){
            jTableClassificacaoGeralDePilotos.setModel(ManterCampeonato.getClassificacaoGeralDePilotosTableModel());
        }
    }

    private void atualizarResultadosDeCorridas() {
        if(ManterCampeonato.resultadoDeCorridaJaFoiImportado()){
            jComboBoxCorrida.setModel(ManterCampeonato.getCorridasComboBoxModel());
        }
    }

    private void atualizarClassificacaoDePilotosPorCorrida() {
        if(ManterCampeonato.resultadoDeCorridaJaFoiImportado()){
            jTableClassificacaoDePilotosPorCorrida.setModel(ManterCampeonato.getClassificacaoDePilotosPorCorridaTableModel((Integer)jComboBoxCorrida.getSelectedItem()));
        }
    }

    private void atualizarClassificacaoGeralDeEquipes() {
       if(ManterCampeonato.resultadoDeCorridaJaFoiImportado()){
        jTableClassificacaoGeralDeEquipes.setModel(ManterCampeonato.getClassificacaoGeralDeEquipesTableModel());
       }
    }
}
