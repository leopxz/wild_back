package com.WildLife.Wild.service;


import com.WildLife.Wild.entities.ChamadosEntity;
import com.WildLife.Wild.repository.ChamadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ChamadosService {
    @Autowired
    private ChamadosRepository chamadosRepository;

    public List<ChamadosEntity> getChamadosList() {
        return chamadosRepository.findAll();
    }

    public ChamadosEntity saveChamados(ChamadosEntity chamados){
        return chamadosRepository.save(chamados);
    }

    public void DeleteById(Long id){
        chamadosRepository.deleteById(id);
    }


    public ChamadosEntity updateChamados(ChamadosEntity chamados, Long id){
        ChamadosEntity target=chamadosRepository.findById(id).orElseThrow(()-> new Error("chamados não encontrado"));
        target.setNome(chamados.getNome() == null? target.getNome() : chamados.getNome());
        target.setTelefone(chamados.getTelefone() == null? target.getTelefone() : chamados.getTelefone());
        target.setNome_animal(chamados.getNome_animal()== null? target.getNome_animal(): chamados.getNome_animal());
        target.setCidade(chamados.getCidade() == null? target.getCidade(): chamados.getCidade());
        target.setUF(chamados.getUF() == null? target.getUF() : chamados.getUF());
        target.setBairro(chamados.getBairro() == null? target.getBairro(): chamados.getBairro());
        target.setLocal_encontrado(chamados.getLocal_encontrado() == null ? target.getLocal_encontrado() : chamados.getLocal_encontrado());
        target.setData(chamados.getData() == null ? target.getData() : chamados.getData());
        target.setObservaçao(chamados.getObservaçao() == null ? target.getObservaçao() : chamados.getObservaçao());
        return chamadosRepository.save(target);







    }






}
