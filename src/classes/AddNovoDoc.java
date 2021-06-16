/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnicos
 */
public class AddNovoDoc {
    
    
    public AddNovoDoc()
    {
        
    }
    public boolean addDoc(String id, String titulo_doc, String ref_origem, 
        String ref_loca,  String descricao, 
        String quant, 
        String valor,
        String localizacao,
        String fonte,  String data_entrada,String status,String grupo,String formato,String edicao_data,String edicao_revisao,String armario,String prateleira)
    {
        String insertQuery = "INSERT INTO documento (id_doc,titulo_doc,ref_origem,ref_loca,descricao,quant,valor, localizacao, fonte, data_entrada, status, grupo, formato,edicao_data ,edicao_revisao,armario, prateleira) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, id);
            ps.setString(2, titulo_doc);
            ps.setString(3, ref_origem);
            ps.setString(4, ref_loca);
            ps.setString(5, descricao);
            ps.setString(6, quant); 
            ps.setString(7, valor);
            ps.setString(8, localizacao);
            ps.setString(9, fonte);
            ps.setString(10, data_entrada);
            ps.setString(11, status);
            ps.setString(12, grupo);
            ps.setString(13, formato);
            ps.setString(14, edicao_data);
            ps.setString(15, edicao_revisao);
            ps.setString(16, armario);
            ps.setString(17, prateleira);
           
               
               
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "DOC ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "DOC NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
}
