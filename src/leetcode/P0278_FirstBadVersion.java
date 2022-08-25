public class P0278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int vFirst = 1;
        int vLast = n;

        while (vFirst < vLast) {
            int vMid = vFirst + (vLast - vFirst) / 2;

            if (isBadVersion(vMid)) {
                vLast = vMid;
            } else {
                vFirst = vMid + 1;
            }

        }

        return vFirst;
    }

    public boolean isBadVersion(int version) {
        throw new RuntimeException("Not implemented");
    }
}
