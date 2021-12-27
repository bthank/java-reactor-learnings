package reactorproject.sec03.helper;

import java.util.function.Consumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactorproject.courseutil.Util;

public class NameProducer implements Consumer<FluxSink<String>> {

	private FluxSink<String> fluxSink;
	
	
	
	@Override
	public void accept(FluxSink<String> stringFluxSink) {
		 
		this.fluxSink = stringFluxSink;
		
	}

	public void produce() {
		String name = Util.faker().name().fullName();
		String thread = Thread.currentThread().getName();
		this.fluxSink.next(thread + "  :  " + name);
	}
	 

}
