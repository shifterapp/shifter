package byrjun.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.ShiftAllocation;
import byrjun.repository.ShiftAllocationRepository;

@Service
public class ShiftAllocationServiceImp implements ShiftAllocationService {
	
	// Connecton to the list of shiftAllocations.
		@Autowired
		ShiftAllocationRepository shiftAllocationRep;

	@Override
	public boolean checkIfShiftIsFull(int id) {
		// TODO implementa þetta fall!
		return false;
	}



	@Override
	public boolean checkIfEmployeeExcists(int id) {
		// TODO implementa þetta fall!
		return true;
	}

	@Override
	public boolean checkIfShiftExcists(int id) {
		// TODO implementa þetta fall!
		return true;
	}

	@Override
	public void addShiftAllocation(ShiftAllocation sa) {
		shiftAllocationRep.save(sa);
	}

}
