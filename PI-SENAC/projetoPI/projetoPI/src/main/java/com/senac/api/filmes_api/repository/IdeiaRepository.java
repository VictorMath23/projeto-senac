package com.senac.api.filmes_api.repository;

import com.senac.api.filmes_api.entity.IdeiaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import com.senac.api.filmes_api.repository.IdeaInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

@Repository
public interface IdeiaRepository extends JpaRepository<IdeiaEntity, Long> {
    @Query("SELECT i FROM IdeiaEntity i ORDER BY i.dataIdeia DESC")
List<IdeiaEntity> findAllOrderByDataIdeiaDesc();
/*
@Query("SELECT new com.senac.api.filmes_api.repository.IdeaInfo(i.id, i.dono, i.proposta, a.area, b.beneficio, g.nome, i.dataIdeia, i.status) FROM IdeiaEntity i " +
       "INNER JOIN i.area a " +
       "INNER JOIN i.gestor g " +
       "INNER JOIN i.beneficio b")
List<IdeaInfo> findAllIdeiaInfo();
*/
//da pagina de consulta
@Query("SELECT new com.senac.api.filmes_api.repository.IdeaInfo(i.id, i.dono, i.proposta, i.area.area, i.beneficio.beneficio, i.gestor.nome, i.dataIdeia, i.status) FROM IdeiaEntity i ORDER BY i.id DESC")
List<IdeaInfo> findAllIdeiaInfo();

//da pagina de consulta
@Query("SELECT new com.senac.api.filmes_api.repository.IdeaInfo(i.id, i.dono, i.proposta, a.area, b.beneficio, g.nome, i.dataIdeia, i.status) " +
       "FROM IdeiaEntity i " +
       "INNER JOIN i.area a " +
       "INNER JOIN i.gestor g " +
       "INNER JOIN i.beneficio b " +
       "WHERE i.dono LIKE %:dono% " +
       "ORDER BY i.id DESC")
List<IdeaInfo> findIdeiasByNome(@Param("dono") String dono);


//da pagina admin
@Query("SELECT new com.senac.api.filmes_api.repository.IdeaInfo(i.id, i.dono, i.proposta, a.area, b.beneficio, g.nome, i.dataIdeia, i.status) " +
           "FROM IdeiaEntity i " +
           "INNER JOIN i.area a " +
           "INNER JOIN i.gestor g " +
           "INNER JOIN i.beneficio b " +
           "WHERE i.status = 'Analise' " +
           "ORDER BY i.id ASC")
List<IdeaInfo> findIdeiasEmAnalise();

//ideia completa
@Query("SELECT new com.senac.api.filmes_api.repository.IdeaInfo(i.id, i.dono, i.proposta, a.area, b.beneficio, g.nome, i.dataIdeia, i.status) " +
       "FROM IdeiaEntity i " +
       "INNER JOIN i.area a " +
       "INNER JOIN i.gestor g " +
       "INNER JOIN i.beneficio b " +
       "WHERE i.status = 'Analise' " +
       "ORDER BY i.id ASC")
List<IdeaInfo> findIdeiasEmAnaliseComProposta();


@Modifying
@Query("UPDATE IdeiaEntity i SET i.status = :status WHERE i.id = :ideiaId")
void atualizarStatusIdeia(@Param("ideiaId") Long ideiaId, @Param("status") String status);






}

