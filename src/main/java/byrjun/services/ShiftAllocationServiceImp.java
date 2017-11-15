package byrjun.services;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Shift;
import byrjun.model.ShiftAllocation;
import byrjun.model.ShiftSwitch;
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
	
	@Override
	public void switchShifts(ShiftSwitch switchShifts){
		
		ShiftAllocation change1 = new ShiftAllocation();
		ShiftAllocation change2 = new ShiftAllocation();
		
		change1.setEmpId(switchShifts.getEmpId1());
		
		change1.setShiftId(switchShifts.getShiftId2());
		
		change2.setEmpId(switchShifts.getEmpId2());
		
		change2.setShiftId(switchShifts.getShiftId1());
		
		shiftAllocationRep.save(change1);
		shiftAllocationRep.save(change2);
		shiftAllocationRep.deleteByEmpIdAndShiftId(switchShifts.getEmpId1(), switchShifts.getShiftId1());
		shiftAllocationRep.deleteByEmpIdAndShiftId(switchShifts.getEmpId2(), switchShifts.getShiftId2());
		
	}

}
