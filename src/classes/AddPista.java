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
public class AddPista {
    
    private String nome_pista ;
    private String data_abertura; 
    private String entidade_resp; 
    private String data_cert; 
    private String data_supervisao; 
    private String estado; 
    private String armario; 
   private String prateleira; 

    public AddPista(String nome_pista, String data_abertura, String entidade_resp, String data_cert, String data_supervisao, String estado, String armario, String prateleira) {
        this.nome_pista = nome_pista;
        this.data_abertura = data_abertura;
        this.entidade_resp = entidade_resp;
        this.data_cert = data_cert;
        this.data_supervisao = data_supervisao;
        this.estado = estado;
        this.armario = armario;
        this.prateleira = prateleira;
    }

    public String getNome_pista() {
        return nome_pista;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public String getEntidade_resp() {
        return entidade_resp;
    }

    public String getData_cert() {
        return data_cert;
    }

    public String getData_supervisao() {
        return data_supervisao;
    }

    public String getEstado() {
        return estado;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }
    
    
     public boolean addPista( String nome_pista, String data_abertura, String entidade_resp, String data_cert, String data_supervisao, String estado, String armario, String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO pistas ( nome_pista,  data_abertura,  entidade_resp,  data_cert,  data_supervisao,  estado,  armario,  prateleira) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, nome_pista);
            ps.setString(2, data_abertura);
            ps.setString(3, entidade_resp);
            ps.setString(4, data_cert);
            ps.setString(5, data_supervisao);
            ps.setString(6, estado); 
            ps.setString(7, armario);
            ps.setString(8, prateleira);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Pista ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Pista NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public ArrayList<AddPista> acordotList()
    {
        ArrayList<AddPista> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM pistas";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            AddPista p;
            while(rs.next())
            {
                p = new AddPista(rs.getString("nome_pista"),rs.getString("data_abertura"),rs.getString("entidade_resp"),
                        rs.getString("data_cert"),rs.getString("data_supervisao"),rs.getString("estado"),
                        rs.getString("armario"),rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
     
     public boolean remove(String matricula)
    {
        String removeQuery = "DELETE FROM Pistas WHERE nome_pista=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, matricula);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Pista Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Pista NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
   
   
   
    
}
