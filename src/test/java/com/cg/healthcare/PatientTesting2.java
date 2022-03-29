package com.cg.healthcare;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.service.IPatientServiceImpl;

@SpringBootTest
public class PatientTesting2 extends AbstractTest {

	Patient pat = new Patient("RAM", "1234567890", 23, "MALE", null);

	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}

	@MockBean
	IPatientRepository repo;

	@Autowired
	IPatientServiceImpl patientServiceImpl;

	/*
	 * @Override
	 * 
	 * @BeforeEach public void setUp() throws Exception { super.setUp(); }
	 */

	@Test
	public void addPatient() throws Exception {
		Patient p = new Patient();
		User u = new User("John", "123456", "");
		p.setName("John Doe");
		p.setAge(44);
		p.setPhoneNo("9123456789");
		p.setGender("Male");
		p.setUser(u);
		when(repo.save(p)).thenReturn(p);
		repo.save(p);
		assertThat(p.getName()).isSameAs("John Doe");
		assertThat(p.getUser()).isSameAs(u);

	}

	@Test
	public void deletePatient() throws Exception {
		Patient p = new Patient();
		User u = new User("John", "123456", "");
		p.setName("John Doe");
		p.setAge(44);
		p.setPhoneNo("9123456789");
		p.setGender("Male");
		p.setUser(u);
		when(repo.save(p)).thenReturn(p);
		repo.save(p);
		repo.delete(p);
//		Mockito.verify(repo.delete(p), times(1)).delete(p);
		Mockito.verify(repo, times(1)).delete(p);
	}

// /RAM
	@Test
	public void viewPatient() throws Exception {
		String uri = "/patient/viewpatient";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}

	@Test
	public void updatePatient() throws Exception {
		String uri = "/patient/updatepatient";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)).andReturn();
		assertEquals(400, mvcResult.getResponse().getStatus());
	}

}
