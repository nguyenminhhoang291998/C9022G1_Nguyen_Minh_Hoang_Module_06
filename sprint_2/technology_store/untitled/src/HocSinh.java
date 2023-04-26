
 class HocSinh implements Comparable{
    private String ten;
    private int diem;
    public HocSinh(String ten, int diem) {
        this.ten = ten;
        this.diem = diem;
    }
    public String getTen() {
        return ten;
    }
    public int getDiem() {
        return diem;
    }

     @Override
     public int compareTo(Object o) {
         return 0;
     }
 }

