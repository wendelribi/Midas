package midas.entidades;

import javax.persistence.*;

@Entity 
public class Patient {
	
	@Id
	@GeneratedValue
	@Column 
	public int patientId;
	@Column (nullable = false)
	public String patientHistory;
	@Column (nullable = false)
	public String birthday;
	
	
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
	
	
	
	
	
}
