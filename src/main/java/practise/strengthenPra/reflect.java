package practise.strengthenPra;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        //正常调用
        reflect r = new reflect();
        r.setPrice(5000);
        System.out.println("price:" + r.getPrice());
        //反射调用
        Class clz = reflect.class;
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor phoneConstructor = clz.getConstructor();
        Object phoneObj = phoneConstructor.newInstance();
        setPriceMethod.invoke(phoneObj, 6000);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Phone Price:" + getPriceMethod.invoke(phoneObj));
    }
}

