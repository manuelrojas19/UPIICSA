package mx.ipn.upiicsa.poo.streamAPI;

import java.util.stream.Stream;

public class IntermediateExamples {

	public static void main(String[] args) {
		Stream<String> coulors = Stream.of("Purple", "Blue", "Red", "Yellow", "Green", "Yellow", "Purple", "Orange",
				"Black");
		coulors.filter(c -> c.length() > 4).distinct().sorted().map(c -> c.substring(0, 2))
				.forEach(System.out::println);
	}
}
