package hoa.can.code.med;

import java.util.List;
import java.util.Map;

public abstract class Constraint<V,D>{
    private List<V> vars;

    public List<V> getVars() {
        return vars;
    }

    public void setVars(List<V> vars) {
        this.vars = vars;
    }

    public Constraint(List<V> vars) {
        this.vars = vars;
    }
    
    public abstract boolean satisfied(Map<V,D> assignment);
}