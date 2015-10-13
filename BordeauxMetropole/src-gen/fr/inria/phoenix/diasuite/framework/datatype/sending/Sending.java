package fr.inria.phoenix.diasuite.framework.datatype.sending;

import java.io.Serializable;

/**
 * <pre>
structure Sending {
 *  	journeys as String[];
 *  	times as String[];
 *  }
</pre>
 */
public class Sending implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field journeys
    private java.util.List<java.lang.String> journeys;
    
    /**
     * Returns the value of the journeys field.
    
    <pre>
    journeys as String[]
    </pre>
    @return the value of journeys
     */
    public java.util.List<java.lang.String> getJourneys() {
        return journeys;
    }
    
    /**
     * Set the value of the journeys field.
    
    <pre>
    journeys as String[]
    </pre>
    @param journeys the new value of journeys
     */
    public void setJourneys(java.util.List<java.lang.String> journeys) {
        this.journeys = journeys;
    }
    // End of code for field journeys

    // Code for field times
    private java.util.List<java.lang.String> times;
    
    /**
     * Returns the value of the times field.
    
    <pre>
    times as String[]
    </pre>
    @return the value of times
     */
    public java.util.List<java.lang.String> getTimes() {
        return times;
    }
    
    /**
     * Set the value of the times field.
    
    <pre>
    times as String[]
    </pre>
    @param times the new value of times
     */
    public void setTimes(java.util.List<java.lang.String> times) {
        this.times = times;
    }
    // End of code for field times

    public Sending() {
    }

    public Sending(java.util.List<java.lang.String> journeys,
            java.util.List<java.lang.String> times) {
        this.journeys = journeys;
        this.times = times;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((journeys == null) ? 0 : journeys.hashCode());
        result = prime * result + ((times == null) ? 0 : times.hashCode());
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
        Sending other = (Sending) obj;
        if (journeys == null) {
            if (other.journeys != null)
                return false;
        } else if (!journeys.equals(other.journeys))
            return false;
        if (times == null) {
            if (other.times != null)
                return false;
        } else if (!times.equals(other.times))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sending [" + 
            "journeys=" + journeys +", " + 
            "times=" + times +
        "]";
    }
}
