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
public class Pilot {
private String id;
private String nome;
private String apelido; 
private String nacionalidade; 
private String tipo_aero; 
private String tipo_licenca; 
private String data_emissao;
private String data_revalidacao;
private String armario; 
private String prateleira;

    public Pilot(String id, String nome, String apelido, String nacionalidade, String tipo_aero, String tipo_licenca, String data_emissao, String data_revalidacao, String armario, String prateleira) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.nacionalidade = nacionalidade;
        this.tipo_aero = tipo_aero;
        this.tipo_licenca = tipo_licenca;
        this.data_emissao = data_emissao;
        this.data_revalidacao = data_revalidacao;
        this.armario = armario;
        this.prateleira = prateleira;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getTipo_aero() {
        return tipo_aero;
    }

    public String getTipo_licenca() {
        return tipo_licenca;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public String getData_revalidacao() {
        return data_revalidacao;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setTipo_aero(String tipo_aero) {
        this.tipo_aero = tipo_aero;
    }

    public void setTipo_licenca(String tipo_licenca) {
        this.tipo_licenca = tipo_licenca;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public void setData_revalidacao(String data_revalidacao) {
        this.data_revalidacao = data_revalidacao;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }
    

public boolean addPilot(String id, String nome, String apelido, 
        String nacionalidade, String tipo_aero, 
        String tipo_licenca,String data_emissao,
        String data_revalidacao,String armario,  
        String prateleira  
        
        )
        
    {
         //String tipo_aero,
        String insertQuery = "INSERT INTO pilotos (id_piloto,nome,apelido,nacionalidade,tipo_aero,tipo_licenca,data_emissao, data_revalidacao,armario, prateleira) VALUES (?,?,?,?,?,?,?,?,?,?)";
        //String insertQuery = "INSERT INTO pilotos VALUES (id_piloto,nome,apelido,nacionalidade,tipo_aero,tipo_licenca,data_emissao, data_revalidacao,armario, prateleira)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, id);
            ps.setString(2, nome);
            ps.setString(3, apelido);
            ps.setString(4, nacionalidade);
            ps.setString(5, tipo_aero);
            ps.setString(6, tipo_licenca); 
            ps.setString(7, data_emissao);
            ps.setString(8, data_revalidacao);
            ps.setString(9, armario);
            ps.setString(10, prateleira);
               
               
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "PILOT ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "PILOT NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


public ArrayList<Pilot> pilotList()
    {
        ArrayList<Pilot> pList = new ArrayList<>();
        String selectQuery="SELECT * FROM pilotos";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            Pilot p;
            while(rs.next())
            {
                p = new Pilot(rs.getString("id_piloto"),rs.getString("nome"),rs.getString("apelido"),
                        rs.getString("nacionalidade"),rs.getString("tipo_aero"),rs.getString("tipo_licenca"),
                        rs.getString("data_emissao"),
                rs.getString("data_revalidacao"),rs.getString("armario"),rs.getString("prateleira"));
                pList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pList;
    }

public boolean remove(String id)
    {
        String removeQuery = "DELETE FROM pilotos WHERE id_piloto=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, id);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Pilot Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Pilot Not Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
