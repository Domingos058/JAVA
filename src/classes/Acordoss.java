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
public class Acordoss {
    private String nome_acordo;
    private String pais ;
    private String data_Assinatura ;
    private String local_assinatura ;
    private String data_registro ;
    private String prateleira;  
    private String armario; 
    
    public Acordoss(String nome_acordo, String pais ,String data_Assinatura ,String local_assinatura ,String data_registro ,String prateleira,  String armario)
    {
        this.nome_acordo=nome_acordo;
        this.pais =pais;
        this.data_Assinatura =data_Assinatura;
        this.local_assinatura= local_assinatura;
        this.data_registro= data_registro;
        this.prateleira=prateleira;  
        this.armario=armario; 
        
    }

    public String getNome_acordo() {
        return nome_acordo;
    }

    public String getPais() {
        return pais;
    }

    public String getData_Assinatura() {
        return data_Assinatura;
    }

    public String getLocal_assinatura() {
        return local_assinatura;
    }

    public String getData_registro() {
        return data_registro;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public String getArmario() {
        return armario;
    }
    
    
    
    public ArrayList<Acordoss> acordotList()
    {
        ArrayList<Acordoss> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM acordos";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            Acordoss p;
            while(rs.next())
            {
                p = new Acordoss(rs.getString("nome_acordo"),rs.getString("pais"),rs.getString("data_Assinatura"),
                        rs.getString("local_assinatura"),rs.getString("data_registro"),rs.getString("prateleira"),
                        rs.getString("armario"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    
     public boolean addAcordos(String nome_acordo, String pais ,String data_Assinatura ,String local_assinatura ,String data_registro ,String prateleira,  String armario)
        
    {
         
        String insertQuery = "INSERT INTO acordos (nome_acordo,pais,data_Assinatura,local_assinatura,data_registro,prateleira,armario) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, nome_acordo);
            ps.setString(2, pais);
            ps.setString(3, data_Assinatura);
            ps.setString(4, local_assinatura);
            ps.setString(5, data_registro);
            ps.setString(6, prateleira); 
            ps.setString(7, armario);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Acordo ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acordo NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     
     public boolean remove(String nome_acordo)
    {
        String removeQuery = "DELETE FROM acordos WHERE nome_acordo=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, nome_acordo);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Acordo Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acordo NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
