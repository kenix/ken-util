/*
* Created at 21:04 on 17.04.17
*/
package org.kenix.util.alg;

/**
 * @author zzhao
 */
public class Taxicab {

  public static void main(String[] args) {
    final int n = Integer.parseInt(args[0]);
    final PqMin<Item> pq = new PqMin<>();
    for (int i = 1; i <= n; i++) {
      pq.insert(new Item(i, i));
    }

    Item prev = new Item(0, 0);
    int run = 1;
    while (!pq.isEmpty()) {
      final Item curr = pq.removeRoot();
      if (prev.sum == curr.sum) {
        run++;
        if (run == 2) {
          System.out.print(prev.sum + " = " + prev);
        }
        System.out.print(" = " + curr);
      } else {
        if (run > 1) {
          System.out.println();
        }
        run = 1;
      }
      prev = curr;
      if (curr.j < n) {
        pq.insert(new Item(curr.i, curr.j + 1));
      }
    }
    if (run > 1) {
      System.out.println();
    }
  }

  private final static class Item implements Comparable<Item> {

    private final long i;
    private final long j;
    private final long sum;

    public Item(long i, long j) {
      this.i = i;
      this.j = j;
      this.sum = i * i * i + j * j * j;
    }

    @Override
    public int compareTo(Item o) {
      return this.sum != o.sum ? Long.compare(this.sum, o.sum) : Long.compare(this.i, o.i);
    }

    @Override
    public String toString() {
      return this.i + "^3 + " + this.j + "^3";
    }
  }
}
