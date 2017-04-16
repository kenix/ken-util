/*
* Created at 18:22 on 14/04/2017
*/
package org.kenix.util.alg;

/**
 * Union find with path compression.
 *
 * @author zzhao
 */
public class UFWPC {

  private final int[] id;

  public UFWPC(int n) {
    this.id = new int[n];
    for (int i = 0; i < this.id.length; i++) {
      this.id[i] = i;
    }
  }

  private int root(int p) {
    while (p != this.id[p]) {
      this.id[p] = this.id[this.id[p]];
      p = this.id[p];
    }
    return p;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    final int rootP = root(p);
    final int rootQ = root(q);

    if (rootP == rootQ) {
      return;
    }

    this.id[rootQ] = rootP;
  }
}
