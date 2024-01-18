package com.search.bottle;

import com.search.core.Node;

public class BottlesSolution {
    public static void main(String[] args) {
        BottleProblem problem = new BottleProblem(new Bottles(0, 0));
        AStarSearch search = new AStarSearch();
        System.out.println("Solution to bottles problem by using A*: ");
        Node solution = search.solve(problem);
        System.out.println(solution.pathToString());
        System.out.println("Path cost of A*: " + solution.getPathCost());
    }

}
