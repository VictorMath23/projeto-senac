package com.senac.api.filmes_api.controller;


import com.senac.api.filmes_api.entity.GestorEntity;
import com.senac.api.filmes_api.entity.IdeiaEntity;
import com.senac.api.filmes_api.repository.GestorRepository;
import com.senac.api.filmes_api.repository.IdeaInfo;
import com.senac.api.filmes_api.repository.IdeiaService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;




@RestController
@RequestMapping("/ideia")
public class IdeiaController {
    @Autowired
    IdeiaService i_serv;
    @Autowired
    GestorRepository gp;
    
    
    @PostMapping("/adicionar")
    public ResponseEntity<IdeiaEntity> adicionaFilme(@RequestBody IdeiaEntity i){
    
        var novaIdeia = i_serv.cadIdeia(i);
        
        return new ResponseEntity(novaIdeia, HttpStatus.OK);
    }
    
    @GetMapping("/listar")
public ResponseEntity<List<IdeiaEntity>> listaTodasIdeias() {
    List<IdeiaEntity> ideias = i_serv.listaIdeiasOrdenadasPorDataDesc();
    return new ResponseEntity<>(ideias, HttpStatus.OK);
}

@GetMapping("/listar-info")
public ResponseEntity<List<IdeaInfo>> listaTodasIdeiasInfo() {
    List<IdeaInfo> ideias = i_serv.listaIdeiaInfo();
    return new ResponseEntity<>(ideias, HttpStatus.OK);
}

@GetMapping("/buscar-ideias")
    public ResponseEntity<List<IdeaInfo>> buscarIdeiasPorNome(@RequestParam String dono) {
        List<IdeaInfo> ideias = i_serv.buscarIdeiasPorNome(dono);
        return new ResponseEntity<>(ideias, HttpStatus.OK);
    }

@GetMapping("/analise")
    public ResponseEntity<List<IdeaInfo>> listarIdeiasEmAnalise() {
        List<IdeaInfo> analises = i_serv.listaIdeiasEmAnalise();
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }

 @GetMapping("/analise-com-proposta")
    public List<IdeaInfo> getIdeiasEmAnaliseComProposta() {
        return i_serv.getIdeiasEmAnaliseComProposta();
    }  
    
 @PostMapping("/aprovar/{ideiaId}")
    public ResponseEntity<String> aprovarIdeia(@PathVariable Long ideiaId) {
        i_serv.atualizarStatusIdeia(ideiaId, "Aprovada");
        return ResponseEntity.ok("Ideia aprovada com sucesso.");
    }

 @PostMapping("/reprovar/{ideiaId}")
    public ResponseEntity<String> reprovarIdeia(@PathVariable Long ideiaId) {
        i_serv.atualizarStatusIdeia(ideiaId, "Rejeitada");
        return ResponseEntity.ok("Ideia rejeitada com sucesso.");
    }
    
    @GetMapping("/detalhes-ideia/{id}")
public String detalhesIdeia(@PathVariable Long id, Model model) {
    // Recupere os detalhes da ideia com o ID fornecido
    // Preencha o modelo com os detalhes
    return "detalhes-ideia"; // Nome do arquivo HTML de detalhes
}

@GetMapping("/admin")  // Mapeamento para a página login.html
    public String abrirPaginaAdmin() {
        return "admin";  // Nome do arquivo HTML da página login
    }

 @PostMapping("/logar")
    public RedirectView login(@RequestParam String email, @RequestParam String matricula, Model model) {
        boolean isAuthenticated = i_serv.authenticateUser(email, matricula);
        if (isAuthenticated) {
            return new RedirectView("/admin"); // Redireciona para /admin
        } else {
            model.addAttribute("error", "Credenciais inválidas");
            return new RedirectView("/login"); // Redireciona para a página de login (ou qualquer outra página desejada)
        }
    }
    
    @GetMapping("/get-user-info")
    public Map<String, Object> getUserInfo(@RequestParam String email, @RequestParam String matricula) {
        Optional<GestorEntity> user = Optional.ofNullable(gp.findByEmailAndMatriculaAndComite(email, matricula, "Y"));

        if (user.isPresent()) {
            // Usuário encontrado
            Map<String, Object> userInfo = Map.of(
                    "email", user.get().getEmail(),
                    "matricula", user.get().getMatricula(),
                    "comite", user.get().getComite()
            );
            return userInfo;
        } else {
            // Usuário não encontrado
            return Map.of("message", "Acesso negado. Verifique suas credenciais.");
        }
    }
    
    
}
