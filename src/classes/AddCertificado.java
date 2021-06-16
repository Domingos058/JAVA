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
public class AddCertificado {
    
    private String nome_aeroporto;
    private String entidade_responsavel;
    private String data_certificacao;
    private String data_supervisao;
    private String armario;
    private String prateleira;

    public AddCertificado(String nome_aeroporto, String entidade_responsavel, String data_certificacao, String data_supervisao, String armario, String prateleira) {
        this.nome_aeroporto = nome_aeroporto;
        this.entidade_responsavel = entidade_responsavel;
        this.data_certificacao = data_certificacao;
        this.data_supervisao = data_supervisao;
        this.armario = armario;
        this.prateleira = prateleira;
    }

    public String getNome_aeroporto() {
        return nome_aeroporto;
    }

    public String getEntidade_responsavel() {
        return entidade_responsavel;
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
    
    public ArrayList<AddCertificado> certList()
    {
        ArrayList<AddCertificado> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM certificao";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            AddCertificado p;
            while(rs.next())
            {
                p = new AddCertificado(rs.getString("nome_aeroporto"),rs.getString("entidade_responsavel"),rs.getString("data_certificacao"),
                        rs.getString("data_supervisao"),rs.getString("armario"),rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    public boolean addCERT(String nome_aeroporto, String entidade_responsavel, String data_certificacao, String data_supervisao, String armario, String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO certificao ( nome_aeroporto,entidade_responsavel, data_certificacao, data_supervisao, armario, prateleira) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, nome_aeroporto);
            ps.setString(2, entidade_responsavel);
            ps.setString(3, data_certificacao);
            ps.setString(4, data_supervisao);
            ps.setString(5, armario);
            ps.setString(6, prateleira); 
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Certificacao ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Certificacao NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     public boolean remove(String nome_ato)
    {
        String removeQuery = "DELETE FROM certificao WHERE nome_aeroporto=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, nome_ato);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Certificacao Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Certificacao NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
