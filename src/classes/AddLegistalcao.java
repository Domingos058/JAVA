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
public class AddLegistalcao {
    
   private String id_legislacao;
    private String assunto;
    private String entidade_resp;
    private String designacao ;
    private String area ;
    private String materia ;
    private String data_pub ;
    private String data_rev ;
    private String estado ;
    private String armario ;
    private String prateleira ;
    
    public AddLegistalcao(String id_legislacao,String assunto,String entidade_resp,String designacao,String area,String materia,
            String data_pub,String data_rev,String estado,String armario,String prateleira)
    {
        this.id_legislacao=id_legislacao;
    this.assunto=assunto;
    this.entidade_resp=entidade_resp;
    this.designacao= designacao;
    this.area =area;
    this.materia=materia ;
    this.data_pub= data_pub;
    this.data_rev= data_rev;
    this.estado= estado;
    this.armario= armario;
    this.prateleira =prateleira;
    }

    public String getId_legislacao() {
        return id_legislacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getEntidade_resp() {
        return entidade_resp;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getArea() {
        return area;
    }

    public String getMateria() {
        return materia;
    }

    public String getData_pub() {
        return data_pub;
    }

    public String getData_rev() {
        return data_rev;
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
   
    
    public ArrayList<AddLegistalcao> legisList()
    {
        ArrayList<AddLegistalcao> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM legislacao";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            AddLegistalcao p;
            while(rs.next())
            {
                p = new AddLegistalcao(rs.getString("id_legislacao"),rs.getString("assunto"),rs.getString("entidade_resp"),
                        rs.getString("designacao"),rs.getString("area"),rs.getString("materia"),
                        rs.getString("data_pub"),rs.getString("data_rev"),rs.getString("estado"),rs.getString("armario"),
                rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    public boolean addLegis(String id_legislacao,String assunto,String entidade_resp,String designacao,String area,String materia,
            String data_pub,String data_rev,String estado,String armario,String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO legislacao ( id_legislacao,assunto, entidade_resp, designacao, area, materia,\n" +
"             data_pub, data_rev, estado, armario, prateleira) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, id_legislacao);
            ps.setString(2, assunto);
            ps.setString(3, entidade_resp);
            ps.setString(4, designacao);
            ps.setString(5, area);
            ps.setString(6, materia); 
            ps.setString(7, data_pub);
            ps.setString(8, data_rev);
            ps.setString(9, estado);
            ps.setString(10, armario);
            ps.setString(11, prateleira);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Legislacao ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Legislacao NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean remove(String nome_ato)
    {
        String removeQuery = "DELETE FROM legislacao WHERE id_legislacao=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, nome_ato);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Legislacao Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Legislacao NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
