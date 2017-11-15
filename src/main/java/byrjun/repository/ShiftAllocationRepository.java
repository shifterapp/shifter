package byrjun.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import byrjun.model.Shift;
import byrjun.model.ShiftAllocation;
import byrjun.model.ShiftSwitch;

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


	@Transactional
	void deleteByEmpIdAndShiftId(int emp_Id, int shift_Id);
	
	LinkedList<ShiftAllocation> findByShiftIdAndEmpId(Integer shiftId, Integer empId);
	
	int countByShiftId(int id);
	
}
