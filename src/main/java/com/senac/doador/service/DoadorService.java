package com.senac.doador.service;

import com.senac.doador.dto.DoacaoDto;
import com.senac.doador.dto.request.DoadorDtoRequest;
import com.senac.doador.dto.response.DoadorDtoResponse;
import com.senac.doador.entity.Doador;
import com.senac.doador.clientefeign.DoacaoCliente;
import com.senac.doador.repository.DoadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DoacaoCliente doacaoCliente;

private final DoadorRepository doadorRepository;

public DoadorService(DoadorRepository doadorRepository) {this.doadorRepository = doadorRepository;}

public List<Doador> listarDoadores() { return this.doadorRepository.listarDoadores();}

public DoadorDtoResponse salvar(DoadorDtoRequest doadorDtoRequest){
    Doador doador = new Doador();
    doador.setNome(doadorDtoRequest.getNome());
    doador.setEndereco(doadorDtoRequest.getEndereco());
    doador.setStatus(1);
    Doador doadorSave = this.doadorRepository.save(doador);

    return modelMapper.map(doadorSave, DoadorDtoResponse.class);
}

    public List<DoacaoDto> listarDoacoesPorDoador(Long idDoador) {
        return doacaoCliente.buscarDoacoesPorUsuario(idDoador);
    }

    public void apagar(Integer idDoador) { this.doadorRepository.apagadoLogico(idDoador);}

}