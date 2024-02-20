package com.project.main.service;

import com.project.main.entity.Ant;

import java.util.List;

public interface AntService {

    public List<Ant> getAllAnts();

    Ant getAntById(int antId);

    void saveAnt(Ant ant);

    void deleteAnt(int antId);
}
