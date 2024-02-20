package com.project.main.service;

import com.project.main.entity.Ant;
import com.project.main.repository.AntRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntServiceImpl implements AntService {

    private final AntRepository antRepository;

    public AntServiceImpl(AntRepository antRepository) {
        this.antRepository = antRepository;
    }

    @Override
    public List<Ant> getAllAnts() {
        return antRepository.findAll();
    }

    @Override
    public Ant getAntById(int antId) {
        return antRepository.findById(antId).orElse(null);
    }

    @Override
    public void saveAnt(Ant ant) {
        antRepository.save(ant);
    }

    @Override
    public void deleteAnt(int antId) {
        antRepository.deleteById(antId);
    }
}
