package fr.inria.phoenix.diasuite.framework.device.communicationservice;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>questionAnswer</code> from device <code>CommunicationService</code>.

<pre>
source questionAnswer as String indexed by questionId as String;
</pre>
 */
public final class QuestionAnswerIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public QuestionAnswerIndices(java.lang.String questionId) {
        this._questionId = questionId;
    }
    
    // Code for index questionId
    private java.lang.String _questionId;
    
    /**
     * Get the <code>questionId</code> index
     * 
     * @return the value of the <code>questionId</code> index
     */
    public java.lang.String questionId() {
        return _questionId;
    }
    
    /**
     * Set the <code>questionId</code> index
     * 
     * @param newQuestionId the new value for the <code>questionId</code> index
     */
    public void setQuestionId(java.lang.String newQuestionId) {
        this._questionId = newQuestionId;
    }
    // End of code for index questionId
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_questionId == null) ? 0 : _questionId.hashCode());
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
        QuestionAnswerIndices other = (QuestionAnswerIndices) obj;
        if (_questionId == null) {
            if (other._questionId != null)
                return false;
        } else if (!_questionId.equals(other._questionId))
            return false;
        return true;
    }
}
