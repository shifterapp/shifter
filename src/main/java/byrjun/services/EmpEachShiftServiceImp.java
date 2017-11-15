package byrjun.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import byrjun.model.EmpEachShift;
import byrjun.repository.EmpEachShiftRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpEachShiftServiceImp implements EmpEachShiftService {
	@Autowired
	EmpEachShiftRepository empEachShiftRep;
	
	@Override
	public List<EmpEachShift> getAll(){
		return empEachShiftRep.getAll();
	}
	
	@Override
	public void add (EmpEachShift empEachShift) {
		empEachShiftRep.add(empEachShift);
	}	
	
	@Override
	public void empty() {
		empEachShiftRep.empty();
	}

}
