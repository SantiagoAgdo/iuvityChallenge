package com.iuvity.santiago;

import com.iuvity.santiago.controller.KardexController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class SantiagoApplicationTests {

	@Autowired
	private KardexController kardexController;
	@Test
	void contextLoads() { //Verifica la creacion del controller
		assertThat(kardexController).isNotNull();
	}

}
