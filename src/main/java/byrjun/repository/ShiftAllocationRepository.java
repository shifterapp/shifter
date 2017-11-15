package byrjun.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import byrjun.model.Shift;
import byrjun.model.ShiftAllocation;

public interface ShiftAllocationRepository extends JpaRepository<ShiftAllocation, Long> {
	
	/**
	 * Returns all shiftAllocations in the app.
	 * @return list of all shiftAllocations
	 */
	LinkedList<ShiftAllocation> findAll();
	
	/**
	 * Adds an shiftAllocation to the database.
	 * @param ShiftAllocation
	 */
	ShiftAllocation save (ShiftAllocation shiftAllocation);
	
	/**
	 * Returns list of employees on that shift.
	 * @param shift Id
	 * @return list of employees
	 */
	LinkedList<ShiftAllocation> findByShiftId(Integer shiftId);
	
	LinkedList<ShiftAllocation> findByShiftIdAndEmpId(Integer shiftId, Integer empId);
	
	int countByShiftId(int id);
	
	
	
	
	

}
