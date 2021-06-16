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
 * @author domin
 */
public class PesquisaDocs {
    
     private String id_doc; 
 private String titulo_doc ;
 private String ref_origem;
 private String ref_loca ;
 private String descricao; 
 private String quant ;
 private String valor ;
 private String localizacao ;
 private String fonte ;
 private String data_entrada ;
 private String status ;
 private String grupo ;
 private String formato; 
 private String edicao_data ;
 private String edicao_revisao;
 private String armario; 
 private String prateleira;
 private String titulo;

    public PesquisaDocs(String id_doc, String titulo_doc, String ref_origem, String ref_loca, String descricao, String quant, String valor, String localizacao, String fonte, String data_entrada, String status, String grupo, String formato, String edicao_data, String edicao_revisao, String armario, String prateleira, String titulo) {
        this.id_doc = id_doc;
        this.titulo_doc = titulo_doc;
        this.ref_origem = ref_origem;
        this.ref_loca = ref_loca;
        this.descricao = descricao;
        this.quant = quant;
        this.valor = valor;
        this.localizacao = localizacao;
        this.fonte = fonte;
        this.data_entrada = data_entrada;
        this.status = status;
        this.grupo = grupo;
        this.formato = formato;
        this.edicao_data = edicao_data;
        this.edicao_revisao = edicao_revisao;
        this.armario = armario;
        this.prateleira = prateleira;
        this.titulo=titulo;
    }

    public String getId_doc() {
        return id_doc;
    }

    public String getTitulo_doc() {
        return titulo_doc;
    }

    public String getRef_origem() {
        return ref_origem;
    }

    public String getRef_loca() {
        return ref_loca;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getQuant() {
        return quant;
    }

    public String getValor() {
        return valor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getFonte() {
        return fonte;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public String getStatus() {
        return status;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getFormato() {
        return formato;
    }

    public String getEdicao_data() {
        return edicao_data;
    }

    public String getEdicao_revisao() {
        return edicao_revisao;
    }

    public String getArmario() {
        return armario;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public String getTitulo() {
        return titulo;
    }
    
 
    

    public ArrayList<PesquisaDocs> acordotList()
    {
        ArrayList<PesquisaDocs> aList = new ArrayList<>();
        String selectQuery="SELECT * FROM documento WHERE titulo_doc=?";
        //String selectQuery="SELECT * FROM documento";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=DB.getConnection().prepareStatement(selectQuery);
            ps.setString(1, titulo);
            rs=ps.executeQuery();
            PesquisaDocs p;
            //ps.executeUpdate();
            while(rs.next())
            {
                p = new PesquisaDocs(rs.getString("id_doc"),rs.getString("titulo_doc"),rs.getString("ref_origem"),
                rs.getString("ref_loca"),rs.getString("descricao"),rs.getString("quant"),
                rs.getString("valor"),rs.getString("localizacao"),rs.getString("fonte"),rs.getString("data_entrada"),rs.getString("status"),
                rs.getString("grupo"),rs.getString("formato"),rs.getString("edicao_data"),rs.getString("edicao_revisao"),rs.getString("armario"),
                rs.getString("prateleira"),rs.getString(""));
                aList.add(p);
            }
            System.out.println(titulo);
           
        } catch (SQLException ex) {
            Logger.getLogger(Doc.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, "STATUS CHANGED"+rs,"",2);
       
        return aList;
    }
    
}
