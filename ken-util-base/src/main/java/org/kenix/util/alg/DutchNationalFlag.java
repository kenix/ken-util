/*
* Created at 21:52 on 25.04.17
*/
package org.kenix.util.alg;

import java.util.Collections;
import java.util.List;

/**
 * @author zzhao
 */
public class DutchNationalFlag<T> {

  private final T t0;
  private final T t1;
  private final T t2;

  public DutchNationalFlag(T t0, T t1, T t2) {
    if (t0 == t1 || t0 == t2 || t1 == t2) {
      throw new IllegalArgumentException("distinct t0, t1, t2 required");
    }
    this.t0 = t0;
    this.t1 = t1;
    this.t2 = t2;
  }

  public void sort(T[] arr) {
    int lo = 0;
    int mi = 0;
    int hi = arr.length - 1;

    while (mi <= hi) {
      final T tm = arr[mi];
      if (tm == t0) {
        swap(arr, lo, mi);
        lo++;
        mi++;
      } else if (tm == t1) {
        mi++;
      } else if (tm == t2) {
        swap(arr, mi, hi);
        hi--;
      } else {
        throw new IllegalArgumentException(
            "given array contains invalid element: " + tm + " at " + mi);
      }
    }
  }

  public void sort(List<T> list) {
    int lo = 0;
    int mi = 0;
    int hi = list.size() - 1;

    while (mi <= hi) {
      final T tm = list.get(mi);
      if (tm == t0) {
        Collections.swap(list, lo, mi);
        lo++;
        mi++;
      } else if (tm == t1) {
        mi++;
      } else if (tm == t2) {
        Collections.swap(list, mi, hi);
        hi--;
      } else {
        throw new IllegalArgumentException(
            "given array contains invalid element: " + tm + "at " + mi);
      }
    }
  }

  private void swap(T[] arr, int a, int b) {
    final T t = arr[a];
    arr[a] = arr[b];
    arr[b] = t;
  }
}
