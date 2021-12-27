package reactorproject.sec01;

import java.util.stream.Stream;


public class Lecture01Stream {

	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.of(1).map(
				i -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return i * 2;
				});
		
		// System.out.println(stream);
		stream.forEach(System.out::println);
	}
	
	
}