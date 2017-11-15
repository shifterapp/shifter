package byrjun.model;

public class ShiftSwitch {
	Integer empId1;
	Integer empId2;
	Integer shiftId1;
	Integer shiftId2;
	
	public ShiftSwitch() {
		
	}
	
	public ShiftSwitch(Integer empId1,Integer shiftId1, Integer empId2, Integer shiftId2){
		this.empId1 = empId1;
		this.empId2 = empId2;
		this.shiftId1 = shiftId1;
		this.shiftId2 = shiftId2;
	}

	public Integer getEmpId1() {
		return empId1;
	}

	public void setEmpId1(Integer empId1) {
		this.empId1 = empId1;
	}

	public Integer getEmpId2() {
		return empId2;
	}

	public void setEmpId2(Integer empId2) {
		this.empId2 = empId2;
	}

	public Integer getShiftId1() {
		return shiftId1;
	}

	public void setShiftId1(Integer shiftId1) {
		this.shiftId1 = shiftId1;
	}

	public Integer getShiftId2() {
		return shiftId2;
	}

	public void setShiftId2(Integer shiftId2) {
		this.shiftId2 = shiftId2;
	}
	
}
