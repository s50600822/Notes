package hoa.can.code;

import hoa.can.code.gg.JumpingRecursive;

public class JumpingRecTest extends JumpingTest {
    public JumpingRecTest() {
        super(new JumpingRecursive());
    }

    @Override
    public void slow() {
        // do nothing since it will freeze
    }
}
