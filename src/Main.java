import java.util.ArrayList;

class Transportation {
    int myNumber;  // 자신의 고유한 번호
    int nowOil; // 현재 주유량
    int nowSpeed; // 현재 속도
    int maxPassengers; // 최대 승객수
    int nowPassengers; // 현재 승객수
    int charge; // 지불할 요금
    boolean carState; // 차의 상태
    Transportation()
    {

    }
    // 차가 출발할때
    public void startDrive() {
        this.carState = true;
    }

    // 차가 속도를 변경할때
    public void changeSpeed(int plus_speed) {
        if (this.nowOil < 10) {
            System.out.println("주유량을 확인해주세요");
            return;
        }
        this.nowSpeed += plus_speed;
    }

    // 차의 상태를 변화시킬때
    public void changeState() {
        this.carState = !this.carState;
    }

    // 승객이 입장한다.
    public void passengerIn(int passengers) {
        if (this.maxPassengers - passengers < 0) {
            System.out.println("최대 승객 수 초과!");
            return;
        }
        System.out.println("탑승 승객 수 : " + passengers);
        this.maxPassengers -= passengers;
        this.nowPassengers += passengers;
        System.out.println("잔여 승객 수 : " + this.maxPassengers);
        this.charge = 1000 * passengers;
        System.out.println("요금확인 = " + this.charge);
    }
    public void changeOil(int oil) {
        this.nowOil += oil;
        if (!this.carState) {
            System.out.println("상태 = 차고지행");
        }
        System.out.println("주유량 :" + this.nowOil + "L입니다.");
        if (this.nowOil < 10) {
            this.changeState();
            System.out.println("주유가 필요합니다");
            System.out.println("상태: 차고지행");
        }
    }

}

class Bus extends Transportation {
    Bus() {
    }
    Bus(int bus_Number) {
        this.myNumber = bus_Number;
        this.carState = true;
        this.nowOil = 100;
        this.nowSpeed = 0;
        this.nowPassengers = 0;
        this.maxPassengers = 30;
        this.charge = 0;
        System.out.println(myNumber + "번 버스 생성했습니다.");
    }
}

class Taxi extends Transportation {
    ArrayList<String> destination = new ArrayList<>();
    ArrayList<Integer> destinationLength = new ArrayList<>();
    int normalDistance;
    int normalCharge;
    int plusCharge;
    int sumCharge;

    Taxi(int myNumber) {
        this.myNumber = myNumber;
        this.normalCharge = 3000;
        this.normalDistance = 1;
        this.plusCharge = 1000;
        this.maxPassengers = 4;
        this.nowOil = 100;
        this.carState = true;
        this.nowSpeed = 0;
        this.sumCharge = 0;
        System.out.println(this.myNumber + "번 택시 생성했습니다.");
        System.out.println("현재 주유량은 : " + this.nowOil + "L입니다");
        System.out.println("현재 상태는 : 일반입니다.");
    }
    public void passengerIn(int passengers) {
        if (this.maxPassengers - passengers < 0) {
            System.out.println("최대 승객 수 초과!");
            return;
        }
        System.out.println("탑승 승객 수 : " + passengers + "명입니다.");
        this.maxPassengers -= passengers;
        this.nowPassengers += passengers;
        System.out.println("잔여 승객 수 : " + this.maxPassengers+ "명입니다.");
        this.charge = 1000 * passengers;
    }
    public void putDestination(String destination, int destinationLength) {
        System.out.println("기본요금은 : " + normalCharge + " 입니다.");
        this.destination.add(destination);
        this.destinationLength.add(destinationLength);
        System.out.println("목적지는 : " + destination + "입니다.");
        System.out.println("목적지까지의 거리는 : " + destinationLength + "Km 입니다.");
        changeCharge(destinationLength);
        System.out.println("지불할 요금은 : " + this.charge + "원 입니다.");
        if(this.carState)
        {
            System.out.println("현재 상태는 : 운행중입니다.");
        }
        else{
            System.out.println("현재 상태는 : 운행불가 입니다.");
        }
    }
    public void changeOil(int oil) {
        this.nowOil += oil;
        if (!this.carState) {
            System.out.println("상태 = 일반");
        }
        System.out.println("주유량 :" + this.nowOil + "L입니다.");
        if (this.nowOil < 10) {
            this.changeState();
//            System.out.println("주유가 필요합니다");
//            System.out.println("상태: 운행불가");
        }
    }

    public void changeCharge(int destinationLength) {
        this.charge = this.normalCharge + (destinationLength - this.normalDistance) * this.plusCharge;
        this.sumCharge +=this.charge;
    }

    public void payCharge()
    {
        this.carState = false;
        System.out.println("누적된 총 요금은 : " + this.sumCharge + "원입니다.");
        this.maxPassengers += nowPassengers;
        this.nowPassengers = 0;
        this.charge = 0;
        if (this.nowOil < 10) {
            this.changeState();
            System.out.println("상태: 운행불가");
            System.out.println("주유가 필요합니다");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. 버스 객체를 생성하고 얘들가지고 놀아보자.
        Bus a = new Bus(1);
        Bus b = new Bus(2);
        a.startDrive();
        // 1. 승객 2명 탑승
        a.passengerIn(2); // 탑승승객수, 잔여승객수, 요금확인
        // 2. 주유량 감소
        a.changeOil(-50); // 주유량 50만큼 감소
        // 3. 상태 변경
        a.changeState();
        // 4. 주유량 증가
        a.changeOil(10);
        // 5. 상태변경
        a.changeState();
        // 6. 승객 추가
        a.passengerIn(45); // Error! 최대 승객 수 초과
        a.passengerIn(5);
        // 7. 주유량 -55
        a.changeOil(-55);

        System.out.println();

        // 2. 택시 객체를 생성하고 얘들 가지고 놀아보자.
        Taxi c = new Taxi(3);
        Taxi d = new Taxi(4);
        c.passengerIn(2);
        c.putDestination("서울역", 2);
        c.changeOil(-80);
        c.payCharge();

        c.startDrive();
        c.passengerIn(5);
        c.passengerIn(3);
        c.putDestination("구로디지털단지역",12);
        c.changeOil(-20);
        c.payCharge();



    }
}