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
public class Aeronaves {
        private String tipo;
        private String marca;
        private String modelo;
        private String matricula;
        private String data_entrada; 
        private String data_cert; 
        private String responsavel; 
        private String operador; 
        private String  baseop; 
        private String armario; 
        private String prateleira;
        
        
        public Aeronaves(String tipo,String marca,String modelo,String matricula,String data_entrada,String data_cert,String responsavel,String operador,String  baseop,String armario,String prateleira)
        {
            this.tipo=tipo;
            this.marca=marca;
            this.modelo=modelo;
            this.matricula=matricula;
            this.data_entrada=data_entrada; 
            this.data_cert=data_cert; 
            this.responsavel=responsavel; 
            this.operador=operador; 
            this.baseop=baseop; 
            this.armario=armario; 
            this.prateleira=prateleira;
        }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public String getData_cert() {
        return data_cert;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getOperador() {
        return operador;
    }

    public String getBaseop() {
        return baseop;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }
        
    public ArrayList<Aeronaves> acordotList()
    {
        ArrayList<Aeronaves> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM air";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            Aeronaves p;
            while(rs.next())
            {
                p = new Aeronaves(rs.getString("tipo"),rs.getString("marca"),rs.getString("modelo"),
                        rs.getString("matricula"),rs.getString("data_entrada"),rs.getString("data_cert"),
                        rs.getString("responsavel"),rs.getString("operador"),rs.getString("baseop"),rs.getString("armario"),rs.getString("prateleira"));
                aList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aList;
    }
    
    public boolean addAir(String tipo, String marca ,String modelo ,String matricula ,String data_entrada ,String data_cert,  String responsavel,String operador,String baseop,String armario,String prateleira)
        
    {
         
        String insertQuery = "INSERT INTO air (tipo,marca,modelo,matricula,data_entrada,data_cert,responsavel,operador,baseop,armario,prateleira) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, tipo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, matricula);
            ps.setString(5, data_entrada);
            ps.setString(6, data_cert); 
            ps.setString(7, responsavel);
            ps.setString(8, operador);
            ps.setString(9, baseop);
            ps.setString(10, armario);
            ps.setString(11, prateleira);
            ps.executeUpdate();
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Aeronave ADD","",2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Aeronave NOT ADD","",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean remove(String matricula)
    {
        String removeQuery = "DELETE FROM air WHERE matricula=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setString(1, matricula);
            if(ps.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null, "Aeronave Removed", "", 2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Aeronave NOT Removed", "", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
