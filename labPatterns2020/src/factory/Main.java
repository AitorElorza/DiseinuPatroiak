package factory;

import domain.Covid19Pacient;
import domain.Medicament;

public class Main {

	public static void main(String[] args) {
		SymptomFactory f= new SymptomFactory();
		Covid19Pacient	p1=new Covid19Pacient("aitor",	35,f);
		PacientSymptomGUI	psGUI1 =	new PacientSymptomGUI(p1);
		Medicament m=new Medicament("Ibuprofeno", f);
		MedicalGUI mgui=new MedicalGUI(m);
		
	}

}
