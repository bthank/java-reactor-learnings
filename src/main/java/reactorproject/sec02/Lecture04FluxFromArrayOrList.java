package reactorproject.sec02;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture04FluxFromArrayOrList {

	
	public static void main(String[] args) {
		
		
		// List<String> strings = Arrays.asList("a","b","c");
		
		// flux from iterable is like 'just' where you already have the data that will be subscribed

		//Flux.fromIterable(strings)
		//	.subscribe(Util.onNext());
		
		
		// Flux from array
		Integer[] arr = {1,4,7,9,10};
		Flux.fromArray(arr)
				.subscribe(Util.onNext());
		
		
		
		
	}
	
	
}
