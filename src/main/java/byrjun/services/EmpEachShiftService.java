package byrjun.services;

import java.util.List;

import byrjun.model.EmpEachShift;

public interface EmpEachShiftService {

	/**
	 * Returns all employees on spesiffic shift.
	 * @return list of all objects that includes information about each shift and employees that are registered one it.
	 */
	public List<EmpEachShift> getAll();

	/**
	 * Adds an object that includes information about shift and all employees that are registered on it.
	 * @param EmpEachShift, the object that holds the information.
	 */
	public void add(EmpEachShift empEachShift);

	/**
	 * Empties the repository
	 */
	public void empty();
	
	

}
