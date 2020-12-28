package design;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2020/12/24 20:50
 */
public class BitMap {
    private long bits;
    private int[] map;

    public static final long SHIFT = 5;
    public static final long MASK  = ((1 << SHIFT) -1);

    public BitMap(long nbits) {
        bits = nbits + 1;
        int size  = (int) (((bits >>> SHIFT) + 1) & 0x0ffffffffL);
        map = new int[size];

        for (int i = 0; i < size; i++) {
            map[i] = 0;
        }

    }

    public long size() {
        return bits;
    }

    public void set(long index) {
        int offset = (int) ((index >>> SHIFT) & 0x0ffffffffL); //获得index
        long position  = index & MASK; // 取模  position = value % 8 ,模八，也即看最低三位是什么，因为最低三位肯定除不尽8，就是最终的余数。  所以即 value & 0111 即可，即0x07
        int tmp = 1<<position;
        map[offset] |= 1<<position;
    }

    public void clear(long index) {
        int offset = (int) ((index >>> SHIFT) & 0x0ffffffffL);
        map[offset] &=  ~(1 << (index & MASK));
    }

    public boolean isSet(long index) {
        int offset = (int) ((index >>> SHIFT) & 0x0ffffffffL);
        int off = (int) (index & MASK);

        return ((map[offset] >>> off) & 0x01) == 0x1;

    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(1L << 32);
        bitMap.set(3232268298L);
        System.out.println(bitMap.isSet(3232268298L));
    }

}