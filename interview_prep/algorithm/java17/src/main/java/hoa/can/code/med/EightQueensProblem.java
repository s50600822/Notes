package hoa.can.code.med;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.lang.Math.abs;

public final class EightQueensProblem extends Constraint<Integer, Integer> {
	private List<Integer> columns;

	public EightQueensProblem(List<Integer> columns) {
		super(columns);
		this.columns = columns;
	}

	@Override
	public boolean satisfied(Map<Integer, Integer> assignment) {
		for (Entry<Integer, Integer> item : assignment.entrySet()) {
			int thisQueenCol = item.getKey();
			int thisQueenRow = item.getValue();
			for (int nextQueenCol = thisQueenCol + 1; nextQueenCol <= columns.size(); nextQueenCol++) {
				if (assignment.containsKey(nextQueenCol)) {
					int nextQueenRow = assignment.get(nextQueenCol);
					//row check
					if (thisQueenRow == nextQueenRow) {
						return false;
					}
					//diagonal check
					if (abs(thisQueenRow - nextQueenRow) ==  abs(thisQueenCol - nextQueenCol)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}