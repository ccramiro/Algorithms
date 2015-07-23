package random;

import java.util.BitSet;
import java.util.Random;

public class BitSetOperation {

	public static void doStuff() {
		BitSet s = new BitSet();
		final int billion = 100000000;
		for (int l = 0; l < billion; l++) {
			s.set(l);
		}
		while (true) {
			Random rand = new Random();
			int n = (rand.nextInt(billion));
			if (s.get(n))
				System.out.println(n);
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
			}
		}
	}

	public static void main(String args[]) {
		doStuff();
	}
}
