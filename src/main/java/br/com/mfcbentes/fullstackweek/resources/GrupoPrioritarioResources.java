package br.com.mfcbentes.fullstackweek.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfcbentes.fullstackweek.domain.GrupoPrioritario;
import br.com.mfcbentes.fullstackweek.repository.GrupoPrioritarioRepository;

@RestController
@RequestMapping("/grupo")
public class GrupoPrioritarioResources {
	
	@Autowired
	private GrupoPrioritarioRepository grupoPrioritarioRepository;
	
	@GetMapping
	public List<GrupoPrioritario> listarTodos(){
		return grupoPrioritarioRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public GrupoPrioritario buscarPeloCodigo(@PathVariable("codigo") Long codigo) {
		return grupoPrioritarioRepository.findById(codigo).orElse(null);
	}
	
	@PostMapping
	public GrupoPrioritario cadastrarGrupoPrioritario(@RequestBody GrupoPrioritario grupoPrioritario) {
		return grupoPrioritarioRepository.save(grupoPrioritario);
	}
	
	@PutMapping("/{codigo}")
	public GrupoPrioritario atualizarGrupoPrioritario(@PathVariable("codigo") Long codigo,
			@RequestBody GrupoPrioritario grupoPrioritario) {
		return grupoPrioritarioRepository.findById(codigo).map(
				record -> {
					record.setNome(grupoPrioritario.getNome());
					record.setDescricao(grupoPrioritario.getDescricao());
					
					return grupoPrioritarioRepository.save(record);
				}).orElse(null);
	}
	
}
