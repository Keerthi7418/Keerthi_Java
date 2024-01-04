package question3;

import java.util.Arrays;

public class StreamExample {

	 public static void main(String[] args) {
	        Integer[] numbers = {1, 2, 3, 4, 5};

	        int sum = Arrays.stream(numbers)
	                .filter(n -> n % 2 != 0) // Filter odd numbers
	                .map(n -> n * n) // Square the numbers
	                .reduce(0, Integer::sum); // Calculate the sum

	        System.out.println("ODD NUMBERS : " + Arrays.toString(Arrays.stream(numbers).filter(n -> n % 2 != 0).toArray()));
	        System.out.println("SQUARES : " + Arrays.toString(Arrays.stream(numbers).filter(n -> n % 2 != 0).map(n -> n * n).toArray()));
	        System.out.println("SUM : " + sum);
	        System.out.println("OUTPUT : " + sum);
	    }
	}

