package sample.data;

import sample.models.Dot;
import sample.models.Floor;
import sample.models.Plan;
import sample.models.Wall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Data {
    private Plan plan = new Plan();
    private List<Collection<Dot>> bindingDots = new ArrayList<>();

    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
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

    public List<String> getFloorNames(){
        List<String> list = new ArrayList<>();
        plan.getFloors().forEach(f -> list.add(f.getName()));
        return list;
    }
}
