package com.search.bestfirst;

import com.search.core.Node;

public class HeuristicSearchTest {

    public static void main(String[] args) {
        HeuristicProblem problem = new HeuristicProblem();
        HeuristicSearch search = new HeuristicSearch();
        System.out.println("Solution to problem using Best First Search: ");
        Node solution = search.solve(problem);
        System.out.println(solution.pathToString());
        System.out.println("Path cost of Best First Search: " + solution.getPathCost());
    }
}
