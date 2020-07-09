public class MedDecorator {
    protected Medication tempMed;
	
	public MedDecorator(Medication newMed){
		
		tempMed = newMed;
		
	}
	
	public String getName() {
		
		return tempMed.getName();
		
	}

	public double getQuantity() {
		
		return tempMed.getQuantity();
		
	}
    
}
