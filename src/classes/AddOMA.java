/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnicos
 */
public class AddOMA {
    private String id_OMA; 
    private String nome_oma; 
    private String pais_oma; 
    private String sede_oma; 
    private String data_certificacao;
    private String data_supervisao; 
    private String armario; 
    private String prateleira; 

    public AddOMA(String id_OMA,String nome_oma, String pais_oma, String sede_oma, String data_certificacao, String data_supervisao, String armario, String prateleira) {
        this.id_OMA = id_OMA;
        this.nome_oma = nome_oma;
        this.pais_oma = pais_oma;
        this.sede_oma = sede_oma;
        this.data_certificacao = data_certificacao;
        this.data_supervisao = data_supervisao;
        this.armario = armario;
        this.prateleira = prateleira;
    }

    public String getId_OMA() {
        return id_OMA;
    }

    public String getNome_oma() {
        return nome_oma;
    }

    public String getPais_oma() {
        return pais_oma;
    }

    public String getSede_oma() {
        return sede_oma;
    }

    public String getData_certificacao() {
        return data_certificacao;
    }

    public String getData_supervisao() {
        return data_supervisao;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }
    
    
    
    public ArrayList<AddOMA> acordotList()
    {
        ArrayList<AddOMA> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM manutencao_OMA";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            AddOMA p;
            while(rs.next())
            {
                p = new AddOMA(rs.getString("id_OMA"),rs.getString("nome_oma"),rs.getString("pais_oma"),rs.getString("sede_oma"),rs.getString("data_certificacao"),rs.getString("data_supervisao"),rs.getString("armario"),rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    
    public boolean addOMMA( String id_OMA,String nome_oma, String pais_oma, String sede_oma, String data_certificacao, String data_supervisao, String armario, String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO manutencao_OMA (  id_OMA, nome_oma,  pais_oma,  sede_oma,  data_certificacao,  data_supervisao,  armario,  prateleira) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, id_OMA);
            ps.setString(2, nome_oma);
            ps.setString(3, pais_oma);
            ps.setString(4, sede_oma);
            ps.setString(5, data_certificacao);
            ps.setString(6, data_supervisao); 
            ps.setString(7, armario);
            ps.setString(8, prateleira);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "manutencao_OMA ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "manutencao_OMA NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
     public boolean remove(String matricula)
    {
        String removeQuery = "DELETE FROM manutencao_OMA WHERE id_OMA=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, matricula);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "manutencao_OMA Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "manutencao_OMA NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
