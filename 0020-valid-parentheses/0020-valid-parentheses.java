class Solution {
    public boolean isValid(String s) {
        Stack<Character>ss=new Stack<Character>();
        for(char c:s.toCharArray())
        {
            if(c=='('||c=='['||c=='{')
            {
                ss.push(c);
            }
            else
            {
                if(ss.isEmpty())
                {
                    return false;
                }
                char top=ss.peek();
                if((c==')' && top=='(') || (c==']' && top=='[') || (c=='}' && top=='{'))
            {
                ss.pop();
            }
            else
            {
                return false;
            }
            }
        }
        return ss.isEmpty();
    }
}