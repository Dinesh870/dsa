class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sa = new Stack<>();
        Queue<Integer> st = new LinkedList<>();
        int n = students.length;
        
        for(int i = 0; i < n; i++) {
            st.add(i);
            sa.push(n-i-1);
        }

        // // while(n > 0) {
        // //     System.out.print(students[st.pop()]+" ");
        // //     n--;
        // // }
        // // System.out.println();
        // // n = students.length;
        // // while(n > 0) {
        // //     System.out.print(sandwiches[q.poll()]+" ");
        // //     n--;
        // // }

        boolean canEat = true;
        while(canEat) {
            n = st.size();
            canEat = false;
            while(n > 0) {
                if(students[st.peek()] == sandwiches[sa.peek()]) {
                    st.remove();
                    sa.pop();
                    canEat = true;
                } else {
                    int x = st.poll();
                    st.add(x);
                }
                n--;
            }
        }
        
        return st.size();
        
    }
}