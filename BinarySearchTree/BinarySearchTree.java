class Node {
  int data;
  Node left;
  Node right;
}

public class BinarySearchTree {
  private Node root;

  public void add(int data) {
    //ツリーがない場合の処理
    if (root == null) {
      root = new Node();
      root.data = data;
      return;
    }

    //現在のノードをルートノードとする
    Node current = root;
    while (true) {
      //追加する値 < 現在のノードの値
      if (data < current.data) {
        //次のノードが存在しない場合
        if (current.left == null) {
          current.left = new Node(); //ノードを作成
          current.left.data = data;
        }
        // 存在する場合は次のノードを現在ノードとして繰り返す
        current = current.left;
      }
      // 追加する値 >= 現在のノードの値
      else if (data >= current.data) {
        if (current.right == null) {
          current.right = new Node();
          current.right.data = data;
          return;
        }
        current = current.right;
      }
    }
  }

  public boolean contains(int data) {
    //現在ノードをルートノードとする
    Node current = root;
    //次のノードが存在しない場合は探索終了
    while (current != null) {
      // 等しければ探索終了
      if (current.data == data) {
        return true;
      }
      // 探索する値< 現在ノードの場合左の子ノードへ
      else if (data < current.data) {
        current = current.left;
      }
      // 探索する値 > 現在ノードの場合右の子ノードへ
      else if (data > current.data) {
        current = current.right;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    int[] data = { 3, 4, 7, 9, 1, 2, 3, 6, 5 };
    for (int i = 0; i < data.length; i++) {
      tree.add(data[i]);
    }

    System.out.println(tree.contains(3));
    System.out.println(tree.contains(10));
  }
}
