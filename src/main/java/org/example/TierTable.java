package org.example;

abstract class TierTable {
    final double[][] pairs;

    public TierTable(double... tiers) {
        if (tiers.length % 2 == 1) {
            throw new IllegalArgumentException("不正な長さ：" + tiers.length);
        }
        double[][] a = new double[tiers.length / 2][];
        for (int i = 0; i < tiers.length; i += 2) {
            a[i / 2] = new double[]{tiers[i], tiers[i + 1]};
        }
        this.pairs = a;
    }

    abstract double map(double amount);
}
