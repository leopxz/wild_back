package com.WildLife.Wild.service;

import com.WildLife.Wild.controllers.FuncionarioController;
import com.WildLife.Wild.entities.FuncionariosEntity;
import com.WildLife.Wild.repository.FuncionarioRepository;
import jakarta.persistence.Id;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;
    public List<FuncionariosEntity>getFuncionarioList(){
        return repository.findAll();
    }
    public FuncionariosEntity saveFuncionario(FuncionariosEntity funcionario){
        String senhaCryptografada = BCrypt.hashpw(funcionario.getPassword(), BCrypt.gensalt());
        funcionario.setPassword(senhaCryptografada);
        return repository.save(funcionario);
    }
    public FuncionariosEntity findByEmailandPassword(String email, String password){
        Optional<FuncionariosEntity> funcionarios = repository.findByEmail(email);
        if (funcionarios.isPresent()){
            if(BCrypt.checkpw(password, funcionarios.get().getPassword())){
                return  funcionarios.get();
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public FuncionariosEntity updateFuncionario(FuncionariosEntity funcionario, Long id){
        FuncionariosEntity target=repository.findById(id).orElseThrow(()->new Error("funcionario não encontrado"));
        target.setCargo(funcionario.getCargo() == null? target.getCargo(): funcionario.getCargo());
        target.setNome(funcionario.getNome() == null? target.getNome(): funcionario.getNome());
        target.setUsuario(funcionario.getUsuario() == null? target.getUsuario(): funcionario.getUsuario());
        target.setPassword(funcionario.getPassword() == null? target.getPassword(): funcionario.getPassword());
        target.setNascimento(funcionario.getNascimento() == null? target.getNascimento(): funcionario.getNascimento());
        target.setTelefone(funcionario.getTelefone() == null? target.getTelefone(): funcionario.getTelefone());
        target.setEmail(funcionario.getEmail() == null? target.getEmail(): funcionario.getEmail());
        target.setId_funcionario(id);
        return repository.save(target);
    }

}
