import org.w3c.dom.Node;

public class huffman {
    void decode(String s, Node root) {
        int position = 0;
        while (position < s.length()) {
            s = s.substring(position);
            position = decode2(s, root, 0);
        }
    }

    int decode2(String s, Node root, int position) {
        if (((int) root.data) != 0) {
            System.out.print(root.data);
            return 0;
        } else {
            if (s.charAt(position) == '1') {
                return decode2(s, root.right, ++position) + 1;
            } else {
                return decode2(s, root.left, ++position) + 1;
            }
        }
    }
}
