package test;

import java.lang.reflect.Method;

public interface TestMXBean {
    void setFlag(boolean flag);
    class TestMXBeanIml implements TestMXBean{

        @Override
        public void setFlag(boolean flag) {
            Class<?> clazz;
            try {
                clazz= Class.forName("test.FilterPlanMz");
                Method method =clazz.getMethod("setFlag1");
                method.invoke(clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        Class<?> clazz;
//        try {
//            clazz=Class.forName("test.FilterPlanMz");
//            Method method =clazz.getMethod("setFlag");
//            method.invoke(clazz,false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        new TestMXBeanIml().setFlag(true);
    }
}
