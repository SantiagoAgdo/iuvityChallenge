package com.iuvity.santiago.controller;

import com.quipu.santiago.repository.PlaylistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
public class PlayListControllerTest {

    @Autowired
    PlaylistRepository playlistRepository;


    @Test
    public void guardarPlayList(){
        PlayList playList = mock();
        playlistRepository.save(playList);
    }

    @Test
    public void deletePlaylist(){
        List<Cancion> lista = new ArrayList<>();
        Cancion cancion = new Cancion(1, "ti", "art", "alb","2000","gen", new PlayList());
        lista.add(cancion);
        PlayList playList = new PlayList(0,"fiesta","para fiesta", lista);
        playlistRepository.save(playList);
        playlistRepository.deleteByNombre("fiesta");
    }

    @Test
    public void viewDescriptionTest(){
        PlayList playList = mock();
        playlistRepository.save(playList);
        playlistRepository.findByNombre("Party");
    }


    public PlayList mock() {
        List<Cancion> lista = new ArrayList<>();
        Cancion cancion = new Cancion(1, "RockAndRollPr", "Desconocido", "Viejo","2001","Rock", new PlayList());
        lista.add(cancion);
        return new PlayList(0,"Party","Party Rock", lista);
    }
}
