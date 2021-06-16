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
public class Doc {
    private String id;
    private String status;
    private String titulo;
    private String armario;
    private String prateleira;
     private String localizacao;
    public Doc(){};
    
    public Doc(String id,String titulo,String status,String armario,String prateleira,String localizacao)
    {
        this.id=id;
        this.status=status;
        this.titulo=titulo;
        this.armario=armario;
        this.prateleira=prateleira;
        this.localizacao=localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean addStatus(String status,String id)
    {
        String insertQuery = "UPDATE documento SET status = ? WHERE id_doc = ? ";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, status);
            ps.setString(2, id);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "STATUS CHANGED","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "STATUS NOT CHANGED","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean remove(String id)
    {
        String removeQuery = "DELETE FROM documento WHERE id_doc=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, id);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Document Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Document Not Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<Doc> docList()
    {
        ArrayList<Doc> dList = new ArrayList<>();
        String selectQuery="SELECT * FROM documento";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            Doc doc;
            while(rs.next())
            {
                doc = new Doc(rs.getString("id_doc"),rs.getString("titulo_doc"),rs.getString("status"),rs.getString("armario"),rs.getString("prateleira"),rs.getString("localizacao"));
                dList.add(doc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dList;
    }
    
}
