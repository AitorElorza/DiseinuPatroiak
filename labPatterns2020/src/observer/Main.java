package observer;

import java.util.Observable;

import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SymptomFactory f= new SymptomFactory();
		Observable pacient=new Covid19Pacient("aitor", 35,f);
		PacientObserverGUI pacientGUI= new PacientObserverGUI (pacient);
		PacientSymptomGUI frame = new PacientSymptomGUI ((Covid19Pacient) pacient);
		PacientThermometerGUI thermometer = new PacientThermometerGUI(pacient);
		SemaphorGUI semaphor=new SemaphorGUI(pacient);
		Observable pacient2=new Covid19Pacient("Ane", 29,f);
		PacientObserverGUI pacientGUI2= new PacientObserverGUI (pacient2);
		PacientSymptomGUI frame2 = new PacientSymptomGUI ((Covid19Pacient) pacient2);
		PacientThermometerGUI thermometer2 = new PacientThermometerGUI(pacient2);
		Observable pacient3=new Covid19Pacient("Jon", 45,f);
		PacientObserverGUI pacientGUI3= new PacientObserverGUI (pacient3);
		PacientSymptomGUI frame3 = new PacientSymptomGUI ((Covid19Pacient) pacient3);
		PacientThermometerGUI thermometer3 = new PacientThermometerGUI(pacient3);
	}


}
