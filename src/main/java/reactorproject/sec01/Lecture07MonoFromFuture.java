package reactorproject.sec01;

import java.util.concurrent.CompletableFuture;

import reactor.core.publisher.Mono;
import reactorproject.courseutil.Util;

public class Lecture07MonoFromFuture {

	public static void main(String[] args) {
		
		Mono.fromFuture(getName())
			.subscribe(Util.onNext()); // this won't return any result until we block the thread
		
		// use this method to block the thread
		Util.sleepSeconds(1);
		
	}
	
	private static CompletableFuture<String> getName() {
		return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
	}
	
	
	
}
