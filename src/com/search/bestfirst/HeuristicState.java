package com.search.bestfirst;

import com.search.simple.SimpleState;

public class HeuristicState extends SimpleState {

    public final static int hA = 10;
    public final static int hB = 8;
    public final static int hC = 12;
    public final static int hD = 9;
    public final static int hE = 4;
    public final static int hF = 2;
    public final static int hG = 3;
    public final static int hH = 0;

    public HeuristicState(String value) {
        super(value);
    }

    public int getHValue() {
        switch (this.value) {
            case A -> {
                return hA;
            }
            case B -> {
                return hB;
            }
            case C -> {
                return hC;
            }
            case D -> {
                return hD;
            }
            case E -> {
                return hE;
            }
            case F -> {
                return hF;
            }
            case G -> {
                return hG;
            }
            case H -> {
                return hH;
            }
        }

        throw new IllegalArgumentException("Invalid");
    }
}
