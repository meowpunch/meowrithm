package sap;

//'main' method must be in a class 'Rextester'.
//openjdk version '11.0.5'
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;


interface StateMachineInterface<S, I> {
    /**
     * Add a transition to the state machine, i.e. if in state "start_state" and
     * token "input" is read, change state to "end_state".
     */
    void addTransition(S start_state, I input, S end_state);

    /**
     * Add an accepting end state to the state machine, i.e. if (and only if),
     * after reading the whole input, the machine is in one of the accepted
     * states, accepts() should return true.
     */
    void addAcceptingState(S state);

    /**
     * Parse the given input, starting in the given state.
     */
    boolean accepts(S start_state, List<I> input);
}


class StateMachine<S, I> implements StateMachineInterface<S, I> {
    /*
     * Please add your implementation here!
     *
     * HashMap start_state -> input
     *   HashMap input -> end_state
     */
    private final HashMap<S, HashMap<I, S>> transitions = new HashMap<>();
    private final HashSet<S> acceptingStates = new HashSet<>();

    @Override
    public void addTransition(S start_state, I input, S end_state) {
        final HashMap<I, S> m = transitions.getOrDefault(start_state, new HashMap<>());
        m.put(input, end_state);
        transitions.put(start_state, m);
    }

    @Override
    public void addAcceptingState(S state) {
        acceptingStates.add(state);
    }

    @Override
    /*
        Average Time Complexity: O(size of input)
     */
    public boolean accepts(S start_state, List<I> input) {
        S curr_state = start_state;

        for (I i : input) {
        if (transitions.containsKey(curr_state)) {
            final HashMap<I, S> m = transitions.get(curr_state);
            if (m.containsKey(i)) curr_state = m.get(i);
            else return false;
        } else return false;
    }

        return acceptingStates.contains(curr_state);
    }
}

class Rextester
{
    private static StateMachineInterface<Integer, Character> sm = new StateMachine<Integer, Character>();

    private static void init() {
    sm.addTransition(1, 'a', 2);
    sm.addTransition(2, 'a', 2);
    sm.addTransition(2, 'b', 3);
    sm.addTransition(1, 'c', 4);
    sm.addTransition(4, 'b', 4);

    sm.addAcceptingState(3);
    sm.addAcceptingState(4);
}

    private static Iterable<Object[]> testdata() {
    return Arrays.asList(new Object[][] {//
        { 1, "aaaab", true }, //
        { 1, "ab", true }, //
        { 1, "c", true }, //
        { 1, "cbbbb", true }, //
        { 4, "", true }, //
        { 1, "", false }, //
        { 1, "aba", false }, //
        { 1, "acb", false }, //
        { 1, "ccccb", false }, //
        { 1, "ccccbbbb", false }, //
        { 1, "abcd", false }, //
        { 4, "a", false } //
    });
}

    public static void main(String args[])
    {
        Rextester.init();
        Iterator<Object[]> iter = Rextester.testdata().iterator();
        while (iter.hasNext()) {
            Object[] test = iter.next();
            List<Character> listC = new ArrayList<Character>();
            for (char c : test[1].toString().toCharArray()) {
                listC.add(c);
            }
            boolean expected = (Boolean) test[2];
            if (expected != sm.accepts((int) test[0], listC)) {
                System.out.printf("Test failed for start: %d, input: %s\n", test[0], test[1].toString());
            }
        }

        System.out.println("Test finished");
    }
}
