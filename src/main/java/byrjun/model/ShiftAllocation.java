package byrjun.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The class holds information about a shift in the system.
 * 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date October 2017 HBV 501G Hugbúnaðarverkefni Háskóli Íslands
 */

@Entity
@Table(name = "ShiftAllocations")
public class ShiftAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Vinsamlegast gefið upp auðkenni starfsmanns.")
	private Integer empId;
	@NotNull(message = "Vinsamlegast gefið upp auðkenni vaktar.")
	private Integer shiftId;

	public ShiftAllocation() {
	}

	// Getters for emp_id and shift_id
	public Integer getEmpId() {
		return empId;
	}

	public Integer getShiftId() {
		return shiftId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}

}
