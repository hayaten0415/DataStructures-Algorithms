import java.util.*;


public class UFtree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[m];
        int b[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }

        // 答えがintに収まらないためlong型を使う
        long[] ans = new long[m];
        // 最後は全ての橋が壊れているのでN個から2つを選ぶ分だけある（Combination）
        ans[m - 1] = (long) n * (n - 1) / 2;
        UnionFind uni = new UnionFind(n);
        for (int i = m - 1; i >= 1; i--) {
            // 繋がってなかったのが繋がった時
            if (uni.root(a[i]) != uni.root(b[i])) {
                ans[i - 1] = (long) ans[i] - uni.size(a[i]) * uni.size(b[i]);
                uni.connect(a[i], b[i]);
            } else {
                ans[i - 1] = ans[i];
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }

    static class UnionFind {
        ArrayList<Integer> parent;

        UnionFind(int n) {
            parent = new ArrayList<Integer>();
            Integer[] values = new Integer[n];
            // 初期値セット、作るときは全て-1にする。こうすることで全てバラバラになる
            Arrays.fill(values, -1);
            // 初期値を配列に入れる
            parent.addAll(Arrays.asList(values));
        }

        // Aがどのグループに属しているか調べる
        int root(int a) {
            if (parent.get(a) < 0) {
                return a;
            } else {
                int root = root(parent.get(a));
                parent.set(a, root);
                return root;
            }
        }

        // 自分のいるグループの頂点数を調べる
        int size(int a) {
            return -parent.get(root(a));
        }

        // AとBをくっつける
        boolean connect(int a, int b) {
            // AとBを直接つなぐのではなく、root(A)にroot(B)をくっつける
            a = root(a);
            b = root(b);
            if (a == b) {
                // すでにくっついているのでくっつけない
                return false;
            }

            // 大きい方に小さい方をくっつける
            // Bのほうが大きい場合はAとBを入れ替える
            if (size(a) < size(b)) {
                int tmp = a;
                a = b;
                b = tmp;

            }

            parent.set(a, parent.get(a) + parent.get(b));
            parent.set(b, a);

            return true;

        }

    }
}