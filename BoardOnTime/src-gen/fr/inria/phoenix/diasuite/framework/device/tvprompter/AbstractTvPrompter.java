package fr.inria.phoenix.diasuite.framework.device.tvprompter;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device TvPrompter extends Prompter {
 * }
</pre>
 */
public abstract class AbstractTvPrompter extends Service {
    
    public AbstractTvPrompter(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/Prompter/TvPrompter/", serviceConfiguration);
        updateId(idValue);
        updateLocation(locationValue);
        updateUser(userValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("location", _location);
        attributes.put("user", _user);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("askCloseQuestion")) {
            askCloseQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3],
                    (java.util.List<java.lang.String>) args[4]);
            return null;
        }
        if (orderName.equals("askCloseQuestionWithImage")) {
            askCloseQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3],
                    (java.util.List<java.lang.String>) args[4],
                    (java.lang.String) args[5]);
            return null;
        }
        if (orderName.equals("askOpenQuestion")) {
            askOpenQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3]);
            return null;
        }
        if (orderName.equals("askOpenQuestionWithImage")) {
            askOpenQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3],
                    (java.lang.String) args[4]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("location")) {
            return _location;
        }
        if (orderName.equals("user")) {
            return _user;
        }
        if (orderName.equals("answer")) {
            return getAnswer((java.lang.String) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute location from device PhysicalDevice
    private java.lang.String _location;
    
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
     */
    protected void updateLocation(java.lang.String newLocationValue) {
        if (_location != newLocationValue) {
            _location = newLocationValue;
            updateAttribute("location", newLocationValue);
        }
    }
    
    /**
     * Returns the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @return the value of <code>location</code>
     */
    public java.lang.String getLocation() {
        return _location;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute user from device PhysicalDevice
    private java.lang.String _user;
    
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
     */
    protected void updateUser(java.lang.String newUserValue) {
        if (_user != newUserValue) {
            _user = newUserValue;
            updateAttribute("user", newUserValue);
        }
    }
    
    /**
     * Returns the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @return the value of <code>user</code>
     */
    public java.lang.String getUser() {
        return _user;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source answer from device Prompter
    private java.util.HashMap<AnswerIndices, java.lang.String> _answer = new java.util.HashMap<AnswerIndices, java.lang.String>();
    
    /**
     * Publish the value of source <code>answer</code> from device <code>Prompter</code>.
    
    <pre>
    source answer as String indexed by questionId as String;
    </pre>
    @param newAnswerValue the new value for the source <code>answer</code>
    @param questionId the value of the index <code>questionId</code>
     */
    protected void publishAnswer(java.lang.String newAnswerValue,
            java.lang.String questionId) {
        AnswerIndices _indices_ = new AnswerIndices(questionId);
        _answer.put(_indices_, newAnswerValue);
        getProcessor().publishValue(getOutProperties(), "answer", newAnswerValue, questionId); 
    }
    
    /**
     * Returns the value of source <code>answer</code> from device <code>Prompter</code>.
    
    <pre>
    source answer as String indexed by questionId as String;
    </pre>
    @param questionId the value of the index <code>questionId</code>
    @return the value of the source <code>answer</code>
     */
    protected java.lang.String getAnswer(java.lang.String questionId) throws Exception {
        return _answer.get(new AnswerIndices(questionId));
    }
    // End of code for source answer from device Prompter
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    /**
     * Implement this method to define the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device Prompter.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     */
    protected abstract void askCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers) throws Exception;
    
    /**
     * Implement this method to define the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device Prompter.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     * @param image parameter 6 of the order.
     */
    protected abstract void askCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers,
            java.lang.String image) throws Exception;
    
    /**
     * Implement this method to define the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device Prompter.
     * 
    
    <pre>
    askOpenQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     */
    protected abstract void askOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) throws Exception;
    
    /**
     * Implement this method to define the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device Prompter.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param image parameter 5 of the order.
     */
    protected abstract void askOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) throws Exception;
}
