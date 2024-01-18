package com.search.solver;

import com.search.core.Problem;
import com.search.core.AbstractTreeSearch;
import com.search.core.Node;

import java.util.Collection;
import java.util.Stack;

public class DepthFirstTreeSearch extends AbstractTreeSearch {

    public Collection<Node> initFrontier() {
        return new Stack<Node>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((Stack<Node>) frontier).pop();
    }
}