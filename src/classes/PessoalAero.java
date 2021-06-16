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
public class PessoalAero {
    
    private String id_aero;
    private String aeronauticos; 
    private String nome; 
    private String apelido;
    private String data_licenca; 
    private String data_revalidacao; 
    private String data_formacao;
    private String especialidade; 
    private String tipo_aeronave;
    private String qualificacao;
    private String entidade_respo;
    private String armario; 
    private String prateleira;
    
    public PessoalAero(String id_aero, String aeronauticos, String nome, String apelido, String data_licenca, String data_revalidacao, 
            String data_formacao, String especialidade, String tipo_aeronave, String qualificacao, String entidade_respo, String armario, String prateleira)
    {
        this.id_aero=id_aero;
        this.aeronauticos=aeronauticos; 
        this.nome=nome; 
        this.apelido=apelido;
        this.data_licenca=data_licenca; 
        this.data_revalidacao=data_revalidacao; 
        this.data_formacao=data_formacao;
        this.especialidade=especialidade; 
        this.tipo_aeronave=tipo_aeronave;
        this.qualificacao=qualificacao;
        this.entidade_respo=entidade_respo;
        this.armario=armario; 
        this.prateleira=prateleira;
    }

    public String getId_aero() {
        return id_aero;
    }

    public String getAeronauticos() {
        return aeronauticos;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getData_licenca() {
        return data_licenca;
    }

    public String getData_revalidacao() {
        return data_revalidacao;
    }

    public String getData_formacao() {
        return data_formacao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTipo_aeronave() {
        return tipo_aeronave;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public String getEntidade_respo() {
        return entidade_respo;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }
    
    
    
    
    
    public ArrayList<PessoalAero> aerotList()
    {
        ArrayList<PessoalAero> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM pessoal_aero";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            PessoalAero p;
            while(rs.next())
            {
                p = new PessoalAero(rs.getString("id_aero"),rs.getString("aeronauticos"),rs.getString("nome"),
                        rs.getString("apelido"),rs.getString("data_licenca"),rs.getString("data_revalidacao"),
                        rs.getString("data_formacao"),
                rs.getString("especialidade"),rs.getString("tipo_aeronave"),rs.getString("qualificacao"),
                rs.getString("entidade_respo"),rs.getString("armario"),rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    
    public boolean addpessoal_aero(String id_aero, String aeronauticos, String nome, 
            String apelido, String data_licenca, String data_revalidacao, 
            String data_formacao, String especialidade, String tipo_aeronave, 
            String qualificacao, String entidade_respo, String armario, String prateleira
        )
        
    {
         
        String insertQuery = "INSERT INTO pessoal_aero (id_aero,aeronauticos,nome,apelido,data_licenca,data_revalidacao,data_formacao, "
                + "especialidade,tipo_aeronave, qualificacao,entidade_respo,armario,prateleira) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, id_aero);
            ps.setString(2, aeronauticos);
            ps.setString(3, nome);
            ps.setString(4, apelido);
            ps.setString(5, data_licenca);
            ps.setString(6, data_revalidacao); 
            ps.setString(7, data_formacao);
            ps.setString(8, especialidade);
            ps.setString(9, tipo_aeronave);
            ps.setString(10, qualificacao);
            ps.setString(11, entidade_respo);
            ps.setString(12, armario);
            ps.setString(13, prateleira);
               
               
               
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Pessoal ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Pessoal NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean remove(String id)
    {
        String removeQuery = "DELETE FROM pessoal_aero WHERE id_aero=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, id);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Pessoal Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Pessoal NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
