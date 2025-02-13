class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> s=new Stack<Integer>();
        for(String st:tokens)
        {
            if(st.equals("+"))
            {
                s.push(s.pop()+s.pop());
            }
            else if(st.equals("/"))
            {
                b=s.pop();
                a=s.pop();
                s.push(a/b);
            }
            else if(st.equals("*"))
            {
                s.push(s.pop()*s.pop());
            }
            else if(st.equals("-"))
            {
                b=s.pop();
                a=s.pop();
                s.push(a-b);
            }
            else{
                s.push(Integer.parseInt(st));
            }
        }
        return s.pop();
    }
}