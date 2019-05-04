public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        // TODO
        long l = 1;
        long h = n;
        while (l < h) {
            long middle = (h + l)/2;
            if (isBadVersion.isFailingVersion(middle)) {h = middle;}
            else {l = middle+1;}
            System.out.println("hey");
        }
        if (isBadVersion.isFailingVersion(l))
            return l;
            System.out.println("by");
        return -1;
    }

}
