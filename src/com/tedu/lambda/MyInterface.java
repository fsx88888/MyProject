package com.tedu.lambda;
@FunctionalInterface
public interface MyInterface {
    public abstract void a(); //本接口新定义的的抽象
    public abstract String toString();//和Object 中重名
    public abstract  boolean equals(Object obj);//和Object 中重名
    //toString()和equals（）看似是抽象方法，实际是有方法体的具体方法
}

class  MyInterfaceImpl implements  MyInterface{

    @Override
    public void a() {
        System.out.println("a......");
    }
}
class  TestMyInterface{
    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.a();
        impl.equals("");
        impl.toString();
    }
}
