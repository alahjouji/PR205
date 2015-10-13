package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.tvprompter.AbstractTvPrompter;
import fr.inria.phoenix.diasuite.framework.device.tvprompter.AnswerIndices;

// @internal
public final class TvPrompterMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTvPrompter {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String locationValue,
                java.lang.String userValue) {
            super(serviceConfiguration, idValue, locationValue, userValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateLocation(java.lang.String newLocationValue) {
            updateLocation(newLocationValue);
        }
        
        public void _updateUser(java.lang.String newUserValue) {
            updateUser(newUserValue);
        }
        
        protected java.lang.String getAnswer(java.lang.String questionId) throws Exception {
            java.lang.String result = __answer.get(new AnswerIndices(questionId));
            if(result == null)
                return super.getAnswer(questionId);
            return result;
        }
        
        public void _publishAnswer(java.lang.String newAnswerValue,
                java.lang.String questionId) {
            publishAnswer(newAnswerValue,
                questionId);
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
    }
    
    Proxy proxy;
    
    TvPrompterMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, locationValue, userValue);
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
    public TvPrompterMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute location from device PhysicalDevice
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
    @return this for fluent interface
     */
    public TvPrompterMock location(java.lang.String newLocationValue) {
        proxy._updateLocation(newLocationValue);
        return this;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute user from device PhysicalDevice
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
    @return this for fluent interface
     */
    public TvPrompterMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source answer from device Prompter
    /**
     * Publish the value of source <code>answer</code> from device <code>Prompter</code>.
    
    <pre>
    source answer as String indexed by questionId as String;
    </pre>
    @param newAnswerValue the new value for the source <code>answer</code>
    @param questionId the value of the index <code>questionId</code>
    @return this for fluent interface
     */
    public TvPrompterMock answer(java.lang.String newAnswerValue,
            java.lang.String questionId) {
        proxy._publishAnswer(newAnswerValue,
            questionId);
        return this;
    }
    
    private java.util.HashMap<AnswerIndices, java.lang.String> __answer = new java.util.HashMap<AnswerIndices, java.lang.String>();
    /**
     * Set the value (without publication) of source <code>answer</code> from device <code>Prompter</code>.
    
    <pre>
    source answer as String indexed by questionId as String;
    </pre>
    @param newAnswerValue the new value for the source <code>answer</code>
    @param questionId the value of the index <code>questionId</code>
    @return this for fluent interface
     */
    public TvPrompterMock setAnswer(java.lang.String newAnswerValue,
            java.lang.String questionId) {
        AnswerIndices _indices_ = new AnswerIndices(questionId);
        __answer.put(_indices_, newAnswerValue);
        return this;
    }
    // End of code for source answer from device Prompter
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public TvPrompterMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TvPrompterMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>askCloseQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * Check that the <code>askOpenQuestion</code> order from the <code>AskQuestion</code> action
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
     * defined in device Prompter was called.
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
}
