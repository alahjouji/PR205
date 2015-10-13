package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.communicationservice.AbstractCommunicationService;
import fr.inria.phoenix.diasuite.framework.device.communicationservice.QuestionAnswerIndices;
import fr.inria.phoenix.diasuite.framework.device.communicationservice.TrustedQuestionAnswerIndices;

// @internal
public final class CommunicationServiceMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractCommunicationService {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastMessage() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.message.Message result = __lastMessage;
            if(result == null)
                return super.getLastMessage();
            return result;
        }
        
        public void _publishLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
            publishLastMessage(newLastMessageValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastTrustedMessage() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.message.Message result = __lastTrustedMessage;
            if(result == null)
                return super.getLastTrustedMessage();
            return result;
        }
        
        public void _publishLastTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastTrustedMessageValue) {
            publishLastTrustedMessage(newLastTrustedMessageValue);
        }
        
        protected java.lang.String getQuestionAnswer(java.lang.String questionId) throws Exception {
            java.lang.String result = __questionAnswer.get(new QuestionAnswerIndices(questionId));
            if(result == null)
                return super.getQuestionAnswer(questionId);
            return result;
        }
        
        public void _publishQuestionAnswer(java.lang.String newQuestionAnswerValue,
                java.lang.String questionId) {
            publishQuestionAnswer(newQuestionAnswerValue,
                questionId);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> getSafeContacts() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> result = __safeContacts;
            if(result == null)
                return super.getSafeContacts();
            return result;
        }
        
        public void _publishSafeContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newSafeContactsValue) {
            publishSafeContacts(newSafeContactsValue);
        }
        
        protected java.lang.String getTrustedQuestionAnswer(java.lang.String questionId) throws Exception {
            java.lang.String result = __trustedQuestionAnswer.get(new TrustedQuestionAnswerIndices(questionId));
            if(result == null)
                return super.getTrustedQuestionAnswer(questionId);
            return result;
        }
        
        public void _publishTrustedQuestionAnswer(java.lang.String newTrustedQuestionAnswerValue,
                java.lang.String questionId) {
            publishTrustedQuestionAnswer(newTrustedQuestionAnswerValue,
                questionId);
        }
        
        protected void askCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content,
                java.util.List<java.lang.String> possibleAnswers) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askCloseQuestion");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __action.add(possibleAnswers);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content,
                java.util.List<java.lang.String> possibleAnswers,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askCloseQuestionWithImage");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __action.add(possibleAnswers);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content,
                java.util.List<java.lang.String> possibleAnswers) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askCloseTrustedQuestion");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __action.add(possibleAnswers);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content,
                java.util.List<java.lang.String> possibleAnswers,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askCloseTrustedQuestionWithImage");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __action.add(possibleAnswers);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askOpenQuestion");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askOpenQuestionWithImage");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askOpenTrustedQuestion");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void askOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String questionId,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("askOpenTrustedQuestionWithImage");
                __action.add(to);
                __action.add(questionId);
                __action.add(title);
                __action.add(content);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendMessage");
                __action.add(to);
                __action.add(title);
                __action.add(content);
                __action.add(attachments);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendMessageWithImage");
                __action.add(to);
                __action.add(title);
                __action.add(content);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendTrustedMessage");
                __action.add(to);
                __action.add(title);
                __action.add(content);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendTrustedMessageWithImage");
                __action.add(to);
                __action.add(title);
                __action.add(content);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    CommunicationServiceMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source lastMessage from device CommunicationService
    /**
     * Publish the value of source <code>lastMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @param newLastMessageValue the new value for the source <code>lastMessage</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock lastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
        proxy._publishLastMessage(newLastMessageValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message __lastMessage = null;
    /**
     * Set the value (without publication) of source <code>lastMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @param newLastMessageValue the new value for the source <code>lastMessage</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock setLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
        __lastMessage = newLastMessageValue;
        return this;
    }
    // End of code for source lastMessage from device CommunicationService
    
    // Code for source lastTrustedMessage from device CommunicationService
    /**
     * Publish the value of source <code>lastTrustedMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastTrustedMessage as Message;
    </pre>
    @param newLastTrustedMessageValue the new value for the source <code>lastTrustedMessage</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock lastTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastTrustedMessageValue) {
        proxy._publishLastTrustedMessage(newLastTrustedMessageValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message __lastTrustedMessage = null;
    /**
     * Set the value (without publication) of source <code>lastTrustedMessage</code> from device <code>CommunicationService</code>.
    
    <pre>
    source lastTrustedMessage as Message;
    </pre>
    @param newLastTrustedMessageValue the new value for the source <code>lastTrustedMessage</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock setLastTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastTrustedMessageValue) {
        __lastTrustedMessage = newLastTrustedMessageValue;
        return this;
    }
    // End of code for source lastTrustedMessage from device CommunicationService
    
    // Code for source questionAnswer from device CommunicationService
    /**
     * Publish the value of source <code>questionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source questionAnswer as String indexed by questionId as String;
    </pre>
    @param newQuestionAnswerValue the new value for the source <code>questionAnswer</code>
    @param questionId the value of the index <code>questionId</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock questionAnswer(java.lang.String newQuestionAnswerValue,
            java.lang.String questionId) {
        proxy._publishQuestionAnswer(newQuestionAnswerValue,
            questionId);
        return this;
    }
    
    private java.util.HashMap<QuestionAnswerIndices, java.lang.String> __questionAnswer = new java.util.HashMap<QuestionAnswerIndices, java.lang.String>();
    /**
     * Set the value (without publication) of source <code>questionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source questionAnswer as String indexed by questionId as String;
    </pre>
    @param newQuestionAnswerValue the new value for the source <code>questionAnswer</code>
    @param questionId the value of the index <code>questionId</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock setQuestionAnswer(java.lang.String newQuestionAnswerValue,
            java.lang.String questionId) {
        QuestionAnswerIndices _indices_ = new QuestionAnswerIndices(questionId);
        __questionAnswer.put(_indices_, newQuestionAnswerValue);
        return this;
    }
    // End of code for source questionAnswer from device CommunicationService
    
    // Code for source safeContacts from device CommunicationService
    /**
     * Publish the value of source <code>safeContacts</code> from device <code>CommunicationService</code>.
    
    <pre>
    source safeContacts as Contact[];
    </pre>
    @param newSafeContactsValue the new value for the source <code>safeContacts</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock safeContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newSafeContactsValue) {
        proxy._publishSafeContacts(newSafeContactsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> __safeContacts = null;
    /**
     * Set the value (without publication) of source <code>safeContacts</code> from device <code>CommunicationService</code>.
    
    <pre>
    source safeContacts as Contact[];
    </pre>
    @param newSafeContactsValue the new value for the source <code>safeContacts</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock setSafeContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newSafeContactsValue) {
        __safeContacts = newSafeContactsValue;
        return this;
    }
    // End of code for source safeContacts from device CommunicationService
    
    // Code for source trustedQuestionAnswer from device CommunicationService
    /**
     * Publish the value of source <code>trustedQuestionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source trustedQuestionAnswer as String indexed by questionId as String;
    </pre>
    @param newTrustedQuestionAnswerValue the new value for the source <code>trustedQuestionAnswer</code>
    @param questionId the value of the index <code>questionId</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock trustedQuestionAnswer(java.lang.String newTrustedQuestionAnswerValue,
            java.lang.String questionId) {
        proxy._publishTrustedQuestionAnswer(newTrustedQuestionAnswerValue,
            questionId);
        return this;
    }
    
    private java.util.HashMap<TrustedQuestionAnswerIndices, java.lang.String> __trustedQuestionAnswer = new java.util.HashMap<TrustedQuestionAnswerIndices, java.lang.String>();
    /**
     * Set the value (without publication) of source <code>trustedQuestionAnswer</code> from device <code>CommunicationService</code>.
    
    <pre>
    source trustedQuestionAnswer as String indexed by questionId as String;
    </pre>
    @param newTrustedQuestionAnswerValue the new value for the source <code>trustedQuestionAnswer</code>
    @param questionId the value of the index <code>questionId</code>
    @return this for fluent interface
     */
    public CommunicationServiceMock setTrustedQuestionAnswer(java.lang.String newTrustedQuestionAnswerValue,
            java.lang.String questionId) {
        TrustedQuestionAnswerIndices _indices_ = new TrustedQuestionAnswerIndices(questionId);
        __trustedQuestionAnswer.put(_indices_, newTrustedQuestionAnswerValue);
        return this;
    }
    // End of code for source trustedQuestionAnswer from device CommunicationService
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestion() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestion".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!possibleAnswers.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestionWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!possibleAnswers.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
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
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!possibleAnswers.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestion() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestion".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestion(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!possibleAnswers.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestionWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askCloseTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, possibleAnswers as String[], image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param possibleAnswers parameter 5 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!possibleAnswers.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askCloseTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
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
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.util.List<java.lang.String> possibleAnswers,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askCloseTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!possibleAnswers.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestion() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestion".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestionWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestionWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenQuestionWithImage</code> order from the <code>AskQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param image parameter 5 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askOpenTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestion() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestion".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestion</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestion(to as Contact, questionId as String, title as String, content as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestion".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestionWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAskOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>askOpenTrustedQuestionWithImage</code> order from the <code>AskTrustedQuestion</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    askOpenTrustedQuestionWithImage(to as Contact, questionId as String, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param questionId parameter 2 of the order.
     * @param title parameter 3 of the order.
     * @param content parameter 4 of the order.
     * @param image parameter 5 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAskOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String questionId,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("askOpenTrustedQuestionWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!questionId.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param attachments parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!attachments.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param image parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendTrustedMessage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessage(to as Contact, title as String, content as String );
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessage(to as Contact, title as String, content as String );
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessage(to as Contact, title as String, content as String );
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessage(to as Contact, title as String, content as String );
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendTrustedMessageWithImage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessageWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessageWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessageWithImage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessageWithImage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessageWithImage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendTrustedMessageWithImage</code> order from the <code>SendTrustedMessage</code> action
     * defined in device CommunicationService was called.
     * 
    
    <pre>
    sendTrustedMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param image parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendTrustedMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
