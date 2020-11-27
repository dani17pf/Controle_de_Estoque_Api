package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.ClienteDTO;
import br.com.controledeestoque.repositorio.ClienteRepositorio;

@Service
public class ClienteServices {

	@Autowired
	ClienteRepositorio clienteRepositorio; 
	
	public List<ClienteDTO> getCliente() {
		
		return clienteRepositorio.findAll();
        
    }
	
	public ClienteDTO getCliente(Long id) {
		Optional<ClienteDTO> result = clienteRepositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public ClienteDTO postCliente( ClienteDTO cliente) {
		
		return clienteRepositorio.save(cliente);
    }
	
	public ClienteDTO atualizaCliente(Long id, ClienteDTO cliente) {
		Optional<ClienteDTO> result = clienteRepositorio.findById(id);
		
		if(result.isPresent()) {
			cliente.setId(id);
			return clienteRepositorio.save(cliente);
		}
        return null;
		
    }
	
	
	public ResponseEntity<?> deleteCliente(Long id) {

		Optional<ClienteDTO> result = clienteRepositorio.findById(id);

		if (result.isPresent()) {
			clienteRepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
}
