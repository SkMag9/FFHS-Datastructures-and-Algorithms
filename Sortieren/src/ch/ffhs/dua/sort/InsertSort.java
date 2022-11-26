package ch.ffhs.dua.sort;

public class InsertSort
{
	/**
	 * Sortiert ein Array durch Einfügen
	 * @param array Das zu sortierende Array.
	 */
	public static void sort(int[] array)
	{
		sort(array,0,array.length-1);
	}
	
	/**
	 * Sortiert einen durch zwei Grenzen angebenen Teil eines Arrays durch Einfügen.
	 * Arrayelemente ausserhalb der Grenzen werden nicht verschoben.
	 * @param array Das zu sortierende Array.
	 * @param start Index des ersten Elementes des Teils, das Sortiert werden muss.
	 * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		// Catch Clauses
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;

			System.out.println("Start index was greater than the end index. Start and End were therefore swapped.");
		}

		if(start == end){
			return;
		}

		if(start < 0) {
			start = 0;
			System.out.println("Start index is less than 0; using 0 instead.");
		}

		if(end >= array.length) {
			end = array.length-1;
			System.out.println("End index out of bounds, using highest possible value: " + (array.length-1));
		}

		for(int i = start+1; i <= end; i++) {
			int temp = array[i];    // Element to be inserted
			int j = i - 1;          // Element to the left of temp

			// While loop to shift the values as needed
			while (j >= 0 && temp <= array[j]) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = temp;    // inserts the sorted element to the most left space.
		}
	}
}
