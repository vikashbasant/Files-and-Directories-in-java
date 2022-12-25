package in.co.decimal.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;


public class DirectoryScanRunner {
	public static void main(String[] args) throws IOException {

		Path currentDirectories = Paths.get(".");
		// Files.list(currentDirectories).forEach(System.out::println);

		// output of this console is:
		/**
		 * ./bin ./.classpath ./resources ./.project ./.settings ./src
		 * 
		 */

		// -------------------file walk through:

		// Files.walk(currentDirectories, 4).forEach(System.out::println);

		// Predicate<? super Path> predicate = path ->
		// String.valueOf(path).contains(".java");
		//
		// Files.walk(currentDirectories,
		// 6).filter(predicate).forEach(System.out::println);

		// output:
		/**
		 * ./src/in/co/decimal/file/IsValidString.java
		 * ./src/in/co/decimal/file/DirectoryScanRunner.java
		 */

		// ---------------------------There is another method search through file:
		BiPredicate<Path, BasicFileAttributes> JavaMatcher = (path, attributes) -> String.valueOf(path)
				.contains(".java");

		BiPredicate<Path, BasicFileAttributes> directoryMatcher = (path, attributes) -> attributes.isDirectory();

		Files.find(currentDirectories, 6, directoryMatcher).forEach(System.out::println);

		// output:
		/**
		 * ./src/in/co/decimal/file/IsValidString.java
		 * ./src/in/co/decimal/file/DirectoryScanRunner.java
		 */
	}
}
