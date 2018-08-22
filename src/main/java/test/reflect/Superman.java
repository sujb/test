package test.reflect;

/**
 * @Description :
 * @Author : sujinbo
 * @Date : 2018/8/22 10:54
 */
public class Superman extends Person implements ActionInterface{

    private boolean blueBriefs;

    public void fly(){
        System.out.println("superman can fly");
    }

    public boolean isBlueBriefs() {
        return blueBriefs;
    }

    public void setBlueBriefs(boolean blueBriefs) {
        this.blueBriefs = blueBriefs;
    }

    @Override
    public void walk(int m) {
        System.out.println("超人走了"+m+"米");
    }

    @Override
    public String toString() {
        return "Superman{" +
                "blueBriefs=" + blueBriefs +
                "} " + super.toString();
    }
}
