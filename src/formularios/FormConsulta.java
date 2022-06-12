/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import dados.Consulta;
import dados.Funcionario;
import dados.Medicamento;
import dados.Medico;
import dados.Paciente;
import dados.TipoConsulta;
import javax.swing.JOptionPane;
import metodos.MetConsulta;
import pesquisa.PesMedicamento;
import pesquisa.PesMedico;
import pesquisa.PesPaciente;
import pesquisa.PesTipoConsulta;

/**
 *
 * @author v1n1c
 */
public class FormConsulta extends javax.swing.JFrame {
    
    Paciente p;
    Medico m;
    int agendAux = 0;
    int limpAux = 0;
    
    public FormConsulta() {
        initComponents();
    }
    
    public FormConsulta(Consulta c) {
        initComponents();
        
        agendAux = 1;
        limpAux = 1;
        
        jB_pesquisaP.setEnabled(false);
        jB_pesquisaM.setEnabled(false);
        jB_pesquisaTC.setEnabled(false);
        
        jB_agendar.setText("Reagendar");
        
        jT_idConsulta.setText(Integer.toString(c.getId_consulta()));
        jT_data.setText(c.getData());
        jT_hora.setText(c.getHora());
        jC_status.setSelectedItem(c.getStatus());
        
        jT_idPaciente.setText(Integer.toString(c.getPac().getId_paciente()));
        jT_paciente.setText(c.getPac().getNome());
        
        jT_idMedico.setText(Integer.toString(c.getMed().getId_medico()));
        jT_medico.setText(c.getMed().getNome());
        
        jT_idTipoConsulta.setText(Integer.toString(c.getTipcon().getId_tipoConsulta()));
        jT_tipoConsulta.setText(c.getTipcon().getTipo_consulta());
        jT_valor.setText(c.getTipcon().getValor());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jT_data = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jT_hora = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jB_pesquisaP = new javax.swing.JButton();
        jT_paciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jB_pesquisaM = new javax.swing.JButton();
        jT_medico = new javax.swing.JTextField();
        jB_agendar = new javax.swing.JButton();
        jB_limpar1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jT_tipoConsulta = new javax.swing.JTextField();
        jT_idPaciente = new javax.swing.JTextField();
        jT_idMedico = new javax.swing.JTextField();
        jL_consulta = new javax.swing.JLabel();
        jB_pesquisaTC = new javax.swing.JButton();
        jT_idTipoConsulta = new javax.swing.JTextField();
        jT_valor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jC_status = new javax.swing.JComboBox<>();
        jT_idConsulta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/consulta2.png"))); // NOI18N
        jLabel1.setText("  Agendar Consulta");

        jLabel2.setText("Data:");

        try {
            jT_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Hora:");

        try {
            jT_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Paciente:");

        jB_pesquisaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jB_pesquisaP.setText("Pesquisar");
        jB_pesquisaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisaPActionPerformed(evt);
            }
        });

        jT_paciente.setEditable(false);
        jT_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_pacienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Médico:");

