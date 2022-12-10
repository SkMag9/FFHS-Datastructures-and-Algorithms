package ch.ffhs.dua.binSearch;

public class BinSearch {
	/**
	 * Findet für einen aufsteigend geordneten Array zu einer Zahl value
	 * den kleinsten und den grössten Index.
	 *
	 * @param array
	 * @param value
	 * @return Ein Paar mit kleinestem und grösstem Index oder
	 * null, wenn der gegebene Wert im array nicht vorkommt.
	 */
	public static Pair search(int[] array, int value) {
		int lowestIndex = -1;
		int highestIndex = -1;


		int lowerIndex = 0;
		int higherIndex = array.length - 1;

		while (lowerIndex <= higherIndex) {
			// Normal binary search code
			int mid_index = (lowerIndex + higherIndex) / 2;
			if (array[mid_index] > value) {
				higherIndex = mid_index - 1;
			} else if (array[mid_index] < value) {
				lowerIndex = mid_index + 1;
			}
			// If the index contains the desired value save it to lowestIndex and search the lower half to search for
			// lower indexes with the same value. If there is a lower index this one will be overwritten, if not, this
			// is the lowest.
			else {
				lowestIndex = mid_index;
				higherIndex = mid_index - 1;
			}
		}


		lowerIndex = 0;
		higherIndex = array.length - 1;

		while (lowerIndex <= higherIndex) {
			// Normal binary search code
			int mid_index = (lowerIndex + higherIndex) / 2;
			if (array[mid_index] > value) {
				higherIndex = mid_index - 1;
			} else if (array[mid_index] < value) {
				lowerIndex = mid_index + 1;
			}
			// If the index contains the desired value save it to highestIndex and search the higher half to search for
			// higher indexes with the same value. If there is a higher index this one will be overwritten, if not,
			// this is the highest.
			else {
				highestIndex = mid_index;
				lowerIndex = mid_index + 1;
			}
		}

		// if there were no indexes found for the value return null.
		if (lowestIndex == -1 || highestIndex == -1) {
			return null;
		}
		// If there were indexes found, return a pair object containing both.
		return new Pair(lowestIndex, highestIndex);
	}
}
