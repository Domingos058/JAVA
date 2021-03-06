/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.AddNovoDoc;
import classes.AddResumoDocs;
import classes.DB;
import classes.Doc;
import classes.PesquisaDocs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author domin
 */
public class PesquisaDoc extends javax.swing.JFrame {

    /**
     * Creates new form PesquisaDoc
     * 
     */
    private String titulo;
  
    public PesquisaDoc(String titulo) {
        initComponents();
        this.titulo=titulo;
        popularTabela();
        
        
    }
    
    
     private void  popularTabela()
    {
         classes.AddResumoDocs p = new AddResumoDocs("","","","","","","","","","","","","","","","","");
       ArrayList<classes.AddResumoDocs> pList = p.acordotList();
      //int ia=0;
       
       String [] colNames ={"Id_doc","Titulo","Ref_Local","Descricao","Quant","valor","Localizacao","Fonte","Data_Entrada","Status",
           "Grupo","Formato","Edicao_Data","Edicao_Revisao","Armario","Prateleira"};
       Object [][] rows=new Object[pList.size()][colNames.length];
       for(int j=0, i=0;i<pList.size();i++)
       {
           if(titulo==pList.get(i).getTitulo_doc())
           {
               rows[i][0]=pList.get(i).getId_doc();
               rows[i][1]=pList.get(i).getTitulo_doc();
               rows[i][2]=pList.get(i).getRef_loca();
               rows[i][3]=pList.get(i).getDescricao();
               rows[i][4]=pList.get(i).getQuant();
               rows[i][5]=pList.get(i).getValor();
               rows[i][6]=pList.get(i).getLocalizacao();
               rows[i][7]=pList.get(i).getFonte();
               rows[i][8]=pList.get(i).getData_entrada();
               rows[i][9]=pList.get(i).getStatus();
               rows[i][10]=pList.get(i).getGrupo();
               rows[i][11]=pList.get(i).getFormato();
               rows[i][12]=pList.get(i).getEdicao_data();
               rows[i][13]=pList.get(i).getEdicao_revisao();
               rows[i][14]=pList.get(i).getArmario();
               rows[i][15]=pList.get(i).getPrateleira();   
           
           }
           else
           {
               
           }
           
       }
       System.out.println(titulo);
       DefaultTableModel model =  new DefaultTableModel(rows,colNames);
       jTable1.setModel(model);       
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1426, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PesquisaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaDoc("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
