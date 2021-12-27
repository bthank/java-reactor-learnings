package reactorproject.sec02;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactorproject.sec02.assignment.StockPricePublisher;

public class Lecture10StockPriceAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(1);
		
		
		StockPricePublisher.getPrice()
			.subscribeWith(new Subscriber<Integer>() {
				
				// creating an instance variable to store my subscription
				private Subscription subscription;

				@Override
				public void onSubscribe(Subscription subscription) {
					this.subscription = subscription;
					subscription.request(Long.MAX_VALUE); // this is basically unbounded or telling publisher to give me everything you have
				}

				@Override
				public void onNext(Integer price) {
					 
					System.out.println(LocalDateTime.now() + "    :    Price : " + price);
					if (price > 110 || price < 90) {
						this.subscription.cancel();
						latch.countDown();
					}
				}

				@Override
				public void onError(Throwable throwable) {
					 
					latch.countDown();
				}

				@Override
				public void onComplete() {
					 
					latch.countDown();
					
				}
				
			});
		// this will wait for the countdown
		latch.await();
	}
	
	
}
