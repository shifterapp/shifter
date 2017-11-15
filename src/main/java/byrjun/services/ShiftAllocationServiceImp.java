package byrjun.services;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Shift;
import byrjun.model.ShiftAllocation;
import byrjun.repository.ShiftAllocationRepository;

@Service
public class ShiftAllocationServiceImp implements ShiftAllocationService {
	
	// Connecton to the list of shiftAllocations.
		@Autowired
		ShiftAllocationRepository shiftAllocationRep;
		@Autowired
		EmployeeService employeeService;
		@Autowired
		ShiftService shiftService;

	@Override
	public boolean checkIfShiftIsFull(int id) {
		if(shiftAllocationRep.countByShiftId(id) <= Integer.parseInt(shiftService.getShiftById((long) id).getHowMany())-1)	
			return true;
			return false;
	}

	@Override
	public void addShiftAllocation(ShiftAllocation sa) {
		shiftAllocationRep.save(sa);
	}
	
	@Override
	public String getShiftAllocationErrorMessage(Long empId, Long shiftId) {
		String errorMessage = "";
		if(!employeeService.checkIfEmpExists(empId)) {
			errorMessage += "Starfsmaður með einkennið " + empId + " finnst ekki. <br/>";
		}
		if(!shiftService.checkIfShiftExists(shiftId)) {
			errorMessage += "Vakt með einkennið " + shiftId + " finnst ekki. <br/>";
		}
		return errorMessage;
	}

	@Override
	public boolean checkIfShiftAllocationExists(int empId, int shiftId) {
		// TODO implementa þetta fall!
		if(shiftAllocationRep.findByShiftIdAndEmpId(shiftId, empId).isEmpty())
			return true;
			return false;
	}

	@Override
	public LinkedList<ShiftAllocation> allShiftAllocations() {
		return shiftAllocationRep.findAll();
	}

	@Override
	public LinkedList<ShiftAllocation> getShiftAllocationByShiftId(Integer shiftId) {
		return shiftAllocationRep.findByShiftId(shiftId);
	}
	

}
