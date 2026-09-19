import java.util.*;

public class Q188 {
    static class Node {
        Node parent;
        String id;

        public Node(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String parentId = tokens[0];
            String childrenId = tokens[1];

            Node pNode = map.computeIfAbsent(parentId, Node::new);
            Node cNode = map.computeIfAbsent(childrenId, Node::new);
            cNode.parent = pNode;
        }

        StringJoiner sj = new StringJoiner(" ");
        String[] str = sc.nextLine().trim().split("\\s+");
        for (String s : str) {
            if(!map.containsKey(s)){
                sj.add(s);
                continue;
            }

            Node tmp = map.get(s);
            if(tmp.parent==null||(tmp.parent!=null&&c(tmp.parent.id, str))){
                sj.add(s);
            }
        }

        System.out.println(sj);
    }

    private static boolean c(String a, String[] str){
        for(String s:str){
            if(a.equals(s)) return false;
        }
        return true;
    }
}
