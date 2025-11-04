package com.senac.doador.clientefeign;

import com.senac.doador.dto.DoacaoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "doacaoCliente", url = "10.136.64.14:8080", path="api/doacoes")
public interface DoacaoCliente {

    @GetMapping("/obterDoacoesDoUsuario/{idDoador}")
    List<DoacaoDto> buscarDoacoesPorUsuario(@PathVariable("idDoador") Long idDoador);
}
