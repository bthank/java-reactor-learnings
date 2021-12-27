package reactorproject.courseutil;

import java.util.function.Consumer;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;

public class Util {
	
	public static final Faker FAKER = Faker.instance();

	
	public static Consumer<Object> onNext(){
		return o -> System.out.println("Received: " + o);
		
	}
	
	public static Consumer<Throwable> onError() {
		return e -> System.out.println("ERROR: " + e.getMessage());
	}
	
	public static Runnable onComplete() {
		return () -> System.out.println("Subscription completed");
	}
	
	public static Faker faker() {
		return FAKER;
	}
	
	public static void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Subscriber<Object> subscriber() {
		return new DefaultSubscriber();
	}
	
	public static Subscriber<Object> subscriber(String name) {
		return new DefaultSubscriber(name);
	}
	
}
