public class Shift {

	public static void main(String[] args) {
		// 10 -> 1000, 2^2 -> 2^4
		System.out.println(4 << 2); // 00000000 00000000 00000000 00000100 -> 00000000 00000000 00000000 00010000
		System.out.println(-4 << 2); // 11111111 11111111 11111111 11111100 -> 11111111 11111111 11111111 11110000

		// 1000 -> 10, 2^4 -> 2^2
		System.out.println(16 >> 2); // 00000000 00000000 00000000 00010000 -> 00000000 00000000 00000000 00000100
		System.out.println(-16 >> 2); // 11111111 11111111 11111111 11110000 -> 11111111 11111111 11111111 11111100

		// unsigned shift
		System.out.println(16 >>> 2); // 00000000 00000000 00000000 00010000 -> 00000000 00000000 00000000 00000100
		System.out.println(-16 >>> 2); // 11111111 11111111 11111111 11110000 -> 00111111 11111111 11111111 11111100
	}

}