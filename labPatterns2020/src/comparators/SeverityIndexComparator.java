package comparators;

import java.util.Comparator;

import domain.Symptom;

public class SeverityIndexComparator implements Comparator<Symptom> {

	@Override
	public int compare(Symptom o1, Symptom o2) {
		int s1 =o1.getSeverityIndex();
		int s2=o2.getSeverityIndex();
		if(s1>s2) {
			return 1;
		}else if(s1<s2) {
			return -1;
		}
		return 0;
	}

}
