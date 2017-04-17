/*
* Created at 22:36 on 22/11/15
*/
package org.kenix.util.base;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author zzhao
 */
public final class CollectionUtil {

  private CollectionUtil() {
    throw new AssertionError("not for instantiation or inheritance");
  }

  public static <T> T last(List<T> list) {
    if (list.isEmpty()) {
      throw new NoSuchElementException();
    }
    return list.get(list.size() - 1);
  }

  public static <T extends Comparable<T>> void heapSort(T[] items) {
    int n = items.length; // assume array [-, items[0], items[1], ... items[items.length-1]]
    for (int i = n / 2; i > 0; i--) {
      sink(items, i, n);
    }
    while (n > 1) {
      exch(items, 1, n);
      sink(items, 1, --n);
    }
  }

  private static <T extends Comparable<T>> void sink(T[] items, int i, int n) {
    while (i < n) {
      int cIdx = i * 2;
      if (cIdx + 1 <= n && less(items, cIdx, cIdx + 1)) {
        cIdx = cIdx + 1;
      }

      if (cIdx <= n && less(items, i, cIdx)) {
        exch(items, i, cIdx);
        i = cIdx;
      } else {
        return;
      }
    }
  }

  private static <T extends Comparable<T>> boolean less(T[] items, int a, int b) {
    return items[a - 1].compareTo(items[b - 1]) < 0;
  }

  private static <T extends Comparable<T>> void exch(T[] items, int a, int b) {
    final T item = items[a - 1];
    items[a - 1] = items[b - 1];
    items[b - 1] = item;
  }
}
