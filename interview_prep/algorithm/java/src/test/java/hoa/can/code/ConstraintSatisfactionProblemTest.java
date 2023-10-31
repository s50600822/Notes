package hoa.can.code;

import hoa.can.code.med.ConstraintSatisfactionProblem;
import hoa.can.code.med.EightQueensProblem;
import hoa.can.code.med.MapColoringProblem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstraintSatisfactionProblemTest {
    @Test
    @DisplayName("test colorize AussieMap - diff colors for shared border territories")
    public void testMapcoloring() {
		List<String> territories = List.of(
				"Western Australia",
				"Northern Territory",
				"South Australia",
				"Queensland",
				"New South Wales",
				"Victoria",
				"Tasmania");
		final List<String> colors = List.of("RED", "GREEN", "BLUE");
		Map<String, List<String>> domains = new HashMap<>();
		for (String variable : territories) {
			domains.put(variable, colors);
		}
		ConstraintSatisfactionProblem<String, String> csp = new ConstraintSatisfactionProblem<>(territories, domains);
		csp.addConstraint(new MapColoringProblem("Western Australia", "Northern Territory"));
		csp.addConstraint(new MapColoringProblem("Western Australia", "South Australia"));
		csp.addConstraint(new MapColoringProblem("South Australia", "Northern Territory"));
		csp.addConstraint(new MapColoringProblem("Queensland", "Northern Territory"));
		csp.addConstraint(new MapColoringProblem("Queensland", "South Australia"));
		csp.addConstraint(new MapColoringProblem("Queensland", "New South Wales"));
		csp.addConstraint(new MapColoringProblem("New South Wales", "South Australia"));
		csp.addConstraint(new MapColoringProblem("Victoria", "South Australia"));
		csp.addConstraint(new MapColoringProblem("Victoria", "New South Wales"));
		csp.addConstraint(new MapColoringProblem("Victoria", "Tasmania"));
		
        Map<String, String> solution = csp.backtrackingSearch();

        assertEquals(territories.size(), solution.size(), "solution found!");
        System.out.println(solution);//preview
    }

    @Test
    @DisplayName("test 8 queens")
    public void test8Queens() {
		List<Integer> columns = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		Map<Integer, List<Integer>> rows = new HashMap<>();
		for (int column : columns) {
			rows.put(column, List.of(1, 2, 3, 4, 5, 6, 7, 8));
		}
		ConstraintSatisfactionProblem<Integer, Integer> csp = new ConstraintSatisfactionProblem<>(columns, rows);
		csp.addConstraint(new EightQueensProblem(columns));
		Map<Integer, Integer> solution = csp.backtrackingSearch();
        
        assertEquals(8, solution.size(), "solution found!");
        //System.out.println(solution);//preview
    }    
}

