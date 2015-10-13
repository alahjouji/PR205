package fr.inria.phoenix.diasuite.framework.device.communicationservice;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device CommunicationService extends Service {
 * 	action SendMessage;
 * 	action AskQuestion;
 * 	source questionAnswer as String indexed by questionId as String;
 * 	source lastMessage as Message;
 * 	action SendTrustedMessage; 
 * 	action AskTrustedQuestion; 
 * 	source trustedQuestionAnswer as String indexed by questionId as String;
 * 	source lastTrustedMessage as Message;
 * 	source safeContacts as Contact[];
 * }
</pre>
 */
public abstract class AbstractCommunicationService extends Service {
    
    public AbstractCommunicationService(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/CommunicationService/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
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
        if (orderName.equals("askCloseTrustedQuestion")) {
            askCloseTrustedQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3],
                    (java.util.List<java.lang.String>) args[4]);
            return null;
        }
        if (orderName.equals("askCloseTrustedQuestionWithImage")) {
            askCloseTrustedQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
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
        if (orderName.equals("askOpenTrustedQuestion")) {
            askOpenTrustedQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3]);
            return null;
        }
        if (orderName.equals("askOpenTrustedQuestionWithImage")) {
            askOpenTrustedQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3],
                    (java.lang.String) args[4]);
            return null;
        }
        if (orderName.equals("sendMessage")) {
            sendMessage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File>) args[3]);
            return null;
        }
        if (orderName.equals("sendMessageWithImage")) {
            sendMessageWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3]);
            return null;
        }
        if (orderName.equals("sendTrustedMessage")) {
            sendTrustedMessage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2]);
            return null;
        }
        if (orderName.equals("sendTrustedMessageWithImage")) {
            sendTrustedMessageWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (java.lang.String) args[1],
                    (java.lang.String) args[2],
                    (java.lang.String) args[3]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("lastMessage")) {
            return getLastMessage();
        }
        if (orderName.equals("lastTrustedMessage")) {
            return getLastTrustedMessage();
        }
        if (orderName.equals("questionAnswer")) {
            return getQuestionAnswer((java.lang.String) args[0]);
        }
        if (orderName.equals("safeContacts")) {
            return getSafeContacts();
        }
        if (orderName.equals("trustedQuestionAnswer")) {
            return getTrustedQuestionAnswer((java.lang.String) args[0]);
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
    
    // Code for source lastMessage from device CommunicationService
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message _lastMessage;
    
    /**
     * Publish the value of source <code>lastMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @param newLastMessageValue the new value for the source <code>lastMessage</code>
     */
    protected void publishLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
        _lastMessage = newLastMessageValue;
        getProcessor().publishValue(getOutProperties(), "lastMessage", newLastMessageValue); 
    }
    
    /**
     * Returns the value of source <code>lastMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @return the value of the source <code>lastMessage</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastMessage() throws Exception {
        return _lastMessage;
    }
    // End of code for source lastMessage from device CommunicationService
    
    // Code for source lastTrustedMessage from device CommunicationService
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message _lastTrustedMessage;
    
    /**
     * Publish the value of source <code>lastTrustedMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastTrustedMessage as Message;
    </pre>
    @param newLastTrustedMessageValue the new value for the source <code>lastTrustedMessage</code>
     */
    protected void publishLastTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastTrustedMessageValue) {
        _lastTrustedMessage = newLastTrustedMessageValue;
        getProcessor().publishValue(getOutProperties(), "lastTrustedMessage", newLastTrustedMessageValue); 
    }
    
    /**
     * Returns the value of source <code>lastTrustedMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastTrustedMessage as Message;
    </pre>
    @return the value of the source <code>lastTrustedMessage</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastTrustedMessage() throws Exception {
        return _lastTrustedMessage;
    }
    // End of code for source lastTrustedMessage from device CommunicationService
    
    // Code for source questionAnswer from device CommunicationService
    private java.util.HashMap<QuestionAnswerIndices, java.lang.String> _questionAnswer = new java.util.HashMap<QuestionAnswerIndices, java.lang.String>();
    
    /**
     * Publish the value of source <code>questionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source questionAnswer as String indexed by questionId as String;
    </pre>
    @param newQuestionAnswerValue the new value for the source <code>questionAnswer</code>
    @param questionId the value of the index <code>questionId</code>
     */
    protected void publishQuestionAnswer(java.lang.String newQuestionAnswerValue,
            java.lang.String questionId) {
        QuestionAnswerIndices _indices_ = new QuestionAnswerIndices(questionId);
        _questionAnswer.put(_indices_, newQuestionAnswerValue);
        getProcessor().publishValue(getOutProperties(), "questionAnswer", newQuestionAnswerValue, questionId); 
    }
    
    /**
     * Returns the value of source <code>questionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source questionAnswer as String indexed by questionId as String;
    </pre>
    @param questionId the value of the index <code>questionId</code>
    @return the value of the source <code>questionAnswer</code>
     */
    protected java.lang.String getQuestionAnswer(java.lang.String questionId) throws Exception {
        return _questionAnswer.get(new QuestionAnswerIndices(questionId));
    }
    // End of code for source questionAnswer from device CommunicationService
    
    // Code for source safeContacts from device CommunicationService
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> _safeContacts;
    
    /**
     * Publish the value of source <code>safeContacts</code> from device <code>CommunicationService</code>.
    
    <pre>
    source safeContacts as Contact[];
    </pre>
    @param newSafeContactsValue the new value for the source <code>safeContacts</code>
     */
    protected void publishSafeContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newSafeContactsValue) {
        _safeContacts = newSafeContactsValue;
        getProcessor().publishValue(getOutProperties(), "safeContacts", newSafeContactsValue); 
    }
    
    /**
     * Returns the value of source <code>safeContacts</code> from device <code>CommunicationService</code>.
    
    <pre>
    source safeContacts as Contact[];
    </pre>
    @return the value of the source <code>safeContacts</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> getSafeContacts() throws Exception {
        return _safeContacts;
    }
    // End of code for source safeContacts from device CommunicationService
    
    // Code for source trustedQuestionAnswer from device CommunicationService
    private java.util.HashMap<TrustedQuestionAnswerIndices, java.lang.String> _trustedQuestionAnswer = new java.util.HashMap<TrustedQuestionAnswerIndices, java.lang.String>();
    
    /**
     * Publish the value of source <code>trustedQuestionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source trustedQuestionAnswer as String indexed by questionId as String;
    </pre>
    @param newTrustedQuestionAnswerValue the new value for the source <code>trustedQuestionAnswer</code>
    @param questionId the value of the index <code>questionId</code>
     */
    protected void publishTrustedQuestionAnswer(java.lang.String newTrustedQuestionAnswerValue,
            java.lang.String questionId) {
        TrustedQuestionAnswerIndices _indices_ = new TrustedQuestionAnswerIndices(questionId);
        _trustedQuestionAnswer.put(_indices_, newTrustedQuestionAnswerValue);
        getProcessor().publishValue(getOutProperties(), "trustedQuestionAnswer", newTrustedQuestionAnswerValue, questionId); 
    }
    
    /**
     * Returns the value of source <code>trustedQuestionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source trustedQuestionAnswer as String indexed by questionId as String;
    </pre>
    @param questionId the value of the index <code>questionId</code>
    @return the value of the source <code>trustedQuestionAnswer</code>
     */
    protected java.lang.String getTrustedQuestionAnswer(java.lang.String questionId) throws Exception {
        return _trustedQuestionAnswer.get(new TrustedQuestionAnswerIndices(questionId));
    }
    // End of code for source trustedQuestionAnswer from device CommunicationService
    
    /**
     * Implement this method to define the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService.
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
     * defined in device CommunicationService.
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
     * Implement this method to define the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     */
    protected abstract void askCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers) throws Exception;
    
    /**
     * Implement this method to define the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     * @param image parameter 6 of the order.
     */
    protected abstract void askCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers,
            java.lang.String image) throws Exception;
    
    /**
     * Implement this method to define the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService.
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
     * defined in device CommunicationService.
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
    
    /**
     * Implement this method to define the <code>askOpenTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    askOpenTrustedQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     */
    protected abstract void askOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) throws Exception;
    
    /**
     * Implement this method to define the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param image parameter 5 of the order.
     */
    protected abstract void askOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) throws Exception;
    
    /**
     * Implement this method to define the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param attachments parameter 4 of the order.
     */
    protected abstract void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws Exception;
    
    /**
     * Implement this method to define the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param image parameter 4 of the order.
     */
    protected abstract void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) throws Exception;
    
    /**
     * Implement this method to define the <code>sendTrustedMessage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    sendTrustedMessage(to as Contact, title as String, content as String );
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     */
    protected abstract void sendTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) throws Exception;
    
    /**
     * Implement this method to define the <code>sendTrustedMessageWithImage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService.
     * 
    
    <pre>
    sendTrustedMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param image parameter 4 of the order.
     */
    protected abstract void sendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) throws Exception;
}
