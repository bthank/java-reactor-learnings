package reactorproject.sec03;

import java.nio.file.Path;
import java.nio.file.Paths;

import reactorproject.courseutil.Util;
import reactorproject.sec03.assignment.FileReaderService;

public class Lecture09FileReaderServiceAssignment {
	
	public static void main(String[] args) {
		
		FileReaderService readerService = new FileReaderService();
		
		Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
		readerService.read(path)
			.map(s -> {
				Integer integer = Util.faker().random().nextInt(0,10);
				if (integer > 8) {
					throw new RuntimeException("oops value was larger than 8");
				}
				return s;
			})
			.take(20)
			.subscribe(Util.subscriber());
		
		
		
	}
	
	

}
