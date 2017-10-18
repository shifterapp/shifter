package byrjun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
	List<Shift> findAll();
	
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
	 * Returns shift with that id
	 * @param id of shift
	 * @return shift with that id
	 */
	Shift findById(Long id);
}
