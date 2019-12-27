package example.reflectDemo3;

public class PersonAImplLawsuit implements Lawsuit {
    @Override
    public void submit(String str) {
        System.out.println("张三提交类以下证据:"+str);
    }

    @Override
    public void defend() {

    }
}
