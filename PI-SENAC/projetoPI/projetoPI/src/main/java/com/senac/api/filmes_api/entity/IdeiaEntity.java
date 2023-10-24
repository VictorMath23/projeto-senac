package com.senac.api.filmes_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;


@Data
@Entity
@Table(name = "ideia")
public class IdeiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dono;
    private String proposta;
       
    @ManyToOne()
    @JoinColumn(name = "area_id")
    private AreaEntity area;


    @ManyToOne()
    @JoinColumn(name = "gestor_id")
    private GestorEntity gestor;

    @ManyToOne()
    @JoinColumn(name = "beneficio_id")
    private BeneficioEntity beneficio;

    private LocalDate dataIdeia;
    private String status = "Analise";
}

  
