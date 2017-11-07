package byrjun.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import byrjun.model.Employee;

/**
 * The class holds information about all shifts in the app.
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

import byrjun.model.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
	
	/**
	 * Returns all shifts in the app.
	 * @return list of all employees.
	 */
	LinkedList<Shift> findAll();
	
	/**
	 * Adds a shift to the database.
	 * @param Shift
	 */
	Shift save (Shift shift);
	
	/**
	 * Returns list of shifts with that title.
	 * @param title of shift
	 * @return list of shifts with that title.
	 */
	List<Shift> findByTitle(String title);
	
	/**
	 * Use findEmployee instead
	 */
	LinkedList<Shift> findByTitleContainingIgnoreCaseOrTypeContainingIgnoreCase(String title,  String type);
	
	/**
	 * Finds employee by name and returns that employees.
	 * @param nafn
	 * @return list of employees with that name. 
	 */
	default LinkedList<Shift> findShift(String title, String type){
	return findByTitleContainingIgnoreCaseOrTypeContainingIgnoreCase(title, type);
	}
	
	/**
	 * Returns shift with that id
	 * @param id of shift
	 * @return shift with that id
	 */
	Shift findById(Long id);
	
	/**
	 * Returns true if shift with given id exists.
	 * @param id of shift
	 * @return boolean value which states if shift with that id exists or not.
	 */
	boolean exists(Long id);
}
