package adapter;

import java.util.ArrayList;
import java.util.List;

import domain.Covid19Pacient;

public class Covid19PacientInvertedIteratorAdapter implements InvertedIterator{
	
	private List<String> s;
	private Covid19Pacient pacient;
	private int last =s.size();


	@Override
	public Object previous() {
		last--;
		return s.get(last);
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return this.last >0;
	}

	@Override
	public void goLast() {
		last= s.size();
		
	}

}
