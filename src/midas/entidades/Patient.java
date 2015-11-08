package midas.entidades;

import java.util.List;

import javax.persistence.*;

@Entity 
public class Patient {
	
	@Id
	@GeneratedValue
	@Column 
	private int patientId;
	@Column (nullable = false)
	private String patientHistory;
	@Column (nullable = false)
	private String birthday;
	@OneToMany(mappedBy = "patient")
	private List<Study> studies;
	
	public Patient() {
		
	}
	public Patient(String patientHistory, String birthday) {
		this.patientHistory = patientHistory;
		this.birthday = birthday;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public String getPatientHistory() {
		return patientHistory;
	}
	public void setPatientHistory(String patientHistory) {
		this.patientHistory = patientHistory;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public List<Study> getStudies() {
		return studies;
	}
	public void setStudies(List<Study> studies) {
		this.studies = studies;
	}
	
}
