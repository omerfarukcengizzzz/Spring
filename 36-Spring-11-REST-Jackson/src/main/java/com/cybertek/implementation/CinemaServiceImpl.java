package com.cybertek.implementation;

import com.cybertek.entity.Cinema;
import com.cybertek.repository.CinemaRepository;
import com.cybertek.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> retrieveAll() {
        return cinemaRepository.findAll();
    }
}
