// Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x, your task is to complete the function countPairs(), that returns the count of all pairs of (a, b), where a belongs to one BST and b belongs to another BST, such that a + b = x.

// This is only interior solution of the gfg POTD

class Solution
{
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		
		 int count = 0;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Initialize current nodes for both BSTs
        Node curr1 = root1, curr2 = root2;

        while ((curr1 != null || !stack1.isEmpty()) && (curr2 != null || !stack2.isEmpty())) {
            // Traverse the leftmost path in the first BST
            while (curr1 != null) {
                stack1.push(curr1);
                curr1 = curr1.left;
            }

            // Traverse the rightmost path in the second BST
            while (curr2 != null) {
                stack2.push(curr2);
                curr2 = curr2.right;
            }

            // If either of the stacks is empty, break the loop
            if (stack1.isEmpty() || stack2.isEmpty()) {
                break;
            }

            // Get the top elements from both stacks
            Node top1 = stack1.peek();
            Node top2 = stack2.peek();

            // Check if the pair's sum equals x
            if (top1.data + top2.data == x) {
                count++;
                // Pop both elements and move to the next
                stack1.pop();
                stack2.pop();
                curr1 = top1.right;
                curr2 = top2.left;
            } else if (top1.data + top2.data < x) {
                // If the sum is less than x, pop from stack1 and move to the next element in the first BST
                stack1.pop();
                curr1 = top1.right;
            } else {
                // If the sum is greater than x, pop from stack2 and move to the next element in the second BST
                stack2.pop();
                curr2 = top2.left;
            }
        }

        return count;
	}
}