package byrjun.model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Column;
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
@Table (name = "Shifts")
public class Shift {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String title;
	private String type;
	private LocalDate date;
	private String beginTime;
	private String endTime;
//	private String limit;
	
	/**
	 * The constructor
     * @param  title of the shift
     * @param shiftType the type of the shift.
     * @param shiftDate the date of the shift
     * @param beginTime when the shift starts.
     * @param endTime when the shift ends.
     * @param limit the max number of employees on the shift.
	 * @throws ParseException
	 */
	public Shift(String title,String shiftType, String shiftDate, String beginTime, String endTime) throws ParseException {
		this.title = title;
		this.type = shiftType;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		this.date = LocalDate.parse(shiftDate, formatter);
		this.beginTime = beginTime;
		this.endTime = endTime;
//		this.limit = limit;
	}
	
	//Getters og setters for Shift.

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
//	public String getLimit() {
//		return limit;
//	}
//	
//	public void setLimit(String limit) {
//		this.limit = limit;
//	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
