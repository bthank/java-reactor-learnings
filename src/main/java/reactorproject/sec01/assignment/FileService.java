package reactorproject.sec01.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import reactor.core.publisher.Mono;

public class FileService {

	
	private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");
	
	
	// read pipeline
	public static Mono<String> read(String fileName) {
		// this is the pipeline that we built; we are not doing any work; 
		// the work will be done when someone subscribes to this pipeline
		return Mono.fromSupplier(() -> readFile(fileName));
	}
	
	// write pipeline; this does not return anything; this should just notify the subscriber of completion
	public static Mono<String> write(String fileName, String content) {
		// this is the pipeline that we built; we are not doing any work; 
		// the work will be done when someone subscribes to this pipeline
		return Mono.fromRunnable(() -> writeFile(fileName, content));
	}
	
	// delete pipeline; this does not return anything; this should just notify the subscriber of completion
	public static Mono<Void> delete(String fileName) {
		// this is the pipeline that we built; we are not doing any work; 
		// the work will be done when someone subscribes to this pipeline
		return Mono.fromRunnable(() -> deleteFile(fileName));
	}
	
	
	
	// Expose 3 methods
	
	private static String readFile(String fileName) {
		
		try {
			return Files.readString(PATH.resolve(fileName)); // this will append the filename to the PATH
		} catch (IOException e) {
			
			throw new RuntimeException(e);
		}

		
	}
	
	private static void writeFile(String fileName, String content) {
		
		try {
			Files.writeString(PATH.resolve(fileName), content); // this will append the filename to the PATH
		} catch (IOException e) {
			
			throw new RuntimeException(e);
		}

		
	}
	
	
	private static void deleteFile(String fileName) {
		
		try {
			Files.delete(PATH.resolve(fileName)); // this will append the filename to the PATH
		} catch (IOException e) {
			
			throw new RuntimeException(e);
		}

		
	}
}
