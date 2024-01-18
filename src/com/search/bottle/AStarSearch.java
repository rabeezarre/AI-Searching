package com.search.bottle;

import com.search.core.AbstractTreeSearch;
import com.search.core.Node;
import com.search.core.Problem;

import java.util.*;

public class AStarSearch extends AbstractTreeSearch {

    private final Set<Node> closedList;

    public AStarSearch() {
        closedList = new HashSet<>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        frontier.removeAll(closedList);

        Map<Node, Double> fValues = new HashMap<>();
        for (Node node : frontier) {
            double gValue = node.getPathCost();
            double hValue = ((Bottles) node.getState()).getHValue();
            double fValue = gValue + hValue;
            fValues.put(node, fValue);
        }

        Node selectedNode = Collections.min(frontier, Comparator.comparingDouble(fValues::get));

        closedList.add(selectedNode);

        return selectedNode;
    }

    @Override
    public Collection<Node> initFrontier() {
        return new ArrayList<>();
    }

    public Node solve(Problem problem) {
        closedList.clear();
        return super.solve(problem);
    }

    @Override
    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> nodes = super.expand(node, problem);

        nodes.removeIf(closedList::contains);

        return nodes;
    }
}
