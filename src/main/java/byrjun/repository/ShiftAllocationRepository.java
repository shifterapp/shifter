package byrjun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import byrjun.model.ShiftAllocation;

public interface ShiftAllocationRepository extends JpaRepository<ShiftAllocation, Long> {
	
	/**
	 * Returns all shiftAllocations in the app.
	 * @return list of all shiftAllocations
	 */
	List<ShiftAllocation> findAll();
	
	/**
	 * Adds an shiftAllocation to the database.
	 * @param ShiftAllocation
	 */
	ShiftAllocation save (ShiftAllocation shiftAllocation);
	

}
