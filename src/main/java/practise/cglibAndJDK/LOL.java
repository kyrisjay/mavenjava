package practise.cglibAndJDK;

public class LOL implements shop{

    @Override
    public void buy(String goods) {
        System.out.println("调用了购买方法");
        System.out.println("新买了一件商品:"+goods);
    }

    @Override
    public void sell(String goods,String price) {
        System.out.println("调用了出售的方法");
        System.out.println("出售了一件商品:"+goods+" 获得了:"+price+"yuan");
    }
}
