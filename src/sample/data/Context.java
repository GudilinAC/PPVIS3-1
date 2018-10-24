package sample.data;

import sample.models.Dot;
import sample.models.Floor;
import sample.models.Plan;
import sample.models.Wall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Context {
    private Plan plan = new Plan();
    private List<Collection<Dot>> bindingDots = new ArrayList<>();

    private static Context ourInstance = new Context();

    public static Context getInstance() {
        return ourInstance;
    }

    private Context() {
        bindingDots.add(new HashSet<>());
    }

    public void saveChanges(){
        bindingDots.clear();
        getFloors().forEach(f -> {
            Collection<Dot> collection = new HashSet<>();
            f.getStructures().forEach(s -> {
                if (s instanceof Wall){
                    collection.add(((Wall) s).getBeginDot());
                    collection.add(((Wall) s).getEndDot());
                }
            });
            bindingDots.add(getFloors().indexOf(f),collection);
        });
    }

    public Collection<Dot> getBindingDots(int floor){
        return bindingDots.get(floor);
    }

    public Plan getPlan(){
        return plan;
    }

    public void setPlan(Plan plan){
        this.plan = plan;
        saveChanges();
    }

    public List<Floor> getFloors () { return plan.getFloors(); }

    public Floor getFloor(int floor) { return plan.getFloors().get(floor); }
}
