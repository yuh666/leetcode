package bianpinghuaqiantaoliebiaodiedaiqi_342;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
public class NestedIterator implements Iterator<Integer> {

     Iterator<Integer> inner;
        public NestedIterator(List<NestedInteger> nestedList) {
            ArrayList<Integer> list = new ArrayList<>();
            if(nestedList != null && !nestedList.isEmpty()) {
                inorder(nestedList,list);
            }
            inner = list.iterator();
        }

    private void inorder(List<NestedInteger> nestedList, ArrayList<Integer> list) {
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else{
                inorder(nestedInteger.getList(),list);
            }
        }
    }

    @Override
        public Integer next() {
            return inner.next();
        }

        @Override
        public boolean hasNext() {
            return inner.hasNext();
        }
}
