package com.senac.doador.dto;

import com.senac.doador.entity.Doador;

import java.util.List;

public class DoadorComDoacoesDTO {

    private Doador doador;
    private List<DoacaoDto> doacoes;

    public DoadorComDoacoesDTO(Doador doador, List<DoacaoDto> doacoes){
        this.doador = doador;
        this.doacoes = doacoes;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public List<DoacaoDto> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<DoacaoDto> doacoes) {
        this.doacoes = doacoes;
    }
}
