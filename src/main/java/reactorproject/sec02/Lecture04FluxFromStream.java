package reactorproject.sec02;

import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture04FluxFromStream {

	
	public static void main(String[] args) {
		
		
		List<Integer> list = List.of(1,2,3,4,5);
		
		Stream<Integer> stream = list.stream();
		
		// stream is a 1 time use; it cannot be reused after it is used once
		// stream.forEach(System.out::println);
		
		
		
		//Flux<Integer> integerFlux = Flux.fromStream(stream);
		// this will allow us to create a stream as part of the supplier so that each subscriber can access the stream data
		Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());
		
		
		
		// this guy will be able to process the stream
		integerFlux
			.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
					);
		
		// this guy won't have anything left to process from the stream
		integerFlux
		.subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
				);
		
		
	}
	
	
}
