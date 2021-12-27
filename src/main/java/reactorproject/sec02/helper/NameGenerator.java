package reactorproject.sec02.helper;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class NameGenerator {
	
	
//	public static List<String> getNames(int count) {
//		
//		List<String> list = new ArrayList<>(count);
//		for (int i = 0; i < count; i++) {
//			list.add(getName());
//		}
//		return list;
//	}
	
	public static Flux<String> getName(int count) {
		return Flux.range(0, count)
			.map(i -> getName());
	}
	
	
	private static String getName() {
		System.out.println("Generating name ...");
		Util.sleepSeconds(1);
		return Util.faker().name().fullName();
	}
	
	

}
