package reactorproject.courseutil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object>{

	// this is the default name for the subscriber
	private String name = "";
	
	

	public DefaultSubscriber() {
		 
	}

	public DefaultSubscriber(String name) {
		this.name = name + " - ";
	}
	
	
	
	@Override
	public void onSubscribe(Subscription subscription) {
		subscription.request(Long.MAX_VALUE); // means the publisher should give eveything they have; unbounded
		
	}

	@Override
	public void onNext(Object object) {
 
		System.out.println(name + " Received : " + object);
		
	}

	@Override
	public void onError(Throwable throwable) {

		System.out.println(name + " ERROR : " + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		
		System.out.println(name + " Completed");
		
	}

}
