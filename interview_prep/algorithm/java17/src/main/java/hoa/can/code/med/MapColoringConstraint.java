package hoa.can.code.med;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapColoringConstraint extends Constraint<String, String> {
	private String place1, place2;

	public MapColoringConstraint(String place1, String place2) {
		super(List.of(place1, place2));
		this.place1 = place1;
		this.place2 = place2;
	}

	@Override
	public boolean satisfied(Map<String, String> assignment) {
		if (!assignment.containsKey(place1) || !assignment.containsKey(place2)) {
			return true;
		}
		return !assignment.get(place1).equals(assignment.get(place2));
	}

	public void aussieTerritory(String[] args) {
		List<String> variables = List.of(
				"Western Australia",
				"Northern Territory",
				"South Australia",
				"Queensland",
				"New South Wales",
				"Victoria",
				"Tasmania");
		final List<String> colors = List.of("RED", "GREEN", "BLUE");
		Map<String, List<String>> domains = new HashMap<>();
		for (String variable : variables) {
			domains.put(variable, colors);

		}
		ConstraintSatisfactionProblem<String, String> csp = new ConstraintSatisfactionProblem<>(variables, domains);
		csp.addConstraint(new MapColoringConstraint("Western Australia", "Northern Territory"));
		csp.addConstraint(new MapColoringConstraint("Western Australia", "South Australia"));
		csp.addConstraint(new MapColoringConstraint("South Australia", "Northern Territory"));
		csp.addConstraint(new MapColoringConstraint("Queensland", "Northern Territory"));
		csp.addConstraint(new MapColoringConstraint("Queensland", "South Australia"));
		csp.addConstraint(new MapColoringConstraint("Queensland", "New South Wales"));
		csp.addConstraint(new MapColoringConstraint("New South Wales", "South Australia"));
		csp.addConstraint(new MapColoringConstraint("Victoria", "South Australia"));
		csp.addConstraint(new MapColoringConstraint("Victoria", "New South Wales"));
		csp.addConstraint(new MapColoringConstraint("Victoria", "Tasmania"));
		Map<String, String> solution = csp.backtrackingSearch();
		if (solution == null) {
			System.out.println("No solution found!");
		} else {
			System.out.println(solution);
		}
	}

}
