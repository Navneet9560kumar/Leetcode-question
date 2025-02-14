class ProductOfNumbers {
    ArrayList<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            return;
        }
        int prev = (list.isEmpty()) ? 1 : list.get(list.size() - 1);
        list.add(prev * num);
    }

    public int getProduct(int k) {
        int s = list.size();
        if (s < k) return 0;
        if (s == k) return list.get(s - 1);
        return list.get(s - 1) / list.get(s - k - 1);
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */