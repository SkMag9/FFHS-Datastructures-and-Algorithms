package ch.ffhs.dua.sort;

public class QuickSort 
{
	
	/**
	 * Sortiert ein Array durch Quicksort.
	 * @param array Zu sortierendes Array.
	 */
	public static void sort(int[] array)
	{
		sort(array,0,array.length-1);
	}
	
	/**
	 * Sortiert ein Teilstück eines Arrays durch Quicksort.
	 * @param array ZU sortierenden Array
	 * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
	 * @param end   Index des letzen Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		int piv = findPivot(array,start,end);
		if (start < end) {
			int partitionIndex = partition(array, start, end, piv);

			sort(array, start, partitionIndex-1);
			sort(array, partitionIndex+1, end);
		}
	}

	public static void sortWithMaxDepth(int[] array, int start, int end, int maxDepth){
		maxDepth--;
		if (maxDepth >= 0) {
			int piv = findPivot(array, start, end);
			if (start < end) {
				int partitionIndex = partition(array, start, end, piv);

				sort(array, start, partitionIndex - 1);
				sort(array, partitionIndex + 1, end);
			}
		} else {
			HeapSort.sort(array, start, end);
		}
	}
	
	/** 
	 * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort 
	 * statt Quicksort aufgerufen werden sollte.
	 * The Method used to choose the threshold is described in FindingThreshold.java
	 */

	static int THRESHOLD = 300;
	
	/**
	 * Modifiziertes Quicksorts.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 */
	public static void sortPlus(int[] array)
	{
		if(array.length < THRESHOLD){
			InsertSort.sort(array);
		} else {
			QuickSort.sort(array);
		}
	}

	/**
	 * Modifiziertes Quicksorts zum SOrtieren eines Teilstücks eines Arrays.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten  Elementes des zu sortierenden teilstücks.
	 * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
	 */
	public static void sortPlus(int[] array, int start, int end)
	{
		if(array.length < THRESHOLD){
			InsertSort.sort(array, start, end);
		} else {
			QuickSort.sort(array, start, end);
		}
	}

	/**
	 * Hilfsmethode für Quicksort. 
	 * Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente,
	 * die kleiner als ein gewisses Pivot-Elements sind, links stehen
	 * und alle Elemente, die grösser als das Pivot-Element rechts stehen.
	 * @param array Array zum Umordnen.
	 * @param start Indes des ersten  Elements des Teilstücks, das geteilt werden muss.
	 * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
	 * @param piv   Index des PiotElements
	 * @return Index des Piot-Element nach der Partitionierung.
	 */
	static int partition(int[] array, int start, int end, int piv)
	{
		int n = (start - 1);

		for(int i = start; i < end; i++){
			if(array[i] <= array[piv]){
				n++;

				swap(array, n, i);
			}
		}

		swap(array, n+1, end);

		return n + 1;
	}
	
	/**
	 * Hilfsmethode zum Vertauschen zweier Array-Elemente
	 * @param array Array, in dem die Indeces vertauscht werden.
	 * @param a element a
	 * @param b element b
	 */
	static void swap(int[] array, int a, int b)
	{
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	/**
	 * Hilfsmethode zum Finden eines Pivot-Elementes für Quicksort.
	 * Zu einem Array und den zwei Indices start und end wird 
	 * der Index eines möglichen Pivot-Elementes angegeben 
	 * @param array	array
	 * @param start start-index
	 * @param end end-index
	 * @return Index eines Pivot-Elementes
	 */
	static int findPivot(int[] array, int start, int end)
	{
		// just return the last element as pivot to sort around it. in a random array this
		// should not make a difference what pivot we take.
		return end;
	}
}
