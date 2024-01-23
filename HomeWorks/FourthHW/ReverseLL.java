package HomeWorks.FourthHW;

import java.util.LinkedList;

public class ReverseLL {
    public static void main(String[] args) {
        
    }

    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        LinkedList<Object> result = new LinkedList<>();
        
        for (int i = ll.size(); i > 0; i--) {
            result.addFirst(ll.get(i));
        }

        return result;
    }
}
