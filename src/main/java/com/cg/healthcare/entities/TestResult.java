package com.cg.healthcare.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "test_result")
public class TestResult {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testRes_seq")
	@SequenceGenerator(name="testRes_seq", sequenceName = "testRes_seq", initialValue = 1, allocationSize = 1 )
	private int testResultid;
	private String testName;
	private double testReading;
	private String testcondition;

	@JsonIgnore
	@ManyToOne
	private Appointment appointment;

	public TestResult() {
	}

	public TestResult(int testResultid, double testReading, String testName, Appointment appointment) {
		super();
		this.testResultid = testResultid;
		this.testReading = testReading;
		this.testName = testName;
		this.appointment = appointment;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestcondition() {
		return testcondition;
	}

	public void setTestcondition(String testcondition) {
		this.testcondition = testcondition;
	}

	public int getTestResultid() {
		return testResultid;
	}

	public void setTestResultid(int testResultid) {
		this.testResultid = testResultid;
	}

	public double getTestReading() {
		return testReading;
	}

	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

}
