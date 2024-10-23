/**
인터페이스(I)를 사용함으로써 A가 B,C를 직접적으로 매개변수로 사용하지 못하게 할 수 있다.
따라서 B나 C가 선행적으로 만들어지지 않더라도 A클래스를 정의할 수 있다.
 */

class A {
    void autoPlay(I i) {
        i.play();
    }
}

interface I {
    public abstract void play();
}

class B implements I {
    public void play() {
        System.out.println("Play in B class");
    }
}

class C implements I {
    public void play() {
        System.out.println("Play in C class");
    }
}

class InterfaceTest2 {
    public static void main(String[] args) {
        A a = new A();
        a.autoPlay(new B());
        a.autoPlay(new C());
    }
}