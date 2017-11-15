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
	/*
	@Modifying//(clearAutomatically = true)
	@Query("UPDATE shift_allocation SET emp_id = :empId2 WHERE emp_id = :empId1 AND shift_id = :shiftId1")
	ShiftSwitch changeEmpOnShift (@Param("emp_id")int empId1, @Param("emp_id")int empId2, @Param("shift_id")int shiftId1);
	*/
	@Transactional
	void deleteByEmpIdAndShiftId(int emp_Id, int shift_Id);
}
