package byrjun.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Employee;
import byrjun.model.Shift;
import byrjun.repository.ShiftRepository;

/**
 * Implementation for the ValidationService class. 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

@Service
public class ShiftServiceImp implements ShiftService {
	
	// Connecton to the list of shifts
	@Autowired
	ShiftRepository shiftRep;
	
	
	@Override
	public boolean dateNotEmpty(String date){
		if(date.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	
	@Override 
	public String getShiftErrorMessage(String date,String beginTime,String endTime,String shiftTitle,String howMany) {
	String errorMessage = "";
	if(!dateNotEmpty(date)) {
		errorMessage += "Vinsamlegast fylltu inn dagsetningu vaktarinnar. <br/>";
	}
	
	if(!beginTimeNotEmpty(beginTime)){
		errorMessage += "Vinsamlegast fylltu inn upphafstíma vaktarinnar. <br/>";
	}
	if(!endTimeNotEmpty(endTime)){
		errorMessage += "Vinsamlegast fylltu inn endatíma vaktarinnar. <br/>";
	}
	if(!shiftTitleNotEmpty(shiftTitle)){
		errorMessage += "Vinsamlegast settu titil á vaktina. <br/>";
		
	}
	if(!howManyNotEmpty(howMany)){
		errorMessage += "Vinsamlegast settu fjölda starfsmanna á vaktina <br/>";
	}
	return errorMessage;
	}
	
	
	
	@Override
	public boolean beginTimeNotEmpty(String beginTime){
		if(beginTime== ""){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean endTimeNotEmpty(String endTime){
		if(endTime == ""){
			return false;
		}
		return true;
	}
	@Override
	public boolean shiftTitleNotEmpty(String shiftTitle){
		if(shiftTitle == ""){
			return false;
		}
		return true;
		
	}
	@Override
	public boolean howManyNotEmpty(String howMany){
		if(howMany ==""){
			return false;
		}
		return true;
	}

	@Override
	public void addShift(Shift s) {
		shiftRep.save(s);
		
	}

	@Override
	public LinkedList<Shift> allShifts() {
		return (LinkedList<Shift>) shiftRep.findAll();
	}
	
	@Override 
	public Shift getShiftById(Long shiftId) {
		return shiftRep.findById(shiftId);
	}
	
	@Override
	public boolean checkIfShiftExists(Long shiftId) {
		return shiftRep.exists(shiftId);
	}
	
	@Override
	public LinkedList<Shift> searchForShift(String title, String type) {
		LinkedList<Shift> shifts = shiftRep.findShift(title, type);
		return shifts;
	}


	@Override
	public int countShifts() {
		return (int) shiftRep.count();
	}
}