        jB_pesquisaM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jB_pesquisaM.setText("Pesquisar");
        jB_pesquisaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisaMActionPerformed(evt);
            }
        });

        jT_medico.setEditable(false);

        jB_agendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        jB_agendar.setText("Agendar");
        jB_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_agendarActionPerformed(evt);
            }
        });

        jB_limpar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        jB_limpar1.setText("Limpar");
        jB_limpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_limpar1ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.png"))); // NOI18N
        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("Consulta:");

        jT_tipoConsulta.setEditable(false);

        jT_idPaciente.setEditable(false);
        jT_idPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_idPacienteActionPerformed(evt);
            }
        });

        jT_idMedico.setEditable(false);

        jL_consulta.setText("ID:");

        jB_pesquisaTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jB_pesquisaTC.setText("Pesquisar");
        jB_pesquisaTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisaTCActionPerformed(evt);
            }
        });

        jT_idTipoConsulta.setEditable(false);

        jT_valor.setEditable(false);

        jLabel7.setText("Valor:");

        jLabel8.setText("Status:");

        jC_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agendada", "Finalizada", "Retorno" }));

        jT_idConsulta.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jL_consulta)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT_data, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(jT_idConsulta))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_limpar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_agendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jT_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jT_idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jT_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jB_pesquisaP, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jT_idMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jT_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jB_pesquisaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jT_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jT_idTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jT_tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jC_status, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_pesquisaTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_consulta)
                    .addComponent(jT_idConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_agendar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jT_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_limpar1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jT_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jT_idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_pesquisaP))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jT_idMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_pesquisaM))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jT_idTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_pesquisaTC))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jT_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jC_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jB_limpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_limpar1ActionPerformed
        if(limpAux == 0){
            limpar();
        }else{
            jT_data.setText(null);
            jT_hora.setText(null);
        }
    }//GEN-LAST:event_jB_limpar1ActionPerformed

    private void jB_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_agendarActionPerformed
        if(agendAux == 0){
            agendar();
        }else if(agendAux == 1){
            editar();
        }
    }//GEN-LAST:event_jB_agendarActionPerformed

    private void jB_pesquisaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisaMActionPerformed
        PesMedico pesme = new PesMedico(this, true);
        pesme.setVisible(true);
        
        Medico m = pesme.getM();
        jT_idMedico.setText(Integer.toString(m.getId_medico()));
        jT_medico.setText(m.getNome());
    }//GEN-LAST:event_jB_pesquisaMActionPerformed

    private void jT_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_pacienteActionPerformed

    private void jB_pesquisaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisaPActionPerformed
        PesPaciente pespa = new PesPaciente(this, true);
        pespa.setVisible(true);
        
        Paciente p = pespa.getP();
        jT_idPaciente.setText(Integer.toString(p.getId_paciente()));
        jT_paciente.setText(p.getNome());
    }//GEN-LAST:event_jB_pesquisaPActionPerformed

    private void jT_idPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_idPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_idPacienteActionPerformed

    private void jB_pesquisaTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisaTCActionPerformed
        PesTipoConsulta pestipcon = new PesTipoConsulta(this, true);
        pestipcon.setVisible(true);
        
        TipoConsulta tipcon = pestipcon.getTipcon();
        jT_idTipoConsulta.setText(Integer.toString(tipcon.getId_tipoConsulta()));
        jT_tipoConsulta.setText(tipcon.getTipo_consulta());
        jT_valor.setText(tipcon.getValor());
    }//GEN-LAST:event_jB_pesquisaTCActionPerformed

    public void agendar(){
        Consulta c = new Consulta();
        c.setData(jT_data.getText());
        c.setHora(jT_hora.getText());
        c.setStatus(jC_status.getSelectedItem().toString());
        
        Paciente p = new Paciente();
        p.setId_paciente(Integer.parseInt(jT_idPaciente.getText()));
        c.setPac(p);
                
        Medico m = new Medico();
        m.setId_medico(Integer.parseInt(jT_idMedico.getText()));
        c.setMed(m);
        
        TipoConsulta tc = new TipoConsulta();
        tc.setId_tipoConsulta(Integer.parseInt(jT_idTipoConsulta.getText()));
        c.setTipcon(tc);
        
        MetConsulta metc = new MetConsulta();
        metc.cadastrar(c);
        
        jT_data.setText(null);
        jT_hora.setText(null);
        jC_status.setSelectedIndex(0);
        jT_idPaciente.setText(null);
        jT_paciente.setText(null);
        jT_idMedico.setText(null);
        jT_medico.setText(null);
        jT_idTipoConsulta.setText(null);
        jT_tipoConsulta.setText(null);
        jT_valor.setText(null);  
    }
    
    public void editar(){
        Consulta c = new Consulta();
        c.setId_consulta(Integer.parseInt(jT_idConsulta.getText()));
        c.setData(jT_data.getText());
        c.setHora(jT_hora.getText());
        c.setStatus(jC_status.getSelectedItem().toString());
        
        Paciente p = new Paciente();
        p.setId_paciente(Integer.parseInt(jT_idPaciente.getText()));
        c.setPac(p);
                
        Medico m = new Medico();
        m.setId_medico(Integer.parseInt(jT_idMedico.getText()));
        c.setMed(m);
        
        TipoConsulta tc = new TipoConsulta();
        tc.setId_tipoConsulta(Integer.parseInt(jT_idTipoConsulta.getText()));
        c.setTipcon(tc);
        
        MetConsulta metc = new MetConsulta();
        metc.atualizar(c);
        
        this.dispose();
        
    }
    
    public void limpar(){
        jT_idTipoConsulta.setText(null);
        jT_tipoConsulta.setText(null);
        jT_valor.setText(null);
        jT_data.setText(null);
        jT_hora.setText(null);
        jT_paciente.setText(null);
        jT_medico.setText(null);
        jT_tipoConsulta.setText(null);
        jT_idMedico.setText(null);
        jT_idPaciente.setText(null);
        jB_agendar.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_agendar;
    private javax.swing.JButton jB_limpar1;
    private javax.swing.JButton jB_pesquisaM;
    private javax.swing.JButton jB_pesquisaP;
    private javax.swing.JButton jB_pesquisaTC;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jC_status;
    private javax.swing.JLabel jL_consulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jT_data;
    private javax.swing.JFormattedTextField jT_hora;
    private javax.swing.JTextField jT_idConsulta;
    private javax.swing.JTextField jT_idMedico;
    private javax.swing.JTextField jT_idPaciente;
    private javax.swing.JTextField jT_idTipoConsulta;
    private javax.swing.JTextField jT_medico;
    private javax.swing.JTextField jT_paciente;
    private javax.swing.JTextField jT_tipoConsulta;
    private javax.swing.JTextField jT_valor;
    // End of variables declaration//GEN-END:variables
}