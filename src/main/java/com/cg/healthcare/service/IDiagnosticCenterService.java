package com.cg.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;

@Service
public interface IDiagnosticCenterService {
	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception;
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) throws DataNotFoundInDataBase;
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFoundInDataBase;
	List<DiagnosticTest> viewTestDetails(int diagnosticCenterId);
	DiagnosticTest addTest(int diagnosticcenterId, int testid) throws DataNotFoundInDataBase;
	DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFoundInDataBase;
	DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException;
	List<Appointment> getListOfAppointments(String centerName);

	


}