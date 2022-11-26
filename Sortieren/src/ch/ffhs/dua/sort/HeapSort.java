package ch.ffhs.dua.sort;

import java.util.Arrays;

public class HeapSort
{
	/**
	 * Sortiert ein Array mit Heapsort.
	 * @param array
	 */
	public static void sort(int[] array)
	{
		sort(array, 0, array.length - 1);
	}

	/**
	 * Sortiert ein Teilstück eines Array s mit Heapsort.
	 * @param array
	 * @param start Index des ersten  Elementes des zu sortierenden Teils.
	 * @param start Index des letzten Elementes des zu sortierenden Teils.
	 */
	public static void sort(int[] array, int start, int end)
	{
		int size = subArrayLength(start,end);
		int[] subArray = new int[size];

		// fill array with subarray values
		System.arraycopy(array, start, subArray, 0, size);

		makeHeap(subArray,0,size-1);

		System.out.println(Arrays.toString(subArray));
		// extract elements from heap
		for (int i = size - 1; i>=0; i--){
			swap(subArray, 0, i);
			heap(subArray,i,0, start);
		}

		System.arraycopy(subArray,0,array,start,size);
	}

	/**
	 * Erzeugt aus einem angegebenen Teilstück einen Heap.
	 * @param array
	 * @param start Index des ersten Elementes, aus dem ein Heap erzeugt werden sollte.
	 *              Das ist auch der Index der Wurzel des Heaps; die Kinder der Wurzel
	 *              liegen dann an den Position start+1 und start+2.
	 * @param end   Index des letzten Elementes des Stücks, aus dem ein Heap erzeugt werden sollte.
	 */
	public static void makeHeap(int[] array, int start, int end)
	{
		int size = subArrayLength(start,end);
		int[] subArray = new int[size];


		// fill array with subarray values
		System.arraycopy(array, start, subArray, 0, size);

		// build heap for subarray
		for (int i = size/2; i >= 0; i--){
			heap(subArray, size, i, start);
		}

		System.out.println(Arrays.toString(array));

		System.arraycopy(subArray,0,array,start,size);
		System.out.println(Arrays.toString(array));

	}

	static void heap(int[] array, int size, int index, int start)
	{
		int largestChildIndex = index;
		int leftChildIndex = leftChild(index,start-1);
		int rightChildIndex = rightChild(index,start-1);

		// If left child is larger than root
		if (leftChildIndex < size && array[leftChildIndex] > array[largestChildIndex])
			largestChildIndex = leftChildIndex;

		// If right child is larger than largest so far
		if (rightChildIndex < size && array[rightChildIndex] > array[largestChildIndex])
			largestChildIndex = rightChildIndex;

		// If largest is not root
		if (largestChildIndex != index)
		{
			int swap = array[index];
			array[index] = array[largestChildIndex];
			array[largestChildIndex] = swap;

			// Recursively heapify the affected sub-tree
			heap(array, size, largestChildIndex, start);
		}
	}


	/**
	 * Entfernt das Wurzelelement eines Heaps, baut den Heap um,
	 * so dass er nach dem Entfernen wieder ein Heap ist (mit einem Element weniger),
	 * und setzt das ehemalige Wurzelelement an die vormals letzte Stelle im Heap
	 * (die nun nicht mehr zum Heap gehört).
	 * @param array Ein Array, das als Teilstück einen heap enthält.
	 * @param start Indes der Wurzel des heaps
	 * @param end   Index des letzten Heap-Elements.
	 */
	public static void removeHeapRoot(int[] array, int start, int end)
	{
		swap(array,start,end);
		makeHeap(array,start,end-1);
	}

	/**
	 * Berechnet den Index des linken Kindelementes in einem Heap.
	 * @param parentIndex
	 * @param offset Offset für Heap-Eigenschaft: entspricht
	 *         dem Index der Heapwurzel - 1
	 * @return Index des linken Kindes
	 */
	static int leftChild(int parentIndex, int offset)
	{
		return 2 * parentIndex - offset;
	}

	/**
	 * Berechnet den Index des rechten Kindelementes in einem Heap.
	 * @param parentIndex
	 * @param offset Offset für Heap-Eigenschaft: entspricht
	 *         dem Index der Heapwurzel - 1
	 * @return Index des rechten Kindes
	 */
	static int rightChild(int parentIndex, int offset)
	{
		return leftChild(parentIndex, offset) + 1;
	}

	/**
	 * Swaps 2 elements of an array
	 * @param array
	 * @param a
	 * @param b
	 */
	public static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * Calculates the length of the subarray
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int subArrayLength(int startIndex, int endIndex){
		return endIndex-startIndex+1;
	}
}
