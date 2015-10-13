package fr.inria.phoenix.scenario.boardontime.impl.context;

import java.util.ArrayList;
import java.util.List;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection;
import fr.inria.phoenix.diasuite.framework.context.journeycomputer.JourneyComputerValue;
import fr.inria.phoenix.diasuite.framework.datatype.sending.Sending;

/* (non-Javadoc)
 * The implementation of the JourneySelection context
 * @see fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection
 */
public class JourneySelection extends AbstractJourneySelection {
	private String journey;
    public JourneySelection(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection#onJourneyComputer(JourneyComputerValue)
     */
    @Override
    protected java.lang.String onJourneyComputer(JourneyComputerValue journeyComputerValue) {
        // TODO Auto-generated method stub
    	Sending journeys = journeyComputerValue.value();
    	
    	List<String> times=journeys.getTimes();
    	List<Float> floats=new ArrayList<Float>();
    	for (String temp : times) {
    		int ind1 = temp.indexOf ("h"); 
    		int ind2 = temp.indexOf (":"); 
    		String mano1 = temp.substring(0,ind1); 
    		String mano2 = temp.substring(ind1+1,ind2); 
    		String mano3 = temp.substring(ind2+1,temp.length()); 
    		float f1 = Float.parseFloat(mano1);
    		float f2 = Float.parseFloat(mano2);
    		float f3 = Float.parseFloat(mano3);
    		float f=f1*3600+f2*60+f3;
    		floats.add(f);
    	}
    	Float f=floats.get(0);
    	int ind=0;
    	for (int i = 0; i < floats.size(); i++) {
    		if(floats.get(i)<f){
    			ind=i;
    			f=floats.get(i);
    		}
    	}
    	this.journey=journeys.getJourneys().get(ind);
        return this.journey;
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection#getValue()
     */
    @Override
    protected java.lang.String getValue() {
        // TODO Auto-generated method stub
        return this.journey;
    }
}
