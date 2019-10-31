/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroprodutos.model;

/**
 *
 * @author joão pedro
 */
public class Especificacao {
    private int codigo;
    private String fabricante;
    private String cor;
    private String sistema;
    private String detalhes;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        
        sb.append(codigo)
                .append(" - ")
                .append(fabricante)
                .append(" - ")
                .append(cor)
                .append(" - ")
                .append(sistema)
                .append(" - ")
                .append(detalhes);
         return sb.toString();
    }
    
}
