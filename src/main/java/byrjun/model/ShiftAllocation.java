package byrjun.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class holds information about a shift in the system.
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date October 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

@Entity
@Table (name = "ShiftAllocations")
public class ShiftAllocation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
	private int shiftId;
	
	public ShiftAllocation() {}

	public ShiftAllocation(int empId,int shiftId ) {
		this.empId = empId;
		this.shiftId = shiftId;
	}

	
	//Getters for emp_id and shift_id
	public int getEmpId() {
		return empId;
	}
	public int getShiftId() {
		return shiftId;
	}
	
	
	

}
