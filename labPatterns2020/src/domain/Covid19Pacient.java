package domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import factory.SymptomFactory;
import iterator.Covid19PacientIterator;

public class Covid19Pacient extends Observable{
	private String  name; 
	private int age;
	private Map<Symptom,Integer> symptoms=new HashMap<Symptom,Integer>();
	private SymptomFactory factory;

	public Covid19Pacient(String name, int years, SymptomFactory f) {
		this.name = name;
		this.age = years;
		this.factory=f;
	}

	public Covid19Pacient(String name, int years) {
		this.name = name;
		this.age = years;
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight(Symptom s) {
		return symptoms.get(s);
	}

	public Set<Symptom> getSymptoms() {
		return symptoms.keySet();
	}
	public Iterator<Symptom> iterator(){
		return new Covid19PacientIterator(new ArrayList<Symptom>(symptoms.keySet()));
	}
	
	public Symptom getSymptomByName(String symptomName) {
		Iterator<Symptom> i= getSymptoms().iterator();
		Symptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().equals(symptomName)) return s;
		}
		return null;	
	}

	public void addSymptom(Symptom c, Integer w){
		symptoms.put(c,w);
		setChanged();
		notifyObservers();
	}
	
	public Symptom addSymptomByName(String symptom, Integer w){
		Symptom s=getSymptomByName(symptom);
		if (s==null) {
			s=createSymptom(symptom, this.factory); 
			symptoms.put(s,w);	
			setChanged();
			notifyObservers();
		}
		return s;
	}

	public Symptom removeSymptomByName(String symptomName) {
		Symptom s=getSymptomByName(symptomName);
		System.out.println("Simptom to remove: "+s);
		if (s!=null) symptoms.remove(s);
		return s;
	}
	
	public double covidImpact() {
		double afection=0;
		double increment=0;
		double impact=0;
		
		//calculate afection
		for (Symptom c: symptoms.keySet()) {
			if (c!=null )
			   afection=afection+c.getSeverityIndex()*symptoms.get(c);
		}
		afection=afection/symptoms.size();
		
		//calculate increment
		if (getAge()>65) increment=afection*0.5;
		
		//calculate impact
		impact=afection+increment;
		return impact;
	}
	
	private Symptom createSymptom(String symptomName, SymptomFactory f) {
	    return f.createSymptom(symptomName);				
	}
}
