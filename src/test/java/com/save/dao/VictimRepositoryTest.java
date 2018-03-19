package com.save.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.save.model.Victim;
import com.save.repository.IVictimRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VictimRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	 @Autowired
	 private IVictimRepository victimRepository;

	@Test
	public void whenFindById_thenReturnVictim() {
		//given
		//Date date1 = new Date(01/01/2000);
		Date date2 = new Date(12/12/2010);
		Victim victim = new Victim("TEST01","test01",date2,0);
		entityManager.persist(victim);
		entityManager.flush();
		
		//when
		List<Victim> list = victimRepository.findAll();
		Victim v1 = list.get(0);
		Long id = v1.getId();
		Victim found = victimRepository.getOne(id);
		
		
		//then
		assertEquals(victim, found);
		assertThat(found.getFirstname()).isEqualTo(victim.getFirstname());
	}
	
	@Test
	public void getVictimsListAlphaTest() {
		//given
		//Date date1 = new Date(01/01/2000);
		Date date2 = new Date(12/12/2010);
		Victim victim1 = new Victim("CCC","test01",date2,0);
		Victim victim2 = new Victim("AAA","test01",date2,0);
		Victim victim3 = new Victim("BBB","test01",date2,0);
		entityManager.persist(victim1);
		entityManager.persist(victim2);
		entityManager.persist(victim3);
		entityManager.flush();
		
		//when
		List<Victim> list = victimRepository.getVictimsListAlpha();
		List<Victim> listAlpha = new ArrayList<Victim>();
		listAlpha.add(victim2);
		listAlpha.add(victim3);
		listAlpha.add(victim1);
		
		//then
		assertThat(list, is(listAlpha));
		
	}
	
	@Test
	public void saveVictimTest() {
		//given
		//Date date1 = new Date(01/01/2000);
		Date date2 = new Date(12/12/2010);
		Victim victim = new Victim("TEST01","test01",date2,0);
		Victim victim_saved = victimRepository.save(victim);
		assertEquals(victim,victim_saved);
		
	}

}
