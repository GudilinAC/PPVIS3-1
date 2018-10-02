package sample.data;

import sample.models.Plan;

public class Context {
    private Plan plan = new Plan();
    private static Context ourInstance = new Context();

    public static Context getInstance() {
        return ourInstance;
    }

    private Context() {
    }

    public Plan getPlan(){
        return plan;
    }

    public void setPlan(Plan plan){
        this.plan = plan;
    }
}
