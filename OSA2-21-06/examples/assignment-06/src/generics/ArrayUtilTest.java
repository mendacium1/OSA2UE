package generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

	@Test
	void biggestNullArray() {
		assertThrows(NullPointerException.class, () -> {
			ArrayUtil.biggest(null);
		});
	}
	@Test
	void biggestEmptyArray() {
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayUtil.biggest(new Integer[]{});
		});
	}

	@Test
	void biggestSingleElementArray() {
		Integer result = ArrayUtil.biggest(new Integer[]{3});

		assertEquals(3, result);
	}
	@Test
	void biggestMultiElementArray() {
		Integer[] values = new Integer[]{3, 2, 4, 1};
		Integer result = ArrayUtil.biggest(values);

		assertEquals(4, result);
		assertArrayEquals(new Integer[]{3, 2, 4, 1}, values);
	}

	@Test
	void biggestMultiDuplicatesElementArray() {
		Integer[] values = new Integer[]{4, 3, 2, 2, 4, 1};
		Integer result = ArrayUtil.biggest(values);

		assertEquals(4, result);
		assertArrayEquals(new Integer[]{4, 3, 2, 2, 4, 1}, values);
	}

	@Test
	void biggestMultiEqualElementArray() {
		Integer[] values = new Integer[]{3, 3, 3, 3};
		Integer result = ArrayUtil.biggest(values);

		assertEquals(3, result);
		assertArrayEquals(new Integer[]{3, 3, 3, 3}, values);
	}
}