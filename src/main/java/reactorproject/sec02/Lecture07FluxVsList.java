package reactorproject.sec02;

import java.util.List;

import reactorproject.courseutil.Util;
import reactorproject.sec02.helper.NameGenerator;

public class Lecture07FluxVsList {

	public static void main(String[] args) {
		
		// Here we have to wait 5 seconds for the names to be provided
//		List<String> names = NameGenerator.getNames(5);
//		System.out.println(names);
		
		
		// Here using Flux we don't have to wait; Each name is provided as it is generated
		// As and when something is ready it is emitted to the subscriber without waiting
		// Flux is helpful for processing time
		NameGenerator.getName(5)
			.subscribe(Util.onNext());
		
		
	}
	
	
}
