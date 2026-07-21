package pe.nh.demo07.service;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.nh.demo07.dto.ClienteResponse;
import pe.nh.demo07.mapper.ClienteMapper;
import pe.nh.demo07.repository.ClienteRepository;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository repo;
    private ClienteMapper mapper;

    public Page<ClienteResponse> listar(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::aResponse);
    }
}
