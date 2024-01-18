package com.search.uniformcost;

import com.search.core.AbstractTreeSearch;
import com.search.core.Node;
import com.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class UniformCostSearch extends AbstractTreeSearch {
    @Override
    public Collection<Node> initFrontier() {
        return new ArrayList<Node>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        Node lowestCostNode = null;
        double lowestCost = Double.MAX_VALUE;

        for (Node node : frontier) {
            if (node.getPathCost() < lowestCost) {
                lowestCost = node.getPathCost();
                lowestCostNode = node;
            }
        }

        if (lowestCostNode != null) {
            frontier.remove(lowestCostNode);
        }

        return lowestCostNode;
    }
}

