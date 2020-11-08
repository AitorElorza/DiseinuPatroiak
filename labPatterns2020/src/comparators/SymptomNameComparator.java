package comparators;

import java.util.Comparator;

import domain.Symptom;

public class SymptomNameComparator implements Comparator<Symptom> {


	@Override
	public int compare(Symptom o1, Symptom o2) {
		String n1=o1.getName();
		String n2=o2.getName();
		int size;
		int big=0;
		if(n1.length()>n2.length()) {
			size=n2.length();
		}else {
			size=n1.length();
		}
		for(int i=0;i<size;i++) {
			if(n1.charAt(i)>n2.charAt(i)) {
				return 1;
			}if(n1.charAt(i)<n2.charAt(i)) {
				return -1;
			}
			big++;
		}
		if(big<size) {
			return 1;
		}else if(big>size) {
			return -1;
		}
		return 0;
	}

}
