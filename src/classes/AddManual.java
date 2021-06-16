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
public class AddManual {
    
    private String idF; 
    private String nomef ;
    private String tipo_aero ;
    private String pais_fabricante ;
    private String edicao ;
    private String data_revisao; 
    private String procedimento_recep; 
    private String estado; 
    private String armario ;
    private String prateleira ;

    public String getIdF() {
        return idF;
    }

    public String getNomef() {
        return nomef;
    }

    public String getTipo_aero() {
        return tipo_aero;
    }

    public String getPais_fabricante() {
        return pais_fabricante;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getData_revisao() {
        return data_revisao;
    }

    public String getProcedimento_recep() {
        return procedimento_recep;
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

    public AddManual(String idF, String nomef, String tipo_aero, String pais_fabricante, String edicao, String data_revisao, String procedimento_recep, String estado, String armario, String prateleira) {
        this.idF = idF;
        this.nomef = nomef;
        this.tipo_aero = tipo_aero;
        this.pais_fabricante = pais_fabricante;
        this.edicao = edicao;
        this.data_revisao = data_revisao;
        this.procedimento_recep = procedimento_recep;
        this.estado = estado;
        this.armario = armario;
        this.prateleira = prateleira;
    }
  
    
    
    
     public boolean addManualF( String idF, String nomef, String tipo_aero, String pais_fabricante, String edicao, String data_revisao, String procedimento_recep, String estado, String armario, String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO manualF (idF,  nomef,  tipo_aero,  pais_fabricante,  edicao,  data_revisao,  procedimento_recep,  estado,  armario,  prateleira) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, idF);
            ps.setString(2, nomef);
            ps.setString(3, tipo_aero);
            ps.setString(4, pais_fabricante);
            ps.setString(5, edicao);
            ps.setString(6, data_revisao); 
            ps.setString(7, procedimento_recep);
            ps.setString(8, estado);
            ps.setString(9, armario);
            ps.setString(10, prateleira);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Manual ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Manual NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     
     public ArrayList<AddManual> acordotList()
    {
        ArrayList<AddManual> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM manualF";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            AddManual p;
            while(rs.next())
            {
                p = new AddManual(rs.getString("idF"),rs.getString("nomef"),rs.getString("tipo_aero"),
                        rs.getString("pais_fabricante"),rs.getString("edicao"),rs.getString("data_revisao"),
                        rs.getString("procedimento_recep"),rs.getString("estado"),rs.getString("armario"),rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
     
     
     public boolean remove(String matricula)
    {
        String removeQuery = "DELETE FROM manualF WHERE idF=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, matricula);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Manual Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Manual NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
