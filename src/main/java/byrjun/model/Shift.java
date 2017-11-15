package byrjun.model;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import byrjun.constraints.ShiftDateConstraint;

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
    @Column(name="shift_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Vinsamlegast fyllið út titil vaktar.")
    @NotEmpty(message = "Vinsamlegast fyllið út titil vaktar.")
	private String title;
    @NotNull(message = "Vinsamlegast fyllið út týpu vaktar.")
    @NotEmpty(message = "Vinsamlegast fyllið út týpu vaktar.")
	private String type;
    @NotNull(message = "Vinsamlegast fyllið út dagsetningu.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ShiftDateConstraint(message = "Dagsetning má ekki vera liðin.")
	private LocalDate date;
    @NotNull(message = "Vinsamlegast fyllið út upphafstíma.")
    @DateTimeFormat(iso = ISO.TIME)
	private LocalTime beginTime;
    @NotNull(message = "Vinsamlegast fyllið út lokatíma.")
    @DateTimeFormat(iso = ISO.TIME)
	private LocalTime endTime;
    @NotNull(message = "Vinsamlegast tilgreinið fjöldatakmörkun.")
    @NotEmpty(message = "Vinsamlegast tilgreinið fjöldatakmörkun.")
	private String howMany;

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
	public Shift() {
		
	}
	
	public Shift(String title,String shiftType, String shiftDate, String beginTime, String endTime, String howMany) throws ParseException {
		this.title = title;
		this.type = shiftType;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		this.date = LocalDate.parse(shiftDate, formatter);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		this.beginTime = LocalTime.parse(beginTime, timeFormatter);
		this.endTime = LocalTime.parse(endTime, timeFormatter);
		this.howMany = howMany;
	}
	 
	//Getters og setters for Shift.
	
	public Long getId(){
		return id;
	}

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
	
	public LocalTime getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(LocalTime beginTime) {
		this.beginTime = beginTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getHowMany() {
		return howMany;
	}

	public void setHowMany(String howMany) {
		this.howMany = howMany;
	}

}
