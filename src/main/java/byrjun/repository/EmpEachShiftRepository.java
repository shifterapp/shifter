package byrjun.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import byrjun.model.EmpEachShift;

@Repository
public class EmpEachShiftRepository {
	
	private final List<EmpEachShift> empEachShiftList;
	
	public EmpEachShiftRepository() {
		this.empEachShiftList = new ArrayList<EmpEachShift>();
	}
	
	/**
	 * Returns all employees on spesiffic shift.
	 * @return list of all objects that includes information about each shift and employees that are registered one it.
	 */
	public List<EmpEachShift> getAll(){
		return empEachShiftList;
	}
	
	/**
	 * Adds an object that includes information about shift and all employees that are registered on it.
	 * @param EmpEachShift, the object that holds the information.
	 */
	public void add (EmpEachShift empEachShift) {
		empEachShiftList.add(empEachShift);
	}
	
	/**
	 * Empties the repository
	 */
	public void empty() {
		empEachShiftList.clear();
	}

}
