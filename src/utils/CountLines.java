package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CountLines {
	public static long nbLines(String n) {
		try (Stream<String> stream = Files.lines(Paths.get(n), StandardCharsets.ISO_8859_1)) {
			long nb = stream.count();
			System.out.println(n + " : " + nb + " lines");
			return nb;
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		try (Stream<Path> stream = Files.walk(Paths.get("src"))) {
			System.out.println("total : " +
					stream
					.filter(Files::isRegularFile)
					.filter(p -> !p.toString().endsWith("CountLines.java"))
					.mapToLong(p -> nbLines(p.toString()))
					.sum() + " lines"
				);
		}
	}
}
