package com.search.bestfirst;

import com.search.core.Problem;
import com.search.simple.SimpleState;

import java.util.ArrayList;
import java.util.Collection;

public class HeuristicProblem implements Problem {

    HeuristicState initialState = new HeuristicState(HeuristicState.A);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return ((HeuristicState) state).getHValue() == 0;
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<>();
        String s = ((HeuristicState) state).value;
        if (s.equals(HeuristicState.A)) {
            actions.add("go to B");
            actions.add("go to C");
        } else if (s.equals(HeuristicState.B)) {
            actions.add("go to D");
            actions.add("go to E");
        } else if (s.equals(HeuristicState.C)) {
            actions.add("go to D");
        } else if (s.equals(HeuristicState.D)) {
            actions.add("go to G");
        } else if (s.equals(HeuristicState.E)) {
            actions.add("go to F");
        } else if (s.equals(HeuristicState.F)) {
            actions.add("go to H");
        } else if (s.equals(HeuristicState.G)) {
            actions.add("go to H");
        } else if (s.equals(HeuristicState.H)) {

        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to A")) return new HeuristicState(HeuristicState.A);
        if (action.equals("go to B")) return new HeuristicState(HeuristicState.B);
        if (action.equals("go to C")) return new HeuristicState(HeuristicState.C);
        if (action.equals("go to D")) return new HeuristicState(HeuristicState.D);
        if (action.equals("go to E")) return new HeuristicState(HeuristicState.E);
        if (action.equals("go to F")) return new HeuristicState(HeuristicState.F);
        if (action.equals("go to G")) return new HeuristicState(HeuristicState.G);
        if (action.equals("go to H")) return new HeuristicState(HeuristicState.H);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        SimpleState startState = (SimpleState) start;
        SimpleState destState = (SimpleState) dest;

        if (startState.equals(new SimpleState(SimpleState.A)) && destState.equals(new SimpleState(SimpleState.B))) {
            return 2;
        }
        if (startState.equals(new SimpleState(SimpleState.A)) && destState.equals(new SimpleState(SimpleState.C))) {
            return 1;
        }
        if (startState.equals(new SimpleState(SimpleState.B)) && destState.equals(new SimpleState(SimpleState.E))) {
            return 3;
        }
        if (startState.equals(new SimpleState(SimpleState.B)) && destState.equals(new SimpleState(SimpleState.D))) {
            return 1;
        }
        if (startState.equals(new SimpleState(SimpleState.C)) && destState.equals(new SimpleState(SimpleState.D))) {
            return 3;
        }
        if (startState.equals(new SimpleState(SimpleState.D)) && destState.equals(new SimpleState(SimpleState.G))) {
            return 5;
        }
        if (startState.equals(new SimpleState(SimpleState.G)) && destState.equals(new SimpleState(SimpleState.H))) {
            return 3;
        }
        if (startState.equals(new SimpleState(SimpleState.E)) && destState.equals(new SimpleState(SimpleState.F))) {
            return 2;
        }
        if (startState.equals(new SimpleState(SimpleState.F)) && destState.equals(new SimpleState(SimpleState.H))) {
            return 1;
        }

        throw new IllegalArgumentException("Invalid action");
    }
}
