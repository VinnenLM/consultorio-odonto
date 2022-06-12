/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import dados.Laudo;
import dados.Medico;
import dados.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.MetLaudo;
import pesquisa.PesMedico;
import pesquisa.PesPaciente;
import relatorios.ImprimirLaudo;
import relatorios.RelLaudo;

/**
 *
 * @author Vinnen
 */
public class FormLaudo extends javax.swing.JFrame {

    /**
     * Creates new form FormLaudo
     */
    public FormLaudo() {
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jT_data = new javax.swing.JFormattedTextField();
        jT_idPaciente = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jT_descricao = new javax.swing.JTextField();
        jT_paciente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jB_pesquisaPac = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jB_limpar3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jT_idMedico = new javax.swing.JTextField();
        jT_medico = new javax.swing.JTextField();
        jB_pesquisaMed = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jT_hora = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_laudo = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jT_pesquisa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        try {
            jT_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jT_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_dataActionPerformed(evt);
            }
        });

        jT_idPaciente.setEditable(false);
        jT_idPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_idPacienteActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.png"))); // NOI18N
        jButton7.setText("Cancelar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jT_paciente.setEditable(false);
        jT_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_pacienteActionPerformed(evt);
            }
        });

        jLabel10.setText("Descrição:");

        jB_pesquisaPac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jB_pesquisaPac.setText("Pesquisar");
        jB_pesquisaPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisaPacActionPerformed(evt);
            }
        });

        jLabel12.setText("Paciente:");

        jB_limpar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        jB_limpar3.setText("Limpar");
        jB_limpar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_limpar3ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/gerar.png"))); // NOI18N
        jButton8.setText("Gerar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/laudo2.png"))); // NOI18N
        jLabel1.setText(" Gerar Laudo");

        jLabel5.setText("Médico:");

        jT_idMedico.setEditable(false);

        jT_medico.setEditable(false);

        jB_pesquisaMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jB_pesquisaMed.setText("Pesquisar");
        jB_pesquisaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisaMedActionPerformed(evt);
            }
        });

        jLabel3.setText("Hora:");

        try {
            jT_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Data:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT_data)
                            .addComponent(jT_hora)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jT_idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jT_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jT_idMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jT_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jT_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(jB_pesquisaPac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(jB_pesquisaMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jB_limpar3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jT_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_limpar3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jT_idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_pesquisaPac))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jT_idMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_pesquisaMed))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jT_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Laudo", jPanel1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novo.png"))); // NOI18N
        jButton5.setText("Novo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excluir.png"))); // NOI18N
        jButton9.setText("Excluir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.png"))); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jT_laudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Hora", "Descrição", "Paciente", "Médico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jT_laudo);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jT_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_pesquisaActionPerformed(evt);
            }
        });

        jLabel15.setText("Pesquisar por Paciente:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imprimir.png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jT_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton9)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Laudos", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_pesquisaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisaMedActionPerformed
        PesMedico pesm = new PesMedico(this, true);
        pesm.setVisible(true);
        
        Medico m = pesm.getM();
        jT_idMedico.setText(Integer.toString(m.getId_medico()));
        jT_medico.setText(m.getNome());
    }//GEN-LAST:event_jB_pesquisaMedActionPerformed

    private void jT_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_dataActionPerformed

    private void jT_idPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_idPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_idPacienteActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jT_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_pacienteActionPerformed

    private void jB_pesquisaPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisaPacActionPerformed
        PesPaciente pespa = new PesPaciente(this, true);
        pespa.setVisible(true);

        Paciente p = pespa.getP();
        jT_idPaciente.setText(Integer.toString(p.getId_paciente()));
        jT_paciente.setText(p.getNome());
    }//GEN-LAST:event_jB_pesquisaPacActionPerformed

    private void jB_limpar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_limpar3ActionPerformed
        jT_data.setText(null);
        jT_hora.setText(null);
        jT_descricao.setText(null);
        jT_idPaciente.setText(null);
        jT_paciente.setText(null);
        jT_idMedico.setText(null);
        jT_medico.setText(null);
    }//GEN-LAST:event_jB_limpar3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Laudo l = new Laudo();
        l.setData(jT_data.getText());
        l.setHora(jT_hora.getText());
        l.setDescricao(jT_descricao.getText());

        Paciente p = new Paciente();
        p.setId_paciente(Integer.parseInt(jT_idPaciente.getText()));
        l.setPac(p);

        Medico m = new Medico();
        m.setId_medico(Integer.parseInt(jT_idMedico.getText()));
        l.setMed(m);

        MetLaudo metl = new MetLaudo();
        metl.cadastrar(l);

        ImprimirLaudo imprime = new ImprimirLaudo();
        List listaDados = GetDados();
        imprime.ImprimirRelatorio(listaDados);

        preencherTabela();

        jT_data.setText(null);
        jT_hora.setText(null);
        jT_descricao.setText(null);
        jT_idPaciente.setText(null);
        jT_paciente.setText(null);
        jT_idMedico.setText(null);
        jT_medico.setText(null);

        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jT_data.setText(null);
        jT_hora.setText(null);
        jT_idPaciente.setText(null);
        jT_paciente.setText(null);
        jT_idMedico.setText(null);
        jT_medico.setText(null);
        jT_descricao.setText(null);
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int opcao = jT_laudo.getSelectedRow();
        if (opcao >= 0) {
            Laudo l = new Laudo();
            l.setId_laudo(Integer.parseInt(jT_laudo.getValueAt(opcao, 0).toString()));
            MetLaudo metpro = new MetLaudo();
            metpro.excluir(l);
            preencherTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um linha!");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        preencherNome(jT_pesquisa.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jT_pesquisa.setText(null);
        preencherTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ImprimirLaudo imprime = new ImprimirLaudo();
        List listaDados = GetDadosTab();
        if (GetDadosTab() != null) {
            imprime.ImprimirRelatorio(listaDados);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um linha!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jT_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_pesquisaActionPerformed
        preencherNome(jT_pesquisa.getText());
    }//GEN-LAST:event_jT_pesquisaActionPerformed

    public void preencherTabela() {
        MetLaudo metrec = new MetLaudo();
        List<Laudo> lista = metrec.ListarTodos();
        DefaultTableModel modeloTabela = (DefaultTableModel) jT_laudo.getModel();
        modeloTabela.setRowCount(0);
        for (Laudo l : lista) {
            modeloTabela.addRow(new Object[]{l.getId_laudo(), l.getData(), l.getHora(), l.getDescricao(), l.getPac().getNome(), l.getMed().getNome()});
        }
    }

    public void preencherNome(String nome) {
        MetLaudo metrec = new MetLaudo();
        List<Laudo> lista = metrec.ListarNome(nome);
        DefaultTableModel modeloTabela = (DefaultTableModel) jT_laudo.getModel();
        modeloTabela.setRowCount(0);
        for (Laudo l : lista) {
            modeloTabela.addRow(new Object[]{l.getId_laudo(), l.getData(), l.getHora(), l.getDescricao(), l.getPac().getNome(), l.getMed().getNome()});
        }
    }

    public List GetDados() {
        List lista = new ArrayList();
        RelLaudo print = new RelLaudo();
        print.setData(jT_data.getText());
        print.setHora(jT_hora.getText());
        print.setDescricao(jT_descricao.getText());
        print.setPaciente(jT_paciente.getText());
        print.setMedico(jT_medico.getText());
        lista.add(print);

        return lista;
    }

    public List GetDadosTab() {

        int opcao = jT_laudo.getSelectedRow();
        List lista = new ArrayList();
        RelLaudo print = new RelLaudo();

        if (opcao >= 0) {

            print.setData(jT_laudo.getValueAt(opcao, 1).toString());
            print.setHora(jT_laudo.getValueAt(opcao, 2).toString());
            print.setDescricao(jT_laudo.getValueAt(opcao, 3).toString());
            print.setPaciente(jT_laudo.getValueAt(opcao, 4).toString());
            print.setMedico(jT_laudo.getValueAt(opcao, 5).toString());
            lista.add(print);
            return lista;
        }
        return null;
    }

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
            java.util.logging.Logger.getLogger(FormLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLaudo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_limpar3;
    private javax.swing.JButton jB_pesquisaMed;
    private javax.swing.JButton jB_pesquisaPac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jT_data;
    private javax.swing.JTextField jT_descricao;
    private javax.swing.JFormattedTextField jT_hora;
    private javax.swing.JTextField jT_idMedico;
    private javax.swing.JTextField jT_idPaciente;
    private javax.swing.JTable jT_laudo;
    private javax.swing.JTextField jT_medico;
    private javax.swing.JTextField jT_paciente;
    private javax.swing.JTextField jT_pesquisa;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}