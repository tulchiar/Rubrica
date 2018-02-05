package it.tulchiar.rubrica.bean;

public class Contatto {
	
	private Integer idContatto;
	private String nome;
	private String cognome;
	private String telefono;
	private String fax;
	private String cellulare;
	private String email;
	private String pec;
	private String passwordPec;
	private String note;
	private Integer cancellato;
	
	public Contatto () {
		super();
	}

	public Contatto (Integer idContatto) {
		super();
		this.idContatto = idContatto;
	}
	
	public Contatto (String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Contatto(Integer idContatto, String nome, String cognome, String telefono, String fax, String cellulare,
			String email, String pec, String passwordPec, String note) {
		super();
		this.idContatto = idContatto;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.fax = fax;
		this.cellulare = cellulare;
		this.email = email;
		this.pec = pec;
		this.passwordPec = passwordPec;
		this.note = note;
	}

	public Integer getCancellato() {
		return cancellato;
	}
	
	public Integer getIdContatto() {
		return idContatto;
	}

	public void setIdContatto(Integer idContatto) {
		this.idContatto = idContatto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getPasswordPec() {
		return passwordPec;
	}

	public void setPasswordPec(String passwordPec) {
		this.passwordPec = passwordPec;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() { 
		return String.format("Contatto: %s %s %s", this.getCognome(), this.getNome(), this.getTelefono());
	}
	
}