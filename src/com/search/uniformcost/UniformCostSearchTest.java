package com.search.uniformcost;

import com.search.core.Node;
import com.search.core.Problem;
import com.search.solver.DepthFirstTreeSearch;

public class UniformCostSearchTest {

    public static void main(String[] args) {
        Problem problem = new UniformCostProblem();

        DepthFirstTreeSearch search = new DepthFirstTreeSearch();
        System.out.println("Solution to problem using Depth First Search: ");
        Node solution = search.solve(problem);
        System.out.println(solution.pathToString());
        System.out.println("Path cost of Depth First Search: " + solution.getPathCost());

        System.out.println();

        UniformCostSearch search2 = new UniformCostSearch();
        System.out.println("Solution to problem using Uniform Cost Search: ");
        Node solution2 = search2.solve(problem);
        System.out.println(solution2.pathToString());
        System.out.println("Path cost of Uniform Cost Search: " + solution2.getPathCost());
    }
}
