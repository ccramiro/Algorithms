package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrinter {

	// Static access only
	private TreePrinter(){}

	public static <T> void printNode(Node<T> root) {
        int maxLevel = TreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || areAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = ( int ) Math.pow( 2, ( Math.max( floor - 1, 0 ) ) );
        int firstSpaces = ( int ) Math.pow( 2, ( floor ) ) - 1;
        int betweenSpaces = ( int ) Math.pow( 2, ( floor + 1) ) - 1;

        printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.mValue);
                newNodes.add(node.mLeft);
                newNodes.add(node.mRight);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).mLeft != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).mRight != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max( maxLevel(node.mLeft), maxLevel( node.mRight ) ) + 1;
    }

    private static <T> boolean areAllElementsNull( List<Node<T>> list ) {
        for (Node<T> object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

}
