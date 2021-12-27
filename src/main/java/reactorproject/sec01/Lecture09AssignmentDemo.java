package reactorproject.sec01;

import reactorproject.courseutil.Util;
import reactorproject.sec01.assignment.FileService;

public class Lecture09AssignmentDemo {

	
	public static void main(String[] args) {
		
		// test our File Service
		
		FileService.read("file03.txt")
			.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
					);
		
		
		FileService.write("file03.txt", "This is file03 another line")
			.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
					);
		
		FileService.delete("file05.txt")
			.subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
					);
				
		
		
	}
	
	
	
	
	
}
