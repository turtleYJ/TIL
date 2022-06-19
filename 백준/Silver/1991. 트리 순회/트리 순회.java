import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char value;
	Node left;
	Node right;
	
	Node(char value) {
		this.value = value;
		// left와 right는 모르니까 우선적으로 노드값(value)를 기반으로 Node 인스턴스를 생성
	}
}

class Tree {
	Node root;
	
	void createNode(char value, char left, char right) {
		if (root == null) {
			root = new Node(value);
			
			// 좌우 값이 있는 경우 노드를 생성해준다.
			if(left != '.') {
				root.left = new Node(left);
			}
			if(right != '.') {
				root.right = new Node(right);
			}
		} 
		// 루트가 null이 아닌 경우
		else {
			linkNode(root, value, left, right);
		}
		
	}
	
	// 재귀식으로 노드값(value)과 일치하는 노드를 찾아 연결시키기.
	void linkNode(Node node, char value, char left, char right) {
		if (node == null) return;
		
		if (node.value == value) {
			
			if(left != '.') {
				node.left = new Node(left);
			}
			if(right != '.') {
				node.right = new Node(right);
			}
		}
		// 현재 노드가 연결하려는 노드와 같지 않다면
		// 현재 노드의 좌우를 확인하여 재귀식으로 찾는다.
		else {
			linkNode(node.left, value, left, right);
			linkNode(node.right, value, left, right);
		}
	}
	
	// 전위순회 : Root -> Left -> Right
	void preOrder (Node node) {
		if (node != null) {
			System.out.print(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	// 중위순회 : Left -> Root -> Right
	void inOrder (Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.value);
			inOrder(node.right);
		}
	}
	
	// 후위순회 : Left -> Right -> Root
	void postOrder (Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.value);
		}
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char val = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree.createNode(val, left, right);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}