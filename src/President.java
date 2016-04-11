//Bean
public class President {
    private int termNumber;
    private String firstName, middleName, lastName;
    private int startYear, endYear;
    private String party, trivia, photo, signature, vp;
    
    
    public int getTermNumber() {
        return termNumber;
    }
    public void setTermNumber(int termNumber) {
        this.termNumber = termNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    public String getParty() {
        return party;
    }
    public void setParty(String party) {
        this.party = party;
    }
    public void setTrivia(String trivia){
    		this.trivia= trivia;
    }
    public String getTrivia(){
    		return trivia;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getPhoto() {
        return photo;
    }
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSignature() {
		return signature;
	}
	public void setvp(String vp) {
		this.vp = vp;
	}
	public String getvp() {
		return vp;
	}
    
    @Override
    public String toString() {
        return "President Term Number= " + termNumber + ", First Name= " + firstName + ", Middle Name= " + middleName
                + ", Last Name= " + lastName + ", Start Year= " + startYear + ", End Year= " + endYear + ", Party= " + party;
    }
    
    
}