package fr.inria.phoenix.diasuite.framework.datatype.agendaevent;

import java.io.Serializable;

/**
 * <pre>
structure AgendaEvent {
 * 	title as String;
 * 	description as String;
 * 	startTime as Date;
 * 	endTime as Date;
 * 	place as String;
 * 	calendar as String;
 * }
</pre>
 */
public class AgendaEvent implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field title
    private java.lang.String title;
    
    /**
     * Returns the value of the title field.
    
    <pre>
    title as String
    </pre>
    @return the value of title
     */
    public java.lang.String getTitle() {
        return title;
    }
    
    /**
     * Set the value of the title field.
    
    <pre>
    title as String
    </pre>
    @param title the new value of title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    // End of code for field title

    // Code for field description
    private java.lang.String description;
    
    /**
     * Returns the value of the description field.
    
    <pre>
    description as String
    </pre>
    @return the value of description
     */
    public java.lang.String getDescription() {
        return description;
    }
    
    /**
     * Set the value of the description field.
    
    <pre>
    description as String
    </pre>
    @param description the new value of description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    // End of code for field description

    // Code for field startTime
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime;
    
    /**
     * Returns the value of the startTime field.
    
    <pre>
    startTime as Date
    </pre>
    @return the value of startTime
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getStartTime() {
        return startTime;
    }
    
    /**
     * Set the value of the startTime field.
    
    <pre>
    startTime as Date
    </pre>
    @param startTime the new value of startTime
     */
    public void setStartTime(fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime) {
        this.startTime = startTime;
    }
    // End of code for field startTime

    // Code for field endTime
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime;
    
    /**
     * Returns the value of the endTime field.
    
    <pre>
    endTime as Date
    </pre>
    @return the value of endTime
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getEndTime() {
        return endTime;
    }
    
    /**
     * Set the value of the endTime field.
    
    <pre>
    endTime as Date
    </pre>
    @param endTime the new value of endTime
     */
    public void setEndTime(fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime) {
        this.endTime = endTime;
    }
    // End of code for field endTime

    // Code for field place
    private java.lang.String place;
    
    /**
     * Returns the value of the place field.
    
    <pre>
    place as String
    </pre>
    @return the value of place
     */
    public java.lang.String getPlace() {
        return place;
    }
    
    /**
     * Set the value of the place field.
    
    <pre>
    place as String
    </pre>
    @param place the new value of place
     */
    public void setPlace(java.lang.String place) {
        this.place = place;
    }
    // End of code for field place

    // Code for field calendar
    private java.lang.String calendar;
    
    /**
     * Returns the value of the calendar field.
    
    <pre>
    calendar as String
    </pre>
    @return the value of calendar
     */
    public java.lang.String getCalendar() {
        return calendar;
    }
    
    /**
     * Set the value of the calendar field.
    
    <pre>
    calendar as String
    </pre>
    @param calendar the new value of calendar
     */
    public void setCalendar(java.lang.String calendar) {
        this.calendar = calendar;
    }
    // End of code for field calendar

    public AgendaEvent() {
    }

    public AgendaEvent(java.lang.String title,
            java.lang.String description,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime,
            java.lang.String place,
            java.lang.String calendar) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.calendar = calendar;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
        result = prime * result + ((calendar == null) ? 0 : calendar.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AgendaEvent other = (AgendaEvent) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        if (place == null) {
            if (other.place != null)
                return false;
        } else if (!place.equals(other.place))
            return false;
        if (calendar == null) {
            if (other.calendar != null)
                return false;
        } else if (!calendar.equals(other.calendar))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AgendaEvent [" + 
            "title=" + title +", " + 
            "description=" + description +", " + 
            "startTime=" + startTime +", " + 
            "endTime=" + endTime +", " + 
            "place=" + place +", " + 
            "calendar=" + calendar +
        "]";
    }
}
