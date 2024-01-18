package com.search.bestfirst;

import com.search.core.AbstractTreeSearch;
import com.search.core.Node;
import com.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class HeuristicSearch extends AbstractTreeSearch {
    @Override
    public Collection<Node> initFrontier() {
        return new ArrayList<Node>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        Node bestNode = null;
        int bestHeuristicValue = Integer.MAX_VALUE;

        for (Node node : frontier) {
            if (node.getState() instanceof HeuristicState state) {
                int heuristicValue = state.getHValue();
                if (heuristicValue < bestHeuristicValue) {
                    bestHeuristicValue = heuristicValue;
                    bestNode = node;
                }
            }
        }

        if (bestNode != null) {
            frontier.remove(bestNode);
        }
        return bestNode;
    }

}
