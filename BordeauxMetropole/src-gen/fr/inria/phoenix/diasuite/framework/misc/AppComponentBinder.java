package fr.inria.phoenix.diasuite.framework.misc;

import fr.inria.diagen.core.deploy.AbstractDeploy;



/**
 * This class should be implemented to bind the implementation of the various components
 */
public abstract class AppComponentBinder extends AbstractDeploy {

    // Context instances

    // Controller instances
    
    @Override
    public void deployAll() {
        // Initialization of contexts
        // Intialization of controllers
        // Deploying contexts
        // Deploying controllers
    }
    
    @Override
    public void undeployAll() {
        // Undeploying contexts
        // Undeploying controllers
    }
    
    // Abstract binding methods for contexts
    // End of abstract binding methods for contexts
    
    // Abstract binding methods for controllers
    // End of abstract binding methods for controllers
}
