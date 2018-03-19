package com.save.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.save.model.Responsible;
import com.save.model.Victim;
import com.save.repository.IResponsibleRepository;
import com.save.repository.IVictimRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ResponsibleRepositoryTest {

	private static final int List = 0;

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private IResponsibleRepository responsibleRepository;
	
	@Autowired
	private IVictimRepository victimRepository;
	
	@Test
	public void getResponsiblesFromVictimTest() {
		//given
		//Date date1 = new Date(01/01/2000);
		Date date2 = new Date(12/12/2010);
		Victim victim = new Victim("TEST01","test01",date2,0);
		Victim victim02 =  new Victim("TEST02", "test02",date2,0);
		Responsible contact01 = new Responsible("CONTACT01","contact01",1000, "Bruxelles","rue Haute",1,"contact01@gmail.com","01234");
		Responsible contact02 = new Responsible("CONTACT02","contact02",1000, "Bruxelles","rue Haute",2,"contact01@gmail.com","01234");
		Responsible contact03 = new Responsible("CONTACT03","contact03",1000, "Bruxelles","rue Haute",2,"contact01@gmail.com","01234");
		entityManager.persist(contact01);
		entityManager.persist(contact02);
		entityManager.persist(contact03);
		victim.addResponsible(contact01);
		victim.addResponsible(contact02);
		victim02.addResponsible(contact03);
		entityManager.persist(victim);
		entityManager.persist(victim02);
		entityManager.flush();
		
		//when
		List<Victim> listV = victimRepository.findAll();
		Long id = listV.get(0).getId();
		List<Responsible> list = responsibleRepository.getResponsiblesFromVictim(id);
		List<Responsible> listR = new ArrayList<Responsible>();
		listR.add(contact01);
		listR.add(contact02);
		
		//then
		assertThat(list, is(listR));
	}

}
