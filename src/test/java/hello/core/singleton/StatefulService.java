package hello.core.singleton;

public class StatefulService {

    //Spring Bean 은 항상 무상테로 설계 하여야 한다.
    // price를 order에서 반환받도록 하면 멤버변수에 저장할 필요없이
    // 다른 스레드에서 price값을 덮어버리는 오류가 발생할 일이 없다.


    private int price; //상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;  // <-- 문제 있는 부분
    }

    public int getPrice() {
        return price;
    }
}
