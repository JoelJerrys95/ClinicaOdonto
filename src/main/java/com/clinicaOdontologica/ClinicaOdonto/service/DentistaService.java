package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.DentistaDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService{

    @Autowired
    //IDao<Dentista> dentistaDAOH2;

    DentistaRepository repository;

    public Dentista salvar(Dentista dentista) {
        return repository.save(dentista);
    }

    public List<DentistaDTO> listarDentistas() {
        List<Dentista> dentistaList = repository.findAll();
        List<DentistaDTO> dentistaDTOList = new ArrayList<>();

        for(Dentista e : dentistaList){
            dentistaDTOList.add(new DentistaDTO(e));
        }

        return dentistaDTOList;
    }

    public void alterar (Dentista dentista) {
        repository.save(dentista);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Optional<Dentista> buscarDentistaId(Long id) throws SQLException{
        return repository.findById(id);
    }

}
