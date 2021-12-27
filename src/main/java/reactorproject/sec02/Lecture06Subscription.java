package reactorproject.sec02;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture06Subscription {

	
	
	public static void main(String[] args) {
		
		AtomicReference<Subscription> atomicReference = new AtomicReference<>();
		Flux.range(1, 20)
			.log()
		// our own custom implementation of subscriber
			.subscribeWith(new Subscriber<Integer>() {

				@Override
				public void onSubscribe(Subscription subscription) {
					 System.out.println("Received Subscription: " + subscription);
					 atomicReference.set(subscription);
					
				}

				@Override
				public void onNext(Integer integer) {
					 System.out.println("onNext: " + integer);
					
				}

				@Override
				public void onError(Throwable throwable) {
					System.out.println("onError: " + throwable.getMessage());
				}

				@Override
				public void onComplete() {
					System.out.println("onComplete was invoked");
					
				}
				
			});
		
		System.out.println("Going to sleep for 3 seconds");
		Util.sleepSeconds(3);
		
		atomicReference.get().request(3);
		
		System.out.println("Going to sleep for 5 seconds");
		Util.sleepSeconds(5);
		atomicReference.get().request(3);
		
		System.out.println("Going to sleep for 5 seconds");
		Util.sleepSeconds(5);
		System.out.println("Going to cancel my subscription ...");
		atomicReference.get().cancel();
		
		System.out.println("Going to sleep for 3 seconds");
		Util.sleepSeconds(3);
		
		System.out.println("Going to request for 4 items");
		atomicReference.get().request(4);
		
		System.out.println("Going to sleep for 3 seconds");
		Util.sleepSeconds(3);
	}
	
	
}
