package midas.entidades;

import javax.persistence.*;

@Entity
public class Study {
	@Id
	@GeneratedValue
	@Column (name = "studyId")
	private int id;
	
	@Column
	private String date;
	
	@Column (length = 1024)
	private String findings;
	
	@Column (length = 500)
	private String breastComposition;
	
	@Column (length = 500)
	private String histology;
	
	@ManyToOne
	@Column (name = "patientId")
	private Patient patient;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFindings() {
		return findings;
	}

	public void setFindings(String findings) {
		this.findings = findings;
	}

	public String getBreastComposition() {
		return breastComposition;
	}

	public void setBreastComposition(String breastComposition) {
		this.breastComposition = breastComposition;
	}

	public String getHistology() {
		return histology;
	}

	public void setHistology(String histology) {
		this.histology = histology;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public int getId() {
		return id;
	}
}
