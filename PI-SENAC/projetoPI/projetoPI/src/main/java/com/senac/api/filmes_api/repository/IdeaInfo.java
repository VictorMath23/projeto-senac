
package com.senac.api.filmes_api.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;



public class IdeaInfo {
    private Long id;
    private String dono;
    private String proposta;
    private String area;
    private String beneficio;
    private String gestor;
    private LocalDate dataIdeia;
    private String status;

    public IdeaInfo(Long id, String dono, String proposta, String area, String beneficio, String gestor, LocalDate dataIdeia, String status) {
        this.id = id;
        this.dono = dono;
        this.proposta = proposta;
        this.area = area;
        this.beneficio = beneficio;
        this.gestor = gestor;
        this.dataIdeia = dataIdeia;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }
    
    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    @JsonProperty("beneficio")
    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }
    
    @JsonProperty("gestor")
    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public LocalDate getDataIdeia() {
        return dataIdeia;
    }

    public void setDataIdeia(LocalDate dataIdeia) {
        this.dataIdeia = dataIdeia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}

