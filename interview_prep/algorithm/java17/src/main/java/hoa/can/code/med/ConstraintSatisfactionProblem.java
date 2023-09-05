package hoa.can.code.med;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstraintSatisfactionProblem<V, D> {
    private List<V> vars;
    private Map<V, List<D>> domains;
    private Map<V, List<Constraint<V, D>>> constraints;

    public ConstraintSatisfactionProblem(List<V> vars, Map<V, List<D>> domains) {
        this.vars = vars;
        this.domains = domains;
        for (V var : vars) {
            if (!domains.containsKey(var)) {
                throw new IllegalArgumentException("every var must have domain assigned to it");
            }
            constraints.put(var, new ArrayList<>());
        }
    }

    public void addConstraint(Constraint<V, D> constraint) {
        for (V var : constraint.getVars()) {
            if (!vars.contains(var)) {
                throw new IllegalArgumentException();
            }
            constraints.get(var).add(constraint);
        }
    }

    // Check if the value assignment is consistent by checking all constraints
    // for the given variable against it
    public boolean consistent(V variable, Map<V, D> assignment) {
        for (Constraint<V, D> constraint : constraints.get(variable)) {
            if (!constraint.satisfied(assignment)) {
                return false;
            }
        }
        return true;
    }

    public Map<V, D> backtrackingSearch(Map<V, D> assignment) {
        // assignment is complete if every variable is assigned (our base case)
        if (assignment.size() == vars.size()) {
            return assignment;
        }
        // get the first variable in the CSP but not in the assignment
        return vars.stream()
                .filter(v -> !assignment.containsKey(v))
                .findFirst()
                .map(unassigned -> backtrackingSearch(unassigned, assignment))
                .orElse(null);
    }

    private Map<V, D> backtrackingSearch(V unassigned, Map<V, D> assignment) {
        for (D value : domains.get(unassigned)) {
            // shallow copy of assignment that we can change
            Map<V, D> localAssignment = new HashMap<>(assignment);
            localAssignment.put(unassigned, value);
            // if we're still consistent, we recurse (continue)
            if (consistent(unassigned, localAssignment)) {
                Map<V, D> result = backtrackingSearch(localAssignment);
                // if we didn't find the result, we will end up backtracking
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    // helper for backtrackingSearch when nothing known yet
    public Map<V, D> backtrackingSearch() {
        return backtrackingSearch(new HashMap<>());
    }
}