package com.search.bottle;

import com.search.core.Problem;

import java.util.*;

public class BottleProblem implements Problem {
    private final Bottles initialState;
    private final Bottles finalState1 = new Bottles(2,0);
    private final Bottles finalState2= new Bottles(0, 2);

    public BottleProblem(Bottles initialState) {
        this.initialState = initialState;
    }

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        if (state.equals(finalState1))
            return true;
        else return state.equals(finalState2);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        Bottles bottles = (Bottles) state;
        List<Object> possibleActions = new ArrayList<>();

        if (bottles.getBottleA() < bottles.getCapacityA()) {
            possibleActions.add(Actions.FILL_A);
        }

        if (bottles.getBottleB() < bottles.getCapacityB()) {
            possibleActions.add(Actions.FILL_B);
        }

        if (bottles.getBottleA() > 0) {
            possibleActions.add(Actions.EMPTY_A);
        }

        if (bottles.getBottleB() > 0) {
            possibleActions.add(Actions.EMPTY_B);
        }

        if (bottles.getBottleA() > 0 && bottles.getBottleB() < bottles.getCapacityB()) {
            possibleActions.add(Actions.TRANSFER_A_TO_B);
        }

        if (bottles.getBottleB() > 0 && bottles.getBottleA() < bottles.getCapacityA()) {
            possibleActions.add(Actions.TRANSFER_B_TO_A);
        }

        return possibleActions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        Bottles currentState = (Bottles) state;
        Bottles nextState = new Bottles(currentState.getBottleA(), currentState.getBottleB());

        switch ((Actions) action) {
            case FILL_A -> nextState.setBottleA(nextState.getCapacityA());
            case FILL_B -> nextState.setBottleB(nextState.getCapacityB());
            case EMPTY_A -> nextState.setBottleA(0);
            case EMPTY_B -> nextState.setBottleB(0);
            case TRANSFER_A_TO_B -> {
                int transferA = Math.min(nextState.getBottleA(), nextState.getCapacityB() - nextState.getBottleB());
                nextState.setBottleA(nextState.getBottleA() - transferA);
                nextState.setBottleB(nextState.getBottleB() + transferA);
            }
            case TRANSFER_B_TO_A -> {
                int transferB = Math.min(nextState.getBottleB(), nextState.getCapacityA() - nextState.getBottleA());
                nextState.setBottleB(nextState.getBottleB() - transferB);
                nextState.setBottleA(nextState.getBottleA() + transferB);
            }
        }

        return nextState;
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
