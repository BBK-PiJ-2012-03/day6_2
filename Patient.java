public class Patient {
  public String name;
  private int age;
  private String illness;
  private Patient nextPatient;
  private Patient previousPatient;

	public Patient(String name, int age, String illness) {
	this.name = name;
	this.age = age;
	this.illness = illness;
	this.nextPatient = null;
	this.previousPatient = null;
	}

	public void addPatient(Patient newPatient) {
		if (this.nextPatient == null) {
		// this means this is the last patient in the list
		this.nextPatient = newPatient;
		newPatient.previousPatient = this;
		} else {
		  this.nextPatient.addPatient(newPatient);
		  }
	}

	public boolean deletePatient(Patient patient) {
	  if (this.nextPatient == null) {
	  //patient to remove was not found
	  return false;
	} else if (this.nextPatient.name.equals(patient.name)) {
	  //We found it! It is the next one!
	  // Now link this patient to the one after the next, and the one after the next, to this.
	  this.nextPatient = nextPatient.nextPatient;
	  this.nextPatient.previousPatient = this;
	  return true;
	} else {
	  return this.nextPatient.deletePatient(patient);
	  }
	}

		public void traverseForward(Patient myPatient) {

			 while (myPatient != null) {
				System.out.println(myPatient.name + ", " + myPatient.age + ", " + myPatient.illness);
				myPatient = myPatient.nextPatient;
			}
		}

		public void traverseBackward(Patient myPatient) {

			while (myPatient != null) {
				System.out.println(myPatient.name + ", " + myPatient.age + ", " + myPatient.illness); 
				myPatient = myPatient.previousPatient; 
			}
		}

 public static void main(String[] args) { 
 
 Patient patientListStart = null;

 Patient firstPatient = new Patient("John", 33, "Tuberculosis");
 patientListStart = firstPatient;
 	
 Patient secondPatient = new Patient("Mary", 66, "Meningitis");
 patientListStart.addPatient(secondPatient);

 Patient thirdPatient = new Patient("Tom", 90, "Cancer");
 patientListStart.addPatient(thirdPatient);

 Patient forthPatient = new Patient("Dying", 100, "Brain Cancer");
 patientListStart.addPatient(forthPatient);

 Patient fifthPatient = new Patient("Baby", 3, "Fever");
 patientListStart.addPatient(fifthPatient);

 Patient sixthPatient = new Patient("Peter", 30, "Pneumonia");
 patientListStart.addPatient(sixthPatient);

 Patient seventhPatient = new Patient("Bob", 56, "Lupus");
 patientListStart.addPatient(seventhPatient);

 Patient eigthPatient = new Patient("Lora", 31, "Broken Leg");
 patientListStart.addPatient(eigthPatient);

 Patient ninethPatient = new Patient("Eliza", 35, "Leuchemia");
 patientListStart.addPatient(ninethPatient);

 Patient tenthPatient = new Patient("Chris", 58, "Asthma");
 patientListStart.addPatient(tenthPatient);

 
 patientListStart.deletePatient(fifthPatient);
 

 firstPatient.traverseForward(firstPatient);
 tenthPatient.traverseBackward(tenthPatient);

 }
}