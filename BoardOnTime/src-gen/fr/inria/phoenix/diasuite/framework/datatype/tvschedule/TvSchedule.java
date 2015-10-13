package fr.inria.phoenix.diasuite.framework.datatype.tvschedule;

import java.io.Serializable;

/**
 * <pre>
structure TvSchedule {
 * 	title as String;
 * 	description as String;
 * 	genre as String;
 * 	startTime as Date;
 * 	endTime as Date;
 * 	channel as String;
 * }
</pre>
 */
public class TvSchedule implements Serializable {
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

    // Code for field genre
    private java.lang.String genre;
    
    /**
     * Returns the value of the genre field.
    
    <pre>
    genre as String
    </pre>
    @return the value of genre
     */
    public java.lang.String getGenre() {
        return genre;
    }
    
    /**
     * Set the value of the genre field.
    
    <pre>
    genre as String
    </pre>
    @param genre the new value of genre
     */
    public void setGenre(java.lang.String genre) {
        this.genre = genre;
    }
    // End of code for field genre

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

    // Code for field channel
    private java.lang.String channel;
    
    /**
     * Returns the value of the channel field.
    
    <pre>
    channel as String
    </pre>
    @return the value of channel
     */
    public java.lang.String getChannel() {
        return channel;
    }
    
    /**
     * Set the value of the channel field.
    
    <pre>
    channel as String
    </pre>
    @param channel the new value of channel
     */
    public void setChannel(java.lang.String channel) {
        this.channel = channel;
    }
    // End of code for field channel

    public TvSchedule() {
    }

    public TvSchedule(java.lang.String title,
            java.lang.String description,
            java.lang.String genre,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime,
            java.lang.String channel) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.startTime = startTime;
        this.endTime = endTime;
        this.channel = channel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((channel == null) ? 0 : channel.hashCode());
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
        TvSchedule other = (TvSchedule) obj;
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
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
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
        if (channel == null) {
            if (other.channel != null)
                return false;
        } else if (!channel.equals(other.channel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TvSchedule [" + 
            "title=" + title +", " + 
            "description=" + description +", " + 
            "genre=" + genre +", " + 
            "startTime=" + startTime +", " + 
            "endTime=" + endTime +", " + 
            "channel=" + channel +
        "]";
    }
}
