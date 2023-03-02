package com.iuvity.santiago.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Transactional
public class PlayListRepositoryTest {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Test
    public void testFindByNombre() {
        PlayList playList = new PlayList();
        playlistRepository.save(playList);
        PlayList result = playlistRepository.findByNombre(playList.getNombre());
        Assertions.assertEquals(playList.getNombre(), result.getNombre());
    }

    @Test
    public void testDeleteByNombre() {
        PlayList playList = getPlaylist();
        playlistRepository.save(playList);
        playlistRepository.deleteByNombre(playList.getNombre());
        List<PlayList> result = new ArrayList<>();
        playlistRepository.findAll().forEach(e -> result.add(e));
        Assertions.assertEquals(result.size(), 0);
    }

    private PlayList getPlaylist() {
        List<Cancion> lista = new ArrayList<>();
        Cancion cancion = new Cancion(1, "ti", "art", "alb", "2000", "gen", new PlayList());
        lista.add(cancion);

        PlayList playList = new PlayList();
        playList.setId(1);
        playList.setNombre("Fiesta");
        playList.setDescripcion("pa party");
        playList.setCanciones(lista);
        return playList;
    }
}
