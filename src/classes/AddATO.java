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
public class AddATO {
    
    private String nome_ato;
    private String pais;
    private String capital;
    private String data_criacao;
    private String data_homo;
    private String armario;
    private String prateleira;
    
    
    
    
    public AddATO(String nome_ato,String pais,String capital,String data_criacao,String data_homo,String armario,String prateleira)
    {
        this.nome_ato=nome_ato;
        this.pais=pais;
        this.capital=capital;
        this.data_criacao=data_criacao;
        this.data_homo=data_homo;
        this.armario=armario;
        this.prateleira=prateleira;
    }
    
    public ArrayList<AddATO> atotList()
    {
        ArrayList<AddATO> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM ato";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            AddATO p;
            while(rs.next())
            {
                p = new AddATO(rs.getString("nome_ato"),rs.getString("pais"),rs.getString("capital"),
                        rs.getString("data_criacao"),rs.getString("data_homo"),rs.getString("armario"),
                        rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    public boolean addATO(String nome_ato,String pais,String capital,String data_criacao,String data_homo,String armario,String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO ato ( nome_ato, pais, capital, data_criacao, data_homo, armario, prateleira) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, nome_ato);
            ps.setString(2, pais);
            ps.setString(3, capital);
            ps.setString(4, data_criacao);
            ps.setString(5, data_homo);
            ps.setString(6, armario); 
            ps.setString(7, prateleira);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "ATO ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ATO NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean remove(String nome_ato)
    {
        String removeQuery = "DELETE FROM ato WHERE nome_ato=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, nome_ato);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "ATO Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ATO NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public String getNome_ato() {
        return nome_ato;
    }

    public String getPais() {
        return pais;
    }

    public String getCapital() {
        return capital;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public String getData_homo() {
        return data_homo;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }
    
}
