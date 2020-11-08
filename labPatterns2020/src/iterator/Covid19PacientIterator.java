package iterator;

import java.util.Iterator;
import java.util.List;

import domain.Symptom;

public class Covid19PacientIterator implements Iterator{
	List<Symptom> symptoms;
	int position=0;

	public Covid19PacientIterator(List<Symptom> s) {
		this.symptoms = s;
	}

	@Override
	public boolean hasNext() {
		return position<symptoms.size();
	}

	@Override
	public Object next() {
		Symptom symptom=symptoms.get(position);
		position++;
		return symptom;
	}

}
