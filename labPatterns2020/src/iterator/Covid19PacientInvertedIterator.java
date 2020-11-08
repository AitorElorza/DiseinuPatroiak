package iterator;

import java.util.List;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientInvertedIterator implements InvertedIterator {
	List<Symptom> symptoms;
	int position;

	public Covid19PacientInvertedIterator(List<Symptom> s) {
		this.symptoms = s;
		this.position=symptoms.size();
	}
	
	@Override
	public Object previous() {
		Symptom symptom=symptoms.get(position);
		position--;
		return symptom;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return position>=0;
	}

	@Override
	public void goLast() {
		position=symptoms.size();

	}

}
