package fr.inria.phoenix.scenario.boardontime.impl.context;

import java.util.ArrayList;
import java.util.List;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.bike_availability.AbstractBike_availability;
import fr.inria.phoenix.diasuite.framework.context.bikechecker.BikeCheckerValue;
import fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes;
import fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv;

/* (non-Javadoc)
 * The implementation of the Bike_availability context
 * @see fr.inria.phoenix.diasuite.framework.context.bike_availability.AbstractBike_availability
 */
public class Bike_availability extends AbstractBike_availability {
    
    public Bike_availability(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.bike_availability.AbstractBike_availability#onBikeChecker(BikeCheckerValue, DiscoverForBikeCheckerValue)
     */
    @Override
    protected Bike_availabilityValuePublishable onBikeChecker(BikeCheckerValue bikeCheckerValue, DiscoverForBikeChecker discover) {
        // TODO Auto-generated method stub
    	String a = bikeCheckerValue.value(); 
		List<String> dep=new ArrayList<String>();
		List<String> arr=new ArrayList<String>();
		String c=a;
		//String e=new String();
		int ind;
		int ind1;
		while(c.contains("Mode : Vélo")){
			int ind2=c.indexOf("Mode : Vélo");
			//b.add(a.indexOf("Mode : Vélo"));
			//e=c.substring(0,ind2-2);
			ind=c.lastIndexOf("De : ",c.indexOf("Mode : Vélo"));
			String s1=new String();
			int i1;
			i1=c.substring(ind, ind2).indexOf("(");
			s1=c.substring(ind, ind2).substring(5,i1);
			dep.add(s1);
			ind1=c.lastIndexOf("à  : ",c.indexOf("Mode : Vélo"));
			String s2=new String();
			int i2;
			i2=c.substring(ind1, ind2).indexOf("(");
			s2=c.substring(ind1, ind2).substring(5,i2);
			arr.add(s2);
			c=c.substring(ind2+13);
		}
		BikesAv filter=new BikesAv();
		filter.setDep(dep);
		filter.setArr(arr);
		Bikes bikes = discover.bordeauxMetropoles().anyOne().getBikes(filter);
		String send=new String("On a besoin de: ");
		for (int i = 0; i < dep.size(); i++) {
			if(bikes.getStationsBi().get(i)==0)
				send=send+"\n1 vélo à la station "+dep.get(i);
			if(bikes.getStationsPl().get(i)==0)
				send=send+"\n1 place à la station "+arr.get(i);
		}
		if(send.contains("station"))
    		return new Bike_availabilityValuePublishable(send, true);
		return new Bike_availabilityValuePublishable(send, false);    
	}
}
