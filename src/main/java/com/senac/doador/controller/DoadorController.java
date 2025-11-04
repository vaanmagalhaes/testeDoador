package com.senac.doador.controller;

import com.senac.doador.dto.DoacaoDto;
import com.senac.doador.dto.DoadorComDoacoesDTO;
import com.senac.doador.entity.Doador;
import com.senac.doador.service.DoadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/doador")
@Tag(name="Doador", description="API para gerenciamento dos doadores do sistema")
@CrossOrigin ("*")
public class DoadorController {

    private final DoadorService doadorService;

    public DoadorController(DoadorService doadorService) {this.doadorService = doadorService;}

    @GetMapping("/listar")
    public ResponseEntity<List<Doador>> listar() {return ResponseEntity.ok(doadorService.listarDoadores());}

    @GetMapping("/consultardoacoes")
    public List<DoadorComDoacoesDTO> consultarDoacoes() {
        List<Doador> doadores = doadorService.listarDoadores();
        List<DoadorComDoacoesDTO> lista = new ArrayList<>();
        for (Doador d : doadores) {
            List<DoacaoDto> doacoes = doadorService.listarDoacoesPorDoador(Long.valueOf(d.getId()));
            lista.add(new DoadorComDoacoesDTO(d, doacoes));
        }
        return lista;
    }



}
