
package com.senac.api.filmes_api.repository;

import com.senac.api.filmes_api.entity.GestorEntity;
import com.senac.api.filmes_api.entity.IdeiaEntity;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vsilva18
 */
@Service 
public class IdeiaService {
    
    @Autowired
    IdeiaRepository i_rp;
    @Autowired
    private GestorRepository gestorRepository;
    
    
    public IdeiaEntity cadIdeia(IdeiaEntity i){
    
        i.setId(null);
        i_rp.save(i);
        return i;
    }
    
    public List<IdeiaEntity> listaIdeias(){
        
        return i_rp.findAll();
    }
    
    public List<IdeiaEntity> listaIdeiasOrdenadasPorDataDesc() {
    return i_rp.findAllOrderByDataIdeiaDesc();
}
    
    public List<IdeaInfo> listaIdeiaInfo() {
    return i_rp.findAllIdeiaInfo();
}
    
    public List<IdeaInfo> buscarIdeiasPorNome(String dono) {
        return i_rp.findIdeiasByNome(dono);
    }
    
    public List<IdeaInfo> listaIdeiasEmAnalise() {
        return i_rp.findIdeiasEmAnalise();
    }
    
    public List<IdeaInfo> getIdeiasEmAnaliseComProposta() {
        return i_rp.findIdeiasEmAnaliseComProposta();
    }
    
    @Transactional
    public void atualizarStatusIdeia(Long ideiaId, String status) {
        i_rp.atualizarStatusIdeia(ideiaId, status);
    }
    
    @Autowired
    public IdeiaService(GestorRepository gestorRepository) {
        this.gestorRepository = gestorRepository;
    }
    
    public boolean authenticateUser(String email, String matricula) {
        GestorEntity gestor = gestorRepository.findByEmailAndMatriculaAndComite(email, matricula, "Y");
        return gestor != null;
    }
}
    