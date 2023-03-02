package com.iuvity.santiago.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Rule;


import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlaylistTest {

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private  PlayList playList;
    private  Cancion cancion;



    @Before
    public void setUp() {
        List<Cancion> lista = new ArrayList<>();
        cancion = new Cancion(1, "ti", "art", "alb","2000","gen", new PlayList());
        lista.add(cancion);
        playList = new PlayList(0,"fiesta","para fiesta", lista);
    }

    @Test
    public void saveNameInPlaylist() {
        Assertions.assertEquals(playList.getNombre(), "fiesta");
    }

    @Test
    public void saveTittleInCancion() {
        Assertions.assertEquals(cancion.getTitulo(), "ti");
    }






}
