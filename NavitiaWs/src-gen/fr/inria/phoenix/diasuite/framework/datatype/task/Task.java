package fr.inria.phoenix.diasuite.framework.datatype.task;

import java.io.Serializable;

/**
 * <pre>
structure Task {
 * 	id as String;
 * 	content as String;
 * 	state as TaskState;
 * }
</pre>
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field id
    private java.lang.String id;
    
    /**
     * Returns the value of the id field.
    
    <pre>
    id as String
    </pre>
    @return the value of id
     */
    public java.lang.String getId() {
        return id;
    }
    
    /**
     * Set the value of the id field.
    
    <pre>
    id as String
    </pre>
    @param id the new value of id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }
    // End of code for field id

    // Code for field content
    private java.lang.String content;
    
    /**
     * Returns the value of the content field.
    
    <pre>
    content as String
    </pre>
    @return the value of content
     */
    public java.lang.String getContent() {
        return content;
    }
    
    /**
     * Set the value of the content field.
    
    <pre>
    content as String
    </pre>
    @param content the new value of content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    // End of code for field content

    // Code for field state
    private fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state;
    
    /**
     * Returns the value of the state field.
    
    <pre>
    state as TaskState
    </pre>
    @return the value of state
     */
    public fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState getState() {
        return state;
    }
    
    /**
     * Set the value of the state field.
    
    <pre>
    state as TaskState
    </pre>
    @param state the new value of state
     */
    public void setState(fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) {
        this.state = state;
    }
    // End of code for field state

    public Task() {
    }

    public Task(java.lang.String id,
            java.lang.String content,
            fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) {
        this.id = id;
        this.content = content;
        this.state = state;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
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
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Task [" + 
            "id=" + id +", " + 
            "content=" + content +", " + 
            "state=" + state +
        "]";
    }
}
